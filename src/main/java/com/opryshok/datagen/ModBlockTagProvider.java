package com.opryshok.datagen;

import com.opryshok.compat.tags.FarmersDelightTags;
import com.opryshok.utils.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
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
        registerCompatTags();

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
                .add(ONION_CRATE)
                .add(RICE_CRATE)
                .add(CHORUS_CRATE)
                .add(CUTTING_BOARD)
                .add(LEMON_LOG, LEMON_WOOD, STRIPPED_LEMON_LOG, STRIPPED_LEMON_WOOD)
                .add(AVOCADO_LOG, AVOCADO_WOOD, STRIPPED_AVOCADO_LOG, STRIPPED_AVOCADO_WOOD)
                .add(LEMON_PLANKS, LEMON_STAIRS, LEMON_SLAB, LEMON_FENCE, LEMON_FENCE_GATE, LEMON_TRAPDOOR, LEMON_DOOR)
                .add(AVOCADO_PLANKS, AVOCADO_STAIRS, AVOCADO_SLAB, AVOCADO_FENCE, AVOCADO_FENCE_GATE, AVOCADO_TRAPDOOR, AVOCADO_DOOR)
                .add(LEMON_PRESSURE_PLATE, AVOCADO_PRESSURE_PLATE);

        valueLookupBuilder(BlockTags.SHOVEL_MINEABLE).add(BETTER_FARMLAND);

        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(STOVE)
                .add(PAN)
                .add(POT)
                .add(SALT)
                .add(FERTILIZER_SPRAYER);

        valueLookupBuilder(BlockTags.WOODEN_DOORS)
                .add(AVOCADO_DOOR)
                .add(LEMON_DOOR);

        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(AVOCADO_TRAPDOOR)
                .add(LEMON_TRAPDOOR);

        valueLookupBuilder(BlockTags.HOE_MINEABLE)
                .add(NETHER_HAY)
                .add(WORMWOOD_GRASS)
                .add(LEMON_LEAVES)
                .add(AVOCADO_LEAVES)
                .add(LEMON_FRUIT_LEAVES)
                .add(AVOCADO_FRUIT_LEAVES);

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
                .add(LEMON_LOG, LEMON_WOOD, STRIPPED_LEMON_LOG, STRIPPED_LEMON_WOOD)
                .add(AVOCADO_LOG, AVOCADO_WOOD, STRIPPED_AVOCADO_LOG, STRIPPED_AVOCADO_WOOD);

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

        valueLookupBuilder(BlockTags.FENCES)
                .add(AVOCADO_FENCE)
                .add(LEMON_FENCE);

        valueLookupBuilder(BlockTags.WOODEN_FENCES)
                .add(AVOCADO_FENCE)
                .add(LEMON_FENCE);

        valueLookupBuilder(BlockTags.LEAVES)
                .add(LEMON_LEAVES)
                .add(AVOCADO_LEAVES)
                .add(AVOCADO_FRUIT_LEAVES)
                .add(LEMON_FRUIT_LEAVES);

        valueLookupBuilder(BlockTags.SAPLINGS)
                .add(LEMON_SAPLING)
                .add(AVOCADO_SAPLING);

        // Plant/Crop Tags
        valueLookupBuilder(BlockTags.CROPS)
                .add(TOMATO)
                .add(CABBAGE)
                .add(CORN)
                .add(CHILLI_PEPPER)
                .add(LETTUCE)
                .add(CUCUMBER)
                .add(ONION)
                .add(RICE)
                .add(NETHER_WHEAT)
                .add(ENDER_INFECTED_ONION)
                .add(GRAPE);

        valueLookupBuilder(BlockTags.WOODEN_STAIRS)
                .add(LEMON_STAIRS)
                .add(AVOCADO_STAIRS);

        valueLookupBuilder(BlockTags.WOODEN_DOORS)
                .add(LEMON_DOOR)
                .add(AVOCADO_DOOR);

        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(LEMON_TRAPDOOR)
                .add(AVOCADO_TRAPDOOR);

        valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
                .add(LEMON_BUTTON)
                .add(AVOCADO_BUTTON);

        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(LEMON_PRESSURE_PLATE)
                .add(AVOCADO_PRESSURE_PLATE);

        valueLookupBuilder(ModTags.Blocks.CONVENTIONAL_FARMLAND).add(BETTER_FARMLAND);
        valueLookupBuilder(ModTags.Blocks.CONVENTIONAL_FARMLANDS).add(BETTER_FARMLAND);

        // --- CONVENTIONAL TAGS ---

        // Storage Blocks
        valueLookupBuilder(ConventionalBlockTags.STORAGE_BLOCKS)
                .add(NETHER_HAY)
                .add(SALT)
                .add(BEETROOT_CRATE)
                .add(CABBAGE_CRATE)
                .add(CARROT_CRATE)
                .add(CHILLI_PEPPER_CRATE)
                .add(CORN_CRATE)
                .add(CUCUMBER_CRATE)
                .add(LETTUCE_CRATE)
                .add(POTATO_CRATE)
                .add(TOMATO_CRATE)
                .add(ONION_CRATE)
                .add(RICE_CRATE)
                .add(CHORUS_CRATE);

        // Player Workstations
        valueLookupBuilder(ConventionalBlockTags.PLAYER_WORKSTATIONS_FURNACES)
                .add(POT)
                .add(PAN);

        // Wood
        valueLookupBuilder(ConventionalBlockTags.STRIPPED_LOGS)
                .add(STRIPPED_LEMON_LOG)
                .add(STRIPPED_AVOCADO_LOG);

        valueLookupBuilder(ConventionalBlockTags.STRIPPED_WOODS)
                .add(STRIPPED_LEMON_WOOD)
                .add(STRIPPED_AVOCADO_WOOD);

        // Fence Gates
        valueLookupBuilder(ConventionalBlockTags.WOODEN_FENCE_GATES)
                .add(LEMON_FENCE_GATE)
                .add(AVOCADO_FENCE_GATE);

        // Misc
        valueLookupBuilder(ConventionalBlockTags.RELOCATION_NOT_SUPPORTED)
                .add(STOVE)
                .add(PAN)
                .add(POT)
                .add(FERTILIZER_SPRAYER);
    }

    private void registerCompatTags()   {
        // --- FarmersDelight ---
        valueLookupBuilder(FarmersDelightTags.HEAT_SOURCES)
                .add(STOVE);
        valueLookupBuilder(FarmersDelightTags.STRAW_BLOCKS)
                .add(NETHER_WHEAT);
    }
}
