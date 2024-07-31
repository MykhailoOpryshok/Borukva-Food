package com.opryshok.entity;

import com.opryshok.BorukvaFood;
import com.opryshok.block.cooking.CuttingBoard;
import com.opryshok.item.ModItems;
import com.opryshok.utils.CuttingBoardRecipes;
import com.opryshok.utils.MinimalSidedInventory;
import eu.pb4.factorytools.api.block.BlockEntityExtraListener;
import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import eu.pb4.polymer.virtualentity.api.attachment.BlockAwareAttachment;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class CuttingBoardBlockEntity extends LockableBlockEntity implements MinimalSidedInventory, SidedInventory, BlockEntityExtraListener {
    private static final int[] SLOTS = new int[]{0};
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);
    private CuttingBoard.Model model;
    public CuttingBoardBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.CUTTING_BOARD, blockPos, blockState);
    }
    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup lookup) {
        super.writeNbt(nbt, lookup);
        Inventories.writeNbt(nbt, this.items, lookup);
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup lookup) {
        super.readNbt(nbt, lookup);
        Inventories.readNbt(nbt, this.items, lookup);
        if (this.model != null) {
            this.model.updateItem(getItemStack());
        }
    }

    @Override
    public int getMaxCountPerStack() {
        return 1;
    }

    @Override
    public void markDirty() {
        super.markDirty();
        if (this.model != null) {
            this.model.updateItem(getItemStack());
        }
    }
    @Override
    public DefaultedList<ItemStack> getStacks() {
        return items;
    }

    public ItemStack getItemStack(){
        return getStack(0);
    }
    public boolean addItem(ItemStack itemStack) {
        if (isEmpty() && !itemStack.isEmpty()) {
            setStack(0, itemStack.split(1));
            markDirty();

            return true;
        }

        return false;
    }
    public void removeItem() {
        if (!isEmpty()) {
            setStack(0, ItemStack.EMPTY);
            markDirty();
        }
    }
    public boolean processItemUsingTool(World world, ItemStack tool, PlayerEntity player) {
        if (world == null) {
            return false;
        }
        if (tool.isOf(ModItems.KNIFE)){
            Item currentItem = getItemStack().getItem();
            if (CuttingBoardRecipes.RECIPES.containsKey(currentItem)){
                tool.damage(1, player, LivingEntity.getSlotForHand(player.getActiveHand()));
                ItemScatterer.spawn(world, player.getX(), player.getY(), player.getZ(), CuttingBoardRecipes.RECIPES.get(currentItem).copy());
                removeItem();
                markDirty();
            }
        }
        return true;
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
    @Override
    public void onListenerUpdate(WorldChunk chunk) {
        try {
            this.model = (CuttingBoard.Model) Objects.requireNonNull(BlockAwareAttachment.get(chunk, this.getPos())).holder();
            this.model.updateItem(getItemStack());
        } catch (Throwable e) {
            BorukvaFood.LOGGER.debug("error: ", e);
        }
    }
}
