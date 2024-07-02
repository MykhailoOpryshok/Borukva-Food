package com.opryshok.item;

import com.opryshok.block.ModBlocks;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FertilizerItem extends PolyItem{
    public FertilizerItem(Settings settings, String modelId) {
        super(settings, modelId);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        if (world.getBlockState(pos).isOf(ModBlocks.BETTER_FARMLAND_BLOCK)) {
            for (int i = 0; i < 360; i++){
                if(i % 20 == 0){
                   world.addParticle(ParticleTypes.ANGRY_VILLAGER, true, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5,
                           Math.cos(i) * 0.25d, 0.15d, Math.sin(i) * 0.25d);
                }
            }
            world.playSound(null, pos, SoundEvents.BLOCK_COMPOSTER_FILL, SoundCategory.BLOCKS, 1f, 1f);
            context.getStack().decrement(1);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}
