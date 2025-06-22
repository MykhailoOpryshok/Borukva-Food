package com.opryshok.block;

import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.attachment.BlockBoundAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import xyz.nucleoid.packettweaker.PacketContext;

public class PolyFenceGateBlock extends FenceGateBlock implements FactoryBlock {
    private final Identifier id;
    private final Block template;

    public PolyFenceGateBlock(WoodType type, Settings settings, Block template) {
        super(type, settings);
        this.template = template;
        this.id = Identifier.tryParse(this.getTranslationKey().replace("block.", "").replace(".", ":"));
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext packetContext) {
        BlockState polymerTemplateState = this.template.getDefaultState();
        if (polymerTemplateState.contains(FACING) && polymerTemplateState.contains(OPEN) && polymerTemplateState.contains(IN_WALL)) {
            return polymerTemplateState
                    .with(FACING, state.get(FACING))
                    .with(OPEN, state.get(OPEN))
                    .with(IN_WALL, state.get(IN_WALL));
        }
        return polymerTemplateState;
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new PolyFenceGateBlock.Model(initialBlockState, id);
    }

    public static final class Model extends BlockModel {
        public final ItemStack MODEL_CLOSED;
        public final ItemStack MODEL_OPEN;
        public final ItemDisplayElement[] main = new ItemDisplayElement[2];

        public Model(BlockState state, Identifier id) {
            MODEL_CLOSED = ItemDisplayElementUtil.getModel(Identifier.of(id.getNamespace(),"block/"+id.getPath()));
            MODEL_OPEN = ItemDisplayElementUtil.getModel(Identifier.of(id.getNamespace(), "block/"+id.getPath()+"_open"));

            main[0] = ItemDisplayElementUtil.createSimple();
            main[1] = ItemDisplayElementUtil.createSimple();
            this.updateItem(state);
            addElement(main[0]);
            addElement(main[1]);
        }
        private void updateItem(BlockState state) {
            for (int i = 0; i < 2; i++) {
                ItemDisplayElement elem = main[i];
                elem.setItem(state.get(OPEN) ? MODEL_OPEN : MODEL_CLOSED);
                float scale = 1.0025f;
                elem.setScale(new Vector3f(state.get(OPEN) ? scale : 2 * scale));
                float offset = i == 0 ? 0.001f : -0.001f;
                elem.setTranslation(new Vector3f(offset, offset + (state.get(IN_WALL) ? -0.1875f : 0), offset));
                elem.setRightRotation(state.get(FACING).getRotationQuaternion().mul(RotationAxis.POSITIVE_X.rotationDegrees(-90)).mul(RotationAxis.POSITIVE_Y.rotationDegrees(180)));
            }
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
