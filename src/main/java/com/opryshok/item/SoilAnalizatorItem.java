package com.opryshok.item;

import com.opryshok.block.BetterFarmlandBlock;
import com.opryshok.block.ModBlocks;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class SoilAnalizatorItem extends SimplePolymerItem {
    public SoilAnalizatorItem(Settings settings) {
        super(settings);
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
            , true);
            return ActionResult.SUCCESS;
        }
        if (state.isOf(ModBlocks.FERTILIZER_SPRAYER) && player!= null && player.isSneaking()){
            if (world instanceof ServerWorld serverWorld){
                for (int x = -4; x <= 5; x++) {
                    for (int z = -4; z <= 5; z++) {
                        serverWorld.spawnParticles(ParticleTypes.SCRAPE, pos.getX() + x, pos.getY() + 0.5, pos.getZ() + z, 10, 0, 0, 0,0);
                    }
                }
            }
        }

        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.borukva-food.soil_analizator").formatted(Formatting.GRAY));
    }
}
