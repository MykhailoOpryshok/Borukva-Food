package com.opryshok.utils;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;

public class ModFoodComponents {
    private static FoodComponent.Builder createStew(int hunger) {
        return (new FoodComponent.Builder()).nutrition(hunger).saturationModifier(0.6F).usingConvertsTo(Items.BOWL);
    }
    public static final FoodComponent PIZZA = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3f).build();
    public static final FoodComponent TOMATO = new FoodComponent.Builder().nutrition(2).saturationModifier(0.5F).build();
    public static final FoodComponent CABBAGE = new FoodComponent.Builder().nutrition(1).saturationModifier(0.5f).build();
    public static final FoodComponent CHILLI_PEPPER = new FoodComponent.Builder().nutrition(1).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 40, 0),  1f).build();
    public static final FoodComponent CORN = new FoodComponent.Builder().nutrition(1).saturationModifier(0.5f).build();
    public static final FoodComponent CUCUMBER = new FoodComponent.Builder().nutrition(2).saturationModifier(0.5f).build();
    public static final FoodComponent LETTUCE = new FoodComponent.Builder().nutrition(1).saturationModifier(0.25f).build();
    public static final FoodComponent LEMON = new FoodComponent.Builder().nutrition(1).saturationModifier(0.5f).build();
    public static final FoodComponent ONION = new FoodComponent.Builder().nutrition(2).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 60, 0), 0.5f).build();
    public static final FoodComponent WAFFLE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.6f).build();
    public static final FoodComponent CHOCOLATE_BAR = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build();

    public static final FoodComponent ICE_CREAM = new FoodComponent.Builder().nutrition(3).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 0), 0.75f).build();
    public static final FoodComponent COOKIE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.2f).build();
    public static final FoodComponent BEEF_SANDWICH = new FoodComponent.Builder().nutrition(12).saturationModifier(0.75f).build();
    public static final FoodComponent TOMATO_SANDWICH = new FoodComponent.Builder().nutrition(8).saturationModifier(0.5f).build();
    public static final FoodComponent BREAD_SLICE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.6f).build();
    public static final FoodComponent BORSCH = createStew(6).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 1), 0.5f).build();
    public static final FoodComponent BROTH = createStew(8).build();
    public static final FoodComponent ROTTEN_SOUP = createStew(3)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 0), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 0), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200, 0), 1).build();
    public static final FoodComponent BEEF_SLICES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).build();
    public static final FoodComponent VEGAN_BARBECUE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3f).build();
    public static final FoodComponent COOKED_VEGAN_BARBECUE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.6f).build();
    public static final FoodComponent BEEF_BARBECUE = new FoodComponent.Builder().nutrition(5).saturationModifier(0.4f).build();
    public static final FoodComponent COOKED_BEEF_BARBECUE = new FoodComponent.Builder().nutrition(10).saturationModifier(0.8f).build();
    public static final FoodComponent FRUIT_PIE = new FoodComponent.Builder().nutrition(7).saturationModifier(0.3f).build();
    public static final FoodComponent HONEY_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60, 0), 1f).build();
    public static final FoodComponent PICKLE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.5f).build();
    public static final FoodComponent APPLE_CANDY = new FoodComponent.Builder().nutrition(6).saturationModifier(0.5f).build();
    public static final FoodComponent HONEY_CANDY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.2f).build();
    public static final FoodComponent JACK_CANDY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).build();
    public static final FoodComponent PUMPKIN_CANDY = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build();
    public static final FoodComponent LEMON_CANDY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.2f).build();
}
