package com.opryshok.block;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WormwoodGrass extends GrassBlock implements PolymerTexturedBlock {
    private final BlockState model;
    public WormwoodGrass(Settings settings) {
        super(settings);
        model = PolymerBlockResourceUtils.requestBlock(BlockModelType.PLANT_BLOCK, PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, "block/wormwood_grass")));
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return model;
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(Items.BONE_MEAL)){
            dropStack(world, pos, new ItemStack(ModBlocks.WORMWOOD));
        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }
}
