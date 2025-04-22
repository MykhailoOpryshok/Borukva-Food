package com.opryshok.item;

import com.opryshok.block.BetterFarmlandBlock;
import com.opryshok.utils.ModProperties;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class FertilizerItem extends SimplePolymerItem {
    public FertilizerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);

        if (state.getBlock() instanceof BetterFarmlandBlock block) {
            int newFertility = Math.min(block.getFertility(state) + 2, BetterFarmlandBlock.MAX_FERTILITY);
            int newAcidity = Math.max(block.getAcidity(state) - 1, 0);

            world.setBlockState(pos, state
                    .with(ModProperties.FERTILITY, newFertility)
                    .with(ModProperties.ACIDITY, newAcidity)
            );
            world.playSound(null, pos, SoundEvents.BLOCK_COMPOSTER_FILL, SoundCategory.BLOCKS, 1f, 1f);

            context.getStack().decrement(1);

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.borukva-food.fertilizer").formatted(Formatting.GRAY));
    }
}
