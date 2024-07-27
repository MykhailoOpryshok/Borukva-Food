package com.opryshok.utils;

import com.opryshok.BorukvaFood;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        private static TagKey<Block> createTag(String name){
            return  TagKey.of(RegistryKeys.BLOCK, Identifier.of(BorukvaFood.MOD_ID, name));
        }
    }

    public static class Items{
        public static final TagKey<Item> PLANT_FOOD = createTag("plant_food");
        public static final TagKey<Item> ROTTEN_SOUP_INGREDIENTS = createTag("rotten_soup_ingredients");
        private static TagKey<Item> createTag(String name){
            return  TagKey.of(RegistryKeys.ITEM, Identifier.of(BorukvaFood.MOD_ID, name));
        }
    }
}
