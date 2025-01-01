package com.opryshok.polydex.pages;

import com.opryshok.block.ModBlocks;
import com.opryshok.item.ModItems;
import com.opryshok.polydex.PolydexTextures;
import com.opryshok.recipe.cuttingBoard.CuttingBoardRecipe;
import eu.pb4.polydex.api.v1.recipe.PageBuilder;
import eu.pb4.polydex.api.v1.recipe.PolydexEntry;
import eu.pb4.polydex.api.v1.recipe.PolydexIngredient;
import eu.pb4.polydex.api.v1.recipe.PolydexStack;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CuttingBoardRecipePage extends PrioritizedRecipePage<CuttingBoardRecipe>{
    private static final ItemStack ICON = ModBlocks.CUTTING_BOARD_ITEM.getDefaultStack();
    private final PolydexIngredient<?> ingredients;
    private final PolydexStack<?> output;
    public CuttingBoardRecipePage(RecipeEntry<CuttingBoardRecipe> recipe) {
        super(recipe);
        this.ingredients = PolydexIngredient.of(this.recipe.input().ingredient());
        this.output = PolydexStack.of(this.recipe.output());
    }

    @Override
    public @Nullable Text texture(ServerPlayerEntity player) {
        return PolydexTextures.CUTTING_BOARD;
    }

    @Override
    public boolean isOwner(MinecraftServer server, PolydexEntry entry) {
        return entry.isPartOf(output);
    }

    @Override
    public ItemStack entryIcon(@Nullable PolydexEntry entry, ServerPlayerEntity player) {
        return this.recipe.output();
    }

    @Override
    public ItemStack typeIcon(ServerPlayerEntity serverPlayerEntity) {
        return ICON;
    }

    @Override
    public List<PolydexIngredient<?>> ingredients() {
        return List.of(ingredients);
    }

    @Override
    public void createPage(@Nullable PolydexEntry polydexEntry, ServerPlayerEntity serverPlayerEntity, PageBuilder pageBuilder) {
        pageBuilder.setIngredient(3, 2, this.ingredients);
        pageBuilder.setIngredient(4, 2, ModItems.KNIFE.getDefaultStack());
        pageBuilder.setOutput(5, 2, this.output);
    }
}
