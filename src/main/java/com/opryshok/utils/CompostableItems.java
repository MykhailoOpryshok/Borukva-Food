package com.opryshok.utils;

import com.opryshok.item.ModItems;
import net.minecraft.block.ComposterBlock;

public class CompostableItems {
    public static void register(){
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.TOMATO_SEEDS, 0.3f);
    }
}
