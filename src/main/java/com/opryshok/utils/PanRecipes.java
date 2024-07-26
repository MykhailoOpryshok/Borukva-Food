package com.opryshok.utils;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.HashMap;

public class PanRecipes {
    public static final HashMap<Item, Item> RECIPES = new HashMap<>();

    static {
        // vanila
        put(Items.CHICKEN, Items.COOKED_CHICKEN);
        put(Items.KELP, Items.DRIED_KELP);
        put(Items.BEEF, Items.COOKED_BEEF);
        put(Items.MUTTON, Items.COOKED_MUTTON);
        put(Items.PORKCHOP, Items.COOKED_PORKCHOP);
        put(Items.SALMON, Items.COOKED_SALMON);
        put(Items.POTATO, Items.BAKED_POTATO);
        put(Items.COD, Items.COOKED_COD);
        put(Items.RABBIT, Items.COOKED_RABBIT);
        // mod items

    }
    public static void put(Item ingredient, Item result){
        RECIPES.put(ingredient, result);
    }
}
