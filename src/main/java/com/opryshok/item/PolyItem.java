package com.opryshok.item;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PolyItem extends Item implements PolymerItem {
    private final PolymerModelData polymerModel;
    private final String modelId;
    public PolyItem(Settings settings, String modelId) {
        super(settings);
        this.modelId = modelId;
        polymerModel = PolymerResourcePackUtils.requestModel(Items.FLINT, Identifier.of(BorukvaFood.MOD_ID, modelId ).withPrefixedPath("item/"));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return this.polymerModel.item();
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.borukva-food."+ modelId + ".tooltip").formatted(Formatting.YELLOW));
        super.appendTooltip(stack, context, tooltip, type);
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return this.polymerModel.value();
    }

}
