package com.opryshok.utils;

import com.opryshok.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.HashMap;

public class CuttingBoardRecipes {
    public static final HashMap<Item, ItemStack> RECIPES = new HashMap<>();
    static {
        put(Items.BREAD, new ItemStack(ModItems.BREAD_SLICE, 4));
        put(Items.BEEF, new ItemStack(ModItems.BEEF_SLICES, 2));
        put(ModItems.CHILLI_PEPPER, new ItemStack(ModItems.HOT_SPICE, 1));
        put(ModItems.TOMATO, new ItemStack(ModItems.TOMATO_SLICES, 2));
        put(ModItems.CUCUMBER, new ItemStack(ModItems.CUCUMBER_SLICES, 2));
        put(Items.COOKED_BEEF, new ItemStack(ModItems.COOKED_BEEF_SLICES, 2));
        put(Items.DRIED_KELP, new ItemStack(ModItems.NORI, 2));
        put(Items.PORKCHOP, new ItemStack(ModItems.SALO, 2));
        put(Items.SALMON, new ItemStack(ModItems.SALMON_FILLET, 2));
        put(Items.SUNFLOWER, new ItemStack(ModItems.SUNFLOWER_SEED, 4));
    }
    public static void put(Item ingredient, ItemStack result){
        RECIPES.put(ingredient, result);
    }
}
