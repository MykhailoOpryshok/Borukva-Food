package com.opryshok;

import com.opryshok.block.ModBlocks;
import com.opryshok.entity.ModBlockEntities;
import com.opryshok.item.ModItems;
import com.opryshok.ui.GuiTextures;
import com.opryshok.ui.UiResourceCreator;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
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
		ModBlockEntities.register();
		if (PolymerResourcePackUtils.addModAssets(MOD_ID)) {
			LOGGER.info("Successfully added mod assets for " + MOD_ID);
		} else {
			LOGGER.error("Failed to add mod assets for " + MOD_ID);
		}
		PolymerResourcePackUtils.markAsRequired();

		System.out.println("available blocks plant!!!");
		System.out.println("full block: " + PolymerBlockResourceUtils.getBlocksLeft(BlockModelType.FULL_BLOCK));
		System.out.println("biome plant block: " + PolymerBlockResourceUtils.getBlocksLeft(BlockModelType.BIOME_PLANT_BLOCK));
		System.out.println("plant block: " + PolymerBlockResourceUtils.getBlocksLeft(BlockModelType.PLANT_BLOCK));
	}
}