package com.opryshok.block;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class PolyCropBlock extends CropBlock implements PolymerTexturedBlock {
    public static final int MAX_AGE = 5;
    public static final IntProperty AGE = Properties.AGE_5;
    private final ArrayList<BlockState> polymerBlockStates = new ArrayList<>();
    public PolyCropBlock(Settings settings, String modelId) {
        super(settings);
        for (int i = 0; i <= MAX_AGE; i++){
            polymerBlockStates.add(PolymerBlockResourceUtils.requestBlock(BlockModelType.PLANT_BLOCK,
                    PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, modelId)
                            .withPrefixedPath("block/")
                            .withSuffixedPath("_stage"+i))));
        }
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return polymerBlockStates.get(state.get(getAgeProperty()));
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return Items.WHEAT_SEEDS;
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        return super.onBreak(world, pos, state, player);
    }
}
