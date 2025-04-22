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
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
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
        addCropDrop(ENDER_INFECTED_ONION, ModItems.ENDER_INFECTED_ONION, ModItems.ENDER_INFECTED_ONION_SEEDS);
        addCropDrop(RICE, ModItems.RICE_PANICLE, ModItems.RICE);
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(NETHER_WHEAT)
                .properties(StatePredicate.Builder.create().exactMatch(Properties.AGE_7, 7));
        addDrop(NETHER_WHEAT, cropDrops(NETHER_WHEAT, ModItems.NETHER_WHEAT, ModItems.NETHER_WHEAT_SEEDS, builder));
        addDrop(ONION_CRATE);
        addDrop(RICE_CRATE);
        addDrop(CHORUS_CRATE);
        addDrop(FERTILIZER_SPRAYER);
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
        addDrop(SALT);
        addDrop(AVOCADO_SAPLING);
        addDrop(LEMON_SAPLING);
        addDrop(LEMON_LOG);
        addDrop(LEMON_WOOD);
        addDrop(STRIPPED_LEMON_LOG);
        addDrop(STRIPPED_LEMON_WOOD);
        addDrop(AVOCADO_LOG);
        addDrop(AVOCADO_WOOD);
        addDrop(STRIPPED_AVOCADO_LOG);
        addDrop(STRIPPED_AVOCADO_WOOD);
        addDrop(AVOCADO_PLANKS);
        addDrop(LEMON_PLANKS);
        addDrop(LEMON_LEAVES, leavesDrops(LEMON_LEAVES, LEMON_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(AVOCADO_LEAVES, leavesDrops(AVOCADO_LEAVES, AVOCADO_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(AVOCADO_FRUIT_LEAVES, fruitLeavesDrop(AVOCADO_FRUIT_LEAVES, AVOCADO_SAPLING, ModItems.AVOCADO, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(LEMON_FRUIT_LEAVES, fruitLeavesDrop(LEMON_FRUIT_LEAVES, LEMON_SAPLING, ModItems.LEMON, 0.05f, 0.0625f, 0.083333336f, 0.1f));
        addDrop(AVOCADO_DOOR, doorDrops(AVOCADO_DOOR));
        addDrop(LEMON_DOOR, doorDrops(LEMON_DOOR));
        addDrop(LEMON_TRAPDOOR);
        addDrop(LEMON_SLAB, slabDrops(LEMON_SLAB));
        addDrop(AVOCADO_SLAB, slabDrops(AVOCADO_SLAB));
        addDrop(AVOCADO_TRAPDOOR);
        addDrop(POT);
        addDrop(NETHER_HAY);
        addDrop(GRAPE, ModItems.GRAPE_SAPLING);
        addDrop(WORMWOOD_GRASS, WORMWOOD);
    }
    private void addCropDrop(Block cropBlock, Item cropItem, Item seedItem) {
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(cropBlock)
                .properties(StatePredicate.Builder.create().exactMatch(Properties.AGE_7, 7));
        addDrop(cropBlock, customCropDrop(cropBlock, cropItem, seedItem, builder));
    }
    public LootTable.Builder customCropDrop(Block crop, Item product, Item seeds, LootCondition.Builder condition) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.applyExplosionDecay(crop, LootTable.builder().pool(LootPool.builder().with(ItemEntry.builder(product).conditionally(condition).alternatively(ItemEntry.builder(seeds)))).pool(LootPool.builder().conditionally(condition).with(ItemEntry.builder(product).apply(ApplyBonusLootFunction.binomialWithBonusCount(impl.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 2)))));
    }
    public LootTable.Builder fruitLeavesDrop(Block leaves, Block sapling, Item dropItem, float... saplingChance) {
        return this.leavesDrops(leaves, sapling, saplingChance)
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(this.createWithoutShearsOrSilkTouchCondition())
                        .with(ItemEntry.builder(dropItem)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))));
    }
}
