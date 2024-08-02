package com.opryshok.block;

import com.opryshok.BorukvaFood;
import com.opryshok.PolySaplingBlock;
import com.opryshok.block.bushes.BlackcurrantsBush;
import com.opryshok.block.bushes.GooseberryBush;
import com.opryshok.block.cooking.CuttingBoard;
import com.opryshok.block.cooking.Pan;
import com.opryshok.block.cooking.Stove;
import com.opryshok.block.crops.*;
import com.opryshok.block.food.MeatPizza;
import com.opryshok.block.food.VeganPizza;
import com.opryshok.item.ModItems;
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.opryshok.BorukvaFood.MOD_ID;

public class ModBlocks {
    // Blocks:
    public static final Block TOMATO = registerBlock("tomato_crop", new TomatoCrop(Block.Settings.copy(Blocks.WHEAT)));
    public static final Block CABBAGE = registerBlock("cabbage_crop", new CabbageCrop(Block.Settings.copy(Blocks.WHEAT)));
    public static final Block CORN = registerBlock("corn_crop", new CornCrop(Block.Settings.copy(Blocks.WHEAT)));
    public static final Block CHILLI_PEPPER = registerBlock("chilli_pepper_crop", new ChilliPepperCrop(Block.Settings.copy(Blocks.WHEAT)));
    public static final Block LETTUCE = registerBlock("lettuce_crop", new LettuceCrop(Block.Settings.copy(Blocks.WHEAT)));
    public static final Block CUCUMBER = registerBlock("cucumber_crop", new CucumberCrop(Block.Settings.copy(Blocks.WHEAT)));
    public static final Block ONION = registerBlock("onion_crop", new OnionCrop(Block.Settings.copy(Blocks.WHEAT)));

