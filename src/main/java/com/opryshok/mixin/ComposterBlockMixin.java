package com.opryshok.mixin;

import com.opryshok.item.ModItems;
import net.minecraft.block.ComposterBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import static com.opryshok.BorukvaFood.modConfig;

@Mixin(ComposterBlock.class)
public class ComposterBlockMixin{
    @ModifyVariable(method = "emptyFullComposter", at = @At("STORE"), ordinal = 0)
    private static ItemEntity s(ItemEntity value){
        if(modConfig.isReplaceCompostOutputWithFertilizer()) {
            value.setStack(new ItemStack(ModItems.COMPOST));
        }
        return value;
    }
    @ModifyArg(method = "getInventory", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/ComposterBlock$FullComposterInventory;<init>(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/WorldAccess;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/item/ItemStack;)V"), index = 3)
    public ItemStack newItemStack(ItemStack outputItem){
        if(modConfig.isReplaceCompostOutputWithFertilizer()) {
            return new ItemStack(ModItems.COMPOST);
        }
        return outputItem;
    }
}

