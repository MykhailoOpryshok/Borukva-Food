package com.opryshok.datagen;

import com.opryshok.utils.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

import static com.opryshok.block.ModBlocks.*;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.AXE_MINEABLE)
                .add(BEETROOT_CRATE)
                .add(CABBAGE_CRATE)
                .add(CARROT_CRATE)
                .add(CHILLI_PEPPER_CRATE)
                .add(CORN_CRATE)
                .add(CUCUMBER_CRATE)
                .add(LETTUCE_CRATE)
                .add(POTATO_CRATE)
                .add(TOMATO_CRATE)
                .add(CUTTING_BOARD)
                .add(ONION_CRATE)
                .add(RICE_CRATE)
                .add(CHORUS_CRATE);

        valueLookupBuilder(BlockTags.SHOVEL_MINEABLE).add(BETTER_FARMLAND);

        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(STOVE)
                .add(SALT)
                .add(FERTILIZER_SPRAYER);

        valueLookupBuilder(BlockTags.WOODEN_DOORS)
                .add(AVOCADO_DOOR)
                .add(LEMON_DOOR);

        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(AVOCADO_TRAPDOOR)
                .add(LEMON_TRAPDOOR);

        valueLookupBuilder(BlockTags.HOE_MINEABLE)
                .add(NETHER_HAY);

        valueLookupBuilder(BlockTags.WOODEN_SLABS)
                .add(AVOCADO_SLAB)
                .add(LEMON_SLAB);

        valueLookupBuilder(ModTags.Blocks.LEMON_LOGS)
                .add(LEMON_LOG)
                .add(LEMON_WOOD)
                .add(STRIPPED_LEMON_LOG)
                .add(STRIPPED_LEMON_WOOD);

        valueLookupBuilder(ModTags.Blocks.AVOCADO_LOGS)
                .add(AVOCADO_LOG)
                .add(AVOCADO_WOOD)
                .add(STRIPPED_AVOCADO_LOG)
                .add(STRIPPED_AVOCADO_WOOD);

        valueLookupBuilder(ModTags.Blocks.KNIFE_MINEABLE);

        valueLookupBuilder(ModTags.Blocks.SICKLE_MINEABLE);

        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                .forceAddTag(ModTags.Blocks.AVOCADO_LOGS)
                .forceAddTag(ModTags.Blocks.LEMON_LOGS);

        valueLookupBuilder(BlockTags.PLANKS)
                .add(AVOCADO_PLANKS)
                .add(LEMON_PLANKS);

        valueLookupBuilder(BlockTags.STAIRS)
                .add(AVOCADO_STAIRS)
                .add(LEMON_STAIRS);

        valueLookupBuilder(BlockTags.BUTTONS)
                .add(AVOCADO_BUTTON)
                .add(LEMON_BUTTON);

        valueLookupBuilder(BlockTags.PRESSURE_PLATES)
                .add(AVOCADO_PRESSURE_PLATE)
                .add(LEMON_PRESSURE_PLATE);

        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(AVOCADO_FENCE_GATE)
                .add(LEMON_FENCE_GATE);

        valueLookupBuilder(BlockTags.LEAVES)
                .add(LEMON_LEAVES)
                .add(AVOCADO_LEAVES)
                .add(AVOCADO_FRUIT_LEAVES)
                .add(LEMON_FRUIT_LEAVES);

        valueLookupBuilder(BlockTags.SAPLINGS)
                .add(LEMON_SAPLING)
                .add(AVOCADO_SAPLING);

        valueLookupBuilder(ModTags.Blocks.CONVENTIONAL_FARMLAND).add(BETTER_FARMLAND);
        valueLookupBuilder(ModTags.Blocks.CONVENTIONAL_FARMLANDS).add(BETTER_FARMLAND);
    }
}
