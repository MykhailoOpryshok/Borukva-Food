package com.opryshok.datagen;

import com.opryshok.item.ModItems;
import com.opryshok.utils.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

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
    }
}