    public static final Block BETTER_FARMLAND = registerBlock("better_farmland", new BetterFarmlandBlock(Block.Settings.copy(Blocks.FARMLAND)));
    public static final Block MEAT_PIZZA = registerBlock("meat_pizza", new MeatPizza(Block.Settings.copy(Blocks.CAKE)));
    public static final Block VEGAN_PIZZA = registerBlock("vegan_pizza", new VeganPizza(Block.Settings.copy(Blocks.CAKE)));
    public static final Block STOVE = registerBlock("stove", new Stove(Block.Settings.copy(Blocks.FURNACE)));
    public static final Block PAN = registerBlock("pan", new Pan(Block.Settings.copy(Blocks.GRASS_BLOCK)));
    public static final Block CUTTING_BOARD = registerBlock("cutting_board", new CuttingBoard(Block.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block BEETROOT_CRATE = registerBlock("beetroot_crate", new SimplePolyBlock(Block.Settings.copy(Blocks.COMPOSTER), "beetroot_crate"));
    public static final Block CABBAGE_CRATE = registerBlock("cabbage_crate", new SimplePolyBlock(Block.Settings.copy(Blocks.COMPOSTER), "cabbage_crate"));
    public static final Block CARROT_CRATE = registerBlock("carrot_crate", new SimplePolyBlock(Block.Settings.copy(Blocks.COMPOSTER), "carrot_crate"));
    public static final Block CHILLI_PEPPER_CRATE = registerBlock("chilli_pepper_crate", new SimplePolyBlock(Block.Settings.copy(Blocks.COMPOSTER), "chilli_pepper_crate"));
    public static final Block CORN_CRATE = registerBlock("corn_crate", new SimplePolyBlock(Block.Settings.copy(Blocks.COMPOSTER), "corn_crate"));
    public static final Block CUCUMBER_CRATE = registerBlock("cucumber_crate", new SimplePolyBlock(Block.Settings.copy(Blocks.COMPOSTER), "cucumber_crate"));
    public static final Block LETTUCE_CRATE = registerBlock("lettuce_crate", new SimplePolyBlock(Block.Settings.copy(Blocks.COMPOSTER), "lettuce_crate"));
    public static final Block POTATO_CRATE = registerBlock("potato_crate", new SimplePolyBlock(Block.Settings.copy(Blocks.COMPOSTER), "potato_crate"));
    public static final Block TOMATO_CRATE = registerBlock("tomato_crate", new SimplePolyBlock(Block.Settings.copy(Blocks.COMPOSTER), "tomato_crate"));
    public static final Block BLACKCURRANTS_BUSH = registerBlock("blackcurrants_bush", new BlackcurrantsBush(Block.Settings.copy(Blocks.SWEET_BERRY_BUSH)));
    public static final Block GOOSEBERRY_BUSH = registerBlock("gooseberry_bush", new GooseberryBush(Block.Settings.copy(Blocks.SWEET_BERRY_BUSH)));
    public static final Block SALT = registerBlock("salt_block", new SimplePolyBlock(Block.Settings.copy(Blocks.STONE), "salt_block"));


    public static final Block LEMON_LOG = registerBlock("lemon_log", new PolyLogBlock(Block.Settings.copy(Blocks.OAK_LOG)));
    public static final Block LEMON_WOOD = registerBlock("lemon_wood", new PolyLogBlock(Block.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_LEMON_LOG = registerBlock("stripped_lemon_log", new PolyLogBlock(Block.Settings.copy(Blocks.OAK_LOG)));
    public static final Block STRIPPED_LEMON_WOOD = registerBlock("stripped_lemon_wood", new PolyLogBlock(Block.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block LEMON_LEAVES = registerBlock("lemon_leaves", new PolyLeavesBlock(Block.Settings.copy(Blocks.OAK_LEAVES), "lemon_leaves"));
    public static final Block LEMON_PLANKS = registerBlock("lemon_planks", new SimplePolyBlock(Block.Settings.copy(Blocks.OAK_PLANKS), "lemon_planks"));
    public static final Block LEMON_SAPLING = registerBlock("lemon_sapling", new PolySaplingBlock(SaplingGenerator.AZALEA, Block.Settings.copy(Blocks.OAK_SAPLING), "lemon_sapling"));


    // Block Items:
    public static final BlockItem LEMON_LOG_ITEM = registerBlockItem("lemon_log", new TexturedPolyBlockItem(LEMON_LOG, new Item.Settings(), "block/lemon_log"));
    public static final BlockItem LEMON_WOOD_ITEM = registerBlockItem("lemon_wood", new TexturedPolyBlockItem(LEMON_WOOD, new Item.Settings(), "block/lemon_wood"));
    public static final BlockItem STRIPPED_LEMON_LOG_ITEM = registerBlockItem("stripped_lemon_log", new TexturedPolyBlockItem(STRIPPED_LEMON_LOG, new Item.Settings(), "block/stripped_lemon_log"));
    public static final BlockItem STRIPPED_LEMON_WOOD_ITEM = registerBlockItem("stripped_lemon_wood", new TexturedPolyBlockItem(STRIPPED_LEMON_WOOD, new Item.Settings(), "block/stripped_lemon_wood"));
    public static final BlockItem LEMON_LEAVES_ITEM = registerBlockItem("lemon_leaves", new TexturedPolyBlockItem(LEMON_LEAVES, new Item.Settings(), "block/lemon_leaves"));
    public static final BlockItem LEMON_PLANKS_ITEM = registerBlockItem("lemon_planks", new TexturedPolyBlockItem(LEMON_PLANKS, new Item.Settings(), "block/lemon_planks"));
    public static final BlockItem LEMON_SAPLING_ITEM = registerBlockItem("lemon_sapling", new TexturedPolyBlockItem(LEMON_SAPLING, new Item.Settings(), "block/lemon_sapling"));


    public static final BlockItem SALT_BLOCK_ITEM = registerBlockItem("salt_block", new TexturedPolyBlockItem(SALT, new Item.Settings(), "block/salt_block"));
    public static final BlockItem MEAT_PIZZA_ITEM = registerBlockItem("meat_pizza", new TexturedPolyBlockItem(MEAT_PIZZA, new Item.Settings().maxCount(1), "item/meat_pizza"));
    public static final BlockItem VEGAN_PIZZA_ITEM = registerBlockItem("vegan_pizza", new TexturedPolyBlockItem(VEGAN_PIZZA, new Item.Settings().maxCount(1), "item/vegan_pizza"));
    public static final BlockItem STOVE_ITEM = registerBlockItem("stove", new TexturedPolyBlockItem(STOVE, new Item.Settings(), "block/stove"));
    public static final BlockItem PAN_ITEM = registerBlockItem("pan", new TexturedPolyBlockItem(PAN, new Item.Settings(), "block/pan"));
    public static final BlockItem CUTTING_BOARD_ITEM = registerBlockItem("cutting_board", new TexturedPolyBlockItem(CUTTING_BOARD, new Item.Settings(), "item/cutting_board"));
    public static final BlockItem BEETROOT_CRATE_ITEM = registerBlockItem("beetroot_crate", new TexturedPolyBlockItem(BEETROOT_CRATE, new Item.Settings(), "block/beetroot_crate"));
    public static final BlockItem CABBAGE_CRATE_ITEM = registerBlockItem("cabbage_crate", new TexturedPolyBlockItem(CABBAGE_CRATE, new Item.Settings(), "block/cabbage_crate"));
    public static final BlockItem CARROT_CRATE_ITEM = registerBlockItem("carrot_crate", new TexturedPolyBlockItem(CARROT_CRATE, new Item.Settings(), "block/carrot_crate"));
    public static final BlockItem CHILLI_CRATE_ITEM = registerBlockItem("chilli_pepper_crate", new TexturedPolyBlockItem(CHILLI_PEPPER_CRATE, new Item.Settings(), "block/chilli_pepper_crate"));
    public static final BlockItem CORN_CRATE_ITEM = registerBlockItem("corn_crate", new TexturedPolyBlockItem(CORN_CRATE, new Item.Settings(), "block/corn_crate"));
    public static final BlockItem CUCUMBER_CRATE_ITEM = registerBlockItem("cucumber_crate", new TexturedPolyBlockItem(CUCUMBER_CRATE, new Item.Settings(), "block/cucumber_crate"));
    public static final BlockItem LETTUCE_CRATE_ITEM = registerBlockItem("lettuce_crate", new TexturedPolyBlockItem(LETTUCE_CRATE, new Item.Settings(), "block/lettuce_crate"));
    public static final BlockItem POTATO_CRATE_ITEM = registerBlockItem("potato_crate", new TexturedPolyBlockItem(POTATO_CRATE, new Item.Settings(), "block/potato_crate"));
    public static final BlockItem TOMATO_CRATE_ITEM = registerBlockItem("tomato_crate", new TexturedPolyBlockItem(TOMATO_CRATE, new Item.Settings(), "block/tomato_crate"));


    public static void registerBlocks() {
        ItemGroup.Builder builder = PolymerItemGroupUtils.builder();
        builder.icon(() -> new ItemStack(ModBlocks.TOMATO_CRATE_ITEM, 1));
        builder.displayName(Text.translatable("item-group.borukva-food.blocks_and_tools"));

        builder.entries((displayContext, entries) -> {
            entries.add(BEETROOT_CRATE_ITEM);
            entries.add(CABBAGE_CRATE_ITEM);
            entries.add(CARROT_CRATE_ITEM);
            entries.add(CHILLI_CRATE_ITEM);
            entries.add(CORN_CRATE_ITEM);
            entries.add(CUCUMBER_CRATE_ITEM);
            entries.add(LETTUCE_CRATE_ITEM);
            entries.add(POTATO_CRATE_ITEM);
            entries.add(TOMATO_CRATE_ITEM);
            entries.add(STOVE_ITEM);
            entries.add(PAN_ITEM);
            entries.add(CUTTING_BOARD_ITEM);
            entries.add(ModItems.KNIFE);
            entries.add(ModItems.SOIL_ANALIZATOR);
            entries.add(ModItems.COMPOST);
            entries.add(ModItems.FERTILIZER);
        });
        ItemGroup polymerGroup = builder.build();
        PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of(BorukvaFood.MOD_ID, "blocks"), polymerGroup);

        BorukvaFood.LOGGER.info("Blocks register");
    }
    public static Block registerBlock(String name, Block block){
        return Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, name), block);
    }
    public static BlockItem registerBlockItem(String name, BlockItem item){
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }
}
