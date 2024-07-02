package com.opryshok.item;

import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item PIZZA = registerItem("pizza", new PolyItem(new Item.Settings().food(ModFoodComponents.PIZZA), "pizza"));
    public static Item BEEF_SANDWICH = registerItem("beef_sandwich", new PolyItem(new Item.Settings().food(ModFoodComponents.BEEF_SANDWICH), "beef_sandwich"));
    public static Item FERTILIZER = registerItem("fertilizer", new FertilizerItem(new Item.Settings(), "fertilizer"));

    public static Item TOMATO_SEEDS = registerItem("tomato_seeds", new PolySeedsItem(ModBlocks.TOMATO_BLOCK, new Item.Settings(), "tomato_seeds"));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BorukvaFood.MOD_ID, name), item);
    }
    public static void registerModItems(){
        BorukvaFood.LOGGER.info("Register Mod Items");
    }
}
