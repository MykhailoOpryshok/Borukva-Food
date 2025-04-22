package com.opryshok.item;

import com.opryshok.entity.PickleJarEntity;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ProjectileItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class PickleJarItem extends SimplePolymerItem implements ProjectileItem {
    public PickleJarItem(Item.Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        var stack = user.getStackInHand(hand);

        PickleJarEntity.spawn(user.getRotationVector(), user.getEyePos(), world, stack.copyWithCount(1), user);

        world.playSound(null, user.getX(), user.getEyeY(), user.getZ(), SoundEvents.ENTITY_SPLASH_POTION_THROW, user.getSoundCategory(), 0.5F,
                0.4F / (world.getRandom().nextFloat() * 0.4F + 1F));


        if (!user.isCreative()) {
            stack.decrement(1);
        }

        return ActionResult.SUCCESS_SERVER;
    }
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        return PickleJarEntity.create(Vec3d.of(direction.getVector()), pos, world, stack.copyWithCount(1));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.borukva-food.pickle_jar").formatted(Formatting.YELLOW));
    }
}
