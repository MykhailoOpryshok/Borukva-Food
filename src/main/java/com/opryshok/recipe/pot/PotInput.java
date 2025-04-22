package com.opryshok.recipe.pot;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.world.World;

import java.util.List;

public record PotInput(List<ItemStack> stacks, ItemStack bowl, World world) implements RecipeInput {

    @Override
    public ItemStack getStackInSlot(int slot) {
        if (slot == 7) {
            return bowl;
        }
        return this.stacks.get(slot);
    }

    @Override
    public int size() {
        return this.stacks.size();
    }
}
