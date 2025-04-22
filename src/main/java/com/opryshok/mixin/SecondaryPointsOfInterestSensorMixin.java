package com.opryshok.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.opryshok.block.ModBlocks;
import net.minecraft.entity.ai.brain.sensor.SecondaryPointsOfInterestSensor;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.village.VillagerProfession;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(SecondaryPointsOfInterestSensor.class)
public class SecondaryPointsOfInterestSensorMixin {
    @Inject(method = "sense(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/passive/VillagerEntity;)V", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableSet;contains(Ljava/lang/Object;)Z", remap = false))
    public void betterFarmlandSensor(ServerWorld serverWorld, VillagerEntity villagerEntity, CallbackInfo ci, @Local (ordinal = 1) BlockPos pos, @Local List<GlobalPos> list){
        if (villagerEntity.getVillagerData().profession().getKey().isPresent() && villagerEntity.getVillagerData().profession().getKey().get().equals(VillagerProfession.FARMER)){
            if (serverWorld.getBlockState(pos).getBlock() == ModBlocks.BETTER_FARMLAND){
                list.add(GlobalPos.create(serverWorld.getRegistryKey(), pos));
            }
        }
    }
}
