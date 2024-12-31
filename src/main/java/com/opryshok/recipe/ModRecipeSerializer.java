package com.opryshok.recipe;

import com.mojang.serialization.MapCodec;
import com.opryshok.BorukvaFood;
import com.opryshok.recipe.cuttingBoard.CuttingBoardRecipe;
import com.opryshok.recipe.pan.PanRecipe;
import com.opryshok.recipe.pot.PotRecipe;
import eu.pb4.factorytools.api.recipe.LazyRecipeSerializer;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModRecipeSerializer {
    public static final LazyRecipeSerializer<PotRecipe> POT = register("pot", PotRecipe.CODEC);
    public static final LazyRecipeSerializer<CuttingBoardRecipe> CUTTING_BOARD = register("cutting_board", CuttingBoardRecipe.CODEC);
    public static final LazyRecipeSerializer<PanRecipe> PAN = register("pan", PanRecipe.CODEC);
    public static void register() {

    }

    public static <T extends RecipeSerializer<?>> T register(String path, T recipeSerializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, BorukvaFood.id(path), recipeSerializer);
    }

    public static <T extends Recipe<?>> LazyRecipeSerializer<T> register(String path, MapCodec<T> codec) {
        return Registry.register(Registries.RECIPE_SERIALIZER, BorukvaFood.id(path), new LazyRecipeSerializer<>(codec));
    }
}
