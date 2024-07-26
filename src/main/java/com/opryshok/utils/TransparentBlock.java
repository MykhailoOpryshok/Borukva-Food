package com.opryshok.utils;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;

public interface TransparentBlock extends PolymerBlock, PolymerTexturedBlock {
    PolymerBlockModel MODEL = PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/transparent_texture"));
    BlockState TRANSPARENT = PolymerBlockResourceUtils.requestBlock(BlockModelType.BIOME_PLANT_BLOCK, MODEL);

    @Override
    default BlockState getPolymerBlockState(BlockState state) {
        return TRANSPARENT;
    }
}
