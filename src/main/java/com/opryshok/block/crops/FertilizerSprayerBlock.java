package com.opryshok.block.crops;

import com.mojang.serialization.MapCodec;
import com.opryshok.BorukvaFood;
import com.opryshok.entity.FertilizerSprayerBlockEntity;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
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
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class FertilizerSprayerBlock extends BlockWithEntity implements FactoryBlock, BlockEntityProvider, InventoryProvider {
    public static BooleanProperty POWERED = Properties.POWERED;
    public static final MapCodec<FertilizerSprayerBlock> CODEC = createCodec(FertilizerSprayerBlock::new);
    public FertilizerSprayerBlock(Settings settings) {
        super(settings.nonOpaque());
        this.setDefaultState(getDefaultState().with(POWERED, false));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.isSneaking() && world.getBlockEntity(pos) instanceof FertilizerSprayerBlockEntity entity){
            entity.openGui((ServerPlayerEntity) player);
            return ActionResult.SUCCESS;
        }
        return super.onUse(state, world, pos, player, hit);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
        world.setBlockState(pos, state.with(POWERED, world.isReceivingRedstonePower(pos)));
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        ItemScatterer.onStateReplaced(state, newState, world, pos);
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FertilizerSprayerBlockEntity(pos, state);
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return Blocks.BARRIER.getDefaultState();
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return FertilizerSprayerBlockEntity::tick;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(Properties.POWERED);
    }

    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return Blocks.DISPENSER.getDefaultState();
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new Model(initialBlockState);
    }

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        var inv = world.getBlockEntity(pos);
        return inv instanceof SidedInventory ? (SidedInventory) inv : null;
    }

    public static class Model extends BlockModel {
        public static final ItemStack MODEL_ON = BaseItemProvider.requestModel(Identifier.of(BorukvaFood.MOD_ID, "block/fertilizer_sprayer_on"));
        public static final ItemStack MODEL_OFF = BaseItemProvider.requestModel(Identifier.of(BorukvaFood.MOD_ID, "block/fertilizer_sprayer_off"));
        public ItemDisplayElement main;

        public Model(BlockState state){
            init(state);
        }
        public void init(BlockState state){
            main = state.get(Properties.POWERED) ? ItemDisplayElementUtil.createSimple(MODEL_ON) : ItemDisplayElementUtil.createSimple(MODEL_OFF);
            main.setScale(new Vector3f(2));
            addElement(main);
        }
        private void updateItem(BlockState state) {
            this.removeElement(this.main);
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
