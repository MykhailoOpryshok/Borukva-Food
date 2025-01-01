package com.opryshok.block;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.util.Identifier;

public class PolyDoorBlock extends DoorBlock implements PolymerTexturedBlock {
    private final BlockState NORTH_DOOR;
    private final BlockState EAST_DOOR;
    private final BlockState SOUTH_DOOR;
    private final BlockState WEST_DOOR;
    private final String path;
    public PolyDoorBlock(Settings settings, String path) {
        super(BlockSetType.OAK, settings);
        this.path = path;
        NORTH_DOOR = initializeModels(BlockModelType.NORTH_DOOR, "north");
        EAST_DOOR = initializeModels(BlockModelType.EAST_DOOR, "east");
        SOUTH_DOOR = initializeModels(BlockModelType.SOUTH_DOOR, "south");
        WEST_DOOR = initializeModels(BlockModelType.WEST_DOOR, "west");
    }
    public BlockState initializeModels(BlockModelType type, String typeForPath){
        return PolymerBlockResourceUtils.requestBlock(type, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/" + path + "_" + typeForPath)));
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
}
