package com.opryshok.block.food;

import com.opryshok.BorukvaFood;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.ArrayList;

public class HoneyCake extends ChocolateCake{
    public HoneyCake(Settings settings) {
        super(settings);
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new Model(initialBlockState);
    }
    public static class Model extends ChocolateCake.Model{
        public static final ArrayList<ItemStack> HONEY_MODEL = new ArrayList<>();

        static {
            for (int i = 0; i <= 6; i++) {
                HONEY_MODEL.add(ItemDisplayElementUtil.getModel(Identifier.of(BorukvaFood.MOD_ID, "block/honey_cake")
                        .withSuffixedPath("_slice" + i)));
            }
        }
        public Model(BlockState state) {
            super(state);
        }

        @Override
        protected void init(BlockState state) {
            this.main = ItemDisplayElementUtil.createSimple(HONEY_MODEL.get(state.get(Properties.BITES)));
            this.main.setScale(new Vector3f(1f));
            this.addElement(this.main);
        }


        @Override
        protected void updateItem(BlockState state) {
            this.main.setItem(HONEY_MODEL.get(state.get(Properties.BITES)));
        }
    }
}
