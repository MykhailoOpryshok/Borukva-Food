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
        public static final TagKey<Block> KNIFE_MINEABLE = createTag("mineable/knife");
        public static final TagKey<Block> SICKLE_MINEABLE = createTag("mineable/sickle");
//        public static final TagKey<Block> MINEABLE_WITH_KNIFE = createTag("mineable/knife");

        public static final TagKey<Block> CONVENTIONAL_FARMLAND = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "farmland"));
        public static final TagKey<Block> CONVENTIONAL_FARMLANDS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "farmlands"));

        private static TagKey<Block> createTag(String name){
            return  TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", name));
        }
    }

    public static class Items{
        public static final TagKey<Item> PLANT_FOOD = createTag("plant_food");
        public static final TagKey<Item> ROTTEN_SOUP_INGREDIENTS = createTag("rotten_soup_ingredients");
        public static final TagKey<Item> LEMON_LOGS = createTag("lemon_logs");
        public static final TagKey<Item> AVOCADO_LOGS = createTag("avocado_logs");


        public static final TagKey<Item> CROPS_CABBAGE = createTag("crops/cabbage");
        public static final TagKey<Item> CROPS_CHILLI_PEPPER = createTag("crops/chilli_pepper");
        public static final TagKey<Item> CROPS_CORN = createTag("crops/corn");
        public static final TagKey<Item> CROPS_CUCUMBER = createTag("crops/cucumber");
        public static final TagKey<Item> CROPS_LETTUCE = createTag("crops/lettuce");
        public static final TagKey<Item> CROPS_ONION = createTag("crops/onion");
        public static final TagKey<Item> CROPS_RICE = createTag("crops/rice");
        public static final TagKey<Item> CROPS_TOMATO = createTag("crops/tomato");
        public static final TagKey<Item> CROPS_NETHER_WHEAT = createTag("crops/nether_wheat");
        public static final TagKey<Item> FOODS_BREADS_WHEAT = createTag("foods/breads/wheat");

        public static final TagKey<Item> FOODS_COOKED_FISHES_COD = createTag("foods/cooked_fishes/cod");
        public static final TagKey<Item> FOODS_COOKED_FISHES_SALMON = createTag("foods/cooked_fishes/salmon");
        public static final TagKey<Item> FOODS_COOKED_FISHES_SQUID = createTag("foods/cooked_fishes/squid");

        public static final TagKey<Item> FOODS_COOKED_MEATS_COOKED_BACON = createTag("foods/cooked_meats/cooked_bacon");
        public static final TagKey<Item> FOODS_COOKED_MEATS_COOKED_BEEF = createTag("foods/cooked_meats/cooked_beef");
        public static final TagKey<Item> FOODS_COOKED_MEATS_COOKED_CHICKEN = createTag("foods/cooked_meats/cooked_chicken");
        public static final TagKey<Item> FOODS_COOKED_MEATS_COOKED_EGGS = createTag("foods/cooked_meats/cooked_eggs");
        public static final TagKey<Item> FOODS_COOKED_MEATS_COOKED_HOGLIN = createTag("foods/cooked_meats/cooked_hoglin");
        public static final TagKey<Item> FOODS_COOKED_MEATS_COOKED_MUTTON = createTag("foods/cooked_meats/cooked_mutton");
        public static final TagKey<Item> FOODS_COOKED_MEATS_COOKED_PORK = createTag("foods/cooked_meats/cooked_pork");

        public static final TagKey<Item> FOODS_DOUGHS = createTag("foods/doughs");
        public static final TagKey<Item> FOODS_DOUGHS_WHEAT = createTag("foods/doughs/wheat");

        public static final TagKey<Item> FOODS_PASTAS = createTag("foods/pastas");
        public static final TagKey<Item> FOODS_PASTA_RAW_PASTAS = createTag("foods/pastas/raw_pastas");

        public static final TagKey<Item> FOODS_SALADS = createTag("foods/salads");

        public static final TagKey<Item> FOODS_RAW_FISHES_COD = createTag("foods/raw_fishes/cod");
        public static final TagKey<Item> FOODS_RAW_FISHES_SALMON = createTag("foods/raw_fishes/salmon");
        public static final TagKey<Item> FOODS_RAW_FISHES_SQUID = createTag("foods/raw_fishes/squid");
        public static final TagKey<Item> FOODS_RAW_FISHES_TROPICAL = createTag("foods/raw_fishes/tropical_fish");

        public static final TagKey<Item> FOODS_RAW_MEATS_RAW_BACON = createTag("foods/raw_meats/raw_bacon");
        public static final TagKey<Item> FOODS_RAW_MEATS_RAW_BEEF = createTag("foods/raw_meats/raw_beef");
        public static final TagKey<Item> FOODS_RAW_MEATS_RAW_CHICKEN = createTag("foods/raw_meats/raw_chicken");
        public static final TagKey<Item> FOODS_RAW_MEATS_RAW_HOGLIN = createTag("foods/raw_meats/raw_hoglin");
        public static final TagKey<Item> FOODS_RAW_MEATS_RAW_MUTTON = createTag("foods/raw_meats/raw_mutton");
        public static final TagKey<Item> FOODS_RAW_MEATS_RAW_PORK = createTag("foods/raw_meats/raw_pork");

        public static final TagKey<Item> FOODS_VEGETABLES_CHILLI_PEPPER = createTag("foods/vegetables/chilli_pepper");
        public static final TagKey<Item> FOODS_VEGETABLES_CORN = createTag("foods/vegetables/corn");
        public static final TagKey<Item> FOODS_VEGETABLES_CUCUMBER = createTag("foods/vegetables/cucumber");
        public static final TagKey<Item> FOODS_VEGETABLES_LETTUCE = createTag("foods/vegetables/lettuce");
        public static final TagKey<Item> FOODS_VEGETABLES_ONION = createTag("foods/vegetables/onion");
        public static final TagKey<Item> FOODS_VEGETABLES_TOMATO = createTag("foods/vegetables/tomato");

        public static final TagKey<Item> GRAINS = createTag("grains");
        public static final TagKey<Item> GRAINS_RICE = createTag("grains/rice");
        public static final TagKey<Item> GRAINS_WHEATS = createTag("grains/wheat");

        public static final TagKey<Item> MILKS = createTag("milks");
        public static final TagKey<Item> MILK_BUCKET = createTag("milks/milk_buckets");
        public static final TagKey<Item> MILK_BOTTLE = createTag("milks/milk_bottles");

        public static final TagKey<Item> SALAD_INGREDIENTS = createTag("salad_ingredients");
        public static final TagKey<Item> SALAD_INGREDIENTS_CABBAGE = createTag("salad_ingredients/cabbage");

        public static final TagKey<Item> SEEDS_CABBAGE = createTag("seeds/cabbage");
        public static final TagKey<Item> SEEDS_CHILLI_PEPPER = createTag("seeds/chilli_pepper");
        public static final TagKey<Item> SEEDS_CORN = createTag("seeds/corn");
        public static final TagKey<Item> SEEDS_CUCUMBER = createTag("seeds/cucumber");
        public static final TagKey<Item> SEEDS_LETTUCE = createTag("seeds/lettuce");
        public static final TagKey<Item> SEEDS_ONION = createTag("seeds/onion");
        public static final TagKey<Item> SEEDS_RICE = createTag("seeds/rice");
        public static final TagKey<Item> SEEDS_TOMATO = createTag("seeds/tomato");
        public static final TagKey<Item> SEEDS_NETHER_WHEAT = createTag("seeds/nether_wheat");

        public static final TagKey<Item> TOOLS_KNIVES = createTag("tools/knives");

        public static final TagKey<Item> FOODS_CHEESE = createTag("foods/cheese");
        public static final TagKey<Item> FOODS_SUSHI = createTag("foods/sushi");

        public static final TagKey<Item> CONVENTIONAL_SEEDS = TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "seeds"));

        public static TagKey<Item> createTag(String name){
            return  TagKey.of(RegistryKeys.ITEM, Identifier.of("c", name));
        }
    }
}
