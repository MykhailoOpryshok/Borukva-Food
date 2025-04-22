package com.opryshok.item;

import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class ChorusPolyItem extends SimplePolymerItem {

    public ChorusPolyItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        return Items.CHORUS_FRUIT.finishUsing(stack, world, user);
    }
}
