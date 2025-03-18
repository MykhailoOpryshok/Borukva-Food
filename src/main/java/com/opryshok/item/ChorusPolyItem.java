package com.opryshok.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class ChorusPolyItem extends PolyItem{

    public ChorusPolyItem(Settings settings, String modelId) {
        super(settings, modelId);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        return Items.CHORUS_FRUIT.finishUsing(stack, world, user);
    }
}
