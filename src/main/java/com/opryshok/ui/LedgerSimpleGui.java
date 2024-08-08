package com.opryshok.ui;

import com.github.quiltservertools.ledger.callbacks.ItemRemoveCallback;
import com.github.quiltservertools.ledger.utility.Sources;
import eu.pb4.sgui.api.gui.SimpleGui;
import eu.pb4.sgui.virtual.inventory.VirtualSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;

public class LedgerSimpleGui extends SimpleGui {
    /**
     * Constructs a new simple container gui for the supplied player.
     *
     * @param type                  the screen handler that the client should display
     * @param player                the player to server this gui to
     * @param manipulatePlayerSlots if <code>true</code> the players inventory
     *                              will be treated as slots of this gui
     */
    public LedgerSimpleGui(ScreenHandlerType<?> type, ServerPlayerEntity player, boolean manipulatePlayerSlots) {
        super(type, player, manipulatePlayerSlots);
    }
    @Override
    public ItemStack quickMove(int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.getSlotRedirectOrPlayer(index);
        if (slot != null && slot.hasStack() && !(slot instanceof VirtualSlot)) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2.copy();
            if (index < this.getVirtualSize()) {
                if (!this.insertItem(itemStack2, this.getVirtualSize(), this.getVirtualSize() + 9 * 4, true)) {
                    return ItemStack.EMPTY;
                }
                if (slot instanceof LedgerSlot ledgerSlot) {
                    ItemRemoveCallback.EVENT.invoker().remove(itemStack, ledgerSlot.pos, player.getServerWorld(), Sources.PLAYER, player);
                }
            } else if (!this.insertItem(itemStack2, 0, this.getVirtualSize(), false)) {
                return ItemStack.EMPTY;
            }
            if (itemStack2.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        } else if (slot instanceof VirtualSlot) {
            return slot.getStack();
        }

        return itemStack;
    }
}
