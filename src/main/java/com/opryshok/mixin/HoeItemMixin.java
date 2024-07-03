package com.opryshok.mixin;

import com.opryshok.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(HoeItem.class)
public class HoeItemMixin {
    @Inject(method = "useOnBlock", at = @At(value = "INVOKE", target = "Ljava/util/function/Consumer;accept(Ljava/lang/Object;)V", shift = At.Shift.AFTER))
    public void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir){
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();

        if (world.getBlockState(blockPos).isOf(Blocks.FARMLAND)) {
            world.setBlockState(blockPos, ModBlocks.BETTER_FARMLAND_BLOCK.getDefaultState());
        }
    }

    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    public void replaceFarmland(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir){
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);

        if (blockState.isOf(Blocks.FARMLAND)) {
            world.setBlockState(blockPos, ModBlocks.BETTER_FARMLAND_BLOCK.getDefaultState());
            world.playSound(context.getPlayer(), blockPos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
            cir.setReturnValue(ActionResult.SUCCESS);
        }
    }
}


