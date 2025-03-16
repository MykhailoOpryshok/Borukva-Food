package com.opryshok.polydex;

import com.opryshok.polydex.pages.CuttingBoardRecipePage;
import com.opryshok.polydex.pages.PanRecipePage;
import com.opryshok.polydex.pages.PotRecipePage;
import com.opryshok.recipe.cuttingBoard.CuttingBoardRecipe;
import com.opryshok.recipe.pan.PanRecipe;
import com.opryshok.recipe.pot.PotRecipe;
import com.opryshok.ui.GuiTextures;
import eu.pb4.factorytools.api.recipe.CountedIngredient;
import eu.pb4.polydex.api.v1.recipe.PolydexCategory;
import eu.pb4.polydex.api.v1.recipe.PolydexIngredient;
import eu.pb4.polydex.api.v1.recipe.PolydexPage;
import eu.pb4.polydex.api.v1.recipe.PolydexPageUtils;
import eu.pb4.polydex.impl.book.ui.GuiUtils;
import eu.pb4.sgui.api.elements.GuiElement;
import net.minecraft.recipe.RecipeType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PolydexCompatImpl {
    public static void register() {
        PolydexPage.registerRecipeViewer(CuttingBoardRecipe.class, CuttingBoardRecipePage::new);
        PolydexPage.registerRecipeViewer(PanRecipe.class, PanRecipePage::new);
        PolydexPage.registerRecipeViewer(PotRecipe.class, PotRecipePage::new);
        PolydexPage.register(PolydexCompatImpl::createPages);
    }

    private static void createPages(MinecraftServer server, Consumer<PolydexPage> polydexPageConsumer) {

    }

    public static GuiElement getButton(RecipeType<?> type) {
        var category = PolydexCategory.of(type);
        return GuiTextures.POLYDEX_BUTTON.get()
                .setName(Text.translatable("text.borukva-food.recipes"))
                .setCallback((index, type1, action, gui) -> {
                    PolydexPageUtils.openCategoryUi(gui.getPlayer(), category, gui::open);
                    GuiUtils.playClickSound(gui.getPlayer());
                }).build();
    }

    public static List<PolydexIngredient<?>> createIngredients(List<CountedIngredient> input) {
        var list = new ArrayList<PolydexIngredient<?>>(input.size());
        for (var x : input) {
            list.add(PolydexIngredient.of(x.ingredient().orElse(null), Math.max(x.count(), 1), 1));
        }
        return list;
    }
}
