package com.opryshok.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static FoodComponent PIZZA = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f).build();
    public static FoodComponent BEEF_SANDWICH = new FoodComponent.Builder().nutrition(6).saturationModifier(0.5f).build();
}
