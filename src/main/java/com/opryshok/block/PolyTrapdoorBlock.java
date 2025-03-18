package com.opryshok.block;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import xyz.nucleoid.packettweaker.PacketContext;

public class PolyTrapdoorBlock extends TrapdoorBlock implements PolymerTexturedBlock {
    private final BlockState TOP_TRAPDOOR_NORTH;
    private final BlockState BOTTOM_TRAPDOOR_NORTH;
    private final BlockState TOP_TRAPDOOR_WEST;
    private final BlockState BOTTOM_TRAPDOOR_WEST;
    private final BlockState NORTH_TRAPDOOR;
    private final BlockState EAST_TRAPDOOR;
    private final BlockState SOUTH_TRAPDOOR;
    private final BlockState WEST_TRAPDOOR;
    private final BlockState TOP_TRAPDOOR_NORTH_WATERLOGGED;
    private final BlockState BOTTOM_TRAPDOOR_NORTH_WATERLOGGED;
    private final BlockState TOP_TRAPDOOR_WEST_WATERLOGGED;
    private final BlockState BOTTOM_TRAPDOOR_WEST_WATERLOGGED;
    private final BlockState NORTH_TRAPDOOR_WATERLOGGED;
    private final BlockState EAST_TRAPDOOR_WATERLOGGED;
    private final BlockState SOUTH_TRAPDOOR_WATERLOGGED;
    private final BlockState WEST_TRAPDOOR_WATERLOGGED;
    private final String path;
    public PolyTrapdoorBlock(Settings settings, String path) {
        super(BlockSetType.OAK, settings);
        this.path = path;
        TOP_TRAPDOOR_NORTH = initializeModels(BlockModelType.TOP_TRAPDOOR, "top_north");
        BOTTOM_TRAPDOOR_NORTH = initializeModels(BlockModelType.BOTTOM_TRAPDOOR, "bottom_north");
        TOP_TRAPDOOR_WEST = initializeModels(BlockModelType.TOP_TRAPDOOR, "top_west");
        BOTTOM_TRAPDOOR_WEST = initializeModels(BlockModelType.BOTTOM_TRAPDOOR, "bottom_west");
        NORTH_TRAPDOOR = initializeModels(BlockModelType.NORTH_TRAPDOOR, "north");
        EAST_TRAPDOOR = initializeModels(BlockModelType.EAST_TRAPDOOR, "east");
        SOUTH_TRAPDOOR = initializeModels(BlockModelType.SOUTH_TRAPDOOR, "south");
        WEST_TRAPDOOR = initializeModels(BlockModelType.WEST_TRAPDOOR, "west");
        TOP_TRAPDOOR_NORTH_WATERLOGGED = initializeModels(BlockModelType.TOP_TRAPDOOR_WATERLOGGED, "top_north");
        BOTTOM_TRAPDOOR_NORTH_WATERLOGGED = initializeModels(BlockModelType.BOTTOM_TRAPDOOR_WATERLOGGED, "bottom_north");
        TOP_TRAPDOOR_WEST_WATERLOGGED = initializeModels(BlockModelType.TOP_TRAPDOOR_WATERLOGGED, "top_west");
        BOTTOM_TRAPDOOR_WEST_WATERLOGGED = initializeModels(BlockModelType.BOTTOM_TRAPDOOR_WATERLOGGED, "bottom_west");
        NORTH_TRAPDOOR_WATERLOGGED = initializeModels(BlockModelType.NORTH_TRAPDOOR_WATERLOGGED, "north");
        EAST_TRAPDOOR_WATERLOGGED = initializeModels(BlockModelType.EAST_TRAPDOOR_WATERLOGGED, "east");
        SOUTH_TRAPDOOR_WATERLOGGED = initializeModels(BlockModelType.SOUTH_TRAPDOOR_WATERLOGGED, "south");
        WEST_TRAPDOOR_WATERLOGGED = initializeModels(BlockModelType.WEST_TRAPDOOR_WATERLOGGED, "west");
    }
    public BlockState initializeModels(BlockModelType type, String typeForPath){
        return PolymerBlockResourceUtils.requestBlock(type, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/" + path + "_" + typeForPath)));
    }
    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, PacketContext context) {
        return Blocks.OAK_TRAPDOOR.getDefaultState();
    }
    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
        boolean waterlogged = state.get(WATERLOGGED);

        if(state.get(Properties.OPEN)){
            return switch (state.get(Properties.HORIZONTAL_FACING)){
                case EAST -> waterlogged ? EAST_TRAPDOOR_WATERLOGGED : EAST_TRAPDOOR;
                case WEST -> waterlogged ? WEST_TRAPDOOR_WATERLOGGED : WEST_TRAPDOOR;
                case SOUTH -> waterlogged ? SOUTH_TRAPDOOR_WATERLOGGED : SOUTH_TRAPDOOR;
                default -> waterlogged ? NORTH_TRAPDOOR_WATERLOGGED : NORTH_TRAPDOOR;
            };
        }else {
            if(state.get(Properties.BLOCK_HALF) == BlockHalf.TOP){
                if (state.get(FACING) == Direction.NORTH || state.get(FACING) == Direction.SOUTH){
                    return waterlogged ? TOP_TRAPDOOR_NORTH_WATERLOGGED : TOP_TRAPDOOR_NORTH;
                } else {
                    return waterlogged ? TOP_TRAPDOOR_WEST_WATERLOGGED : TOP_TRAPDOOR_WEST;
                }
            } else{
                if (state.get(FACING) == Direction.NORTH || state.get(FACING) == Direction.SOUTH){
                    return waterlogged ? BOTTOM_TRAPDOOR_NORTH_WATERLOGGED : BOTTOM_TRAPDOOR_NORTH;
                } else {
                    return waterlogged ? BOTTOM_TRAPDOOR_WEST_WATERLOGGED : BOTTOM_TRAPDOOR_WEST;
                }
            }
        }
    }
}
