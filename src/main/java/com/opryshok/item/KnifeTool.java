package com.opryshok.item;

import com.github.quiltservertools.ledger.callbacks.BlockBreakCallback;
import com.github.quiltservertools.ledger.callbacks.BlockChangeCallback;
import com.github.quiltservertools.ledger.utility.Sources;
import com.opryshok.BorukvaFood;
import com.opryshok.block.food.VeganPizza;
import com.opryshok.utils.ModProperties;
import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class KnifeTool extends ToolItem implements PolymerItem {
    private final PolymerModelData polymerModel;

    public KnifeTool(Settings settings) {
        super(ToolMaterials.IRON, settings);

        polymerModel = PolymerResourcePackUtils.requestModel(Items.IRON_SWORD, Identifier.of(BorukvaFood.MOD_ID, "item/knife"));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return polymerModel.item();
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return polymerModel.value();
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);
        PlayerEntity player = context.getPlayer();

        if (state.getBlock() instanceof VeganPizza block && player != null) {
            int i = state.get(ModProperties.SLICES);

            ItemScatterer.spawn(world, player.getX(), player.getY(), player.getZ(), new ItemStack(block.getSlice(), 1));
            player.getStackInHand(Hand.MAIN_HAND).damage(1, player, LivingEntity.getSlotForHand(Hand.MAIN_HAND));
            if (i == 7){
                BlockBreakCallback.EVENT.invoker().breakBlock(world, pos, state, null, Sources.PLAYER, player);
                world.removeBlock(pos, false);
                world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }
            else {
                world.setBlockState(pos, state.with(ModProperties.SLICES, i + 1), 3);
                BlockChangeCallback.EVENT.invoker().changeBlock(world, pos, state, world.getBlockState(pos), null, null, Sources.CONSUME,  player);
            }

            return ActionResult.SUCCESS;
        }
        return ActionResult.SUCCESS;
    }
}

