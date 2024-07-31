package com.opryshok.datagen;

import com.opryshok.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.Properties;

import java.util.concurrent.CompletableFuture;

import static com.opryshok.block.ModBlocks.*;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
    @Override
    public void generate() {
        addCropDrop(TOMATO, ModItems.TOMATO, ModItems.TOMATO_SEEDS);
        addCropDrop(CABBAGE, ModItems.CABBAGE, ModItems.CABBAGE_SEEDS);
        addCropDrop(CORN, ModItems.CORN, ModItems.CORN_SEEDS);
        addCropDrop(CHILLI_PEPPER, ModItems.CHILLI_PEPPER, ModItems.CHILLI_PEPPER_SEEDS);
        addCropDrop(LETTUCE, ModItems.LETTUCE, ModItems.LETTUCE_SEEDS);
        addCropDrop(CUCUMBER, ModItems.CUCUMBER, ModItems.CUCUMBER_SEEDS);
        addCropDrop(ONION, ModItems.ONION, ModItems.ONION_SEEDS);

        addDrop(BETTER_FARMLAND, Blocks.DIRT.asItem());
        addDrop(STOVE);
        addDrop(PAN);
        addDrop(CUTTING_BOARD);
        addDrop(BEETROOT_CRATE);
        addDrop(CABBAGE_CRATE);
        addDrop(CARROT_CRATE);
        addDrop(CHILLI_PEPPER_CRATE);
        addDrop(CORN_CRATE);
        addDrop(CUCUMBER_CRATE);
        addDrop(LETTUCE_CRATE);
        addDrop(POTATO_CRATE);
        addDrop(TOMATO_CRATE);
    }
    private void addCropDrop(Block cropBlock, Item cropItem, Item seedItem) {
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(cropBlock)
                .properties(StatePredicate.Builder.create().exactMatch(Properties.AGE_7, 7));
        addDrop(cropBlock, customCropDrop(cropBlock, cropItem, seedItem, builder));
    }
    public LootTable.Builder customCropDrop(Block crop, Item product, Item seeds, LootCondition.Builder condition) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.applyExplosionDecay(crop, LootTable.builder().pool(LootPool.builder().with(ItemEntry.builder(product).conditionally(condition).alternatively(ItemEntry.builder(seeds)))).pool(LootPool.builder().conditionally(condition).with(ItemEntry.builder(product).apply(ApplyBonusLootFunction.binomialWithBonusCount(impl.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 2)))));
    }
}
