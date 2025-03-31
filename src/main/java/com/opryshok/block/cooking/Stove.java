package com.opryshok.block.cooking;

import com.mojang.serialization.MapCodec;
import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import com.opryshok.entity.StoveBlockEntity;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.attachment.BlockBoundAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import xyz.nucleoid.packettweaker.PacketContext;

public class Stove extends BlockWithEntity implements FactoryBlock, BlockEntityProvider, InventoryProvider {
    public static final MapCodec<Stove> CODEC;
    public static final BooleanProperty LIT;
    public static final EnumProperty<Direction> FACING;

    static{
        FACING = Properties.HORIZONTAL_FACING;
        LIT = Properties.LIT;
        CODEC = createCodec(Stove::new);
    }
    public Stove(Settings settings) {
        super(settings.nonOpaque());
        this.setDefaultState(getDefaultState().with(LIT, false));
    }

    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, PacketContext context) {
        return Blocks.MUD_BRICKS.getDefaultState();
    }

    public void onStateReplaced(BlockState state, ServerWorld world, BlockPos pos, BlockState newState, boolean moved) {
        ItemScatterer.onStateReplaced(newState, world, pos);
        if (state.isOf(ModBlocks.STOVE) && newState.isOf(ModBlocks.STOVE)) {
            if (state.get(LIT) != newState.get(LIT)) {
                BlockState upBlock = world.getBlockState(pos.up());
                if (upBlock.isOf(ModBlocks.PAN) || upBlock.isOf(ModBlocks.POT)) {
                    world.setBlockState(pos.up(), upBlock.with(Properties.LIT, newState.get(LIT)), 3);
                }
            }
        }
        super.onStateReplaced(newState, world, pos, moved);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        if (state.isOf(ModBlocks.STOVE)){
            BlockState upBlock = world.getBlockState(pos.up());
            if (upBlock.isOf(ModBlocks.PAN) || upBlock.isOf(ModBlocks.POT)){
                world.setBlockState(pos.up(), upBlock.with(Properties.LIT, false), 3);
            }
        }
        super.onBroken(world, pos, state);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return StoveBlockEntity::tick;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.isSneaking() && world.getBlockEntity(pos) instanceof StoveBlockEntity entity){
            entity.openGui((ServerPlayerEntity) player);
            return ActionResult.SUCCESS;
        }
        return super.onUse(state, world, pos, player, hit);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new StoveBlockEntity(pos, state);
    }

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        var inv = world.getBlockEntity(pos);
        return inv instanceof SidedInventory ? (SidedInventory) inv : null;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT, FACING);
        super.appendProperties(builder);
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new Model(initialBlockState);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        return super.onBreak(world, pos, state, player);
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
        return Blocks.BARRIER.getDefaultState();
    }

    public static final class Model extends BlockModel{
        public static final ItemStack LIT_FALSE = ItemDisplayElementUtil.getModel(Identifier.of(BorukvaFood.MOD_ID, "block/stove"));
        public static final ItemStack LIT_TRUE = ItemDisplayElementUtil.getModel(Identifier.of(BorukvaFood.MOD_ID, "block/stove_on"));

        public ItemDisplayElement stove;
        public Model(BlockState state){
            init(state);
        }
        public void init(BlockState state){
            this.stove = state.get(LIT) ? ItemDisplayElementUtil.createSimple(LIT_TRUE) : ItemDisplayElementUtil.createSimple(LIT_FALSE);
            this.stove.setScale(new Vector3f(2));
            this.updateStatePos(state);
            this.addElement(stove);
        }
        private void updateStatePos(BlockState state){
            var direction = state.get(FACING);
            this.stove.setYaw(direction.getPositiveHorizontalDegrees());
        }

        private void updateItem(BlockState state) {
            this.removeElement(this.stove);
            init(state);
        }
        @Override
        public void notifyUpdate(HolderAttachment.UpdateType updateType) {
            if (updateType == BlockBoundAttachment.BLOCK_STATE_UPDATE){
                updateItem(this.blockState());
            }
            super.notifyUpdate(updateType);
        }
    }
}
