package com.opryshok.utils;

import com.opryshok.block.ModBlocks;
import com.opryshok.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModifyLootTables {

    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if ((key.getValue() == LootTables.SNIFFER_DIGGING_GAMEPLAY.getValue())) {
                LootPool.Builder pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.CORN_SEEDS))
                        .with(ItemEntry.builder(ModItems.ONION_SEEDS))
                        .with(ItemEntry.builder(ModItems.CHILLI_PEPPER_SEEDS));
                tableBuilder.pool(pool);
            }
            if ((key.getValue() == LootTables.PILLAGER_OUTPOST_CHEST.getValue())){
                LootPool.Builder pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.TOMATO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3)));
                tableBuilder.pool(pool);
            }
            if ((key.getValue() == LootTables.SIMPLE_DUNGEON_CHEST.getValue())){
                LootPool.Builder pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.75f))
                        .with(ItemEntry.builder(ModItems.ONION_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3)));
                tableBuilder.pool(pool);
            }
            if ((key.getValue() == LootTables.TRAIL_RUINS_COMMON_ARCHAEOLOGY.getValue())){
                tableBuilder.modifyPools(builder ->
                        builder.with(ItemEntry.builder(ModItems.CUCUMBER_SEEDS).weight(2))
                                .with(ItemEntry.builder(ModItems.TOMATO_SEEDS).weight(2))
                                .with(ItemEntry.builder(ModItems.LETTUCE_SEEDS).weight(2)));
            }
            if ((key.getValue() == LootTables.TRIAL_CHAMBERS_CORRIDOR_POT.getValue())){
                tableBuilder.modifyPools(builder -> builder
                        .with(ItemEntry.builder(ModItems.CABBAGE_SEEDS)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3), false))
                                .weight(75))

                        .with(ItemEntry.builder(ModItems.CHILLI_PEPPER_SEEDS)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3), false))
                                .weight(75))

                        .with(ItemEntry.builder(ModBlocks.LEMON_SAPLING_ITEM)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3), false))
                                .weight(30)));
            }
            if ((key.getValue() == LootTables.RUINED_PORTAL_CHEST.getValue())){
                tableBuilder.modifyPools(builder -> builder.with(ItemEntry.builder(ModItems.CHILLI_PEPPER_SEEDS)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3), false))
                        .weight(40)));
            }
            if ((key.getValue() == LootTables.SHIPWRECK_SUPPLY_CHEST.getValue())){
                tableBuilder.modifyPools(builder -> builder.with(ItemEntry.builder(ModItems.CUCUMBER)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3), false))
                        .weight(10)));
            }
            if ((key.getValue() == LootTables.OCEAN_RUIN_WARM_ARCHAEOLOGY.getValue() || key.getValue() == LootTables.OCEAN_RUIN_COLD_ARCHAEOLOGY.getValue())){
                tableBuilder.modifyPools(builder ->
                    builder.with(ItemEntry.builder(ModItems.CUCUMBER_SEEDS).weight(2))
                            .with(ItemEntry.builder(ModItems.TOMATO_SEEDS).weight(2))
                            .with(ItemEntry.builder(ModItems.LETTUCE_SEEDS).weight(2)));
            }
        });
    }
}
