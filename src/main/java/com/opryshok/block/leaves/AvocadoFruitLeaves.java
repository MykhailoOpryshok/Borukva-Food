package com.opryshok.block.leaves;

import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import com.opryshok.item.ModItems;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class AvocadoFruitLeaves extends LemonFruitLeaves{
    public final BlockState model;
    public final BlockState modelWaterlogged;
    public AvocadoFruitLeaves(Settings settings) {
        super(settings);
        this.model = PolymerBlockResourceUtils.requestBlock(BlockModelType.TRANSPARENT_BLOCK, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/avocado_fruit_leaves")));
        this.modelWaterlogged = PolymerBlockResourceUtils.requestBlock(BlockModelType.TRANSPARENT_BLOCK_WATERLOGGED, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/avocado_fruit_leaves")));
    }

    @Override
    public ItemStack getFruitDropStack(int count) {
        return ModItems.AVOCADO.getDefaultStack().copyWithCount(count);
    }

    @Override
    public BlockState getBaseBlockState(BlockState state) {
        return ModBlocks.AVOCADO_LEAVES.getDefaultState().with(Properties.WATERLOGGED, state.get(Properties.WATERLOGGED));
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        if (state.get(Properties.WATERLOGGED)) return modelWaterlogged;
        else return model;
    }
}
