package com.opryshok.block;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class PolySlabBlock extends SlabBlock implements PolymerTexturedBlock {
    private final BlockState TOP_SLAB;
    private final BlockState TOP_SLAB_WATERLOGGED;
    private final BlockState BOTTOM_SLAB;
    private final BlockState BOTTOM_SLAB_WATERLOGGED;
    private final BlockState DOUBLE;

    public PolySlabBlock(Settings settings, String path, BlockState base) {
        super(settings);
        DOUBLE = base;
        TOP_SLAB = PolymerBlockResourceUtils.requestBlock(BlockModelType.TOP_SLAB, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/" + path + "_top")));
        TOP_SLAB_WATERLOGGED = PolymerBlockResourceUtils.requestBlock(BlockModelType.TOP_SLAB_WATERLOGGED, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/" + path + "_top")));
        BOTTOM_SLAB = PolymerBlockResourceUtils.requestBlock(BlockModelType.BOTTOM_SLAB, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/" + path)));
        BOTTOM_SLAB_WATERLOGGED = PolymerBlockResourceUtils.requestBlock(BlockModelType.BOTTOM_SLAB_WATERLOGGED, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/" + path)));
    }
    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return Blocks.OAK_SLAB.getDefaultState();
    }
    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return switch (state.get(TYPE)){
            case TOP -> state.get(WATERLOGGED) ? TOP_SLAB_WATERLOGGED : TOP_SLAB;
            case BOTTOM -> state.get(WATERLOGGED) ? BOTTOM_SLAB_WATERLOGGED : BOTTOM_SLAB;
            default -> DOUBLE;
        };
    }
}
