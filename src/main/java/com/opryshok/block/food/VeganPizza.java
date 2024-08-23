package com.opryshok.block.food;

import com.opryshok.BorukvaFood;
import com.opryshok.item.ModItems;
import com.opryshok.utils.ModProperties;
import com.opryshok.utils.TransparentFlatTripWire;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.attachment.BlockBoundAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.ArrayList;

public class VeganPizza extends Block implements TransparentFlatTripWire, FactoryBlock {

    public VeganPizza(Settings settings) {
        super(settings.nonOpaque());
        this.setDefaultState(getDefaultState().with(ModProperties.SLICES, 0));
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new Model(initialBlockState);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ModProperties.SLICES);
        super.appendProperties(builder);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolidBlock(world, pos.down());
    }

    public Item getSlice() {
        return ModItems.VEGAN_PIZZA_SLICE;
    }

    public static class Model extends BlockModel {
        public static final ArrayList<ItemStack> MODEL = new ArrayList<>();

        static {
            for (int i = 0; i <= 7; i++) {
                MODEL.add(BaseItemProvider.requestModel(Identifier.of(BorukvaFood.MOD_ID, "vegan_pizza")
                        .withPrefixedPath("block/")
                        .withSuffixedPath("_slice" + i)));
            }
        }

        protected ItemDisplayElement pizza;

        protected Model(BlockState state) {
            init(state);
        }

        protected void init(BlockState state) {
            this.pizza = ItemDisplayElementUtil.createSimple(MODEL.get(state.get(ModProperties.SLICES)));
            this.pizza.setScale(new Vector3f(1f));
            this.addElement(this.pizza);
        }

        protected void updateItem(BlockState state) {
            this.removeElement(this.pizza);
            init(state);
        }

        @Override
        public void notifyUpdate(HolderAttachment.UpdateType updateType) {
            if (updateType == BlockBoundAttachment.BLOCK_STATE_UPDATE) {
                updateItem(this.blockState());
            }
            super.notifyUpdate(updateType);
        }
    }
}
