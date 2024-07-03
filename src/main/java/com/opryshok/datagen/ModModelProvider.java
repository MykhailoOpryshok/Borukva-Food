package com.opryshok.datagen;

import com.opryshok.block.ModBlocks;
import com.opryshok.block.PolyCropBlock;
import com.opryshok.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider{
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.TOMATO_BLOCK, PolyCropBlock.AGE, 0, 0, 1, 1, 2, 2, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PIZZA, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEEF_SANDWICH, Models.GENERATED);
        itemModelGenerator.register(ModItems.FERTILIZER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOIL_ANALIZATOR, Models.GENERATED);
    }
}
