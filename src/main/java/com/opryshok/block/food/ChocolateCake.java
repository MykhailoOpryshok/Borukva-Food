package com.opryshok.block.food;

import com.opryshok.BorukvaFood;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.attachment.BlockBoundAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.ArrayList;

public class ChocolateCake extends CakeBlock implements FactoryBlock {
    public ChocolateCake(Settings settings) {
        super(settings);
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return Blocks.BARRIER.getDefaultState();
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new Model(initialBlockState);
    }

    public static class Model extends BlockModel {
        public static final ArrayList<ItemStack> CHOCOLATE_MODEL = new ArrayList<>();
        protected ItemDisplayElement main;

        static {
            for (int i = 0; i <= 6; i++) {
                CHOCOLATE_MODEL.add(BaseItemProvider.requestModel(Identifier.of(BorukvaFood.MOD_ID, "chocolate_cake")
                        .withPrefixedPath("block/")
                        .withSuffixedPath("_slice" + i)));
            }
        }
        public Model(BlockState state){
            init(state);
        }
        protected void init(BlockState state) {
            this.main = ItemDisplayElementUtil.createSimple(CHOCOLATE_MODEL.get(state.get(Properties.BITES)));
            this.main.setScale(new Vector3f(1f));
            this.addElement(this.main);
        }

        protected void updateItem(BlockState state) {
            this.removeElement(this.main);
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
