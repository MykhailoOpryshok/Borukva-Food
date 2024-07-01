package com.opryshok.block;

import com.opryshok.item.ModItems;
import eu.pb4.polymer.blocks.api.BlockModelType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

public class TomatoBlock extends PolyCropBlock{
    public static final int MAX_AGE = 5;
    public static final IntProperty AGE = Properties.AGE_5;
    public TomatoBlock(Settings settings, BlockModelType type, String modelId) {
        super(settings, type, modelId);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.TOMATO_SEEDS;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
