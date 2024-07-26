package com.opryshok.entity;

import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<StoveBlockEntity> STOVE = register("stove", BlockEntityType.Builder.create(StoveBlockEntity::new, ModBlocks.STOVE));
    public static final BlockEntityType<PanBlockEntity> PAN = register("pan", BlockEntityType.Builder.create(PanBlockEntity::new, ModBlocks.PAN));
    public static final BlockEntityType<CuttingBoardBlockEntity> CUTTING_BOARD = register("cutting_board", BlockEntityType.Builder.create(CuttingBoardBlockEntity::new, ModBlocks.CUTTING_BOARD));

    public static void register() {
    }
    public static <T extends BlockEntity> BlockEntityType<T> register(String path, BlockEntityType.Builder<T> builder) {
        BlockEntityType<T> blockEntityType = Registry.register(Registries.BLOCK_ENTITY_TYPE,Identifier.of(BorukvaFood.MOD_ID, path), builder.build());

        PolymerBlockUtils.registerBlockEntity(blockEntityType);

        return blockEntityType;
    }
}
