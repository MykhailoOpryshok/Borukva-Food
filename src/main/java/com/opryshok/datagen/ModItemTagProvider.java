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
        getOrCreateTagBuilder(ItemTags.HOGLIN_FOOD)
                .add(ModItems.NETHER_WHEAT);

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
                .add(ModItems.CABBAGE)
                .add(ModItems.NETHER_WHEAT)
                .add(ModItems.ENDER_INFECTED_ONION);

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
                .add(AVOCADO_LEAVES_ITEM)
                .add(AVOCADO_FRUIT_LEAVES_ITEM)
                .add(LEMON_FRUIT_LEAVES_ITEM);

        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(AVOCADO_SLAB_ITEM)
                .add(LEMON_SLAB_ITEM);

        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                .add(AVOCADO_DOOR_ITEM)
                .add(LEMON_DOOR_ITEM);

        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(AVOCADO_TRAPDOOR_ITEM)
                .add(LEMON_TRAPDOOR_ITEM);

        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(LEMON_SAPLING_ITEM)
                .add(AVOCADO_SAPLING_ITEM);

        getOrCreateTagBuilder(ModTags.Items.CONVENTIONAL_SEEDS)
            .addOptionalTag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
            .add(ModItems.RICE)
            .add(ModItems.TOMATO_SEEDS)
            .add(ModItems.CABBAGE_SEEDS)
            .add(ModItems.CORN_SEEDS)
            .add(ModItems.CHILLI_PEPPER_SEEDS)
            .add(ModItems.CUCUMBER_SEEDS)
            .add(ModItems.LETTUCE_SEEDS)
            .add(ModItems.ONION_SEEDS)
            .add(ModItems.BLACKCURRANTS)
            .add(ModItems.GOOSEBERRY)
            .add(ModItems.NETHER_WHEAT_SEEDS);
    }
}
