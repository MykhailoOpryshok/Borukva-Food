package com.opryshok.entity;

import com.opryshok.utils.MinimalSidedInventory;
import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class PotBlockEntity extends LockableBlockEntity implements MinimalSidedInventory, SidedInventory {
    private static final int[] SLOTS = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(7, ItemStack.EMPTY);
    public PotBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(null, blockPos, blockState);
    }

    @Override
    public DefaultedList<ItemStack> getStacks() {
        return items;
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        return SLOTS;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return true;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return true;
    }
}
