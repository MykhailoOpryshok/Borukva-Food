package com.opryshok.block;

import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.attachment.BlockBoundAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import xyz.nucleoid.packettweaker.PacketContext;

import java.util.HashMap;
import java.util.Map;

public class PolyFenceBlock extends FenceBlock implements FactoryBlock {
    private final Identifier id;
    private final Block fence;

    public PolyFenceBlock(Settings settings, Block template) {
        super(settings);
        this.fence = template;
        this.id = Identifier.tryParse(this.getTranslationKey().replace("block.", "").replace(".", ":"));
    }


    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext packetContext) {
        return fence.getDefaultState()
                .with(NORTH, state.get(NORTH))
                .with(EAST, state.get(EAST))
                .with(SOUTH, state.get(SOUTH))
                .with(WEST, state.get(WEST))
                .with(WATERLOGGED, state.get(WATERLOGGED));
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new Model(initialBlockState, id);
    }

    public static final class Model extends BlockModel {
        public final ItemDisplayElement post;
        public final Map<Direction, ItemDisplayElement> sides = new HashMap<>();

        public Model(BlockState state, Identifier id) {
            ItemStack MODEL_POST = ItemDisplayElementUtil.getModel(Identifier.of(id.getNamespace(),"block/%s_post".formatted(id.getPath())));
            ItemStack MODEL_SIDE = ItemDisplayElementUtil.getModel(Identifier.of(id.getNamespace(), "block/%s_side".formatted(id.getPath())));

            post = ItemDisplayElementUtil.createSimple(MODEL_POST);
            post.setScale(new Vector3f(1.005f));
            addElement(post);
            for (Direction side : Direction.Type.HORIZONTAL) {
                sides.put(side, ItemDisplayElementUtil.createSimple(MODEL_SIDE));
                sides.get(side).setYaw(side.getPositiveHorizontalDegrees());
                sides.get(side).setScale(new Vector3f(1.005f));
                addElement(sides.get(side));
            }
            this.updateItem(state);
        }
        private void updateItem(BlockState state) {
            setVisibility(sides.get(Direction.NORTH), state.get(NORTH));
            setVisibility(sides.get(Direction.EAST), state.get(EAST));
            setVisibility(sides.get(Direction.SOUTH), state.get(SOUTH));
            setVisibility(sides.get(Direction.WEST), state.get(WEST));
        }
        private void setVisibility(ItemDisplayElement elem, boolean visible) {
            elem.setViewRange(visible ? 0.75f : 0f);
        }

        @Override
        public void notifyUpdate(HolderAttachment.UpdateType updateType) {
            if (updateType == BlockBoundAttachment.BLOCK_STATE_UPDATE){
                this.updateItem(this.blockState());
                this.tick();
            }
            super.notifyUpdate(updateType);
        }
    }
}
