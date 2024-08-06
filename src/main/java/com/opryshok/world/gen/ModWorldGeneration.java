package com.opryshok.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        ModBushesGeneration.generateBushes();
        ModTreeGeneration.generateTrees();
    }
}
