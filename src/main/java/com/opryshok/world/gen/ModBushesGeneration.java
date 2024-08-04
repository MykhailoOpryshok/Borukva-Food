package com.opryshok.world.gen;

import com.opryshok.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModBushesGeneration {
    public static void generateBushes(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.DARK_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLACKCURRANTS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.GOOSEBERRY_PLACED_KEY);
    }
}
