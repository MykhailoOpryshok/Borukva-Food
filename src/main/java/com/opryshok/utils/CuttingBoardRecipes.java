package com.opryshok.utils;

import com.opryshok.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.HashMap;

public class CuttingBoardRecipes {
    public static final HashMap<Item, ItemStack> RECIPES = new HashMap<>();
    static {
        put(Items.BREAD, new ItemStack(ModItems.BREAD_SLICE, 2));
        put(Items.BEEF, new ItemStack(ModItems.BEEF_SLICES, 2));
        put(ModItems.CHILLI_PEPPER, new ItemStack(ModItems.HOT_SPICE, 1));
    }
    public static void put(Item ingredient, ItemStack result){
        RECIPES.put(ingredient, result);
    }
}
