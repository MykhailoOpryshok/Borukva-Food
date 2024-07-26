package com.opryshok.datagen;

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
    }
}
