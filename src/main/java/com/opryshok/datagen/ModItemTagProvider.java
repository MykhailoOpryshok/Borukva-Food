package com.opryshok.datagen;

import com.opryshok.item.ModItems;
import com.opryshok.utils.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static com.opryshok.block.ModBlocks.*;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
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
                .add(ModItems.NETHER_WHEAT)
                .add(ModItems.ENDER_INFECTED_ONION);

        valueLookupBuilder(ModTags.Items.ROTTEN_SOUP_INGREDIENTS)
                .add(Items.ROTTEN_FLESH)
                .add(Items.BONE)
                .add(Items.COD)
                .add(Items.SPIDER_EYE)
                .add(Items.POISONOUS_POTATO);

        valueLookupBuilder(ModTags.Items.LEMON_LOGS)
                .add(LEMON_LOG_ITEM)
                .add(LEMON_WOOD_ITEM)
                .add(STRIPPED_LEMON_LOG_ITEM)
                .add(STRIPPED_LEMON_WOOD_ITEM);

        valueLookupBuilder(ModTags.Items.AVOCADO_LOGS)
                .add(AVOCADO_LOG_ITEM)
                .add(AVOCADO_WOOD_ITEM)
                .add(STRIPPED_AVOCADO_LOG_ITEM)
                .add(STRIPPED_AVOCADO_WOOD_ITEM);

        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
                .forceAddTag(ModTags.Items.AVOCADO_LOGS)
                .forceAddTag(ModTags.Items.LEMON_LOGS);

        valueLookupBuilder(ItemTags.PLANKS)
                .add(AVOCADO_PLANKS_ITEM)
                .add(LEMON_PLANKS_ITEM);

        valueLookupBuilder(ItemTags.STAIRS)
                .add(AVOCADO_STAIRS_ITEM)
                .add(LEMON_STAIRS_ITEM);

        valueLookupBuilder(ItemTags.BUTTONS)
                .add(AVOCADO_BUTTON_ITEM)
                .add(LEMON_BUTTON_ITEM);

        valueLookupBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(AVOCADO_PRESSURE_PLATE_ITEM)
                .add(LEMON_PRESSURE_PLATE_ITEM);

        valueLookupBuilder(ItemTags.FENCE_GATES)
                .add(AVOCADO_FENCE_GATE_ITEM)
                .add(LEMON_FENCE_GATE_ITEM);

        valueLookupBuilder(ItemTags.FENCES)
                .add(AVOCADO_FENCE_ITEM)
                .add(LEMON_FENCE_ITEM);

        valueLookupBuilder(ItemTags.WOODEN_FENCES)
                .add(AVOCADO_FENCE_ITEM)
                .add(LEMON_FENCE_ITEM);

        valueLookupBuilder(ItemTags.LEAVES)
                .add(LEMON_LEAVES_ITEM)
                .add(AVOCADO_LEAVES_ITEM)
                .add(AVOCADO_FRUIT_LEAVES_ITEM)
                .add(LEMON_FRUIT_LEAVES_ITEM);

        valueLookupBuilder(ItemTags.WOODEN_SLABS)
                .add(AVOCADO_SLAB_ITEM)
                .add(LEMON_SLAB_ITEM);

        valueLookupBuilder(ItemTags.WOODEN_DOORS)
                .add(AVOCADO_DOOR_ITEM)
                .add(LEMON_DOOR_ITEM);

        valueLookupBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(AVOCADO_TRAPDOOR_ITEM)
                .add(LEMON_TRAPDOOR_ITEM);

        valueLookupBuilder(ItemTags.SAPLINGS)
                .add(LEMON_SAPLING_ITEM)
                .add(AVOCADO_SAPLING_ITEM);

        valueLookupBuilder(ModTags.Items.CONVENTIONAL_SEEDS)
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
