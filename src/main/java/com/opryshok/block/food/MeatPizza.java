package com.opryshok.block.food;

import com.opryshok.BorukvaFood;
import com.opryshok.item.ModItems;
import com.opryshok.utils.ModProperties;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.ArrayList;

public class MeatPizza extends VeganPizza {
    private final Item dropItem;

    public MeatPizza(Settings settings) {
        super(settings);
        this.dropItem = ModItems.MEAT_PIZZA_SLICE;
    }
    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new Model(initialBlockState);
    }

    @Override
    public Item getDropItem() {
        return dropItem;
    }

    public static final class Model extends VeganPizza.Model {
        private static final ArrayList<ItemStack> MEAT_MODEL = new ArrayList<>();

        static {
            for (int i = 0; i <= 8; i++) {
                MEAT_MODEL.add(BaseItemProvider.requestModel(Identifier.of(BorukvaFood.MOD_ID, "meat_pizza")
                        .withPrefixedPath("block/")
                        .withSuffixedPath("_slice" + i)));
            }
        }

        private Model(BlockState state) {
            super(state);
        }

        @Override
        protected void init(BlockState state) {
            this.pizza = ItemDisplayElementUtil.createSimple(MEAT_MODEL.get(state.get(ModProperties.SLICES)));
            this.pizza.setScale(new Vector3f(1f));
            this.addElement(this.pizza);
        }

        @Override
        protected void updateItem(BlockState state) {
            this.removeElement(this.pizza);
            init(state);
        }
    }
}