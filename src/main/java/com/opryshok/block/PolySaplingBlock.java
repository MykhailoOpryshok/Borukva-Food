package com.opryshok.block;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.util.Identifier;

public class PolySaplingBlock extends SaplingBlock implements PolymerTexturedBlock {
    private final BlockState model;
    public PolySaplingBlock(SaplingGenerator generator, Settings settings, String modelId) {
        super(generator, settings);
        model = PolymerBlockResourceUtils.requestBlock(BlockModelType.PLANT_BLOCK, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/"+modelId)));
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return model;
    }
}
