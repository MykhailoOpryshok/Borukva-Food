package com.opryshok.world.gen;

import com.opryshok.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SPARSE_JUNGLE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AVOCADO_PLACED_KEY);
    }
}
