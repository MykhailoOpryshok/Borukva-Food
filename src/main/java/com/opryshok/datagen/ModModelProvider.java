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
        generateCrate(blockStateModelGenerator, ModBlocks.BEETROOT_CRATE, "beetroot_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.CABBAGE_CRATE, "cabbage_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.CARROT_CRATE, "carrot_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.CHILLI_PEPPER_CRATE, "chilli_pepper_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.CORN_CRATE, "corn_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.CUCUMBER_CRATE, "cucumber_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.LETTUCE_CRATE, "lettuce_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.POTATO_CRATE, "potato_crate");
        generateCrate(blockStateModelGenerator, ModBlocks.TOMATO_CRATE, "tomato_crate");

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MEAT_PIZZA_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.MEAT_PIZZA_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.VEGAN_PIZZA_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.VEGAN_PIZZA_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.FERTILIZER, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPOST, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.CABBAGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHILLI_PEPPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CUCUMBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.LETTUCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.KNIFE, Models.HANDHELD);
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
