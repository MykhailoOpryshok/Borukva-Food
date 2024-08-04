package com.opryshok.world.tree;

import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

import static com.opryshok.world.ModConfiguredFeatures.AVOCADO_KEY;
import static com.opryshok.world.ModConfiguredFeatures.LEMON_KEY;

public class ModSaplingGenerator {
    public static final SaplingGenerator LEMON = new SaplingGenerator("lemon", Optional.empty(), Optional.of(LEMON_KEY), Optional.empty());
    public static final SaplingGenerator AVOCADO = new SaplingGenerator("avocado", Optional.empty(), Optional.of(AVOCADO_KEY), Optional.empty());
}
