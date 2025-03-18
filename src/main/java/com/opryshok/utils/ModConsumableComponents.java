package com.opryshok.utils;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

import java.util.List;

import static net.minecraft.component.type.ConsumableComponents.food;

public class ModConsumableComponents {
    public static final ConsumableComponent CHILLI_PEPPER = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 60, 0)
            )
        )
        .build();
    public static final ConsumableComponent ONION = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.NAUSEA, 60, 0)
                , 0.5f
            )
        )
        .build();
    public static final ConsumableComponent ICE_CREAM = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 0)
                , 0.75f
            )
        )
        .build();
    public static final ConsumableComponent CHOCOLATE_ICE_CREAM = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 0)
                , 0.75f
            )
        )
        .build();
    public static final ConsumableComponent BORSCH = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.STRENGTH, 200, 1)
            )
        )
        .build();
    public static final ConsumableComponent ROTTEN_SOUP = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                List.of(
                    new StatusEffectInstance(StatusEffects.HUNGER, 200, 0),
                    new StatusEffectInstance(StatusEffects.POISON, 200, 0),
                    new StatusEffectInstance(StatusEffects.BLINDNESS, 200, 0)
                )
            )
        )
        .build();
    public static final ConsumableComponent HONEY_PIE = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.REGENERATION, 90, 0)
            )
        )
        .build();
    public static final ConsumableComponent HONEY_CANDY = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.REGENERATION, 90, 0),
                0.75f
            )
        )
        .build();
    public static final ConsumableComponent JACK_CANDY = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.JUMP_BOOST, 80, 1),
                0.75f
            )
        )
        .build();
    public static final ConsumableComponent PUMPKIN_CANDY = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.NIGHT_VISION, 90, 0),
                0.75f
            )
        )
        .build();
    public static final ConsumableComponent LEMON_CANDY = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.SPEED, 90, 1),
                0.75f
            )
        )
        .build();
    public static final ConsumableComponent SALMON_MAKI = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.WATER_BREATHING, 200, 0)
            )
        )
        .build();
    public static final ConsumableComponent SALMON_URAMAKI = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.WATER_BREATHING, 200, 0)
            )
        )
        .build();
    public static final ConsumableComponent SALMON_NIGIRI = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.WATER_BREATHING, 200, 0)
            )
        )
        .build();
    public static final ConsumableComponent SALO = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.STRENGTH, 100, 0)
            )
        )
        .build();
    public static final ConsumableComponent FUNGUS_PIZZA_SLICE = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 100, 0)
            )
        )
        .build();
    public static final ConsumableComponent FUNGUS_STEW = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0)
            )
        )
        .build();
    public static final ConsumableComponent NORI = snack()
        .build();
    public static final ConsumableComponent SUNFLOWER_SEED = snack()
        .build();
    public static final ConsumableComponent ROASTED_SUNFLOWER_SEED = snack()
        .build();
    public static final ConsumableComponent GOLDEN_CHORUS_FRUIT = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                List.of(
                    new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1),
                    new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 0)
                )
            )
        )
        .build();
    public static final ConsumableComponent GOLDEN_BREAD = food()
        .consumeEffect(
            new ApplyEffectsConsumeEffect(
                new StatusEffectInstance(StatusEffects.REGENERATION, 200, 0)
            )
        )
        .build();

    public static ConsumableComponent.Builder snack() {
        return ConsumableComponent.builder().consumeSeconds(0.8f);
    }

}
