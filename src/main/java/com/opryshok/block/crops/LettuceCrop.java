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
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.ArrayList;

public class LettuceCrop extends TomatoCrop{
    public LettuceCrop(Settings settings) {
        super(settings);
    }
    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.LETTUCE_SEEDS;
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new Model(initialBlockState);
    }

    public static class Model extends TomatoCrop.Model {
        public static final ArrayList<ItemStack> MODELS = new ArrayList<>();
        static{
            for (int i = 0; i <= 2; i++){
                MODELS.add(ItemDisplayElementUtil.getModel(Identifier.of(BorukvaFood.MOD_ID, "block/lettuce_crop_stage"+i)));
            }
        }

        public Model(BlockState state){
            super(state);
        }

        @Override
        public void init(BlockState state) {
            this.main = ItemDisplayElementUtil.createSimple();
            this.updateItem(state);
            this.main.setScale(new Vector3f(1));
            this.addElement(main);
        }

        @Override
        protected void updateItem(BlockState state) {
            this.main.setItem(switch (state.get(AGE)) {
                case 2, 3, 4, 5, 6 -> getModels().get(1);
                case 7 -> getModels().get(2);
                default -> getModels().getFirst();
            });
        }

        @Override
        public ArrayList<ItemStack> getModels() {
            return MODELS;
        }
    }
}
