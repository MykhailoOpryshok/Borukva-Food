package com.opryshok.item;

import com.opryshok.block.BetterFarmlandBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class SoilAnalizatorItem extends PolyItem {
    public SoilAnalizatorItem(Settings settings, String modelId) {
        super(settings, modelId);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);
        PlayerEntity player = context.getPlayer();

        if (state.getBlock() instanceof BetterFarmlandBlock && player != null) {
            player.sendMessage(
                    Text.translatable("chat.borukva-food.soil_analizator.on_use",
                            state.get(BetterFarmlandBlock.FERTILITY),
                            state.get(BetterFarmlandBlock.ACIDITY)
                    ).formatted(Formatting.YELLOW)
            );
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.borukva-food.soil_analizator").formatted(Formatting.YELLOW));
    }
}
