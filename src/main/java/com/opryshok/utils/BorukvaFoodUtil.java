package com.opryshok.utils;

import com.opryshok.block.ModBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;

public class BorukvaFoodUtil {
    public static int tryInsertingRegular(Inventory inventory, ItemStack itemStack) {
        var size = inventory.size();
        var init = itemStack.getCount();
        for (int i = 0; i < size; i++) {
            var current = inventory.getStack(i);

            if (current.isEmpty()) {
                var maxMove = Math.min(itemStack.getCount(), inventory.getMaxCountPerStack());
                inventory.setStack(i, itemStack.copyWithCount(maxMove));
                itemStack.decrement(maxMove);

            } else if (ItemStack.areItemsAndComponentsEqual(current, itemStack)) {
                var maxMove = Math.min(Math.min(current.getMaxCount() - current.getCount(), itemStack.getCount()), inventory.getMaxCountPerStack());

                if (maxMove > 0) {
                    current.increment(maxMove);
                    itemStack.decrement(maxMove);
                }
            }

            if (itemStack.isEmpty()) {
                return init;
            }
        }

        return init - itemStack.getCount();
    }
    public static void registerWood(){
        addStripped(ModBlocks.AVOCADO_LOG, ModBlocks.STRIPPED_AVOCADO_LOG);
        addStripped(ModBlocks.AVOCADO_WOOD, ModBlocks.STRIPPED_AVOCADO_WOOD);
        addStripped(ModBlocks.LEMON_LOG, ModBlocks.STRIPPED_LEMON_LOG);
        addStripped(ModBlocks.LEMON_WOOD, ModBlocks.STRIPPED_LEMON_WOOD);

        addFlammable(ModBlocks.AVOCADO_LOG, 5, 5);
        addFlammable(ModBlocks.AVOCADO_WOOD, 5, 5);
        addFlammable(ModBlocks.STRIPPED_AVOCADO_LOG, 5, 5);
        addFlammable(ModBlocks.STRIPPED_AVOCADO_WOOD, 5, 5);
        addFlammable(ModBlocks.LEMON_LOG, 5, 5);
        addFlammable(ModBlocks.LEMON_WOOD, 5, 5);
        addFlammable(ModBlocks.STRIPPED_LEMON_LOG, 5, 5);
        addFlammable(ModBlocks.STRIPPED_LEMON_WOOD, 5, 5);
        addFlammable(ModBlocks.LEMON_PLANKS, 5, 20);
        addFlammable(ModBlocks.AVOCADO_PLANKS, 5, 20);
        addFlammable(ModBlocks.LEMON_LEAVES, 30, 60);
        addFlammable(ModBlocks.AVOCADO_LEAVES, 30, 60);
        addFlammable(ModBlocks.LEMON_FRUIT_LEAVES, 30, 60);
        addFlammable(ModBlocks.AVOCADO_FRUIT_LEAVES, 30, 60);
        addFlammable(ModBlocks.LEMON_DOOR, 5, 20);
        addFlammable(ModBlocks.AVOCADO_DOOR, 5, 20);
        addFlammable(ModBlocks.AVOCADO_TRAPDOOR, 5, 20);
        addFlammable(ModBlocks.LEMON_TRAPDOOR, 5, 20);
        addFlammable(ModBlocks.AVOCADO_SLAB, 5, 20);
        addFlammable(ModBlocks.LEMON_SLAB, 5, 20);
        addFlammable(ModBlocks.NETHER_HAY, 5, 20);
    }
    private static void addFlammable(Block block, int burn, int spread){
        FlammableBlockRegistry.getDefaultInstance().add(block, burn, spread);
    }
    private static void addStripped(Block block, Block stripped){
        StrippableBlockRegistry.register(block, stripped);
    }
    public static void ledgerMixinInvoke(){}
}
