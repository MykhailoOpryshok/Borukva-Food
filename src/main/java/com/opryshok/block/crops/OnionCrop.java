package com.opryshok.block.crops;

import com.opryshok.BorukvaFood;
import com.opryshok.item.ModItems;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class OnionCrop extends TomatoCrop{
    public OnionCrop(Settings settings) {
        super(settings);
    }
    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.ONION_SEEDS;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new Model(initialBlockState);
    }

    public static class Model extends TomatoCrop.Model {
        public static final ArrayList<ItemStack> MODELS = new ArrayList<>();
        static{
            for (int i = 0; i <= 3; i++){
                MODELS.add(ItemDisplayElementUtil.getModel(Identifier.of(BorukvaFood.MOD_ID, "block/onion_crop_stage"+i)));
            }
        }

        public Model(BlockState state){
            super(state);
        }

        @Override
        public ArrayList<ItemStack> getModels() {
            return MODELS;
        }
    }
}
