package com.opryshok.block.crops;

import com.opryshok.BorukvaFood;
import com.opryshok.item.ModItems;
import com.opryshok.utils.TransparentBlocks.TransparentPlantWatterlogged;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.attachment.BlockBoundAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidFillable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import xyz.nucleoid.packettweaker.PacketContext;

import java.util.ArrayList;

public class RiceCrop extends TomatoCrop implements TransparentPlantWatterlogged, FluidFillable {
    public RiceCrop(Settings settings) {
        super(settings);
    }
    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState fluid = context.getWorld().getFluidState(context.getBlockPos());
        return fluid.isIn(FluidTags.WATER) && fluid.getLevel() == 8 ? super.getPlacementState(context) : null;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.RICE;
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
        return TransparentPlantWatterlogged.TRANSPARENT_WATTERLOGGED;
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        FluidState fluid = world.getFluidState(pos);
        return super.canPlaceAt(state, world, pos) && fluid.isIn(FluidTags.WATER) && fluid.getLevel() == 8;
    }
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return super.canPlantOnTop(floor, world, pos);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        return !state.canPlaceAt(world, pos) ? Blocks.WATER.getDefaultState() : state;
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return Fluids.WATER.getStill(false);
    }

    @Override
    public boolean canFillWithFluid(@Nullable LivingEntity filler, BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
        return false;
    }

    @Override
    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        return false;
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new Model(initialBlockState);
    }
    public static class Model extends BlockModel {
        public static final ArrayList<ItemStack> MODELS = new ArrayList<>();
        static{
            for (int i = 0; i <= 3; i++){
                MODELS.add(ItemDisplayElementUtil.getModel(Identifier.of(BorukvaFood.MOD_ID, "block/rice_crop_stage"+i)));
            }
        }
        public ItemDisplayElement main;

        public Model(BlockState state){
            init(state);
        }
        public void init(BlockState state){
            this.main = ItemDisplayElementUtil.createSimple(
                    switch (state.get(AGE)) {
                        case 2, 3 -> getModels().get(1);
                        case 4, 5, 6 -> getModels().get(2);
                        case 7 -> getModels().get(3);
                        default -> getModels().getFirst();
                    });
            this.main.setScale(new Vector3f(1f, 2f, 1f));
            this.main.setTranslation(new Vector3f(0f, 0.5f, 0f));
            this.addElement(main);
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
        public ArrayList<ItemStack> getModels (){
            return MODELS;
        }
    }
}
