package com.opryshok.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
    @Override
    public void generate() {
        //BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_BLOCK).properties(StatePredicate.Builder.create().exactMatch(PolyCropBlock.AGE, 5));
        //addDrop(ModBlocks.TOMATO_BLOCK, cropDrops(ModBlocks.TOMATO_BLOCK, ModItems.PIZZA, ModItems.TOMATO_SEEDS, builder));
    }
}
