package com.opryshok.datagen;

import com.opryshok.block.ModBlocks;
import com.opryshok.compat.tags.FarmersDelightTags;
import com.opryshok.item.ModItems;
import com.opryshok.utils.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        registerCompatTags();

        valueLookupBuilder(ItemTags.HOGLIN_FOOD)
                .add(ModItems.NETHER_WHEAT);

        valueLookupBuilder(ModTags.Items.PLANT_FOOD)
                .add(Items.BEETROOT)
                .add(Items.CARROT)
                .add(Items.POTATO)
                .add(Items.APPLE)
                .add(ModItems.LEMON)
                .add(ModItems.TOMATO)
                .add(ModItems.CORN)
                .add(ModItems.LETTUCE)
                .add(ModItems.CUCUMBER)
                .add(ModItems.CHILLI_PEPPER)
                .add(ModItems.CABBAGE)
                .add(ModItems.ENDER_INFECTED_ONION);

        valueLookupBuilder(ModTags.Items.ROTTEN_SOUP_INGREDIENTS)
                .add(Items.ROTTEN_FLESH)
                .add(Items.BONE)
                .add(Items.COD)
                .add(Items.SPIDER_EYE)
                .add(Items.POISONOUS_POTATO);

        valueLookupBuilder(ModTags.Items.LEMON_LOGS)
                .add(ModBlocks.LEMON_LOG_ITEM)
                .add(ModBlocks.LEMON_WOOD_ITEM)
                .add(ModBlocks.STRIPPED_LEMON_LOG_ITEM)
                .add(ModBlocks.STRIPPED_LEMON_WOOD_ITEM);

        valueLookupBuilder(ModTags.Items.AVOCADO_LOGS)
                .add(ModBlocks.AVOCADO_LOG_ITEM)
                .add(ModBlocks.AVOCADO_WOOD_ITEM)
                .add(ModBlocks.STRIPPED_AVOCADO_LOG_ITEM)
                .add(ModBlocks.STRIPPED_AVOCADO_WOOD_ITEM);

        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
                .forceAddTag(ModTags.Items.AVOCADO_LOGS)
                .forceAddTag(ModTags.Items.LEMON_LOGS);

        valueLookupBuilder(ItemTags.PLANKS)
                .add(ModBlocks.AVOCADO_PLANKS_ITEM)
                .add(ModBlocks.LEMON_PLANKS_ITEM);

        valueLookupBuilder(ItemTags.STAIRS)
                .add(ModBlocks.AVOCADO_STAIRS_ITEM)
                .add(ModBlocks.LEMON_STAIRS_ITEM);

        valueLookupBuilder(ItemTags.BUTTONS)
                .add(ModBlocks.AVOCADO_BUTTON_ITEM)
                .add(ModBlocks.LEMON_BUTTON_ITEM);

        valueLookupBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.AVOCADO_PRESSURE_PLATE_ITEM)
                .add(ModBlocks.LEMON_PRESSURE_PLATE_ITEM);

        valueLookupBuilder(ItemTags.FENCE_GATES)
                .add(ModBlocks.AVOCADO_FENCE_GATE_ITEM)
                .add(ModBlocks.LEMON_FENCE_GATE_ITEM);

        valueLookupBuilder(ItemTags.FENCES)
                .add(ModBlocks.AVOCADO_FENCE_ITEM)
                .add(ModBlocks.LEMON_FENCE_ITEM);

        valueLookupBuilder(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.AVOCADO_FENCE_ITEM)
                .add(ModBlocks.LEMON_FENCE_ITEM);

        valueLookupBuilder(ItemTags.LEAVES)
                .add(ModBlocks.LEMON_LEAVES_ITEM)
                .add(ModBlocks.AVOCADO_LEAVES_ITEM)
                .add(ModBlocks.AVOCADO_FRUIT_LEAVES_ITEM)
                .add(ModBlocks.LEMON_FRUIT_LEAVES_ITEM);

        valueLookupBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.AVOCADO_SLAB_ITEM)
                .add(ModBlocks.LEMON_SLAB_ITEM);

        valueLookupBuilder(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.AVOCADO_DOOR_ITEM)
                .add(ModBlocks.LEMON_DOOR_ITEM);

        valueLookupBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.AVOCADO_TRAPDOOR_ITEM)
                .add(ModBlocks.LEMON_TRAPDOOR_ITEM);

        valueLookupBuilder(ItemTags.SAPLINGS)
                .add(ModBlocks.LEMON_SAPLING_ITEM)
                .add(ModBlocks.AVOCADO_SAPLING_ITEM);

        valueLookupBuilder(ModTags.Items.CONVENTIONAL_SEEDS)
            .addOptionalTag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
            .add(ModItems.RICE)
            .add(ModItems.TOMATO_SEEDS)
            .add(ModItems.CABBAGE_SEEDS)
            .add(ModItems.CORN_SEEDS)
            .add(ModItems.CHILLI_PEPPER_SEEDS)
            .add(ModItems.ENDER_INFECTED_ONION_SEEDS)
            .add(ModItems.CUCUMBER_SEEDS)
            .add(ModItems.LETTUCE_SEEDS)
            .add(ModItems.ONION_SEEDS)
            .add(ModItems.BLACKCURRANTS)
            .add(ModItems.GOOSEBERRY)
            .add(ModItems.NETHER_WHEAT_SEEDS);

        valueLookupBuilder(ConventionalItemTags.FOODS)
                .add(ModItems.RICE_BOWL, ModItems.SALMON_FILLET, ModItems.SALMON_MAKI, ModItems.SALMON_NIGIRI,
                        ModItems.SALMON_URAMAKI, ModItems.ONIGIRI, ModItems.NORI, ModItems.SAUERKRAUT, ModItems.SALO,
                        ModItems.SUNFLOWER_SEED, ModItems.ROASTED_SUNFLOWER_SEED, ModItems.TOMATO, ModItems.CABBAGE,
                        ModItems.CHILLI_PEPPER, ModItems.CORN, ModItems.CUCUMBER, ModItems.LETTUCE, ModItems.LEMON,
                        ModItems.BLACKCURRANTS, ModItems.GOOSEBERRY, ModItems.ONION, ModItems.ENDER_INFECTED_ONION,
                        ModItems.WAFFLE, ModItems.CHOCOLATE_BAR, ModItems.MEAT_PIZZA_SLICE, ModItems.VEGAN_PIZZA_SLICE,
                        ModItems.CHOCOLATE_ICE_CREAM, ModItems.ICE_CREAM, ModItems.SWEET_BERRY_COOKIE,
                        ModItems.BLACKCURRANT_COOKIE, ModItems.BEEF_SANDWICH, ModItems.TOMATO_SANDWICH,
                        ModItems.BREAD_SLICE, ModItems.BORSCH, ModItems.BROTH, ModItems.ROTTEN_SOUP,
                        ModItems.BEEF_SLICES, ModItems.VEGAN_BARBECUE, ModItems.COOKED_VEGAN_BARBECUE,
                        ModItems.BEEF_BARBECUE, ModItems.COOKED_BEEF_BARBECUE, ModItems.LEMON_PIE, ModItems.APPLE_PIE,
                        ModItems.HONEY_PIE, ModItems.PICKLE, ModItems.APPLE_CANDY, ModItems.HONEY_CANDY,
                        ModItems.JACK_CANDY, ModItems.PUMPKIN_CANDY, ModItems.LEMON_CANDY, ModItems.SALT_POPCORN,
                        ModItems.CHOCOLATE_POPCORN, ModItems.CHEESE_POPCORN, ModItems.POPCORN, ModItems.CHEESE,
                        ModItems.TOMATO_SLICES, ModItems.CUCUMBER_SLICES, ModItems.LAVASH, ModItems.SHAWARMA,
                        ModItems.BEEF_SALAD, ModItems.VEGETABLE_SALAD, ModItems.COOKED_BEEF_SLICES, ModItems.AVOCADO,
                        ModItems.NETHER_BUN, ModItems.FUNGUS_PIZZA_SLICE, ModItems.BOILED_CORN, ModItems.HOGLIN_MEAT,
                        ModItems.COOKED_HOGLIN_MEAT, ModItems.FUNGUS_STEW, ModItems.COOKED_CHICKEN_LEG,
                        ModItems.CHICKEN_LEG, ModItems.COOKED_MUTTON_SLICES, ModItems.MUTTON_SLICES,
                        ModItems.COOKED_SQUID_RING, ModItems.SQUID_RING, ModItems.PEELED_SQUID_TENTACLES,
                        ModItems.CHORUS_FRUIT_IN_CHOCOLATE_ON_A_STICK, ModItems.CHORUS_FRUITS_WITH_ENDER_JAM,
                        ModItems.ENDER_JAM_STEW_WITH_CHORUS_FRUIT, ModItems.ENDER_PIE, ModItems.GOLDEN_CHORUS_FRUIT,
                        ModItems.BREAD_SLICE_WITH_HONEY, ModItems.BUTTER, ModItems.CROISSANT, ModItems.GOLDEN_BREAD,
                        ModItems.GRAPE, ModItems.HOGLIN_SANDWICH, ModItems.NETHER_BUN_SLICE);

        // Tools
        valueLookupBuilder(ModTags.Items.TOOLS_KNIVES)
                .add(ModItems.KNIFE);

        // Fertilizers
        valueLookupBuilder(ConventionalItemTags.FERTILIZERS)
                .add(ModItems.FERTILIZER, ModItems.COMPOST);

        // Seeds
        valueLookupBuilder(ConventionalItemTags.SEEDS)
                .add(ModItems.TOMATO_SEEDS, ModItems.CABBAGE_SEEDS, ModItems.CORN_SEEDS, ModItems.CHILLI_PEPPER_SEEDS,
                        ModItems.CUCUMBER_SEEDS, ModItems.LETTUCE_SEEDS, ModItems.ONION_SEEDS,
                        ModItems.ENDER_INFECTED_ONION_SEEDS, ModItems.NETHER_WHEAT_SEEDS, ModItems.SUNFLOWER_SEED);
        valueLookupBuilder(ModTags.Items.SEEDS_TOMATO)
                .add(ModItems.TOMATO_SEEDS);
        valueLookupBuilder(ModTags.Items.SEEDS_CABBAGE)
                .add(ModItems.CABBAGE_SEEDS);
        valueLookupBuilder(ModTags.Items.SEEDS_ONION)
                .add(ModItems.ONION_SEEDS);
        valueLookupBuilder(ModTags.Items.SEEDS_RICE)
                .add(ModItems.RICE); // The item itself is the seed
        valueLookupBuilder(ModTags.Items.SEEDS_CORN)
                .add(ModItems.CORN_SEEDS);
        valueLookupBuilder(ModTags.Items.SEEDS_CHILLI_PEPPER)
                .add(ModItems.CHILLI_PEPPER_SEEDS);
        valueLookupBuilder(ModTags.Items.SEEDS_CUCUMBER)
                .add(ModItems.CUCUMBER_SEEDS);
        valueLookupBuilder(ModTags.Items.SEEDS_LETTUCE)
                .add(ModItems.LETTUCE_SEEDS);
        valueLookupBuilder(ModTags.Items.SEEDS_NETHER_WHEAT)
                .add(ModItems.NETHER_WHEAT_SEEDS);
        valueLookupBuilder(ModTags.Items.CROPS_NETHER_WHEAT)
                .add(ModItems.NETHER_WHEAT);

        // Crops
        valueLookupBuilder(ConventionalItemTags.CROPS)
                .add(ModItems.TOMATO, ModItems.CABBAGE, ModItems.CORN, ModItems.CHILLI_PEPPER, ModItems.CUCUMBER,
                        ModItems.LETTUCE, ModItems.ONION, ModItems.ENDER_INFECTED_ONION, ModItems.NETHER_WHEAT,
                        ModItems.RICE);
        valueLookupBuilder(ModTags.Items.CROPS_TOMATO)
                .add(ModItems.TOMATO);
        valueLookupBuilder(ModTags.Items.CROPS_CABBAGE)
                .add(ModItems.CABBAGE);
        valueLookupBuilder(ModTags.Items.CROPS_ONION)
                .add(ModItems.ONION);
        valueLookupBuilder(ModTags.Items.CROPS_RICE)
                .add(ModItems.RICE);
        valueLookupBuilder(ModTags.Items.CROPS_CORN)
                .add(ModItems.CORN);
        valueLookupBuilder(ModTags.Items.CROPS_CHILLI_PEPPER)
                .add(ModItems.CHILLI_PEPPER);
        valueLookupBuilder(ModTags.Items.CROPS_CUCUMBER)
                .add(ModItems.CUCUMBER);
        valueLookupBuilder(ModTags.Items.CROPS_LETTUCE)
                .add(ModItems.LETTUCE);

        // Grains
        valueLookupBuilder(ModTags.Items.GRAINS_RICE)
                .add(ModItems.RICE);
        valueLookupBuilder(ModTags.Items.GRAINS_WHEATS)
                .add(ModItems.NETHER_WHEAT);

        // Food Categories
        valueLookupBuilder(ConventionalItemTags.VEGETABLE_FOODS)
                .add(ModItems.TOMATO, ModItems.CABBAGE, ModItems.CHILLI_PEPPER, ModItems.CORN, ModItems.CUCUMBER,
                        ModItems.LETTUCE, ModItems.ONION, ModItems.ENDER_INFECTED_ONION, ModItems.PICKLE,
                        ModItems.SAUERKRAUT, ModItems.BOILED_CORN);
        valueLookupBuilder(ConventionalItemTags.FRUIT_FOODS)
                .add(ModItems.LEMON, ModItems.AVOCADO, ModItems.GRAPE);
        valueLookupBuilder(ConventionalItemTags.BERRY_FOODS)
                .add(ModItems.BLACKCURRANTS, ModItems.GOOSEBERRY);
        valueLookupBuilder(ConventionalItemTags.RAW_MEAT_FOODS)
                .add(ModItems.SALO, ModItems.BEEF_SLICES,
                        ModItems.HOGLIN_MEAT, ModItems.CHICKEN_LEG, ModItems.MUTTON_SLICES);
        valueLookupBuilder(ConventionalItemTags.COOKED_MEAT_FOODS)
                .add(ModItems.COOKED_BEEF_SLICES,
                        ModItems.COOKED_HOGLIN_MEAT, ModItems.COOKED_CHICKEN_LEG, ModItems.COOKED_MUTTON_SLICES);
        valueLookupBuilder(ConventionalItemTags.RAW_FISH_FOODS)
                .add(ModItems.SALMON_FILLET, ModItems.SQUID_RING, ModItems.PEELED_SQUID_TENTACLES);
        valueLookupBuilder(ConventionalItemTags.COOKED_FISH_FOODS)
                .add(ModItems.COOKED_SQUID_RING);
        valueLookupBuilder(ConventionalItemTags.SOUP_FOODS)
                .add(ModItems.BORSCH, ModItems.BROTH, ModItems.ROTTEN_SOUP, ModItems.FUNGUS_STEW);
        valueLookupBuilder(ConventionalItemTags.CANDY_FOODS)
                .add(ModItems.CHOCOLATE_BAR, ModItems.APPLE_CANDY, ModItems.HONEY_CANDY, ModItems.JACK_CANDY,
                        ModItems.PUMPKIN_CANDY, ModItems.LEMON_CANDY);
        valueLookupBuilder(ConventionalItemTags.PIE_FOODS)
                .add(ModItems.LEMON_PIE, ModItems.APPLE_PIE, ModItems.HONEY_PIE, ModItems.ENDER_PIE);
        valueLookupBuilder(ConventionalItemTags.COOKIE_FOODS)
                .add(ModItems.SWEET_BERRY_COOKIE, ModItems.BLACKCURRANT_COOKIE);
        valueLookupBuilder(ConventionalItemTags.GOLDEN_FOODS)
                .add(ModItems.GOLDEN_CHORUS_FRUIT, ModItems.GOLDEN_BREAD);
        valueLookupBuilder(ConventionalItemTags.FOOD_POISONING_FOODS)
                .add(ModItems.ROTTEN_SOUP);
        valueLookupBuilder(ConventionalItemTags.BREAD_FOODS)
                .add(ModItems.WAFFLE, ModItems.BREAD_SLICE, ModItems.LAVASH, ModItems.NETHER_BUN,
                        ModItems.NETHER_BUN_SLICE, ModItems.CROISSANT, ModItems.GOLDEN_BREAD,
                        ModItems.BREAD_SLICE_WITH_HONEY);

        // Specific Food Categories (Farmers Delight style)
        valueLookupBuilder(ModTags.Items.FOODS_VEGETABLES_ONION).add(ModItems.ONION);
        valueLookupBuilder(ModTags.Items.FOODS_VEGETABLES_TOMATO).add(ModItems.TOMATO);
        valueLookupBuilder(ModTags.Items.FOODS_VEGETABLES_CORN).add(ModItems.CORN, ModItems.BOILED_CORN);
        valueLookupBuilder(ModTags.Items.FOODS_VEGETABLES_CHILLI_PEPPER).add(ModItems.CHILLI_PEPPER);
        valueLookupBuilder(ModTags.Items.FOODS_VEGETABLES_CUCUMBER).add(ModItems.CUCUMBER);
        valueLookupBuilder(ModTags.Items.FOODS_VEGETABLES_LETTUCE).add(ModItems.LETTUCE);
        valueLookupBuilder(ModTags.Items.FOODS_RAW_FISHES_SALMON).add(ModItems.SALMON_FILLET);
        valueLookupBuilder(ModTags.Items.FOODS_RAW_FISHES_SQUID).add(ModItems.SQUID_RING, ModItems.PEELED_SQUID_TENTACLES);
        valueLookupBuilder(ModTags.Items.FOODS_COOKED_FISHES_SQUID).add(ModItems.COOKED_SQUID_RING);
        valueLookupBuilder(ModTags.Items.FOODS_RAW_MEATS_RAW_BEEF).add(ModItems.BEEF_SLICES);
        valueLookupBuilder(ModTags.Items.FOODS_RAW_MEATS_RAW_CHICKEN).add(ModItems.CHICKEN_LEG);
        valueLookupBuilder(ModTags.Items.FOODS_RAW_MEATS_RAW_MUTTON).add(ModItems.MUTTON_SLICES);
        valueLookupBuilder(ModTags.Items.FOODS_RAW_MEATS_RAW_HOGLIN).add(ModItems.HOGLIN_MEAT);
        valueLookupBuilder(ModTags.Items.FOODS_COOKED_MEATS_COOKED_BEEF).add(ModItems.COOKED_BEEF_SLICES);
        valueLookupBuilder(ModTags.Items.FOODS_COOKED_MEATS_COOKED_CHICKEN).add(ModItems.COOKED_CHICKEN_LEG);
        valueLookupBuilder(ModTags.Items.FOODS_COOKED_MEATS_COOKED_MUTTON).add(ModItems.COOKED_MUTTON_SLICES);
        valueLookupBuilder(ModTags.Items.FOODS_COOKED_MEATS_COOKED_HOGLIN).add(ModItems.COOKED_HOGLIN_MEAT);
        valueLookupBuilder(ModTags.Items.SALAD_INGREDIENTS).add(ModItems.LETTUCE, ModItems.TOMATO_SLICES, ModItems.CUCUMBER_SLICES);
        valueLookupBuilder(ModTags.Items.SALAD_INGREDIENTS_CABBAGE).add(ModItems.CABBAGE);
        valueLookupBuilder(ModTags.Items.FOODS_SALADS).add(ModItems.BEEF_SALAD, ModItems.VEGETABLE_SALAD);

        valueLookupBuilder(ModTags.Items.createTag("dusts/salt"))
                .add(ModItems.SALT);
        valueLookupBuilder(ModTags.Items.createTag("salt"))
                .add(ModItems.SALT);
        valueLookupBuilder(ModTags.Items.createTag("cooking_oil"))
                .add(ModItems.OIL);
        valueLookupBuilder(ModTags.Items.createTag("cheese"))
                .add(ModItems.CHEESE);
        valueLookupBuilder(ModTags.Items.createTag("butter"))
                .add(ModItems.BUTTER);

        // Tool Tags
        valueLookupBuilder(ModTags.Items.createTag("tools/sickle"))
                .add(ModItems.HARVEST_SICKLE);

        // Composting
        valueLookupBuilder(ModTags.Items.createTag("compostable_green"))
                .add(ModItems.TOMATO_SEEDS, ModItems.CABBAGE_SEEDS, ModItems.CORN_SEEDS, ModItems.CHILLI_PEPPER_SEEDS,
                        ModItems.CUCUMBER_SEEDS, ModItems.LETTUCE_SEEDS, ModItems.ONION_SEEDS, ModItems.LETTUCE,
                        ModItems.GRAPE_SAPLING);

        valueLookupBuilder(ModTags.Items.createTag("compostable_brown"))
                .add(ModItems.BREAD_SLICE, ModItems.NETHER_WHEAT, ModItems.CROISSANT);

        // Storage Tags
        valueLookupBuilder(ModTags.Items.createTag("jars"))
                .add(ModItems.PICKLE_JAR);
        valueLookupBuilder(ModTags.Items.createTag("jars/empty"))
                .add(ModItems.EMPTY_JAR);

        valueLookupBuilder(ModTags.Items.createTag("lemon")).add(ModItems.LEMON);
        valueLookupBuilder(ModTags.Items.createTag("fruits/lemon")).add(ModItems.LEMON);
        valueLookupBuilder(ModTags.Items.createTag("avocados")).add(ModItems.AVOCADO);
        valueLookupBuilder(ModTags.Items.createTag("fruits/avocado")).add(ModItems.AVOCADO);
        valueLookupBuilder(ModTags.Items.createTag("foods/grapes")).add(ModItems.GRAPE);
        valueLookupBuilder(ModTags.Items.createTag("foods/gooseberries")).add(ModItems.GOOSEBERRY);

        // Specific Food Categories
        valueLookupBuilder(ModTags.Items.createTag("foods/sushi"))
                .add(ModItems.SALMON_MAKI, ModItems.SALMON_NIGIRI, ModItems.SALMON_URAMAKI, ModItems.ONIGIRI);
        valueLookupBuilder(ModTags.Items.createTag("pizzas"))
                .add(ModItems.MEAT_PIZZA_SLICE, ModItems.VEGAN_PIZZA_SLICE, ModItems.FUNGUS_PIZZA_SLICE);
        valueLookupBuilder(ModTags.Items.createTag("popcorn"))
                .add(ModItems.POPCORN, ModItems.SALT_POPCORN, ModItems.CHOCOLATE_POPCORN, ModItems.CHEESE_POPCORN);
        valueLookupBuilder(ModTags.Items.createTag("foods/chorus_berrie"))
                .add(ModItems.CHORUS_FRUIT_IN_CHOCOLATE_ON_A_STICK, ModItems.CHORUS_FRUITS_WITH_ENDER_JAM,
                        ModItems.ENDER_JAM_STEW_WITH_CHORUS_FRUIT, ModItems.GOLDEN_CHORUS_FRUIT, ModItems.ENDER_PIE);
        valueLookupBuilder(ModTags.Items.createTag("apple_pie"))
                .add(ModItems.APPLE_PIE);
        valueLookupBuilder(ModTags.Items.createTag("spice"))
                .add(ModItems.HOT_SPICE);

        valueLookupBuilder(ModTags.Items.createTag("foods/sandwiches"))
                .add(ModItems.BEEF_SANDWICH, ModItems.TOMATO_SANDWICH, ModItems.HOGLIN_SANDWICH, ModItems.SHAWARMA);
        valueLookupBuilder(ModTags.Items.createTag("foods/ice_creams"))
                .add(ModItems.ICE_CREAM, ModItems.CHOCOLATE_ICE_CREAM);


        // Common Cooking Ingredients
        valueLookupBuilder(ModTags.Items.createTag("chocolate")).add(ModItems.CHOCOLATE_BAR);
        valueLookupBuilder(ModTags.Items.createTag("cheese")).add(ModItems.CHEESE);
        valueLookupBuilder(ModTags.Items.createTag("butter")).add(ModItems.BUTTER);
        valueLookupBuilder(ModTags.Items.createTag("jam")).add(ModItems.ENDER_JAM);
        valueLookupBuilder(ModTags.Items.createTag("sea_lettuce")).add(ModItems.NORI); // Nori is a type of sea lettuce/seaweed
        valueLookupBuilder(ModTags.Items.createTag("foods/sauce"))
                .add(ModItems.GUACAMOLE, ModItems.KETCHUP, ModItems.MAYONNAISE, ModItems.ENDER_JAM);
        valueLookupBuilder(ModTags.Items.createTag("foods/sauces/ketchup")).add(ModItems.KETCHUP);
        valueLookupBuilder(ModTags.Items.createTag("foods/sauces/mayonnaise")).add(ModItems.MAYONNAISE);

        // --- Additional Tool Tags ---
        valueLookupBuilder(ModTags.Items.createTag("tools/knife")).add(ModItems.KNIFE);
        valueLookupBuilder(ModTags.Items.createTag("tools/scythe")).add(ModItems.HARVEST_SICKLE);

    }

    private void registerCompatTags()   {
        // --- FarmersDelight ---
        valueLookupBuilder(FarmersDelightTags.KNIVES)
                .add(ModItems.KNIFE);

        valueLookupBuilder(FarmersDelightTags.STRAW_HARVESTERS)
                .add(ModItems.HARVEST_SICKLE);

        valueLookupBuilder(FarmersDelightTags.CABBAGE_ROLL_INGREDIENTS)
                .add(ModItems.HOGLIN_MEAT)
                .add(ModItems.MUTTON_SLICES)
                .add(ModItems.BEEF_SLICES);

        valueLookupBuilder(FarmersDelightTags.MEALS)
                .add(ModItems.BORSCH, ModItems.BROTH, ModItems.ROTTEN_SOUP, ModItems.FUNGUS_STEW);
    }
}
