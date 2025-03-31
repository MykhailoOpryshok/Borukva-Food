package com.opryshok.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.opryshok.block.ModBlocks;
import com.opryshok.config.ModConfig;
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

import java.util.Objects;

@Mixin(CropBlock.class)
public abstract class CropBlockMixin {

    @Inject(method = "canPlantOnTop", at = @At("HEAD"), cancellable = true)
    public void canPlantOnTop(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(floor.getBlock() instanceof FarmlandBlock);
    }
    @Inject(method = "getAvailableMoisture", at = @At("RETURN"), cancellable = true)
    private static void editFloat(Block block, BlockView world, BlockPos pos, CallbackInfoReturnable<Float> cir){
        float f = 1.0F;
        BlockPos blockPos = pos.down();

        for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
                float g = 0.0F;
                BlockState blockState = world.getBlockState(blockPos.add(i, 0, j));
                if (blockState.isOf(Blocks.FARMLAND) || blockState.isOf(ModBlocks.BETTER_FARMLAND)) {
                    g = 1.0F;
                    if (blockState.get(FarmlandBlock.MOISTURE) > 0) {
                        g = 3.0F;
                    }
                }

                if (i != 0 || j != 0) {
                    g /= 4.0F;
                }

                f += g;
            }
        }

        BlockPos blockPos2 = pos.north();
        BlockPos blockPos3 = pos.south();
        BlockPos blockPos4 = pos.west();
        BlockPos blockPos5 = pos.east();
        boolean bl = world.getBlockState(blockPos4).isOf(block) || world.getBlockState(blockPos5).isOf(block);
        boolean bl2 = world.getBlockState(blockPos2).isOf(block) || world.getBlockState(blockPos3).isOf(block);
        if (bl && bl2) {
            f /= 2.0F;
        } else {
            boolean bl3 = world.getBlockState(blockPos4.north()).isOf(block) || world.getBlockState(blockPos5.north()).isOf(block) || world.getBlockState(blockPos5.south()).isOf(block) || world.getBlockState(blockPos4.south()).isOf(block);
            if (bl3) {
                f /= 2.0F;
            }
        }

        float edited = f;

        if(world.getBlockState(pos.down()).isOf(ModBlocks.BETTER_FARMLAND)){
            BlockState farmlandState = world.getBlockState(pos.down());

            float acidity = farmlandState.get(ModProperties.ACIDITY);

            if(Objects.equals(ModConfig.acidityEffects, "fertility")){
                edited *= (ModConfig.fertilityGrowthModifier * (acidity / 10));
            } else if(!Objects.equals(ModConfig.acidityEffects, "disabled")) {
                if (acidity < 3 || acidity > 7) {
                    edited /= 3;
                }
            }

            float x = farmlandState.get(ModProperties.FERTILITY);
            edited *= (ModConfig.fertilityGrowthModifier * (x / 10));

            if (x == 0){
                edited = 0.00001f;
            }
            if (ModConfig.onlyGoodEffects && edited < f){
                edited = f;
            }
        }
        cir.setReturnValue(edited);
        cir.cancel();
    }
    @Inject(method = "applyGrowth", at = @At("TAIL"))
    public void applyGrowthFertilityDecrement(World world, BlockPos pos, BlockState state, CallbackInfo ci, @Local int i){
        if(ModConfig.soilDegradation) {
            FertilityDecrement(world, pos, i);
        }
    }
    @Inject(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z", shift = At.Shift.AFTER))
    public void randomTickFertilityDecrement(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci){
        CropBlock crop = (CropBlock) (Object) this;
        if(ModConfig.soilDegradation) {
            FertilityDecrement(world, pos, crop.getAge(state) + 1);
        }
    }

    @Unique
    public void FertilityDecrement(World world, BlockPos pos, int i){
        if (world.getBlockState(pos.down()).isOf(ModBlocks.BETTER_FARMLAND)){
            var random = new java.util.Random();
            if (random.nextDouble() < (ModConfig.soilDegradationChance / 100)) {
                CropBlock crop = (CropBlock) (Object) this;
                if (i == crop.getMaxAge()) {
                    BlockState farmlandState = world.getBlockState(pos.down());
                    int currentFertility = farmlandState.get(ModProperties.FERTILITY);
                    int newFertility = currentFertility - 1;
                    if (newFertility >= 0) {
                        world.setBlockState(pos.down(), farmlandState.with(ModProperties.FERTILITY, newFertility));
                    }
                }
            }
        }
    }
}
