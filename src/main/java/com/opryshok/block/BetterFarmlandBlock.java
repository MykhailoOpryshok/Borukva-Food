package com.opryshok.block;

import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class BetterFarmlandBlock extends FarmlandBlock implements PolymerBlock {
    public static final IntProperty FERTILITY;
    public static final IntProperty ACIDITY;

    static{
        FERTILITY = IntProperty.of("fertility", 0, 10);
        ACIDITY = IntProperty.of("acidity", 0, 10);
    }

    public BetterFarmlandBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FERTILITY, 5).with(ACIDITY, 5));
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return Blocks.FARMLAND.getDefaultState();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new IntProperty[]{FERTILITY, ACIDITY});
        super.appendProperties(builder);
    }

    @Override
    public Item asItem() {
        return Items.DIRT;
    }
}
