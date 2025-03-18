package com.opryshok.utils.TransparentBlocks;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.block.BlockState;
import xyz.nucleoid.packettweaker.PacketContext;

public interface TransparentPlant extends PolymerBlock, PolymerTexturedBlock {
    BlockState TRANSPARENT = PolymerBlockResourceUtils.requestEmpty(BlockModelType.BIOME_PLANT_BLOCK);

    @Override
    default BlockState getPolymerBlockState(BlockState state, PacketContext context) {
        return TRANSPARENT;
    }
}
