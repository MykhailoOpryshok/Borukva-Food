package com.opryshok.block;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.blocks.api.BlockModelType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.opryshok.BorukvaFood.MOD_ID;

public class ModBlocks {
    public static final Block TOMATO_BLOCK = registerBlock("tomato_crop",
            new TomatoBlock(Block.Settings.copy(Blocks.GOLD_BLOCK), BlockModelType.PLANT_BLOCK, "tomato_crop"));


    public static void registerBlocks() {
        BorukvaFood.LOGGER.info("Blocks register");
    }
    public static Block registerBlock(String modelId, Block block){
        return Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, modelId), block);
    }
    public static BlockItem registerBlockItem(String modelId, BlockItem item){
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, modelId), item);
    }
}
