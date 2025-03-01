package com.opryshok.utils;

import com.opryshok.BorukvaFood;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> LEMON_LOGS = createTag("lemon_logs");
        public static final TagKey<Block> AVOCADO_LOGS = createTag("avocado_logs");

        public static final TagKey<Block> CONVENTIONAL_FARMLAND = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "farmland"));
        public static final TagKey<Block> CONVENTIONAL_FARMLANDS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "farmlands"));

        private static TagKey<Block> createTag(String name){
            return  TagKey.of(RegistryKeys.BLOCK, Identifier.of(BorukvaFood.MOD_ID, name));
        }
    }

    public static class Items{
        public static final TagKey<Item> PLANT_FOOD = createTag("plant_food");
        public static final TagKey<Item> ROTTEN_SOUP_INGREDIENTS = createTag("rotten_soup_ingredients");
        public static final TagKey<Item> LEMON_LOGS = createTag("lemon_logs");
        public static final TagKey<Item> AVOCADO_LOGS = createTag("avocado_logs");

        public static final TagKey<Item> CONVENTIONAL_SEEDS = TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "seeds"));

        private static TagKey<Item> createTag(String name){
            return  TagKey.of(RegistryKeys.ITEM, Identifier.of(BorukvaFood.MOD_ID, name));
        }
    }
}
