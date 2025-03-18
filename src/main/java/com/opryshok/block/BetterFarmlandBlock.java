package com.opryshok.block;

import com.opryshok.utils.ModProperties;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import xyz.nucleoid.packettweaker.PacketContext;

public class BetterFarmlandBlock extends FarmlandBlock implements PolymerBlock {
    public static final IntProperty FERTILITY;
    public static final IntProperty ACIDITY;
    public static final int MAX_FERTILITY;
    public static final int MAX_ACIDITY;

    static{
        FERTILITY = ModProperties.FERTILITY;
        ACIDITY = ModProperties.ACIDITY;
        MAX_FERTILITY = 10;
        MAX_ACIDITY = 10;
    }

    public BetterFarmlandBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FERTILITY, 6).with(ACIDITY, 5));
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
        return Blocks.FARMLAND.getDefaultState().with(Properties.MOISTURE, state.get(MOISTURE));
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
    public int getFertility(BlockState state){
        return state.get(ModProperties.FERTILITY);
    }
    public int getAcidity(BlockState state){
        return state.get(ModProperties.ACIDITY);
    }
}
