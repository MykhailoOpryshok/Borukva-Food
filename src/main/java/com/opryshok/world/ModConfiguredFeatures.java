package com.opryshok.world;

import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> LEMON_KEY = registerKey("lemon");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AVOCADO_KEY = registerKey("avocado");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLACKCURRANTS_KEY = registerKey("blackcurrants");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GOOSEBERRY_KEY = registerKey("gooseberry");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SALT_KEY = registerKey("salt");
    public static void boostrap(Registerable<ConfiguredFeature<?,?>> context) {
        register(context, LEMON_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.LEMON_LOG),
                new BendingTrunkPlacer(4, 2, 0, 3, UniformIntProvider.create(1, 2)),

                new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(ModBlocks.LEMON_LEAVES.getDefaultState(), 5).add(ModBlocks.LEMON_FRUIT_LEAVES.getDefaultState().with(Properties.PERSISTENT, false), 1)),
                new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(2), 64),

                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, AVOCADO_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.AVOCADO_LOG),
                new StraightTrunkPlacer(4, 2, 0),
                new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(ModBlocks.AVOCADO_LEAVES.getDefaultState(), 5).add(ModBlocks.AVOCADO_FRUIT_LEAVES.getDefaultState().with(Properties.PERSISTENT, false), 1)),
                new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(2), ConstantIntProvider.create(3), 128),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, BLACKCURRANTS_KEY, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(
                70,
                7,
                3,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLACKCURRANTS_BUSH.getDefaultState().with(Properties.AGE_3, 3))))
                ));

        register(context, GOOSEBERRY_KEY, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(
                70,
                7,
                3,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GOOSEBERRY_BUSH.getDefaultState().with(Properties.AGE_3, 3))))
        ));

        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);

        register(context, SALT_KEY, Feature.ORE, new OreFeatureConfig(stoneReplacables, ModBlocks.SALT.getDefaultState(), 12));
    }
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(BorukvaFood.MOD_ID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
