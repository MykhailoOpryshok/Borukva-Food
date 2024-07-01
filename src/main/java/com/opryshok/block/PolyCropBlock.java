package com.opryshok.block;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class PolyCropBlock extends CropBlock implements PolymerTexturedBlock {
    private final BlockState polymerBlockState;
    public PolyCropBlock(Settings settings, BlockModelType type, String modelId ) {
        super(settings);
        this.polymerBlockState = PolymerBlockResourceUtils.requestBlock(
                type,
                PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, modelId).withPrefixedPath("block/")));
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return this.polymerBlockState;
    }
}
