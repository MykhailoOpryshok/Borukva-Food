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
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import xyz.nucleoid.packettweaker.PacketContext;

import java.util.*;

public class PolyPressurePlate extends PressurePlateBlock implements FactoryBlock {
    private final Identifier id;
    private final Block template;

    public PolyPressurePlate(BlockSetType blockSet, Settings settings, Block template) {
        super(blockSet, settings);
        this.template = template;
        id = Identifier.tryParse(this.getTranslationKey().replace("block.", "").replace(".", ":"));
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
        return template.getDefaultState().with(POWERED, state.get(POWERED));
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new Model(initialBlockState, id);
    }

    public static final class Model extends BlockModel {
        public final ItemStack MODEL_UNPOWERED;
        public final ItemStack MODEL_POWERED;
        public ItemDisplayElement main;
        private static final Queue<Model> toBeTicked = new ArrayDeque<>();
        private static final Timer timer = new Timer("Polywood: Pressure Plate Update Timer");

        public Model(BlockState state, Identifier id) {
            MODEL_UNPOWERED = ItemDisplayElementUtil.getModel(Identifier.of(id.getNamespace(),"block/"+id.getPath()));
            MODEL_POWERED = ItemDisplayElementUtil.getModel(Identifier.of(id.getNamespace(), "block/"+id.getPath()+"_down"));

            main = ItemDisplayElementUtil.createSimple();
            this.updateItem(state.get(POWERED));
            addElement(main);
        }
        private void updateItem(boolean powered) {
            main.setItem(powered ? MODEL_POWERED : MODEL_UNPOWERED);
            float scale = 1.01f;
            main.setScale(new Vector3f(powered ? scale : 2*scale));
            float scaleOffset = (scale - 1)/2;
            main.setTranslation(new Vector3f(0, scaleOffset, 0));
        }

        @Override
        public void notifyUpdate(HolderAttachment.UpdateType updateType) {
            if (updateType == BlockBoundAttachment.BLOCK_STATE_UPDATE){
                if (!this.blockState().get(POWERED)) {
                    this.updateItem(false);
                    this.tick();
                }
                else {
                    toBeTicked.add(this);

                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if (!toBeTicked.isEmpty()) {
                                Model model = toBeTicked.peek();
                                model.updateItem(true);
                                model.tick();
                                toBeTicked.remove();
                            }
                        }
                    }, 100);
                }
            }
            super.notifyUpdate(updateType);
        }
    }
}