package com.opryshok.item;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HarvestSickleItem extends ToolItem implements PolymerItem {
    private final PolymerModelData polymerModel;

    public HarvestSickleItem(Settings settings) {
        super(ToolMaterials.IRON, settings);

        polymerModel = PolymerResourcePackUtils.requestModel(Items.IRON_SWORD, Identifier.of(BorukvaFood.MOD_ID, "item/harvest_sickle"));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos centerPos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        ItemStack sickleStack = context.getStack();

        if (!world.isClient && player != null) {
            boolean harvested = false;

            // Iterate over a 3x3 area centered on the targeted block
            for (int dx = -1; dx <= 1; dx++) {
                for (int dz = -1; dz <= 1; dz++) {
                    BlockPos pos = centerPos.add(dx, 0, dz);
                    BlockState state = world.getBlockState(pos);

                    if (state.getBlock() instanceof PlantBlock) {
                            world.breakBlock(pos, true, player);
                            harvested = true;
                    }
                }
            }

            if (harvested) {
                // Damage the sickle
                if (player instanceof ServerPlayerEntity serverPlayerEntity && world instanceof ServerWorld serverWorld && !(player).getAbilities().creativeMode) {
                    sickleStack.damage(1, serverWorld, serverPlayerEntity, item -> {});
                }
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.borukva-food.harvest_sickle").formatted(Formatting.GRAY));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return polymerModel.item();
    }
    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return polymerModel.value();
    }
}
