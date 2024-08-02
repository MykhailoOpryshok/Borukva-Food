package com.opryshok.utils;

import com.opryshok.item.ModItems;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.Item;

public class CompostableItems {
    private static final float seeds = 0.3f;
    private static final float plant = 0.65f;
    public static void register(){
        put(ModItems.TOMATO_SEEDS, seeds);
        put(ModItems.CORN_SEEDS, seeds);
        put(ModItems.CHILLI_PEPPER_SEEDS, seeds);
        put(ModItems.CABBAGE_SEEDS, seeds);
        put(ModItems.LETTUCE_SEEDS, seeds);
        put(ModItems.ONION_SEEDS, seeds);
        put(ModItems.CUCUMBER_SEEDS, seeds);
        put(ModItems.GOOSEBERRY, seeds);
        put(ModItems.BLACKCURRANTS, seeds);

        put(ModItems.TOMATO, plant);
        put(ModItems.CABBAGE, plant);
        put(ModItems.CHILLI_PEPPER, plant);
        put(ModItems.CORN, plant);
        put(ModItems.CUCUMBER, plant);
        put(ModItems.LETTUCE, plant);
        put(ModItems.ONION, plant);
    }
    private static void put(Item item, float chance){
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(item, chance);
    }
}
