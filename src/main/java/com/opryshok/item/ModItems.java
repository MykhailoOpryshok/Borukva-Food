package com.opryshok.item;

import com.opryshok.BorukvaFood;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item PIZZA = registerItem("pizza", new FoodItem(new Item.Settings().food(ModFoodComponents.PIZZA), "pizza"));
    public static Item BEEF_SANDWICH = registerItem("beef_sandwich", new FoodItem(new Item.Settings().food(ModFoodComponents.BEEF_SANDWICH), "beef_sandwich"));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BorukvaFood.MOD_ID, name), item);
    }
    public static void registerModItems(){
        BorukvaFood.LOGGER.info("Register Mod Items");
    }
}
