package com.opryshok.block;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TintedParticleLeavesBlock;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import xyz.nucleoid.packettweaker.PacketContext;

public class PolyLeavesBlock extends TintedParticleLeavesBlock implements PolymerTexturedBlock {
    public final BlockState model;
    public final BlockState modelWaterlogged;
    public PolyLeavesBlock(Settings settings, String modelId) {
        super(1.f, settings);
        model = PolymerBlockResourceUtils.requestBlock(BlockModelType.TRANSPARENT_BLOCK, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/"+ modelId)));
        modelWaterlogged = PolymerBlockResourceUtils.requestBlock(BlockModelType.TRANSPARENT_BLOCK_WATERLOGGED, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/"+modelId)));
    }

    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, PacketContext context) {
        return Blocks.OAK_LEAVES.getDefaultState();
    }
    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
        if (state.get(Properties.WATERLOGGED)) return modelWaterlogged;
        else return model;
    }
}
