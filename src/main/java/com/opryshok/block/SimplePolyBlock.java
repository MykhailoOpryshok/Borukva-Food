package com.opryshok.block;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import xyz.nucleoid.packettweaker.PacketContext;

public class SimplePolyBlock extends Block implements PolymerTexturedBlock {
    private final BlockState model;
    public SimplePolyBlock(Settings settings, String path) {
        super(settings);
        model = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/"+path)));
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
        return model;
    }
}
