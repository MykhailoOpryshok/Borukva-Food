package com.opryshok.mixin;

import com.opryshok.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.block.ComposterBlock$FullComposterInventory")
public class FullComposterInventoryMixin {
    @Inject(method = "canExtract", at = @At("HEAD"), cancellable = true)
    public void canExtract(int slot, ItemStack stack, Direction dir, CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(dir == Direction.DOWN && stack.isOf(ModItems.COMPOST));
    }
}