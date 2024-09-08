package com.opryshok.utils.TransparentBlocks;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.block.BlockState;

public interface TransparentTripWire extends PolymerBlock, PolymerTexturedBlock {
    BlockState TRANSPARENT_TRIPWIRE = PolymerBlockResourceUtils.requestEmpty(BlockModelType.TRIPWIRE_BLOCK);
    @Override
    default BlockState getPolymerBlockState(BlockState state) {
        return TRANSPARENT_TRIPWIRE;
    }
}
