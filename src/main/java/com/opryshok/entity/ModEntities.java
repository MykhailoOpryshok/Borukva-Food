package com.opryshok.entity;

import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import eu.pb4.polymer.core.api.entity.PolymerEntityUtils;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final BlockEntityType<StoveBlockEntity> STOVE = register("stove", BlockEntityType.Builder.create(StoveBlockEntity::new, ModBlocks.STOVE));
    public static final BlockEntityType<PanBlockEntity> PAN = register("pan", BlockEntityType.Builder.create(PanBlockEntity::new, ModBlocks.PAN));
    public static final BlockEntityType<FertilizerSprayerBlockEntity> FERTILIZER_SPRAYER = register("fertilizer_sprayer",
            BlockEntityType.Builder.create(FertilizerSprayerBlockEntity::new, ModBlocks.FERTILIZER_SPRAYER));

    public static final BlockEntityType<CuttingBoardBlockEntity> CUTTING_BOARD = register("cutting_board", BlockEntityType.Builder.create(CuttingBoardBlockEntity::new, ModBlocks.CUTTING_BOARD));
    // will be added in new version public static final BlockEntityType<PotBlockEntity> POT = register("pot", BlockEntityType.Builder.create(PotBlockEntity::new, ModBlocks.POT));
    public static final EntityType<PickleJarEntity> CUCUMBER_JAR = register("cucumber_jar", EntityType.Builder.create(PickleJarEntity::new, SpawnGroup.MISC).dimensions(0.25F, 0.25F).maxTrackingRange(4).trackingTickInterval(1));
    public static void register() {
    }
    public static <T extends BlockEntity> BlockEntityType<T> register(String path, BlockEntityType.Builder<T> builder) {
        BlockEntityType<T> blockEntityType = Registry.register(Registries.BLOCK_ENTITY_TYPE,Identifier.of(BorukvaFood.MOD_ID, path), builder.build());

        PolymerBlockUtils.registerBlockEntity(blockEntityType);

        return blockEntityType;
    }
    public static <T extends Entity> EntityType<T> register(String path, EntityType.Builder<T> item) {
        var x = Registry.register(Registries.ENTITY_TYPE, Identifier.of(BorukvaFood.MOD_ID, path), item.build(path));
        PolymerEntityUtils.registerType(x);
        return x;
    }
}
