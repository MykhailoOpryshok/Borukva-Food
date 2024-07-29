package com.opryshok.item;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class PolySeedsItem extends AliasedBlockItem implements PolymerItem {
    private final PolymerModelData polymerModel;

    public PolySeedsItem(Block block, Settings settings, String modelId) {
        super(block, settings);
        this.polymerModel = PolymerResourcePackUtils.requestModel(Items.PUMPKIN_SEEDS, Identifier.of(BorukvaFood.MOD_ID, modelId).withPrefixedPath("item/"));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return this.polymerModel.item();
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return this.polymerModel.value();
    }
}
