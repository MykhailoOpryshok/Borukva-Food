package com.opryshok.block.leaves;

import com.github.quiltservertools.ledger.callbacks.BlockChangeCallback;
import com.github.quiltservertools.ledger.utility.Sources;
import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import com.opryshok.item.ModItems;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LemonFruitLeaves extends LeavesBlock implements PolymerTexturedBlock {
    public final BlockState model;
    public final BlockState modelWaterlogged;
    public LemonFruitLeaves(Settings settings) {
        super(settings);
        this.model = PolymerBlockResourceUtils.requestBlock(BlockModelType.TRANSPARENT_BLOCK, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/lemon_fruit_leaves")));
        this.modelWaterlogged = PolymerBlockResourceUtils.requestBlock(BlockModelType.TRANSPARENT_BLOCK_WATERLOGGED, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/lemon_fruit_leaves")));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient && player != null){
            dropStack(world, pos, player.getMovementDirection().getOpposite(), getFruitDropStack(1));
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1f, 1f);
            world.setBlockState(pos, getBaseBlockState(state));
            BlockChangeCallback.EVENT.invoker().changeBlock(world, pos, state, getBaseBlockState(state), null, null, Sources.PLAYER, player);
            return ActionResult.SUCCESS;
        }
        return super.onUse(state, world, pos, player, hit);
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        if (state.get(Properties.WATERLOGGED)) return modelWaterlogged;
        else return model;
    }
    public ItemStack getFruitDropStack(int count){
        return ModItems.LEMON.getDefaultStack().copyWithCount(count);
    }
    public BlockState getBaseBlockState(BlockState state){
        return ModBlocks.LEMON_LEAVES.getDefaultState().with(Properties.WATERLOGGED, state.get(Properties.WATERLOGGED));
    }
}
