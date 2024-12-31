package com.opryshok.datagen;

import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import com.opryshok.block.bushes.BlackcurrantsBush;
import com.opryshok.block.bushes.GooseberryBush;
import com.opryshok.block.crops.TomatoCrop;
import com.opryshok.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider{
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.TOMATO, BlockStateModelGenerator.TintType.NOT_TINTED, TomatoCrop.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.CABBAGE, BlockStateModelGenerator.TintType.NOT_TINTED, TomatoCrop.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.CORN, BlockStateModelGenerator.TintType.NOT_TINTED, TomatoCrop.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.CHILLI_PEPPER, BlockStateModelGenerator.TintType.NOT_TINTED, TomatoCrop.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.BLACKCURRANTS_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED, BlackcurrantsBush.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.GOOSEBERRY_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED, GooseberryBush.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.CUCUMBER, BlockStateModelGenerator.TintType.NOT_TINTED, TomatoCrop.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.LETTUCE, BlockStateModelGenerator.TintType.NOT_TINTED, TomatoCrop.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.RICE, BlockStateModelGenerator.TintType.NOT_TINTED, TomatoCrop.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        blockStateModelGenerator.registerCrop(ModBlocks.ONION, TomatoCrop.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        generateCrate(blockStateModelGenerator, ModBlocks.BEETROOT_CRATE, "beetroot_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.CABBAGE_CRATE, "cabbage_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.CARROT_CRATE, "carrot_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.CHILLI_PEPPER_CRATE, "chilli_pepper_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.CORN_CRATE, "corn_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.CUCUMBER_CRATE, "cucumber_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.LETTUCE_CRATE, "lettuce_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.POTATO_CRATE, "potato_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.TOMATO_CRATE, "tomato_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.ONION_CRATE, "onion_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.RICE_CRATE, "rice_crate");
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SALT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEMON_LEAVES);
        blockStateModelGenerator.registerLog(ModBlocks.LEMON_LOG).log(ModBlocks.LEMON_LOG).wood(ModBlocks.LEMON_WOOD);
        blockStateModelGenerator.registerTintableCross(ModBlocks.LEMON_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_LEMON_LOG).log(ModBlocks.STRIPPED_LEMON_LOG).wood(ModBlocks.STRIPPED_LEMON_WOOD);

        BlockStateModelGenerator.BlockTexturePool lemonPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LEMON_PLANKS);
        lemonPlanksPool.slab(ModBlocks.LEMON_SLAB);

        blockStateModelGenerator.registerLog(ModBlocks.AVOCADO_LOG).log(ModBlocks.AVOCADO_LOG).wood(ModBlocks.AVOCADO_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_AVOCADO_LOG).log(ModBlocks.STRIPPED_AVOCADO_LOG).wood(ModBlocks.STRIPPED_AVOCADO_WOOD);

        BlockStateModelGenerator.BlockTexturePool avocadoPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AVOCADO_PLANKS);
        avocadoPlanksPool.slab(ModBlocks.AVOCADO_SLAB);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AVOCADO_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AVOCADO_FRUIT_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEMON_FRUIT_LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.AVOCADO_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MEAT_PIZZA_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.MEAT_PIZZA_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.VEGAN_PIZZA_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.VEGAN_PIZZA_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.FUNGUS_PIZZA_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.FUNGUS_PIZZA_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.FERTILIZER, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPOST, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.CABBAGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHILLI_PEPPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CUCUMBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.LETTUCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.KNIFE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HARVEST_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHOCOLATE_ICE_CREAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ICE_CREAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWEET_BERRY_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACKCURRANT_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEEF_SANDWICH, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO_SANDWICH, Models.GENERATED);
        itemModelGenerator.register(ModItems.BREAD_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BORSCH, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROTTEN_SOUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEEF_SLICES, Models.GENERATED);
        itemModelGenerator.register(ModItems.VEGAN_BARBECUE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_VEGAN_BARBECUE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEEF_BARBECUE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_BEEF_BARBECUE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALT, Models.GENERATED);
        itemModelGenerator.register(ModItems.OIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAYONNAISE, Models.GENERATED);
        itemModelGenerator.register(ModItems.KETCHUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.GUACAMOLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WAFFLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHOCOLATE_BAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONION, Models.GENERATED);
        itemModelGenerator.register(ModItems.PICKLE_JAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEMON_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.APPLE_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HONEY_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOT_SPICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PICKLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMPTY_JAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.APPLE_CANDY, Models.GENERATED);
        itemModelGenerator.register(ModItems.HONEY_CANDY, Models.GENERATED);
        itemModelGenerator.register(ModItems.JACK_CANDY, Models.GENERATED);
        itemModelGenerator.register(ModItems.PUMPKIN_CANDY, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEMON_CANDY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALT_POPCORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHOCOLATE_POPCORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE_POPCORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.POPCORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAVASH, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHAWARMA, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEEF_SALAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.VEGETABLE_SALAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_BEEF_SLICES, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEMON, Models.GENERATED);
        itemModelGenerator.register(ModItems.AVOCADO, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO_SLICES, Models.GENERATED);
        itemModelGenerator.register(ModItems.CUCUMBER_SLICES, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.CHOCOLATE_CAKE_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.HONEY_CAKE_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RICE_PANICLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RICE_BOWL, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALMON_FILLET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALMON_MAKI, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALMON_NIGIRI, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALMON_URAMAKI, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONIGIRI, Models.GENERATED);
        itemModelGenerator.register(ModItems.NORI, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAUERKRAUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALO, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUNFLOWER_SEED, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROASTED_SUNFLOWER_SEED, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOILED_CORN, Models.GENERATED);

    }
    public void generateCrate(BlockStateModelGenerator generator, Block generatedBlock, String path){
        generator.registerCubeWithCustomTextures(
                generatedBlock,
                generatedBlock,
                (block, otherTextureSource) -> new TextureMap()
                        .put(TextureKey.DOWN, Identifier.of(BorukvaFood.MOD_ID, "block/crate_bottom"))
                        .put(TextureKey.UP, Identifier.of(BorukvaFood.MOD_ID, "block/" + path + "_top"))
                        .put(TextureKey.SIDE, Identifier.of(BorukvaFood.MOD_ID, "block/" + path + "_side"))
                        .put(TextureKey.PARTICLE, Identifier.of(BorukvaFood.MOD_ID, "block/" + path + "_side"))
        );
    }
}
