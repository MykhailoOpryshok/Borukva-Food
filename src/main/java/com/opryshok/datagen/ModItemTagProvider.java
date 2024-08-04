package com.opryshok.datagen;

import com.opryshok.item.ModItems;
import com.opryshok.utils.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static com.opryshok.block.ModBlocks.*;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.PLANT_FOOD)
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
                .add(ModItems.CABBAGE);

        getOrCreateTagBuilder(ModTags.Items.ROTTEN_SOUP_INGREDIENTS)
                .add(Items.ROTTEN_FLESH)
                .add(Items.BONE)
                .add(Items.COD)
                .add(Items.SPIDER_EYE)
                .add(Items.POISONOUS_POTATO);

        getOrCreateTagBuilder(ModTags.Items.LEMON_LOGS)
                .add(LEMON_LOG_ITEM)
                .add(LEMON_WOOD_ITEM)
                .add(STRIPPED_LEMON_LOG_ITEM)
                .add(STRIPPED_LEMON_WOOD_ITEM);

        getOrCreateTagBuilder(ModTags.Items.AVOCADO_LOGS)
                .add(AVOCADO_LOG_ITEM)
                .add(AVOCADO_WOOD_ITEM)
                .add(STRIPPED_AVOCADO_LOG_ITEM)
                .add(STRIPPED_AVOCADO_WOOD_ITEM);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .forceAddTag(ModTags.Items.AVOCADO_LOGS)
                .forceAddTag(ModTags.Items.LEMON_LOGS);

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(AVOCADO_PLANKS_ITEM)
                .add(LEMON_PLANKS_ITEM);

        getOrCreateTagBuilder(ItemTags.LEAVES)
                .add(LEMON_LEAVES_ITEM)
                .add(AVOCADO_LEAVES_ITEM);

        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(LEMON_SAPLING_ITEM)
                .add(AVOCADO_SAPLING_ITEM);

    }
}
