package com.opryshok.block;

import com.opryshok.BorukvaFood;
import com.opryshok.block.bushes.BlackcurrantsBush;
import com.opryshok.block.bushes.GooseberryBush;
import com.opryshok.block.cooking.CuttingBoard;
import com.opryshok.block.cooking.Pan;
import com.opryshok.block.cooking.Stove;
import com.opryshok.block.crops.CabbageCrop;
import com.opryshok.block.crops.ChilliPepperCrop;
import com.opryshok.block.crops.CornCrop;
import com.opryshok.block.crops.TomatoCrop;
import com.opryshok.block.food.MeatPizza;
import com.opryshok.block.food.VeganPizza;
import com.opryshok.item.ModItems;
import eu.pb4.polymer.core.api.item.PolymerBlockItem;
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
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

    // Block Items:
    public static final BlockItem BETTER_FARMLAND_ITEM = registerBlockItem("better_farmland", new PolymerBlockItem(BETTER_FARMLAND, new Item.Settings(), Items.FARMLAND));
    public static final BlockItem MEAT_PIZZA_ITEM = registerBlockItem("meat_pizza", new TexturedPolyBlockItem(MEAT_PIZZA, new Item.Settings(), "item/meat_pizza"));
    public static final BlockItem VEGAN_PIZZA_ITEM = registerBlockItem("vegan_pizza", new TexturedPolyBlockItem(VEGAN_PIZZA, new Item.Settings(), "item/vegan_pizza"));
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
        builder.displayName(Text.of("Блоки та інструменти"));

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
            entries.add(ModItems.COMPOST);
            entries.add(ModItems.FERTILIZER);
            entries.add(ModItems.KNIFE);
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
