package com.opryshok.block;

import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.attachment.BlockBoundAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import xyz.nucleoid.packettweaker.PacketContext;

import static com.opryshok.BorukvaFood.id;

public class PolyStairsBlock extends StairsBlock implements FactoryBlock {
    private final Identifier id;

    public PolyStairsBlock(BlockState baseBlockState, Settings settings, Block template) {
        super(baseBlockState, settings);
        id = Identifier.tryParse(this.getTranslationKey().replace("block.", "").replace(".", ":"));
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
        BlockState oakStairsState = Blocks.OAK_STAIRS.getDefaultState();
        return oakStairsState
                .with(FACING, state.get(FACING))
                .with(SHAPE, state.get(SHAPE))
                .with(HALF, state.get(HALF))
                .with(WATERLOGGED, state.get(WATERLOGGED));
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new Model(initialBlockState, id.getPath());
    }

    public static final class Model extends BlockModel {
        public final ItemStack MODEL_STRAIGHT;
        public final ItemStack MODEL_CORNER_INNER;
        public final ItemStack MODEL_CORNER_OUTER;
        public ItemDisplayElement main;

        public Model(BlockState state, String path) {
            MODEL_STRAIGHT = ItemDisplayElementUtil.getModel(id("block/"+path));
            MODEL_CORNER_INNER = ItemDisplayElementUtil.getModel(id("block/"+path+"_inner"));
            MODEL_CORNER_OUTER = ItemDisplayElementUtil.getModel(id("block/"+path+"_outer"));
            init(state);
        }

        public void init(BlockState state) {
            main = ItemDisplayElementUtil.createSimple();
            main.setTeleportDuration(0);
            main.setInterpolationDuration(0);
            this.updateItem(state);
            updateStatePos(state);
            addElement(main);
        }

        private void updateStatePos(BlockState state) {
            if (state.get(HALF) == BlockHalf.BOTTOM) {
                main.setYaw(state.get(FACING).getPositiveHorizontalDegrees() + switch (state.get(StairsBlock.SHAPE)) {
                    case STRAIGHT -> -90;
                    case INNER_RIGHT, OUTER_RIGHT -> +270;
                    default -> +180;
                });
            }
            else {
                main.setYaw(state.get(FACING).getPositiveHorizontalDegrees() + switch (state.get(StairsBlock.SHAPE)) {
                    case STRAIGHT, INNER_LEFT, OUTER_LEFT -> + 90;
                    default -> - 180;
                });
                main.setRightRotation(RotationAxis.POSITIVE_Z.rotationDegrees(180));
            }
        }
        private void updateItem(BlockState state) {
            main.setItem(switch (state.get(StairsBlock.SHAPE)) {
                case STRAIGHT -> MODEL_STRAIGHT;
                case INNER_LEFT, INNER_RIGHT -> MODEL_CORNER_INNER;
                case OUTER_LEFT, OUTER_RIGHT -> MODEL_CORNER_OUTER;
            });
            float scale = 1.004f;
            main.setScale(new Vector3f((state.get(StairsBlock.SHAPE) == StairShape.STRAIGHT ? 2*scale : scale)));
            float scaleOffset = (scale - 1)/4;
            boolean isTop = state.get(HALF) == BlockHalf.TOP;
            main.setTranslation(new Vector3f(isTop ? -scaleOffset : scaleOffset, isTop ? -scaleOffset : scaleOffset, state.get(StairsBlock.SHAPE) == StairShape.STRAIGHT ? 0 : scaleOffset));
        }
        @Override
        public void notifyUpdate(HolderAttachment.UpdateType updateType) {
            if (updateType == BlockBoundAttachment.BLOCK_STATE_UPDATE) {
                updateItem(this.blockState());
                updateStatePos(this.blockState());
                this.tick();
            }
            super.notifyUpdate(updateType);
        }
    }
}