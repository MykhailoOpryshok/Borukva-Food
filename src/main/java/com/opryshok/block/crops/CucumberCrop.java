package com.opryshok.block.crops;

import com.opryshok.BorukvaFood;
import com.opryshok.item.ModItems;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
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

public class CucumberCrop extends TomatoCrop{

    public CucumberCrop(Settings settings) {
        super(settings);
    }
    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.CUCUMBER_SEEDS;
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new Model(initialBlockState);
    }

    public static class Model extends TomatoCrop.Model {
        public static final ArrayList<ItemStack> MODELS = new ArrayList<>();
        static{
            for (int i = 0; i <= 3; i++){
                MODELS.add(BaseItemProvider.requestModel(Identifier.of(BorukvaFood.MOD_ID, "block/cucumber_crop_stage"+i)));
            }
        }

        public Model(BlockState state){
            super(state);
            init(state);
        }
        public void init(BlockState state){
            this.main = ItemDisplayElementUtil.createSimple(
                    switch (state.get(AGE)) {
                        case 2, 3 -> getModels().get(1);
                        case 4, 5, 6 -> getModels().get(2);
                        case 7 -> getModels().get(3);
                        default -> getModels().getFirst();
                    });
            this.main.setScale(new Vector3f(1f, 2f, 1f));
            this.main.setTranslation(new Vector3f(0f, 0.5f, 0f));
            this.addElement(main);
        }
        @Override
        public ArrayList<ItemStack> getModels() {
            return MODELS;
        }
    }
}
