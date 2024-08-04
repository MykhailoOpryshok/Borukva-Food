package com.opryshok.world;

import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> AVOCADO_PLACED_KEY = registerKey("avocado_placed");
    public static final RegistryKey<PlacedFeature> BLACKCURRANTS_PLACED_KEY = registerKey("blackcurrants_placed");
    public static final RegistryKey<PlacedFeature> GOOSEBERRY_PLACED_KEY = registerKey("gooseberry_placed");
    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context, AVOCADO_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AVOCADO_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.005f, 1),
                        ModBlocks.AVOCADO_SAPLING));
        register(context, BLACKCURRANTS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLACKCURRANTS_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(30), ModBlocks.BLACKCURRANTS_BUSH));

        register(context, GOOSEBERRY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GOOSEBERRY_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(30), ModBlocks.GOOSEBERRY_BUSH));
    }
    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(BorukvaFood.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
