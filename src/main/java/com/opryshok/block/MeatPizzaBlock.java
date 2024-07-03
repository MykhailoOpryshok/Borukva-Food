package com.opryshok.block;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class MeatPizzaBlock extends CakeBlock implements PolymerTexturedBlock {
    private final ArrayList<BlockState> polymerBlockStates = new ArrayList<>();
    public MeatPizzaBlock(Settings settings, String modelId) {
        super(settings);
        for (int i = 0; i <= 8; i++){
            polymerBlockStates.add(PolymerBlockResourceUtils.requestBlock(BlockModelType.VINES_BLOCK,
                    PolymerBlockModel.of(Identifier.of(BorukvaFood.MOD_ID, modelId)
                            .withPrefixedPath("block/")
                            .withSuffixedPath("_slice" + i))));
        }
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return polymerBlockStates.get(state.get(Properties.BITES));
    }
}
