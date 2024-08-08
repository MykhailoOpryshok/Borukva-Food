package com.opryshok.ui;

import com.github.quiltservertools.ledger.callbacks.ItemInsertCallback;
import com.github.quiltservertools.ledger.callbacks.ItemRemoveCallback;
import com.github.quiltservertools.ledger.utility.Sources;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

public class LedgerSlot extends Slot{
    public final ServerPlayerEntity player;
    public final BlockPos pos;

    public LedgerSlot(BlockPos pos, ServerPlayerEntity player, Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.pos = pos;
        this.player = player;
    }

    @Override
    public void setStackNoCallbacks(ItemStack stack) {
        if (!stack.isEmpty()) {
            ItemInsertCallback.EVENT.invoker().insert(stack, pos, player.getServerWorld(), Sources.PLAYER, player);
        }
        super.setStackNoCallbacks(stack);
    }

    @Override
    public void markDirty() {
        super.markDirty();
    }

    @Override
    public void onTakeItem(PlayerEntity player, ItemStack stack) {
        ItemRemoveCallback.EVENT.invoker().remove(stack, pos, this.player.getServerWorld(), Sources.PLAYER, this.player);
        super.onTakeItem(player, stack);
    }
}
