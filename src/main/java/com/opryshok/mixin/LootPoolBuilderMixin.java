package com.opryshok.mixin;

import com.google.common.collect.ImmutableList;
import com.opryshok.utils.duck.LootPoolBuilderHelper;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.LootPoolEntry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LootPool.Builder.class)
public abstract class LootPoolBuilderMixin implements LootPoolBuilderHelper {
    @Shadow
    @Final
    @Mutable
    private ImmutableList.Builder<LootPoolEntry> entries;

    @Override
    public void borukva_Food$clearEntries() {
        entries = ImmutableList.builder();
    }
}
