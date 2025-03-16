package com.opryshok.block.cooking;

import com.mojang.serialization.MapCodec;
import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import com.opryshok.entity.PotBlockEntity;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
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

public class Pot extends BlockWithEntity implements FactoryBlock, BlockEntityProvider, InventoryProvider {
    public static final BooleanProperty LIT = Properties.LIT;
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final MapCodec<Pot> CODEC = createCodec(Pot::new);

    public Pot(Settings settings) {
        super(settings.nonOpaque());
        this.setDefaultState(getDefaultState().with(Properties.LIT, false));
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
        return Blocks.BARRIER.getDefaultState();
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PotBlockEntity(pos, state);
    }

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        return null;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockState state = world.getBlockState(ctx.getBlockPos().down());
        if (state.isOf(ModBlocks.STOVE)) {
            return this.getDefaultState().with(LIT, state.get(LIT)).with(FACING, ctx.getHorizontalPlayerFacing());
        }
        return this.getDefaultState().with(LIT, false).with(FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.isSneaking() && world.getBlockEntity(pos) instanceof PotBlockEntity entity) {
            entity.openGui((ServerPlayerEntity) player);
            return ActionResult.SUCCESS;
        }
        return super.onUse(state, world, pos, player, hit);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(Properties.HORIZONTAL_FACING, Properties.LIT);
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new Model(initialBlockState, world, pos);
    }
    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        ItemScatterer.onStateReplaced(state, newState, world, pos);
        super.onStateReplaced(state, world, pos, newState, moved);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return PotBlockEntity::ticker;
    }

    public static final class Model extends BlockModel {
        public static final ItemStack MODEL = ItemDisplayElementUtil.getModel(Identifier.of(BorukvaFood.MOD_ID, "block/pot"));
        public ItemDisplayElement pot;
        public ServerWorld world;
        public BlockPos pos;

        public Model(BlockState state, ServerWorld world, BlockPos pos) {
            this.world = world;
            this.pos = pos;
            init(state);
        }

        public void init(BlockState state) {
            this.pot = ItemDisplayElementUtil.createSimple(MODEL);
            this.pot.setTranslation(new Vector3f(0, 0, -0.49f));
            this.pot.setScale(new Vector3f(0.7f));
            this.pot.setDisplaySize(1f, 1f);
            this.updateStatePos(state);
            this.addElement(pot);
        }

        private void updateStatePos(BlockState state) {
            var direction = state.get(FACING);
            this.pot.setYaw(direction.getPositiveHorizontalDegrees());
            this.pot.setPitch(90f + 180f);
        }
    }
}
