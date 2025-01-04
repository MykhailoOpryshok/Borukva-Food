package com.opryshok.utils;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;

public class ModFoodComponents {
    private static FoodComponent.Builder createStew(int hunger) {
        return (new FoodComponent.Builder()).nutrition(hunger).saturationModifier(0.6F).usingConvertsTo(Items.BOWL);
    }
    public static final FoodComponent MEAT_PIZZA = new FoodComponent.Builder().nutrition(6).saturationModifier(0.3f).build();
    public static final FoodComponent PIZZA = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3f).build();
    public static final FoodComponent TOMATO = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3F).build();
    public static final FoodComponent CABBAGE = new FoodComponent.Builder().nutrition(1).saturationModifier(0.3f).build();
    public static final FoodComponent CHILLI_PEPPER = new FoodComponent.Builder().nutrition(1).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 60, 0),  1f).build();
    public static final FoodComponent CORN = new FoodComponent.Builder().nutrition(1).saturationModifier(0.3f).build();
    public static final FoodComponent CUCUMBER = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).build();
    public static final FoodComponent LETTUCE = new FoodComponent.Builder().nutrition(1).saturationModifier(0.25f).build();
    public static final FoodComponent LEMON = new FoodComponent.Builder().nutrition(1).saturationModifier(0.3f).build();
    public static final FoodComponent ONION = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 60, 0), 0.5f).build();
    public static final FoodComponent WAFFLE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.5f).build();
    public static final FoodComponent CHOCOLATE_BAR = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build();

    public static final FoodComponent ICE_CREAM = new FoodComponent.Builder().nutrition(3).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 0), 0.75f).build();
    public static final FoodComponent CHOCOLATE_ICE_CREAM = new FoodComponent.Builder().nutrition(6).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 0), 0.75f).build();
    public static final FoodComponent COOKIE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.2f).build();
    public static final FoodComponent BEEF_SANDWICH = new FoodComponent.Builder().nutrition(12).saturationModifier(0.75f).build();
    public static final FoodComponent TOMATO_SANDWICH = new FoodComponent.Builder().nutrition(8).saturationModifier(0.5f).build();
    public static final FoodComponent BREAD_SLICE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.6f).build();
    public static final FoodComponent BORSCH = createStew(12).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 1), 1f).build();
    public static final FoodComponent BROTH = createStew(8).build();
    public static final FoodComponent ROTTEN_SOUP = createStew(3)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 0), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 0), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200, 0), 1).build();
    public static final FoodComponent BEEF_SLICES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).build();
    public static final FoodComponent VEGAN_BARBECUE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3f).build();
    public static final FoodComponent COOKED_VEGAN_BARBECUE = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6f).build();
    public static final FoodComponent BEEF_BARBECUE = new FoodComponent.Builder().nutrition(5).saturationModifier(0.4f).build();
    public static final FoodComponent COOKED_BEEF_BARBECUE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.75f).build();
    public static final FoodComponent FRUIT_PIE = new FoodComponent.Builder().nutrition(7).saturationModifier(0.3f).build();
    public static final FoodComponent HONEY_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 90, 0), 1f).build();
    public static final FoodComponent PICKLE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.5f).build();
    public static final FoodComponent APPLE_CANDY = new FoodComponent.Builder().nutrition(6).saturationModifier(0.5f).build();
    public static final FoodComponent HONEY_CANDY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 90, 0), 0.75f).build();
    public static final FoodComponent JACK_CANDY = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 80, 1), 0.75f).build();
    public static final FoodComponent PUMPKIN_CANDY = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 90, 0), 0.75f).build();
    public static final FoodComponent LEMON_CANDY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 90, 1), 0.75f).build();
    public static final FoodComponent POPCORN = new FoodComponent.Builder().nutrition(3).saturationModifier(0.35f).build();
    public static final FoodComponent SALT_POPCORN = new FoodComponent.Builder().nutrition(6).saturationModifier(0.35f).build();
    public static final FoodComponent CHEESE_POPCORN = new FoodComponent.Builder().nutrition(7).saturationModifier(0.5f).build();
    public static final FoodComponent CHOCOLATE_POPCORN = new FoodComponent.Builder().nutrition(7).saturationModifier(0.5f).build();
    public static final FoodComponent CHEESE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.25f).build();
    public static final FoodComponent LAVASH = new FoodComponent.Builder().nutrition(3).saturationModifier(0.6f).build();
    public static final FoodComponent TOMATO_SLICES = new FoodComponent.Builder().nutrition(1).saturationModifier(0.3f).build();
    public static final FoodComponent CUCUMBER_SLICES = new FoodComponent.Builder().nutrition(1).saturationModifier(0.3f).build();
    public static final FoodComponent COOKED_BEEF_SLICES = new FoodComponent.Builder().nutrition(4).saturationModifier(0.5f).build();
    public static final FoodComponent SHAWARMA = new FoodComponent.Builder().nutrition(10).saturationModifier(0.5f).build();
    public static final FoodComponent AVOCADO = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build();
    public static final FoodComponent VEGETABLE_SALAD = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3f).usingConvertsTo(Items.BOWL).build();
    public static final FoodComponent BEEF_SALAD = new FoodComponent.Builder().nutrition(10).saturationModifier(0.5f).usingConvertsTo(Items.BOWL).build();
    public static final FoodComponent RICE_BOWL = new FoodComponent.Builder().nutrition(6).saturationModifier(0.5f).usingConvertsTo(Items.BOWL).build();
    public static final FoodComponent SALMON_FILLET = new FoodComponent.Builder().nutrition(1).saturationModifier(0.1f).build();
    public static final FoodComponent NORI = new FoodComponent.Builder().nutrition(1).saturationModifier(0.1f).snack().build();
    public static final FoodComponent SAUERKRAUT = new FoodComponent.Builder().nutrition(7).saturationModifier(0.35f).usingConvertsTo(Items.BOWL).build();
    public static final FoodComponent SALMON_MAKI = new FoodComponent.Builder().nutrition(6).saturationModifier(0.35f).statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 200, 0), 1f).build();
    public static final FoodComponent SALMON_URAMAKI = new FoodComponent.Builder().nutrition(5).saturationModifier(0.35f).statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 200, 0), 1f).build();
    public static final FoodComponent SALMON_NIGIRI = new FoodComponent.Builder().nutrition(4).saturationModifier(0.35f).statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 200, 0), 1f).build();
    public static final FoodComponent SUNFLOWER_SEED = new FoodComponent.Builder().nutrition(1).saturationModifier(0.2f).snack().build();
    public static final FoodComponent ROASTED_SUNFLOWER_SEED = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).snack().build();
    public static final FoodComponent SALO = new FoodComponent.Builder().nutrition(4).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 0), 1f).build();
    public static final FoodComponent ONIGIRI = new FoodComponent.Builder().nutrition(5).saturationModifier(0.3f).build();
    public static final FoodComponent NETHER_BUN = new FoodComponent.Builder().nutrition(4).saturationModifier(0.5f).build();
    public static final FoodComponent FUNGUS_PIZZA_SLICE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 100, 0),  1f).build();
    public static final FoodComponent BOILED_CORN = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3f).build();
    public static final FoodComponent HOGLIN_MEAT = new FoodComponent.Builder().nutrition(3).saturationModifier(3).build();
    public static final FoodComponent COOKED_HOGLIN_MEAT = new FoodComponent.Builder().nutrition(9).saturationModifier(0.7f).build();
    public static final FoodComponent FUNGUS_STEW = createStew(7).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0),  1f).build();
    public static final FoodComponent CHICKEN_LEG = new FoodComponent.Builder().nutrition(1).saturationModifier(0.3f).build();
    public static final FoodComponent COOKED_CHICKEN_LEG = new FoodComponent.Builder().nutrition(6).saturationModifier(0.4f).build();
    public static final FoodComponent MUTTON_SLICES = new FoodComponent.Builder().nutrition(1).saturationModifier(0.3f).build();
    public static final FoodComponent COOKED_MUTTON_SLICES = new FoodComponent.Builder().nutrition(4).saturationModifier(0.9f).build();
    public static final FoodComponent COOKED_SQUID_RING = new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build();
    public static final FoodComponent SQUID_RING = new FoodComponent.Builder().nutrition(3).saturationModifier(0.2f).build();
    public static final FoodComponent PEELED_SQUID_TENTACLES = new FoodComponent.Builder().nutrition(3).saturationModifier(0.2f).build();
}
