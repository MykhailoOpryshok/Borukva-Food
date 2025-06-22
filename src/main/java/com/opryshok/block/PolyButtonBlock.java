package com.opryshok.block;

import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.attachment.BlockBoundAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.*;
import net.minecraft.block.enums.BlockFace;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import xyz.nucleoid.packettweaker.PacketContext;

public class PolyButtonBlock extends ButtonBlock implements FactoryBlock {
    private final Identifier id;
    private final Block template;

    public PolyButtonBlock(BlockSetType blockSetType, int pressTicks, Settings settings, Block template) {
        super(blockSetType, pressTicks, settings);
        this.template = template;
        this.id = Identifier.tryParse(this.getTranslationKey().replace("block.", "").replace(".", ":"));
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext packetContext) {
        return template.getDefaultState().with(FACING, state.get(FACING)).with(FACE, state.get(FACE)).with(POWERED, state.get(POWERED));
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new PolyButtonBlock.Model(initialBlockState, id);
    }

    public static final class Model extends BlockModel {
        public final ItemStack MODEL_UNPOWERED;
        public final ItemStack MODEL_POWERED;
        public ItemDisplayElement main;

        public Model(BlockState state, Identifier id) {
            MODEL_UNPOWERED = ItemDisplayElementUtil.getModel(Identifier.of(id.getNamespace(),"block/"+id.getPath()));
            MODEL_POWERED = ItemDisplayElementUtil.getModel(Identifier.of(id.getNamespace(), "block/"+id.getPath()+"_pressed"));

            main = ItemDisplayElementUtil.createSimple();
            this.updateItem(state);
            addElement(main);
        }
        private void updateItem(BlockState state) {
            main.setItem(state.get(POWERED) ? MODEL_POWERED : MODEL_UNPOWERED);
            if (state.get(FACE) == BlockFace.WALL) main.setRightRotation(state.get(FACING).getRotationQuaternion());
            else if (state.get(FACE) == BlockFace.CEILING) main.setRightRotation(RotationAxis.POSITIVE_Z.rotationDegrees(180).mul(RotationAxis.POSITIVE_Y.rotationDegrees(state.get(FACING).getPositiveHorizontalDegrees())));
            else  main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(state.get(FACING).getPositiveHorizontalDegrees()));

            float scale = 1.005f;
            main.setScale(new Vector3f(scale));
            float scaleOffset = (scale - 1)/2;
            if (state.get(FACE) == BlockFace.WALL) main.setTranslation(new Vector3f(scaleOffset, scaleOffset, scaleOffset).mul(state.get(FACING).getFloatVector()));
            else main.setTranslation(new Vector3f(0, state.get(FACE) == BlockFace.FLOOR ? scaleOffset : -scaleOffset, 0));
        }

        @Override
        public void notifyUpdate(HolderAttachment.UpdateType updateType) {
            if (updateType == BlockBoundAttachment.BLOCK_STATE_UPDATE){
                updateItem(this.blockState());
                this.tick();
            }
            super.notifyUpdate(updateType);
        }
    }
}