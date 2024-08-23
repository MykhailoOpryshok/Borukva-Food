package com.opryshok.utils;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.block.BlockState;

public interface TransparentFlatTripWire extends PolymerBlock, PolymerTexturedBlock {
    BlockState TRANSPARENT_FLAT_TRIPIWIRE = PolymerBlockResourceUtils.requestEmpty(BlockModelType.TRIPWIRE_BLOCK_FLAT);
    @Override
    default BlockState getPolymerBlockState(BlockState state) {
        return TRANSPARENT_FLAT_TRIPIWIRE;
    }
}
