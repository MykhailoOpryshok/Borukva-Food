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
public class CornCrop extends TomatoCrop {
    public CornCrop(Settings settings) {
        super(settings);
    }
    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.CORN_SEEDS;
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new Model(initialBlockState);
    }

    public static class Model extends TomatoCrop.Model {
        public static final ArrayList<ItemStack> MODELS = new ArrayList<>();
        static{
            for (int i = 0; i <= 4; i++){
                MODELS.add(ItemDisplayElementUtil.getModel(Identifier.of(BorukvaFood.MOD_ID, "block/corn_crop_stage"+i)));
            }
        }

        public Model(BlockState state){
            super(state);
        }
        @Override
        public void init(BlockState state){
            main = ItemDisplayElementUtil.createSimple(
                    switch (state.get(AGE)) {
                        case 1, 2 -> MODELS.get(1);
                        case 3, 4 -> MODELS.get(2);
                        case 5, 6 -> MODELS.get(3);
                        case 7 -> MODELS.get(4);
                        default -> MODELS.getFirst();
                    });
            main.setScale(new Vector3f(1f, 2f, 1f));
            main.setTranslation(new Vector3f(0f, 0.5f, 0f));
            addElement(main);
        }
    }
}
