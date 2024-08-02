package com.opryshok.datagen;

import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import com.opryshok.item.ModItems;
import com.opryshok.utils.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

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

        seedsRecipe(ModItems.TOMATO, ModItems.TOMATO_SEEDS, exporter);
        seedsRecipe(ModItems.CABBAGE, ModItems.CABBAGE_SEEDS, exporter);
        seedsRecipe(ModItems.CHILLI_PEPPER, ModItems.CHILLI_PEPPER_SEEDS, exporter);
        seedsRecipe(ModItems.CORN, ModItems.CORN_SEEDS, exporter);
        seedsRecipe(ModItems.CUCUMBER, ModItems.CUCUMBER_SEEDS, exporter);
        seedsRecipe(ModItems.LETTUCE, ModItems.LETTUCE_SEEDS, exporter);
        seedsRecipe(ModItems.ONION, ModItems.ONION_SEEDS, exporter);

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KNIFE, 1)
                .pattern("I ")
                .pattern("S ")
                .input('I', Items.IRON_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.KNIFE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FERTILIZER, 4)
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.VEGAN_BARBECUE, 1)
                .pattern("P  ")
                .pattern("P  ")
                .pattern("S  ")
                .input('P', Ingredient.fromTag(ModTags.Items.PLANT_FOOD))
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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BORSCH, 1)
                .input(Items.POTATO)
                .input(Items.CARROT)
                .input(Items.BEETROOT)
                .input(ModItems.ONION)
                .input(ModItems.TOMATO)
                .input(ModItems.CABBAGE)
                .input(Items.PORKCHOP)
                .input(ModItems.SALT)
                .input(Items.BOWL)
                .criterion(hasItem(Items.BEETROOT), conditionsFromItem(Items.BEETROOT))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.BORSCH)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BROTH, 1)
                .input(Items.CARROT)
                .input(Items.CHICKEN)
                .input(ModItems.ONION)
                .input(ModItems.OIL)
                .input(ModItems.SALT)
                .input(Items.BOWL)
                .criterion(hasItem(Items.CHICKEN), conditionsFromItem(Items.CHICKEN))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.BROTH)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ROTTEN_SOUP, 1)
                .input(Ingredient.fromTag(ModTags.Items.ROTTEN_SOUP_INGREDIENTS), 4)
                .input(Items.BOWL)
                .criterion("has_rotten_item", conditionsFromTag(ModTags.Items.ROTTEN_SOUP_INGREDIENTS))
                .offerTo(exporter, Identifier.of(BorukvaFood.MOD_ID, getRecipeName(ModItems.ROTTEN_SOUP)));

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

        compressBlockRecipe(ModBlocks.SALT_BLOCK_ITEM, ModItems.SALT, exporter);
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
}
