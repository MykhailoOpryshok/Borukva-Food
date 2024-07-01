package com.opryshok.datagen;

import com.opryshok.block.ModBlocks;
import com.opryshok.block.TomatoBlock;
import com.opryshok.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
    @Override
    public void generate() {
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_BLOCK).properties(StatePredicate.Builder.create().exactMatch(TomatoBlock.AGE, 5));
        addDrop(ModBlocks.TOMATO_BLOCK, cropDrops(ModBlocks.TOMATO_BLOCK, ModItems.PIZZA, ModItems.TOMATO_SEEDS, builder));
    }
}
