package com.opryshok.block;

import com.opryshok.utils.DoorModels;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.attachment.BlockBoundAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class PolyDoorBlock extends DoorBlock implements FactoryBlock, PolymerTexturedBlock{
    private final BlockState NORTH_DOOR;
    private final BlockState EAST_DOOR;
    private final BlockState SOUTH_DOOR;
    private final BlockState WEST_DOOR;
    private final String path;
    public PolyDoorBlock(Settings settings, String path) {
        super(BlockSetType.OAK, settings);
        this.path = path;
        NORTH_DOOR = PolymerBlockResourceUtils.requestEmpty(BlockModelType.NORTH_DOOR);
        EAST_DOOR = PolymerBlockResourceUtils.requestEmpty(BlockModelType.EAST_DOOR);
        SOUTH_DOOR = PolymerBlockResourceUtils.requestEmpty(BlockModelType.SOUTH_DOOR);
        WEST_DOOR = PolymerBlockResourceUtils.requestEmpty(BlockModelType.WEST_DOOR);
    }

    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return Blocks.OAK_DOOR.getDefaultState();
    }
    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        if(!state.get(DoorBlock.OPEN)){
            return switch (state.get(DoorBlock.FACING)){
                case EAST -> EAST_DOOR;
                case WEST -> WEST_DOOR;
                case SOUTH -> SOUTH_DOOR;
                default -> NORTH_DOOR;
            };
        } else {
            if(state.get(DoorBlock.HINGE) == DoorHinge.LEFT){
                return switch (state.get(DoorBlock.FACING)){
                    case EAST -> SOUTH_DOOR;
                    case WEST -> NORTH_DOOR;
                    case SOUTH -> WEST_DOOR;
                    default -> EAST_DOOR;
                };
            } else{
                return switch (state.get(DoorBlock.FACING)){
                    case EAST -> NORTH_DOOR;
                    case WEST -> SOUTH_DOOR;
                    case SOUTH -> EAST_DOOR;
                    default -> WEST_DOOR;
                };
            }
        }
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return initialBlockState.get(HALF).equals(DoubleBlockHalf.LOWER) ? new Model(initialBlockState, path) : null;
    }
    public static final class Model extends BlockModel {
        public final ItemStack MODEL_LEFT;
        public final ItemStack MODEL_RIGHT;
        public ItemDisplayElement main;

        public Model(BlockState state, String path) {
            var models = DoorModels.DOOR_MODELS.get(path);
            MODEL_LEFT = models.getLeft();
            MODEL_RIGHT = models.getRight();
            init(state);
        }

        public void init(BlockState state) {
            if(state.get(OPEN)){
                main = state.get(HINGE).equals(DoorHinge.LEFT)
                        ? ItemDisplayElementUtil.createSimple(MODEL_RIGHT)
                        : ItemDisplayElementUtil.createSimple(MODEL_LEFT);
            } else{
                main = state.get(HINGE).equals(DoorHinge.LEFT)
                        ? ItemDisplayElementUtil.createSimple(MODEL_LEFT)
                        : ItemDisplayElementUtil.createSimple(MODEL_RIGHT);
            }
            updateStatePos(state);
            addElement(main);
        }

        private void updateStatePos(BlockState state) {
            var rotation = state.get(FACING).asRotation() + 180;
            var open = state.get(OPEN);
            if(state.get(PolyDoorBlock.HINGE).equals(DoorHinge.LEFT)){
                rotation += open ? 90 : 0;
            } else {
                rotation += open ? 270 : 0;
            }
            main.setYaw(rotation);
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
