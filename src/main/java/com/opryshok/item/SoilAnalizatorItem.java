package com.opryshok.item;

import com.opryshok.block.ModBlocks;
import com.opryshok.utils.ModProperties;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SoilAnalizatorItem extends PolyItem{
    public SoilAnalizatorItem(Settings settings, String modelId) {
        super(settings, modelId);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        if (world.getBlockState(pos).isOf(ModBlocks.BETTER_FARMLAND_BLOCK) && context.getPlayer() != null){
            BlockState state = world.getBlockState(pos);
            context.getPlayer().sendMessage(Text.literal("Рівень родючості: " + state.get(ModProperties.FERTILITY)
                    + "\nРівень кислотності: " + state.get(ModProperties.ACIDITY)).formatted(Formatting.YELLOW));
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}
