package com.opryshok.block.crops;

import com.opryshok.BorukvaFood;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class NetherWheatCrop extends TomatoCrop{
    public NetherWheatCrop(Settings settings) {
        super(settings);
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new Model(initialBlockState);
    }

    public static class Model extends TomatoCrop.Model {
        public static final ArrayList<ItemStack> MODELS = new ArrayList<>();
        static{
            for (int i = 0; i <= 3; i++){
                MODELS.add(BaseItemProvider.requestModel(Identifier.of(BorukvaFood.MOD_ID, "block/nether_wheat_crop_stage"+i)));
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
