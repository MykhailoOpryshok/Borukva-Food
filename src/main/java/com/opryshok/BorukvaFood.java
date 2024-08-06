package com.opryshok;

import com.opryshok.block.ModBlocks;
import com.opryshok.block.bushes.BlackcurrantsBush;
import com.opryshok.block.bushes.GooseberryBush;
import com.opryshok.block.cooking.CuttingBoard;
import com.opryshok.block.cooking.Pan;
import com.opryshok.block.cooking.Stove;
import com.opryshok.block.crops.*;
import com.opryshok.block.food.ChocolateCake;
import com.opryshok.block.food.HoneyCake;
import com.opryshok.block.food.MeatPizza;
import com.opryshok.block.food.VeganPizza;
import com.opryshok.entity.ModEntities;
import com.opryshok.item.ModItems;
import com.opryshok.ui.GuiTextures;
import com.opryshok.ui.UiResourceCreator;
import com.opryshok.utils.BorukvaFoodUtil;
import com.opryshok.utils.CompostableItems;
import com.opryshok.utils.ModCustomTrades;
import com.opryshok.utils.ModifyLootTables;
import com.opryshok.world.gen.ModWorldGeneration;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BorukvaFood implements ModInitializer {

	public static final String MOD_ID = "borukva-food";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		GuiTextures.register();
		UiResourceCreator.setup();
		ModItems.registerModItems();
		ModBlocks.registerBlocks();
		ModEntities.register();
		CompostableItems.register();
		ModWorldGeneration.generateModWorldGen();
		ModifyLootTables.modifyLootTables();
		BorukvaFoodUtil.registerWood();
		ModCustomTrades.registerCustomTrades();
		if (PolymerResourcePackUtils.addModAssets(MOD_ID)) {
			LOGGER.info("Successfully added mod assets for " + MOD_ID);
		} else {
			LOGGER.error("Failed to add mod assets for " + MOD_ID);
		}
		initModels();
		PolymerResourcePackUtils.markAsRequired();
	}

	@SuppressWarnings("ResultOfMethodCallIgnored")
	public void initModels(){
		Stove.Model.LIT_FALSE.isEmpty();
		Stove.Model.LIT_TRUE.isEmpty();
		Pan.Model.MODEL.isEmpty();
		CuttingBoard.Model.MODEL.isEmpty();
		BlackcurrantsBush.Model.MODELS.forEach(ItemStack::isEmpty);
		GooseberryBush.Model.MODELS.forEach(ItemStack::isEmpty);
		MeatPizza.Model.MEAT_MODEL.forEach(ItemStack::isEmpty);
		VeganPizza.Model.MODEL.forEach(ItemStack::isEmpty);
		TomatoCrop.Model.MODELS.forEach(ItemStack::isEmpty);
		OnionCrop.Model.MODELS.forEach(ItemStack::isEmpty);
		LettuceCrop.Model.MODELS.forEach(ItemStack::isEmpty);
		CucumberCrop.Model.MODELS.forEach(ItemStack::isEmpty);
		CornCrop.Model.MODELS.forEach(ItemStack::isEmpty);
		ChilliPepperCrop.Model.MODELS.forEach(ItemStack::isEmpty);
		CabbageCrop.Model.MODELS.forEach(ItemStack::isEmpty);
		ChocolateCake.Model.CHOCOLATE_MODEL.forEach(ItemStack::isEmpty);
		HoneyCake.Model.HONEY_MODEL.forEach(ItemStack::isEmpty);
	}
}