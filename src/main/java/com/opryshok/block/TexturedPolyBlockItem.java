package com.opryshok.block;

import eu.pb4.polymer.core.api.item.PolymerBlockItem;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Vec3d;

public class TexturedPolyBlockItem extends PolymerBlockItem {

    public TexturedPolyBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        ActionResult x = super.useOnBlock(context);
        if (x == ActionResult.SUCCESS) {
            PlayerEntity player = context.getPlayer();
            if (player instanceof ServerPlayerEntity) {
                ServerPlayerEntity serverPlayer = (ServerPlayerEntity)player;
                Vec3d soundPos = Vec3d.ofCenter(context.getBlockPos().offset(context.getSide()));
                BlockSoundGroup blockSoundGroup = this.getBlock().getDefaultState().getSoundGroup();
                serverPlayer.networkHandler.sendPacket(new PlaySoundS2CPacket(
                        Registries.SOUND_EVENT.getEntry(this.getPlaceSound(this.getBlock().getDefaultState())),
                        SoundCategory.BLOCKS,
                        soundPos.x,
                        soundPos.y,
                        soundPos.z,
                        (blockSoundGroup.getVolume() + 1.0F) / 2.0F,
                        blockSoundGroup.getPitch() * 0.8F,
                        player.getRandom().nextLong()
                ));
            }
            return ActionResult.SUCCESS_SERVER;
        } else {
            return x;
        }
    }
}
