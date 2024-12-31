package com.opryshok.recipe.cuttingBoard;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.opryshok.BorukvaFood;
import com.opryshok.entity.CuttingBoardBlockEntity;
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

public record CuttingBoardRecipe (String group, CountedIngredient input, ItemStack output) implements Recipe<CuttingBoardInput> {
    public static final MapCodec<CuttingBoardRecipe> CODEC = RecordCodecBuilder.mapCodec(x -> x.group(
                    Codec.STRING.optionalFieldOf("group", "").forGetter(CuttingBoardRecipe::group),
                    CountedIngredient.CODEC.fieldOf("input").forGetter(CuttingBoardRecipe::input),
                    ItemStack.CODEC.fieldOf("output").forGetter(CuttingBoardRecipe::output)
            ).apply(x, CuttingBoardRecipe::new)
    );
    public static RecipeEntry<CuttingBoardRecipe> of(String string, CountedIngredient ingredient, ItemStack output) {
        return new RecipeEntry<>(BorukvaFood.id("cutting_board/" + string), new CuttingBoardRecipe("", ingredient, output));
    }

    @Override
    public boolean matches(CuttingBoardInput input, World world) {
        if(world.isClient){
            return false;
        }
        return this.input.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(CuttingBoardInput input, RegistryWrapper.WrapperLookup lookup) {
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
        return ModRecipeSerializer.CUTTING_BOARD;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.CUTTING_BOARD;
    }
    public void applyRecipeUse(CuttingBoardBlockEntity inventory, World world) {
        inventory.getStack(0).decrement(1);
        if(inventory.getStack(0).isEmpty()){
            inventory.setStack(0, ItemStack.EMPTY);
        }
    }
}
