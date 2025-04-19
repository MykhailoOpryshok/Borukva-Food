package com.opryshok.datagen;

import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import com.opryshok.item.ModItems;
import com.opryshok.recipe.cuttingBoard.CuttingBoardRecipe;
import com.opryshok.recipe.pan.PanRecipe;
import com.opryshok.recipe.pot.PotRecipe;
import com.opryshok.utils.ModTags;
import eu.pb4.factorytools.api.recipe.CountedIngredient;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        compressBlockRecipe(ModBlocks.BEETROOT_CRATE_ITEM, Items.BEETROOT, exporter);
        compressBlockRecipe(ModBlocks.CABBAGE_CRATE_ITEM, ModItems.CABBAGE, exporter);
        compressBlockRecipe(ModBlocks.CARROT_CRATE_ITEM, Items.CARROT, exporter);
        compressBlockRecipe(ModBlocks.CHILLI_CRATE_ITEM, ModItems.CHILLI_PEPPER, exporter);
        compressBlockRecipe(ModBlocks.CORN_CRATE_ITEM, ModItems.CORN, exporter);
        compressBlockRecipe(ModBlocks.CUCUMBER_CRATE_ITEM, ModItems.CUCUMBER, exporter);
        compressBlockRecipe(ModBlocks.LETTUCE_CRATE_ITEM, ModItems.LETTUCE, exporter);
        compressBlockRecipe(ModBlocks.POTATO_CRATE_ITEM, Items.POTATO, exporter);
        compressBlockRecipe(ModBlocks.TOMATO_CRATE_ITEM, ModItems.TOMATO, exporter);
        compressBlockRecipe(ModBlocks.ONION_CRATE_ITEM, ModItems.ONION, exporter);
        compressBlockRecipe(ModBlocks.RICE_CRATE_ITEM, ModItems.RICE, exporter);

        seedsRecipe(ModItems.TOMATO, ModItems.TOMATO_SEEDS, exporter);
        seedsRecipe(ModItems.CABBAGE, ModItems.CABBAGE_SEEDS, exporter);
        seedsRecipe(ModItems.CHILLI_PEPPER, ModItems.CHILLI_PEPPER_SEEDS, exporter);
        seedsRecipe(ModItems.CORN, ModItems.CORN_SEEDS, exporter);
        seedsRecipe(ModItems.CUCUMBER, ModItems.CUCUMBER_SEEDS, exporter);
        seedsRecipe(ModItems.LETTUCE, ModItems.LETTUCE_SEEDS, exporter);
        seedsRecipe(ModItems.ONION, ModItems.ONION_SEEDS, exporter);

        offerSmelting(exporter, List.of(ModItems.HOGLIN_MEAT), RecipeCategory.FOOD, ModItems.COOKED_HOGLIN_MEAT, 0.35f, 200, "cooked_hoglin_meat");
        offerSmelting(exporter, List.of(ModItems.BEEF_SLICES), RecipeCategory.FOOD, ModItems.COOKED_BEEF_SLICES, 0.35f, 200, "cooked_beef_slices");
        offerSmelting(exporter, List.of(ModItems.MUTTON_SLICES), RecipeCategory.FOOD, ModItems.COOKED_MUTTON_SLICES, 0.35f, 200, "cooked_mutton_slices");
        offerSmelting(exporter, List.of(ModItems.CHICKEN_LEG), RecipeCategory.FOOD, ModItems.COOKED_CHICKEN_LEG, 0.35f, 200, "cooked_chicken_leg");
        offerSmelting(exporter, List.of(ModItems.SQUID_RING), RecipeCategory.FOOD, ModItems.COOKED_SQUID_RING, 0.35f, 200, "cooked_squid_ring");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.STOVE_ITEM, 1)
                .pattern("SSS")
                .pattern("G G")
                .pattern("GGG")
                .input('S', Items.IRON_INGOT)
                .input('G', Blocks.MUD_BRICKS)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Blocks.MUD_BRICKS), conditionsFromItem(Blocks.MUD_BRICKS))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModBlocks.STOVE_ITEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PAN_ITEM, 1)
                .pattern(" SS")
                .pattern(" SS")
                .pattern("G  ")
                .input('S', Items.IRON_INGOT)
                .input('G', Items.BRICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModBlocks.PAN_ITEM)));


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CUTTING_BOARD_ITEM, 1)
                .input(Ingredient.fromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wooden_slabs"))))
                .criterion("has_slabs", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wooden_slabs"))))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID,  getRecipeName(ModBlocks.CUTTING_BOARD_ITEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.KNIFE, 1)
                .pattern("I ")
                .pattern("S ")
                .input('I', Items.IRON_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.KNIFE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.HARVEST_SICKLE, 1)
                .pattern("II")
                .pattern(" S")
                .input('I', Items.IRON_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.HARVEST_SICKLE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FERTILIZER, 4)
                .input(Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.FERTILIZER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BLACKCURRANT_COOKIE, 8)
                .pattern("WBW")
                .input('W', Items.WHEAT)
                .input('B', ModItems.BLACKCURRANTS)
                .criterion(hasItem(ModItems.BLACKCURRANTS), conditionsFromItem(ModItems.BLACKCURRANTS))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.BLACKCURRANT_COOKIE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SWEET_BERRY_COOKIE, 8)
                .pattern("WBW")
                .input('W', Items.WHEAT)
                .input('B', Items.SWEET_BERRIES)
                .criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.SWEET_BERRY_COOKIE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SOIL_ANALIZATOR, 1)
                .pattern(" S ")
                .pattern("SRS")
                .pattern("SSS")
                .input('S', Items.COPPER_INGOT)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.SOIL_ANALIZATOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BEEF_SANDWICH, 1)
                .pattern(" S ")
                .pattern("LBK")
                .pattern(" S ")
                .input('S', ModItems.BREAD_SLICE)
                .input('L', ModItems.LETTUCE)
                .input('B', Items.COOKED_BEEF)
                .input('K', ModItems.KETCHUP)
                .criterion(hasItem(Items.COOKED_BEEF), conditionsFromItem(Items.COOKED_BEEF))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.BEEF_SANDWICH)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.TOMATO_SANDWICH, 1)
                .pattern(" S ")
                .pattern("LTM")
                .pattern(" S ")
                .input('S', ModItems.BREAD_SLICE)
                .input('L', ModItems.LETTUCE)
                .input('T', ModItems.TOMATO)
                .input('M', ModItems.MAYONNAISE)
                .criterion(hasItem(ModItems.TOMATO), conditionsFromItem(ModItems.TOMATO))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.TOMATO_SANDWICH)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHOCOLATE_BAR, 1)
                .input(Items.COCOA_BEANS)
                .input(Items.SUGAR)
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.CHOCOLATE_BAR)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ICE_CREAM, 1)
                .input(ModItems.WAFFLE)
                .input(Items.SNOWBALL)
                .criterion(hasItem(ModItems.WAFFLE), conditionsFromItem(ModItems.WAFFLE))
                .criterion(hasItem(Items.SNOWBALL), conditionsFromItem(Items.SNOWBALL))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.ICE_CREAM)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHOCOLATE_ICE_CREAM, 1)
                .input(ModItems.WAFFLE)
                .input(Items.SNOWBALL)
                .input(ModItems.CHOCOLATE_BAR)
                .criterion(hasItem(ModItems.WAFFLE), conditionsFromItem(ModItems.WAFFLE))
                .criterion(hasItem(Items.SNOWBALL), conditionsFromItem(Items.SNOWBALL))
                .criterion(hasItem(ModItems.CHOCOLATE_BAR), conditionsFromItem(ModItems.CHOCOLATE_BAR))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.CHOCOLATE_ICE_CREAM)));

        campfireCookingRecipe(exporter, ModItems.BEEF_BARBECUE, ModItems.COOKED_BEEF_BARBECUE);
        campfireCookingRecipe(exporter, ModItems.VEGAN_BARBECUE, ModItems.COOKED_VEGAN_BARBECUE);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.KETCHUP, 1)
                .input(ModItems.TOMATO)
                .input(ModItems.SALT)
                .input(Items.SUGAR)
                .criterion(hasItem(ModItems.TOMATO), conditionsFromItem(ModItems.TOMATO))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.KETCHUP)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.MAYONNAISE, 1)
                .input(ModItems.OIL)
                .input(Items.EGG)
                .input(ModItems.LEMON)
                .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.MAYONNAISE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ENDER_JAM, 1)
                .input(Items.ENDER_PEARL)
                .input(Items.ENDER_PEARL)
                .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.ENDER_JAM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.VEGAN_BARBECUE, 1)
                .pattern("P  ")
                .pattern("L  ")
                .pattern("S  ")
                .input('P', Ingredient.fromTag(ModTags.Items.PLANT_FOOD))
                .input('L', Ingredient.ofItems(ModItems.CUCUMBER_SLICES, ModItems.TOMATO_SLICES))
                .input('S', Items.STICK)
                .criterion("has_item_with_tag", conditionsFromTag(ModTags.Items.PLANT_FOOD))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.VEGAN_BARBECUE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BEEF_BARBECUE, 1)
                .pattern("B  ")
                .pattern("B  ")
                .pattern("S  ")
                .input('B', ModItems.BEEF_SLICES)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BEEF_SLICES), conditionsFromItem(ModItems.BEEF_SLICES))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.BEEF_BARBECUE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BREWING, ModItems.EMPTY_JAR, 1)
                .pattern(" S ")
                .pattern("G G")
                .pattern(" G ")
                .input('S', Ingredient.fromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wooden_slabs"))))
                .input('G', Items.GLASS_PANE)
                .criterion(hasItem(Items.GLASS_PANE), conditionsFromItem(Items.GLASS_PANE))
                .criterion("has_slabs", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wooden_slabs"))))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, "empty_jar"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.PICKLE_JAR, 1)
                .pattern("SPS")
                .pattern("CCC")
                .pattern(" E ")
                .input('S', ModItems.SALT)
                .input('P', Items.SUGAR)
                .input('C', ModItems.CUCUMBER)
                .input('E', ModItems.EMPTY_JAR)
                .criterion(hasItem(ModItems.EMPTY_JAR), conditionsFromItem(ModItems.EMPTY_JAR))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, "pickle_jar"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.APPLE_CANDY, 1)
                .input(Items.APPLE)
                .input(Items.SUGAR)
                .input(Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, "apple_candy"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.HONEY_CANDY, 3)
                .input(Items.HONEY_BOTTLE)
                .input(Items.SUGAR)
                .criterion(hasItem(Items.HONEY_BOTTLE), conditionsFromItem(Items.HONEY_BOTTLE))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, "honey_candy"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.JACK_CANDY, 3)
                .input(ModItems.WAFFLE)
                .input(ModItems.CHOCOLATE_BAR)
                .criterion(hasItem(ModItems.WAFFLE), conditionsFromItem(ModItems.WAFFLE))
                .criterion(hasItem(ModItems.CHOCOLATE_BAR), conditionsFromItem(ModItems.CHOCOLATE_BAR))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, "jack_candy"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.PUMPKIN_CANDY, 3)
                .input(Items.PUMPKIN)
                .input(Items.SUGAR)
                .criterion(hasItem(Items.PUMPKIN), conditionsFromItem(Items.PUMPKIN))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, "pumpkin_candy"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.LEMON_CANDY, 3)
                .input(ModItems.LEMON)
                .input(Items.SUGAR)
                .criterion(hasItem(ModItems.LEMON), conditionsFromItem(ModItems.LEMON))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, "lemon_candy"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SALT_BLOCK_ITEM, 1)
                .pattern("SS")
                .pattern("SS")
                .input('S', ModItems.SALT)
                .criterion(hasItem(ModItems.SALT), conditionsFromItem(ModItems.SALT))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID,  getRecipeName(ModBlocks.SALT_BLOCK_ITEM)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SALT, 4)
                .input(ModBlocks.SALT_BLOCK_ITEM, 1)
                .criterion(hasItem(ModBlocks.SALT_BLOCK_ITEM), conditionsFromItem(ModBlocks.SALT_BLOCK_ITEM))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModBlocks.SALT_BLOCK_ITEM) + "_to_" + getRecipeName(ModItems.SALT)));

        planksRecipe(ModTags.Items.AVOCADO_LOGS, ModBlocks.AVOCADO_PLANKS_ITEM, exporter);
        planksRecipe(ModTags.Items.LEMON_LOGS, ModBlocks.LEMON_PLANKS_ITEM, exporter);

        woodRecipe(ModBlocks.AVOCADO_LOG_ITEM, ModBlocks.AVOCADO_WOOD_ITEM, exporter);
        woodRecipe(ModBlocks.LEMON_LOG_ITEM, ModBlocks.LEMON_WOOD_ITEM, exporter);
        woodRecipe(ModBlocks.STRIPPED_AVOCADO_LOG_ITEM, ModBlocks.STRIPPED_AVOCADO_WOOD_ITEM, exporter);
        woodRecipe(ModBlocks.STRIPPED_LEMON_LOG_ITEM, ModBlocks.STRIPPED_LEMON_WOOD_ITEM, exporter);

        pieRecipe(ModItems.HONEY_PIE, Items.HONEY_BOTTLE, exporter);
        pieRecipe(ModItems.APPLE_PIE, Items.APPLE, exporter);
        pieRecipe(ModItems.LEMON_PIE, ModItems.LEMON, exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHEESE, 1)
                .input(Items.MILK_BUCKET)
                .input(ModItems.SALT)
                .input(Items.EGG)
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.CHEESE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.WAFFLE, 2)
                .input(Items.WHEAT)
                .input(Items.SUGAR)
                .input(Items.WHEAT)
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.WAFFLE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.LAVASH, 2)
                .input(Items.WHEAT)
                .input(ModItems.SALT)
                .input(Items.WHEAT)
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.LAVASH)));

        popcornRecipe(ModItems.CHEESE_POPCORN, ModItems.CHEESE, exporter);
        popcornRecipe(ModItems.SALT_POPCORN, ModItems.SALT, exporter);
        popcornRecipe(ModItems.CHOCOLATE_POPCORN, ModItems.CHOCOLATE_BAR, exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GUACAMOLE, 1)
                .input(ModItems.AVOCADO)
                .input(Items.BOWL)
                .criterion(hasItem(ModItems.AVOCADO), conditionsFromItem(ModItems.AVOCADO))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.GUACAMOLE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SHAWARMA, 1)
                .input(ModItems.HOT_SPICE)
                .input(ModItems.COOKED_BEEF_SLICES)
                .input(ModItems.KETCHUP)
                .input(ModItems.MAYONNAISE)
                .input(Ingredient.ofItems(ModItems.TOMATO_SLICES, ModItems.CUCUMBER_SLICES))
                .input(ModItems.LETTUCE)
                .input(ModItems.LAVASH)
                .criterion(hasItem(ModItems.COOKED_BEEF_SLICES), conditionsFromItem(ModItems.COOKED_BEEF_BARBECUE))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.SHAWARMA)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.VEGETABLE_SALAD, 1)
                .input(ModItems.LETTUCE)
                .input(ModItems.OIL)
                .input(ModItems.GUACAMOLE)
                .input(ModItems.CUCUMBER_SLICES)
                .input(ModItems.TOMATO_SLICES)
                .input(Items.BOWL)
                .criterion(hasItem(ModItems.LETTUCE), conditionsFromItem(ModItems.LETTUCE))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.VEGETABLE_SALAD)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BEEF_SALAD, 1)
                .input(ModItems.LETTUCE)
                .input(ModItems.OIL)
                .input(ModItems.COOKED_BEEF_SLICES)
                .input(ModItems.CUCUMBER_SLICES)
                .input(ModItems.TOMATO_SLICES)
                .input(Items.BOWL)
                .criterion(hasItem(ModItems.LETTUCE), conditionsFromItem(ModItems.LETTUCE))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.BEEF_SALAD)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.OIL, 1)
                .input(ModItems.SUNFLOWER_SEED)
                .input(ModItems.SUNFLOWER_SEED)
                .criterion(hasItem(ModItems.SUNFLOWER_SEED), conditionsFromItem(ModItems.SUNFLOWER_SEED))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.OIL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.MEAT_PIZZA_ITEM, 1)
                .pattern("KMS")
                .pattern("JCJ")
                .pattern("WWW")
                .input('K', ModItems.KETCHUP)
                .input('M', ModItems.MAYONNAISE)
                .input('S', ModItems.TOMATO_SLICES)
                .input('J', Ingredient.ofItems(Items.COOKED_BEEF, Items.COOKED_PORKCHOP, Items.COOKED_CHICKEN, Items.COOKED_RABBIT, Items.COOKED_MUTTON))
                .input('C', ModItems.CHEESE)
                .input('W', Items.WHEAT)
                .criterion(hasItem(ModItems.KETCHUP), conditionsFromItem(ModItems.KETCHUP))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModBlocks.MEAT_PIZZA_ITEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.VEGAN_PIZZA_ITEM, 1)
                .pattern("KMS")
                .pattern("JCJ")
                .pattern("WWW")
                .input('K', ModItems.KETCHUP)
                .input('M', ModItems.MAYONNAISE)
                .input('S', ModItems.TOMATO_SLICES)
                .input('J', Items.BROWN_MUSHROOM)
                .input('C', ModItems.CHEESE)
                .input('W', Items.WHEAT)
                .criterion(hasItem(Items.BROWN_MUSHROOM), conditionsFromItem(Items.BROWN_MUSHROOM))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModBlocks.VEGAN_PIZZA_ITEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.CHOCOLATE_CAKE_ITEM, 1)
                .pattern("MMM")
                .pattern("CBC")
                .pattern("WWW")
                .input('M', Items.MILK_BUCKET)
                .input('C', ModItems.CHOCOLATE_BAR)
                .input('B', ModItems.BLACKCURRANTS)
                .input('W', Items.WHEAT)
                .criterion(hasItem(ModItems.CHOCOLATE_BAR), conditionsFromItem(ModItems.CHOCOLATE_BAR))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModBlocks.CHOCOLATE_CAKE_ITEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.HONEY_CAKE_ITEM, 1)
                .pattern("MMM")
                .pattern("CBC")
                .pattern("WWW")
                .input('M', Items.MILK_BUCKET)
                .input('C', Items.HONEY_BOTTLE)
                .input('B', ModItems.GOOSEBERRY)
                .input('W', Items.WHEAT)
                .criterion(hasItem(Items.HONEY_BOTTLE), conditionsFromItem(Items.HONEY_BOTTLE))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModBlocks.HONEY_CAKE_ITEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.FERTILIZER_SPRAYER_ITEM, 1)
                .pattern("III")
                .pattern("CDC")
                .pattern("RRR")
                .input('R', Items.REDSTONE)
                .input('C', Items.SMOOTH_STONE)
                .input('D', Items.DISPENSER.asItem())
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.DISPENSER), conditionsFromItem(Items.DISPENSER))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModBlocks.FERTILIZER_SPRAYER_ITEM)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RICE, 3)
                .input(ModItems.RICE_PANICLE)
                .criterion(hasItem(ModItems.RICE_PANICLE), conditionsFromItem(ModItems.RICE_PANICLE))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.RICE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SALMON_NIGIRI, 3)
                .input(ModItems.SALMON_FILLET)
                .input(ModItems.RICE)
                .input(ModItems.NORI)
                .criterion(hasItem(ModItems.SALMON_FILLET), conditionsFromItem(ModItems.SALMON_FILLET))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.SALMON_NIGIRI)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SALMON_MAKI, 3)
                .input(ModItems.NORI)
                .input(ModItems.SALMON_FILLET)
                .input(ModItems.RICE)
                .input(Ingredient.ofItems(ModItems.CUCUMBER_SLICES, ModItems.GUACAMOLE))
                .criterion(hasItem(ModItems.SALMON_FILLET), conditionsFromItem(ModItems.SALMON_FILLET))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.SALMON_MAKI)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SALMON_URAMAKI, 3)
                .input(ModItems.NORI)
                .input(ModItems.SALMON_FILLET)
                .input(ModItems.RICE)
                .input(Ingredient.ofItems(ModItems.CUCUMBER_SLICES, ModItems.GUACAMOLE))
                .input(ModItems.MAYONNAISE)
                .criterion(hasItem(ModItems.SALMON_FILLET), conditionsFromItem(ModItems.SALMON_FILLET))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.SALMON_URAMAKI)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ONIGIRI, 1)
                .input(ModItems.NORI)
                .input(ModItems.RICE)
                .criterion(hasItem(ModItems.RICE), conditionsFromItem(ModItems.RICE))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.ONIGIRI)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SAUERKRAUT, 1)
                .pattern("SGS")
                .pattern("CJC")
                .pattern(" B ")
                .input('S', ModItems.SALT)
                .input('G', Items.SUGAR)
                .input('C', ModItems.CABBAGE)
                .input('J', Items.CARROT)
                .input('B', Items.BOWL)
                .criterion(hasItem(ModItems.CABBAGE), conditionsFromItem(ModItems.CABBAGE))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.SAUERKRAUT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RICE_BOWL, 1)
                .pattern("RRR")
                .pattern(" B ")
                .input('R', ModItems.RICE)
                .input('B', Items.BOWL)
                .criterion(hasItem(ModItems.RICE), conditionsFromItem(ModItems.RICE))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.RICE_BOWL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.POT_ITEM, 1)
                .pattern("B B")
                .pattern("I I")
                .pattern("III")
                .input('B', Items.BRICK)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, BorukvaFood.id(getRecipeName(ModBlocks.POT_ITEM)));

        of(exporter,
                PotRecipe.of("borsch", List.of(
                        CountedIngredient.ofItems(1, Items.POTATO),
                        CountedIngredient.ofItems(1, Items.BEETROOT),
                        CountedIngredient.ofItems(1, ModItems.ONION),
                        CountedIngredient.ofItems(1, ModItems.CABBAGE),
                        CountedIngredient.ofItems(1, ModItems.SALO),
                        CountedIngredient.ofItems(1, ModItems.SALT)),
                        CountedIngredient.ofItems(1, Items.BOWL), new ItemStack(ModItems.BORSCH, 1), 120),
                PotRecipe.of("broth", List.of(
                        CountedIngredient.ofItems(1, Items.CARROT),
                        CountedIngredient.ofItems(1, Items.CHICKEN),
                        CountedIngredient.ofItems(1, ModItems.ONION),
                        CountedIngredient.ofItems(1, ModItems.OIL),
                        CountedIngredient.ofItems(1, ModItems.SALT)
                ), CountedIngredient.ofItems(1, Items.BOWL), new ItemStack(ModItems.BROTH, 1), 120),
                PotRecipe.of("rotten_soup", List.of(
                        CountedIngredient.fromTag(1, ModTags.Items.ROTTEN_SOUP_INGREDIENTS),
                        CountedIngredient.fromTag(1, ModTags.Items.ROTTEN_SOUP_INGREDIENTS),
                        CountedIngredient.fromTag(1, ModTags.Items.ROTTEN_SOUP_INGREDIENTS),
                        CountedIngredient.fromTag(1, ModTags.Items.ROTTEN_SOUP_INGREDIENTS)
                ), CountedIngredient.ofItems(1, Items.BOWL), new ItemStack(ModItems.ROTTEN_SOUP, 1), 120),
                PotRecipe.of("boiled_corn", List.of(CountedIngredient.ofItems(1, ModItems.CORN)), CountedIngredient.EMPTY, new ItemStack(ModItems.BOILED_CORN, 1), 80),
                PotRecipe.of("fungus_stew", List.of(
                        CountedIngredient.ofItems(1, Items.CRIMSON_FUNGUS),
                        CountedIngredient.ofItems(1, Items.CRIMSON_FUNGUS),
                        CountedIngredient.ofItems(1, Items.WARPED_FUNGUS),
                        CountedIngredient.ofItems(1, Items.WARPED_FUNGUS)
                ), CountedIngredient.ofItems(1, Items.BOWL), new ItemStack(ModItems.FUNGUS_STEW, 1), 120),
                PotRecipe.of("ender_jam_stew_with_chorus_fruit", List.of(
                        CountedIngredient.ofItems(1, ModItems.ENDER_JAM),
                        CountedIngredient.ofItems(1, ModItems.ENDER_INFECTED_ONION),
                        CountedIngredient.ofItems(1, Items.CHORUS_FRUIT)
                ), CountedIngredient.ofItems(1, Items.BOWL), new ItemStack(ModItems.ENDER_JAM_STEW_WITH_CHORUS_FRUIT, 1), 120)
        );
        of(exporter,
                CuttingBoardRecipe.of("tomato_slices", CountedIngredient.ofItems(1, ModItems.TOMATO), new ItemStack(ModItems.TOMATO_SLICES, 3)),
                CuttingBoardRecipe.of("cucumber_slices", CountedIngredient.ofItems(1, ModItems.CUCUMBER), new ItemStack(ModItems.CUCUMBER_SLICES, 3)),
                CuttingBoardRecipe.of("sunflower_seed", CountedIngredient.ofItems(1, Items.SUNFLOWER), new ItemStack(ModItems.SUNFLOWER_SEED, 4)),
                CuttingBoardRecipe.of("salmon_fillet", CountedIngredient.ofItems(1, Items.SALMON), new ItemStack(ModItems.SALMON_FILLET, 2)),
                CuttingBoardRecipe.of("nori", CountedIngredient.ofItems(1, Items.DRIED_KELP), new ItemStack(ModItems.NORI, 2)),
                CuttingBoardRecipe.of("cooked_beef_slices", CountedIngredient.ofItems(1, Items.COOKED_BEEF), new ItemStack(ModItems.COOKED_BEEF_SLICES, 2)),
                CuttingBoardRecipe.of("beef_slices", CountedIngredient.ofItems(1, Items.BEEF), new ItemStack(ModItems.BEEF_SLICES, 2)),
                CuttingBoardRecipe.of("bread_slice", CountedIngredient.ofItems(1, Items.BREAD), new ItemStack(ModItems.BREAD_SLICE, 4)),
                CuttingBoardRecipe.of("hot_spice", CountedIngredient.ofItems(1, ModItems.CHILLI_PEPPER), new ItemStack(ModItems.HOT_SPICE, 1)),
                CuttingBoardRecipe.of("salo", CountedIngredient.ofItems(1, Items.PORKCHOP), new ItemStack(ModItems.SALO, 2)),
                CuttingBoardRecipe.of("chicken_leg", CountedIngredient.ofItems(1, Items.CHICKEN), new ItemStack(ModItems.CHICKEN_LEG, 2)),
                CuttingBoardRecipe.of("cooked_chicken_leg", CountedIngredient.ofItems(1, Items.COOKED_CHICKEN), new ItemStack(ModItems.COOKED_CHICKEN_LEG, 2)),
                CuttingBoardRecipe.of("mutton_slices", CountedIngredient.ofItems(1, Items.MUTTON), new ItemStack(ModItems.MUTTON_SLICES, 2)),
                CuttingBoardRecipe.of("cooked_mutton_slices", CountedIngredient.ofItems(1, Items.COOKED_MUTTON), new ItemStack(ModItems.COOKED_MUTTON_SLICES, 2)),
                CuttingBoardRecipe.of("peeled_squid_tentacles", CountedIngredient.ofItems(1, ModItems.SQUID_TENTAClES), new ItemStack(ModItems.PEELED_SQUID_TENTACLES)),
                CuttingBoardRecipe.of("squid_ring", CountedIngredient.ofItems(1, ModItems.PEELED_SQUID_TENTACLES), new ItemStack(ModItems.SQUID_RING, 3)),
                CuttingBoardRecipe.of("nether_bun_slice", CountedIngredient.ofItems(1, ModItems.NETHER_BUN), new ItemStack(ModItems.NETHER_BUN_SLICE, 2))
        );
        of(exporter,
                PanRecipe.of("cooked_chicken", CountedIngredient.ofItems(1, Items.CHICKEN), new ItemStack(Items.COOKED_CHICKEN), 100),
                PanRecipe.of("dried_kelp", CountedIngredient.ofItems(1, Items.KELP), new ItemStack(Items.DRIED_KELP), 40),
                PanRecipe.of("cooked_beef", CountedIngredient.ofItems(1, Items.BEEF), new ItemStack(Items.COOKED_BEEF), 100),
                PanRecipe.of("cooked_mutton", CountedIngredient.ofItems(1, Items.MUTTON), new ItemStack(Items.COOKED_MUTTON), 100),
                PanRecipe.of("cooked_porkchop", CountedIngredient.ofItems(1, Items.PORKCHOP), new ItemStack(Items.COOKED_PORKCHOP), 100),
                PanRecipe.of("cooked_salmon", CountedIngredient.ofItems(1, Items.SALMON), new ItemStack(Items.COOKED_SALMON), 100),
                PanRecipe.of("baked_potato", CountedIngredient.ofItems(1, Items.POTATO), new ItemStack(Items.BAKED_POTATO), 100),
                PanRecipe.of("cooked_cod", CountedIngredient.ofItems(1, Items.COD), new ItemStack(Items.COOKED_COD), 100),
                PanRecipe.of("cooked_rabbit", CountedIngredient.ofItems(1, Items.RABBIT), new ItemStack(Items.COOKED_RABBIT), 100),
                PanRecipe.of("cooked_beef_slices", CountedIngredient.ofItems(1, ModItems.BEEF_SLICES), new ItemStack(ModItems.COOKED_BEEF_SLICES), 100),
                PanRecipe.of("popcorn", CountedIngredient.ofItems(1, ModItems.CORN_SEEDS), new ItemStack(ModItems.POPCORN), 40),
                PanRecipe.of("roasted_sunflower_seed", CountedIngredient.ofItems(1, ModItems.SUNFLOWER_SEED), new ItemStack(ModItems.ROASTED_SUNFLOWER_SEED), 100),
                PanRecipe.of("cooked_chicken_leg", CountedIngredient.ofItems(1, ModItems.CHICKEN_LEG), new ItemStack(ModItems.COOKED_CHICKEN_LEG), 100),
                PanRecipe.of("cooked_mutton_slices", CountedIngredient.ofItems(1, ModItems.MUTTON_SLICES), new ItemStack(ModItems.MUTTON_SLICES), 100),
                PanRecipe.of("cooked_squid_ring", CountedIngredient.ofItems(1, ModItems.SQUID_RING), new ItemStack(ModItems.COOKED_SQUID_RING), 100),
                PanRecipe.of("cooked_hoglin_meat", CountedIngredient.ofItems(1, ModItems.HOGLIN_MEAT), new ItemStack(ModItems.COOKED_HOGLIN_MEAT), 100)
        );

        compressBlockRecipe(ModBlocks.NETHER_HAY_ITEM, ModItems.NETHER_WHEAT, exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.FUNGUS_PIZZA_ITEM, 1)
                .pattern("FKC")
                .pattern("FKC")
                .pattern("WWW")
                .input('K', ModItems.KETCHUP)
                .input('F', Items.WARPED_FUNGUS)
                .input('C', Items.CRIMSON_FUNGUS)
                .input('W', Items.WHEAT)
                .criterion(hasItem(Items.CRIMSON_FUNGUS), conditionsFromItem(Items.CRIMSON_FUNGUS))
                .offerTo(exporter, BorukvaFood.id(getRecipeName(ModBlocks.FUNGUS_PIZZA_ITEM)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.NETHER_BUN, 3)
                .input(ModItems.NETHER_WHEAT, 2)
                .criterion(hasItem(ModItems.NETHER_WHEAT), conditionsFromItem(ModItems.NETHER_WHEAT_SEEDS))
                .offerTo(exporter, BorukvaFood.id(getRecipeName(ModItems.NETHER_BUN)));
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AVOCADO_SLAB_ITEM, ModBlocks.AVOCADO_PLANKS_ITEM);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEMON_SLAB_ITEM, ModBlocks.LEMON_PLANKS_ITEM);
        offerTrapdoorRecipe(exporter, ModBlocks.AVOCADO_TRAPDOOR_ITEM, ModBlocks.AVOCADO_PLANKS_ITEM);
        offerTrapdoorRecipe(exporter, ModBlocks.LEMON_TRAPDOOR_ITEM, ModBlocks.LEMON_PLANKS_ITEM);
        offerDoorRecipe(exporter, ModBlocks.AVOCADO_DOOR_ITEM, ModBlocks.AVOCADO_PLANKS_ITEM);
        offerDoorRecipe(exporter, ModBlocks.LEMON_DOOR_ITEM, ModBlocks.LEMON_PLANKS_ITEM);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHORUS_FRUIT_IN_CHOCOLATE_ON_A_STICK, 1)
                .input(Items.STICK)
                .input(Items.CHORUS_FRUIT)
                .input(ModItems.CHOCOLATE_BAR)
                .criterion(hasItem(Items.CHORUS_FRUIT), conditionsFromItem(Items.CHORUS_FRUIT))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.CHORUS_FRUIT_IN_CHOCOLATE_ON_A_STICK)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHORUS_FRUITS_WITH_ENDER_JAM, 1)
                .input(Items.BOWL)
                .input(Items.CHORUS_FRUIT)
                .input(ModItems.ENDER_JAM)
                .criterion(hasItem(ModItems.ENDER_JAM), conditionsFromItem(ModItems.ENDER_JAM))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.CHORUS_FRUITS_WITH_ENDER_JAM)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ENDER_PIE, 1)
                .input(Items.WHEAT)
                .input(Items.EGG)
                .input(ModItems.ENDER_JAM)
                .criterion(hasItem(ModItems.ENDER_JAM), conditionsFromItem(ModItems.ENDER_JAM))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.ENDER_PIE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GOLDEN_CHORUS_FRUIT, 1)
                .pattern("GGG")
                .pattern("GCG")
                .pattern("GGG")
                .input('G', Items.GOLD_INGOT)
                .input('C', Items.CHORUS_FRUIT)
                .criterion(hasItem(Items.CHORUS_FRUIT), conditionsFromItem(Items.CHORUS_FRUIT))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.GOLDEN_CHORUS_FRUIT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BREAD_SLICE_WITH_HONEY, 1)
                .pattern(" H ")
                .pattern(" B ")
                .input('H', Items.HONEY_BOTTLE)
                .input('B', ModItems.BREAD_SLICE)
                .criterion(hasItem(ModItems.BREAD_SLICE), conditionsFromItem(ModItems.BREAD_SLICE))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.BREAD_SLICE_WITH_HONEY)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BUTTER, 1)
                .input(Items.MILK_BUCKET)
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.BUTTER)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CROISSANT, 1)
                .input(ModItems.BUTTER)
                .input(Items.WHEAT)
                .input(Items.EGG)
                .input(Items.SUGAR)
                .criterion(hasItem(ModItems.BUTTER), conditionsFromItem(ModItems.BUTTER))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.CROISSANT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GOLDEN_BREAD, 1)
                .pattern("GGG")
                .pattern("GBG")
                .pattern("GGG")
                .input('G', Items.GOLD_INGOT)
                .input('B', Items.BREAD)
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.GOLDEN_BREAD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.HOGLIN_SANDWICH, 1)
                .pattern(" B ")
                .pattern(" H ")
                .pattern(" B ")
                .input('B', ModItems.NETHER_BUN_SLICE)
                .input('H', ModItems.COOKED_HOGLIN_MEAT)
                .criterion(hasItem(ModItems.NETHER_BUN_SLICE), conditionsFromItem(ModItems.NETHER_BUN_SLICE))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.HOGLIN_SANDWICH)));
        seedsRecipe(ModItems.ENDER_INFECTED_ONION, ModItems.ENDER_INFECTED_ONION_SEEDS, exporter);
    }

    private void offerDoorRecipe(RecipeExporter exporter, Item output, Item input) {
        createDoorRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter, BorukvaFood.id(getRecipeName(output)));
    }
    private void offerTrapdoorRecipe(RecipeExporter exporter, Item output, Item input){
        createTrapdoorRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter, BorukvaFood.id(getRecipeName(output)));
    }
    private void campfireCookingRecipe(RecipeExporter exporter, Item input, Item output) {
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(input), RecipeCategory.FOOD, output, 0, 600, RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new)
                .criterion(FabricRecipeProvider.hasItem(input), FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(output)));
    }

    private void compressBlockRecipe(Item blockItem, Item item, RecipeExporter exporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, blockItem, 1)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', item)
                .criterion(hasItem(item), conditionsFromItem(item))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID,  getRecipeName(blockItem)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, item, 9)
                .input(blockItem, 1)
                .criterion(hasItem(blockItem), conditionsFromItem(blockItem))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(blockItem) + "_to_" + getRecipeName(item)));
    }
    private void seedsRecipe(Item item, Item seeds, RecipeExporter exporter){
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, seeds, 3)
                .input(item)
                .criterion(hasItem(item), conditionsFromItem(item))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(item) + "_to_" + getRecipeName(seeds)));
    }
    private void planksRecipe(TagKey<Item> log, Item planks, RecipeExporter exporter){
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, planks, 4)
                .input(Ingredient.fromTag(log))
                .criterion("has_log", conditionsFromTag(log))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(planks)));
    }
    private void woodRecipe(Item log, Item wood, RecipeExporter exporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, wood, 3)
                .pattern("SS")
                .pattern("SS")
                .input('S', log)
                .criterion(hasItem(log), conditionsFromItem(log))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(wood)));
    }
    private void pieRecipe(Item item, Item ingredient, RecipeExporter exporter){
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, item, 1)
                .input(ingredient)
                .input(Items.SUGAR)
                .input(Items.EGG)
                .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(item)));
    }
    private void popcornRecipe(Item item, Item ingredient, RecipeExporter exporter){
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, item, 1)
                .input(ModItems.POPCORN)
                .input(ModItems.POPCORN)
                .input(ingredient)
                .input(Items.PAPER)
                .criterion(hasItem(ModItems.POPCORN), conditionsFromItem(ModItems.POPCORN))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(item)));
    }
    public void of(RecipeExporter exporter, RecipeEntry<?>... recipes) {
        for (var recipe : recipes) {
            exporter.accept(recipe.id(), recipe.value(), null);
        }
    }
}
