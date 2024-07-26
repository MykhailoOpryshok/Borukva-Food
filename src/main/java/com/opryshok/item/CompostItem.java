package com.opryshok.item;

import com.opryshok.block.BetterFarmlandBlock;
import com.opryshok.block.ModBlocks;
import com.opryshok.utils.ModProperties;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CompostItem extends PolyItem{

    public CompostItem(Settings settings, String modelId) {
        super(settings, modelId);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        if (world.getBlockState(pos).isOf(ModBlocks.BETTER_FARMLAND)) {
            BlockState state = world.getBlockState(pos);
            BetterFarmlandBlock block = (BetterFarmlandBlock) state.getBlock();

            int newFertility = block.getFertility(state) + 2;
            int newAcidity = block.getAcidity(state) + 1;

            if (newFertility > BetterFarmlandBlock.MAX_FERTILITY) newFertility = BetterFarmlandBlock.MAX_FERTILITY;
            if (newAcidity > 10) newAcidity = 10;

            world.setBlockState(pos, state.with(ModProperties.FERTILITY, newFertility).with(ModProperties.ACIDITY, newAcidity));

            world.playSound(null, pos, SoundEvents.BLOCK_COMPOSTER_FILL, SoundCategory.BLOCKS, 1f, 1f);
            context.getStack().decrement(1);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}