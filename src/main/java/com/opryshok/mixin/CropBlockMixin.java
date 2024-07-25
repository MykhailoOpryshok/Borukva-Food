package com.opryshok.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.opryshok.block.ModBlocks;
import com.opryshok.utils.ModProperties;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CropBlock.class)
public abstract class CropBlockMixin {

    @Inject(method = "canPlantOnTop", at = @At("RETURN"), cancellable = true)
    public void canPlantOnTop(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(floor.getBlock() instanceof FarmlandBlock);
    }
    @Inject(method = "getAvailableMoisture", at = @At("RETURN"), cancellable = true)
    private static void editFloat(Block block, BlockView world, BlockPos pos, CallbackInfoReturnable<Float> cir){
        float original = cir.getReturnValue();
        float edited = original;

        if(world.getBlockState(pos.down()).isOf(ModBlocks.BETTER_FARMLAND)){
            BlockState farmlandState = world.getBlockState(pos.down());
            float x = farmlandState.get(ModProperties.FERTILITY);
            System.out.println("x: " + x);
            edited = original * (2*(x / 10));
            if (x == 0){
                edited = 0.00001f;
            }
        }
        cir.setReturnValue(edited);
    }
    @Inject(method = "applyGrowth", at = @At("TAIL"))
    public void applyGrowthFertilityDecrement(World world, BlockPos pos, BlockState state, CallbackInfo ci, @Local int i){
        FertilityDecrement(world, pos, i);
    }
    @Inject(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z", shift = At.Shift.AFTER))
    public void randomTickFertilityDecrement(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci){
        CropBlock crop = (CropBlock) (Object) this;
        FertilityDecrement(world, pos, crop.getAge(state) + 1);
    }

    @Unique
    public void FertilityDecrement(World world, BlockPos pos, int i){
        if (world.getBlockState(pos.down()).isOf(ModBlocks.BETTER_FARMLAND)){
            CropBlock crop = (CropBlock) (Object) this;
            if(i == crop.getMaxAge()){
                BlockState farmlandState = world.getBlockState(pos.down());
                int currentFertility = farmlandState.get(ModProperties.FERTILITY);
                int newFertility = currentFertility - 1;
                if(newFertility >= 0) {
                    world.setBlockState(pos.down(), farmlandState.with(ModProperties.FERTILITY, newFertility));
                }
            }
        }
    }
}
