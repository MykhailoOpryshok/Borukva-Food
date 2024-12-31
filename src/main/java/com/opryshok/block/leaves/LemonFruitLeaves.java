package com.opryshok.block.leaves;

import com.opryshok.BorukvaFood;
import com.opryshok.item.ModItems;
import com.opryshok.utils.BorukvaFoodUtil;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LemonFruitLeaves extends LeavesBlock implements PolymerTexturedBlock {
    public static final BooleanProperty HAS_FRUIT = BooleanProperty.of("has_fruit");

    public final BlockState model;
    public final BlockState modelWaterlogged;

    public LemonFruitLeaves(Settings settings) {
        super(settings);
        this.model = PolymerBlockResourceUtils.requestBlock(BlockModelType.TRANSPARENT_BLOCK, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/lemon_fruit_leaves")));
        this.modelWaterlogged = PolymerBlockResourceUtils.requestBlock(BlockModelType.TRANSPARENT_BLOCK_WATERLOGGED, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/lemon_fruit_leaves")));
        this.setDefaultState(this.stateManager.getDefaultState().with(Properties.WATERLOGGED, false).with(HAS_FRUIT, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(HAS_FRUIT);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, net.minecraft.util.math.random.Random random) {
        super.randomTick(state, world, pos, random);
        if (!state.get(HAS_FRUIT) && random.nextInt(10) == 0) {
            world.setBlockState(pos, state.with(HAS_FRUIT, true), 2);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient && player != null && state.get(HAS_FRUIT)) {
            dropStack(world, pos, player.getMovementDirection().getOpposite(), getFruitDropStack(1));
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1f, 1f);
            world.setBlockState(pos, state.with(HAS_FRUIT, false));
            BorukvaFoodUtil.ledgerMixinInvoke();
            return ActionResult.SUCCESS;
        }
        return super.onUse(state, world, pos, player, hit);
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        if (state.get(Properties.WATERLOGGED)) return modelWaterlogged;
        return model;
    }

    public ItemStack getFruitDropStack(int count) {
        return ModItems.LEMON.getDefaultStack().copyWithCount(count);
    }
}
