package com.opryshok.recipe;

import com.opryshok.BorukvaFood;
import com.opryshok.recipe.cuttingBoard.CuttingBoardRecipe;
import com.opryshok.recipe.pan.PanRecipe;
import com.opryshok.recipe.pot.PotRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModRecipeTypes {
    public static final RecipeType<PotRecipe> POT = register("pot");
    public static final RecipeType<CuttingBoardRecipe> CUTTING_BOARD = register("cutting_board");
    public static final RecipeType<PanRecipe> PAN = register("pan");
    public static void register() {

    }

    public static <T extends Recipe<?>> RecipeType<T> register(String path) {
        return Registry.register(Registries.RECIPE_TYPE, BorukvaFood.id(path), new RecipeType<T>() {
            @Override
            public String toString() {
                return BorukvaFood.MOD_ID + ":" + path;
            }
        });
    }
}
