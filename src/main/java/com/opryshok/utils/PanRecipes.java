package com.opryshok.utils;

import com.opryshok.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.HashMap;

public class PanRecipes {
    public static final HashMap<Item, Item> RECIPES = new HashMap<>();

    static {
        put(Items.CHICKEN, Items.COOKED_CHICKEN);
        put(Items.KELP, Items.DRIED_KELP);
        put(Items.BEEF, Items.COOKED_BEEF);
        put(Items.MUTTON, Items.COOKED_MUTTON);
        put(Items.PORKCHOP, Items.COOKED_PORKCHOP);
        put(Items.SALMON, Items.COOKED_SALMON);
        put(Items.POTATO, Items.BAKED_POTATO);
        put(Items.COD, Items.COOKED_COD);
        put(Items.RABBIT, Items.COOKED_RABBIT);
        put(ModItems.BEEF_SLICES, ModItems.COOKED_BEEF_SLICES);
        put(ModItems.CORN_SEEDS, ModItems.POPCORN);
    }
    public static void put(Item ingredient, Item result){
        RECIPES.put(ingredient, result);
    }
}
