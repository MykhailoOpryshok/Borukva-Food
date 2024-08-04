package com.opryshok.datagen;

import com.opryshok.utils.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

import static com.opryshok.block.ModBlocks.*;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(BEETROOT_CRATE)
                .add(CABBAGE_CRATE)
                .add(CARROT_CRATE)
                .add(CHILLI_PEPPER_CRATE)
                .add(CORN_CRATE)
                .add(CUCUMBER_CRATE)
                .add(LETTUCE_CRATE)
                .add(POTATO_CRATE)
                .add(TOMATO_CRATE);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(BETTER_FARMLAND);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(STOVE);

        getOrCreateTagBuilder(ModTags.Blocks.LEMON_LOGS)
                .add(LEMON_LOG)
                .add(LEMON_WOOD)
                .add(STRIPPED_LEMON_LOG)
                .add(STRIPPED_LEMON_WOOD);

        getOrCreateTagBuilder(ModTags.Blocks.AVOCADO_LOGS)
                .add(AVOCADO_LOG)
                .add(AVOCADO_WOOD)
                .add(STRIPPED_AVOCADO_LOG)
                .add(STRIPPED_AVOCADO_WOOD);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .forceAddTag(ModTags.Blocks.AVOCADO_LOGS)
                .forceAddTag(ModTags.Blocks.LEMON_LOGS);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(AVOCADO_PLANKS)
                .add(LEMON_PLANKS);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(LEMON_LEAVES)
                .add(AVOCADO_LEAVES);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(LEMON_SAPLING)
                .add(AVOCADO_SAPLING);
    }
}
