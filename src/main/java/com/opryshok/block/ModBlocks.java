package com.opryshok.block;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.core.api.item.PolymerBlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.opryshok.BorukvaFood.MOD_ID;

public class ModBlocks {
    public static final Block TOMATO_BLOCK = registerBlock("tomato_crop",
            new PolyCropBlock(Block.Settings.copy(Blocks.WHEAT),"tomato_crop"));
    public static final Block BETTER_FARMLAND_BLOCK = registerBlock("better_farmland_block", new BetterFarmlandBlock(Block.Settings.copy(Blocks.FARMLAND)));
    public static final Block MEAT_PIZZA_BLOCK = registerBlock("meat_pizza_block", new MeatPizzaBlock(Block.Settings.copy(Blocks.CAKE),"meat_pizza"));
    public static final BlockItem BETTER_FARMLAND_BLOCK_ITEM = registerBlockItem("better_farmland_block", new PolymerBlockItem(BETTER_FARMLAND_BLOCK, new Item.Settings(), Items.FARMLAND));

    public static void registerBlocks() {
        BorukvaFood.LOGGER.info("Blocks register");
    }
    public static Block registerBlock(String name, Block block){
        return Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, name), block);
    }
    public static BlockItem registerBlockItem(String name, BlockItem item){
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);

    }

}
