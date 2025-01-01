package com.opryshok.polydex.pages;

import com.opryshok.block.ModBlocks;
import com.opryshok.polydex.PolydexCompatImpl;
import com.opryshok.polydex.PolydexTextures;
import com.opryshok.recipe.pot.PotRecipe;
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

public class PotRecipePage extends PrioritizedRecipePage<PotRecipe>{
    private static final ItemStack ICON = ModBlocks.POT_ITEM.getDefaultStack();
    private final List<PolydexIngredient<?>> ingredients;
    private final PolydexIngredient<?> bowl;
    private final PolydexStack<?> output;
    public PotRecipePage(RecipeEntry<PotRecipe> recipe) {
        super(recipe);
        this.ingredients = PolydexCompatImpl.createIngredients(recipe.value().input());
        this.bowl = PolydexIngredient.of(recipe.value().bowl().ingredient());
        this.output = PolydexStack.of(this.recipe.output());
    }

    @Override
    public @Nullable Text texture(ServerPlayerEntity player) {
        return PolydexTextures.POT;
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
        return ingredients;
    }

    @Override
    public void createPage(@Nullable PolydexEntry polydexEntry, ServerPlayerEntity serverPlayerEntity, PageBuilder pageBuilder) {
        for (int i = 0; i < ingredients.size() && i < 6; i++) {
            int column = i % 3;
            int row = 1 + i / 3;
            pageBuilder.setIngredient(column, row, ingredients.get(i));
        }
        if(!bowl.isEmpty()){
            pageBuilder.setIngredient(7, 1, bowl);
        }
        pageBuilder.setOutput(7, 3, output);
    }
}
