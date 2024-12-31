package com.opryshok.recipe.pan;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.opryshok.BorukvaFood;
import com.opryshok.recipe.ModRecipeSerializer;
import com.opryshok.recipe.ModRecipeTypes;
import eu.pb4.factorytools.api.recipe.CountedIngredient;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

public record PanRecipe (String group, CountedIngredient input, ItemStack output, double time) implements Recipe<PanInput> {
    public static final MapCodec<PanRecipe> CODEC = RecordCodecBuilder.mapCodec(x -> x.group(
                    Codec.STRING.optionalFieldOf("group", "").forGetter(PanRecipe::group),
                    CountedIngredient.CODEC.fieldOf("input").forGetter(PanRecipe::input),
                    ItemStack.CODEC.fieldOf("output").forGetter(PanRecipe::output),
                    Codec.DOUBLE.optionalFieldOf("time", 0d).forGetter(PanRecipe::time)
            ).apply(x, PanRecipe::new)
    );
    public static RecipeEntry<PanRecipe> of(String string, CountedIngredient ingredient, ItemStack output, double time) {
        return new RecipeEntry<>(BorukvaFood.id("pan/" + string), new PanRecipe("", ingredient, output, time));
    }
    @Override
    public boolean matches(PanInput input, World world) {
        if(world.isClient){
            return false;
        }
        return this.input.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(PanInput input, RegistryWrapper.WrapperLookup lookup) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializer.PAN;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.PAN;
    }
}
