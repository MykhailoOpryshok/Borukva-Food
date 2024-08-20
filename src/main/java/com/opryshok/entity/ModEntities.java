package com.opryshok.entity;

import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import eu.pb4.polymer.core.api.entity.PolymerEntityUtils;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final BlockEntityType<StoveBlockEntity> STOVE = register("stove", BlockEntityType.Builder.create(StoveBlockEntity::new, ModBlocks.STOVE));
    public static final BlockEntityType<PanBlockEntity> PAN = register("pan", BlockEntityType.Builder.create(PanBlockEntity::new, ModBlocks.PAN));
    public static final BlockEntityType<FertilizerSprayerBlockEntity> FERTILIZER_SPRAYER = register("fertilizer_sprayer", BlockEntityType.Builder.create(FertilizerSprayerBlockEntity::new, ModBlocks.FERTILIZER_SPRAYER));
    public static final BlockEntityType<CuttingBoardBlockEntity> CUTTING_BOARD = register("cutting_board", BlockEntityType.Builder.create(CuttingBoardBlockEntity::new, ModBlocks.CUTTING_BOARD));
    public static final EntityType<PickleJarEntity> CUCUMBER_JAR = register("cucumber_jar", FabricEntityTypeBuilder
            .create().dimensions(EntityDimensions.fixed(0.25f, 0.25f)).entityFactory(PickleJarEntity::new));
    public static void register() {
    }
    public static <T extends BlockEntity> BlockEntityType<T> register(String path, BlockEntityType.Builder<T> builder) {
        BlockEntityType<T> blockEntityType = Registry.register(Registries.BLOCK_ENTITY_TYPE,Identifier.of(BorukvaFood.MOD_ID, path), builder.build());

        PolymerBlockUtils.registerBlockEntity(blockEntityType);

        return blockEntityType;
    }
    public static <T extends Entity> EntityType<T> register(String path, FabricEntityTypeBuilder<T> item) {
        var x = Registry.register(Registries.ENTITY_TYPE, Identifier.of(BorukvaFood.MOD_ID, path), item.build());
        PolymerEntityUtils.registerType(x);
        return x;
    }
}
