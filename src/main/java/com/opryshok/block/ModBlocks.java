package com.opryshok.block;

import com.opryshok.BorukvaFood;
import com.opryshok.block.bushes.BlackcurrantsBush;
import com.opryshok.block.bushes.GooseberryBush;
import com.opryshok.block.cooking.CuttingBoard;
import com.opryshok.block.cooking.Pan;
import com.opryshok.block.cooking.Pot;
import com.opryshok.block.cooking.Stove;
import com.opryshok.block.crops.*;
import com.opryshok.block.food.*;
import com.opryshok.block.leaves.AvocadoFruitLeaves;
import com.opryshok.block.leaves.LemonFruitLeaves;
import com.opryshok.item.ModItems;
import com.opryshok.world.tree.ModSaplingGenerator;
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

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
    public static final Block RICE = registerBlock("rice_crop", new RiceCrop(Block.Settings.copy(Blocks.WHEAT)));
    public static final Block NETHER_WHEAT = registerBlock("nether_wheat_crop", new NetherWheatCrop(Block.Settings.copy(Blocks.WHEAT)));

    public static final Block NETHER_HAY = registerBlock("nether_hay", new PolyLogBlock(Block.Settings.copy(Blocks.HAY_BLOCK)){
        @Override
        public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {return Blocks.HAY_BLOCK.getDefaultState();}
        @Override
        public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {entity.handleFallDamage(fallDistance, 0.2F, world.getDamageSources().fall());}
    });
    public static final Block FERTILIZER_SPRAYER = registerBlock("fertilizer_sprayer", new FertilizerSprayerBlock(Block.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block BETTER_FARMLAND = registerBlock("better_farmland", new BetterFarmlandBlock(Block.Settings.copy(Blocks.FARMLAND)));
    public static final Block MEAT_PIZZA = registerBlock("meat_pizza", new MeatPizza(Block.Settings.copy(Blocks.CAKE)));
    public static final Block VEGAN_PIZZA = registerBlock("vegan_pizza", new VeganPizza(Block.Settings.copy(Blocks.CAKE)));
    public static final Block FUNGUS_PIZZA = registerBlock("fungus_pizza", new FungusPizza(Block.Settings.copy(Blocks.CAKE)));
    public static final Block STOVE = registerBlock("stove", new Stove(Block.Settings.copy(Blocks.MUD_BRICKS)));
    public static final Block PAN = registerBlock("pan", new Pan(Block.Settings.copy(Blocks.IRON_TRAPDOOR)));
    public static final Block POT = registerBlock("pot", new Pot(Block.Settings.copy(Blocks.IRON_TRAPDOOR)));
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
    public static final Block ONION_CRATE = registerBlock("onion_crate", new SimplePolyBlock(Block.Settings.copy(Blocks.COMPOSTER), "onion_crate"));
    public static final Block RICE_CRATE = registerBlock("rice_crate", new SimplePolyBlock(Block.Settings.copy(Blocks.COMPOSTER), "rice_crate"));
    public static final Block BLACKCURRANTS_BUSH = registerBlock("blackcurrants_bush", new BlackcurrantsBush(Block.Settings.copy(Blocks.SWEET_BERRY_BUSH)));
    public static final Block GOOSEBERRY_BUSH = registerBlock("gooseberry_bush", new GooseberryBush(Block.Settings.copy(Blocks.SWEET_BERRY_BUSH)));
    public static final Block SALT = registerBlock("salt_block", new SimplePolyBlock(Block.Settings.copy(Blocks.STONE), "salt_block"){
        @Override
        public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
            return Blocks.STONE.getDefaultState();
        }
    });
    public static final Block LEMON_LOG = registerBlock("lemon_log", new PolyLogBlock(Block.Settings.copy(Blocks.OAK_LOG)));
    public static final Block LEMON_WOOD = registerBlock("lemon_wood", new PolyLogBlock(Block.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_LEMON_LOG = registerBlock("stripped_lemon_log", new PolyLogBlock(Block.Settings.copy(Blocks.OAK_LOG)));
    public static final Block STRIPPED_LEMON_WOOD = registerBlock("stripped_lemon_wood", new PolyLogBlock(Block.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block LEMON_LEAVES = registerBlock("lemon_leaves", new PolyLeavesBlock(Block.Settings.copy(Blocks.OAK_LEAVES), "lemon_leaves"));
    public static final Block LEMON_PLANKS = registerBlock("lemon_planks", new SimplePolyBlock(Block.Settings.copy(Blocks.OAK_PLANKS), "lemon_planks"));
    public static final Block LEMON_SLAB = registerBlock("lemon_slab", new PolySlabBlock(Block.Settings.copy(Blocks.OAK_SLAB), "lemon_slab", LEMON_PLANKS.getDefaultState()));
    public static final Block LEMON_TRAPDOOR = registerBlock("lemon_trapdoor", new PolyTrapdoorBlock(Block.Settings.copy(Blocks.OAK_TRAPDOOR), "lemon_trapdoor"));
    public static final Block LEMON_SAPLING = registerBlock("lemon_sapling", new PolySaplingBlock(ModSaplingGenerator.LEMON, Block.Settings.copy(Blocks.OAK_SAPLING), "lemon_sapling"));
    public static final Block LEMON_DOOR = registerBlock("lemon_door", new PolyDoorBlock(Block.Settings.copy(Blocks.OAK_DOOR), "lemon_door"));
    public static final Block AVOCADO_LOG = registerBlock("avocado_log", new PolyLogBlock(Block.Settings.copy(Blocks.OAK_LOG)));
    public static final Block AVOCADO_WOOD = registerBlock("avocado_wood", new PolyLogBlock(Block.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_AVOCADO_LOG = registerBlock("stripped_avocado_log", new PolyLogBlock(Block.Settings.copy(Blocks.OAK_LOG)));
    public static final Block STRIPPED_AVOCADO_WOOD = registerBlock("stripped_avocado_wood", new PolyLogBlock(Block.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block AVOCADO_LEAVES = registerBlock("avocado_leaves", new PolyLeavesBlock(Block.Settings.copy(Blocks.OAK_LEAVES), "avocado_leaves"));
    public static final Block AVOCADO_PLANKS = registerBlock("avocado_planks", new SimplePolyBlock(Block.Settings.copy(Blocks.OAK_PLANKS), "avocado_planks"));
    public static final Block AVOCADO_TRAPDOOR = registerBlock("avocado_trapdoor", new PolyTrapdoorBlock(Block.Settings.copy(Blocks.OAK_TRAPDOOR), "avocado_trapdoor"));
    public static final Block AVOCADO_DOOR = registerBlock("avocado_door", new PolyDoorBlock(Block.Settings.copy(Blocks.OAK_DOOR), "avocado_door"));
    public static final Block AVOCADO_SLAB = registerBlock("avocado_slab", new PolySlabBlock(Block.Settings.copy(Blocks.OAK_SLAB), "avocado_slab", AVOCADO_PLANKS.getDefaultState()));
    public static final Block AVOCADO_SAPLING = registerBlock("avocado_sapling", new PolySaplingBlock(ModSaplingGenerator.AVOCADO, Block.Settings.copy(Blocks.OAK_SAPLING), "avocado_sapling"));
    public static final Block CHOCOLATE_CAKE = registerBlock("chocolate_cake", new ChocolateCake(Block.Settings.copy(Blocks.CAKE)));
    public static final Block HONEY_CAKE = registerBlock("honey_cake", new HoneyCake(Block.Settings.copy(Blocks.CAKE)));
    public static final Block LEMON_FRUIT_LEAVES = registerBlock("lemon_fruit_leaves", new LemonFruitLeaves(Block.Settings.copy(Blocks.OAK_LEAVES)));
    public static final Block AVOCADO_FRUIT_LEAVES = registerBlock("avocado_fruit_leaves", new AvocadoFruitLeaves(Block.Settings.copy(Blocks.OAK_LEAVES)));
    // Block Items:
    public static final BlockItem NETHER_HAY_ITEM = registerBlockItem("nether_hay", new TexturedPolyBlockItem(NETHER_HAY, new Item.Settings(), "block/nether_hay"));
    public static final BlockItem AVOCADO_FRUIT_LEAVES_ITEM = registerBlockItem("avocado_fruit_leaves", new TexturedPolyBlockItem(AVOCADO_FRUIT_LEAVES, new Item.Settings(), "block/avocado_fruit_leaves_has_fruit"));
    public static final BlockItem LEMON_FRUIT_LEAVES_ITEM =registerBlockItem("lemon_fruit_leaves", new TexturedPolyBlockItem(LEMON_FRUIT_LEAVES, new Item.Settings(), "block/lemon_fruit_leaves_has_fruit"));
    public static final BlockItem HONEY_CAKE_ITEM = registerBlockItem("honey_cake", new TexturedPolyBlockItem(HONEY_CAKE, new Item.Settings(), "item/honey_cake"));
    public static final BlockItem CHOCOLATE_CAKE_ITEM = registerBlockItem("chocolate_cake", new TexturedPolyBlockItem(CHOCOLATE_CAKE, new Item.Settings(), "item/chocolate_cake"));
    public static final BlockItem LEMON_LOG_ITEM = registerBlockItem("lemon_log", new TexturedPolyBlockItem(LEMON_LOG, new Item.Settings(), "block/lemon_log"));
    public static final BlockItem LEMON_WOOD_ITEM = registerBlockItem("lemon_wood", new TexturedPolyBlockItem(LEMON_WOOD, new Item.Settings(), "block/lemon_wood"));
    public static final BlockItem STRIPPED_LEMON_LOG_ITEM = registerBlockItem("stripped_lemon_log", new TexturedPolyBlockItem(STRIPPED_LEMON_LOG, new Item.Settings(), "block/stripped_lemon_log"));
    public static final BlockItem STRIPPED_LEMON_WOOD_ITEM = registerBlockItem("stripped_lemon_wood", new TexturedPolyBlockItem(STRIPPED_LEMON_WOOD, new Item.Settings(), "block/stripped_lemon_wood"));
    public static final BlockItem LEMON_LEAVES_ITEM = registerBlockItem("lemon_leaves", new TexturedPolyBlockItem(LEMON_LEAVES, new Item.Settings(), "block/lemon_leaves"));
    public static final BlockItem LEMON_PLANKS_ITEM = registerBlockItem("lemon_planks", new TexturedPolyBlockItem(LEMON_PLANKS, new Item.Settings(), "block/lemon_planks"));
    public static final BlockItem LEMON_SLAB_ITEM = registerBlockItem("lemon_slab", new TexturedPolyBlockItem(LEMON_SLAB, new Item.Settings(), "block/lemon_slab"));
    public static final BlockItem LEMON_TRAPDOOR_ITEM = registerBlockItem("lemon_trapdoor", new TexturedPolyBlockItem(LEMON_TRAPDOOR, new Item.Settings(), "item/lemon_trapdoor"));
    public static final BlockItem LEMON_DOOR_ITEM = registerBlockItem("lemon_door", new TexturedPolyBlockItem(LEMON_DOOR, new Item.Settings(), "item/lemon_door"));
    public static final BlockItem LEMON_SAPLING_ITEM = registerBlockItem("lemon_sapling", new TexturedPolyBlockItem(LEMON_SAPLING, new Item.Settings(), "item/lemon_sapling"));
    public static final BlockItem AVOCADO_LOG_ITEM = registerBlockItem("avocado_log", new TexturedPolyBlockItem(AVOCADO_LOG, new Item.Settings(), "block/avocado_log"));
    public static final BlockItem AVOCADO_WOOD_ITEM = registerBlockItem("avocado_wood", new TexturedPolyBlockItem(AVOCADO_WOOD, new Item.Settings(), "block/avocado_wood"));
    public static final BlockItem STRIPPED_AVOCADO_LOG_ITEM = registerBlockItem("stripped_avocado_log", new TexturedPolyBlockItem(STRIPPED_AVOCADO_LOG, new Item.Settings(), "block/stripped_avocado_log"));
    public static final BlockItem STRIPPED_AVOCADO_WOOD_ITEM = registerBlockItem("stripped_avocado_wood", new TexturedPolyBlockItem(STRIPPED_AVOCADO_WOOD, new Item.Settings(), "block/stripped_avocado_wood"));
    public static final BlockItem AVOCADO_LEAVES_ITEM = registerBlockItem("avocado_leaves", new TexturedPolyBlockItem(AVOCADO_LEAVES, new Item.Settings(), "block/avocado_leaves"));
    public static final BlockItem AVOCADO_PLANKS_ITEM = registerBlockItem("avocado_planks", new TexturedPolyBlockItem(AVOCADO_PLANKS, new Item.Settings(), "block/avocado_planks"));
    public static final BlockItem AVOCADO_SLAB_ITEM = registerBlockItem("avocado_slab", new TexturedPolyBlockItem(AVOCADO_SLAB, new Item.Settings(), "block/avocado_slab"));
    public static final BlockItem AVOCADO_TRAPDOOR_ITEM = registerBlockItem("avocado_trapdoor", new TexturedPolyBlockItem(AVOCADO_TRAPDOOR, new Item.Settings(), "item/avocado_trapdoor"));
    public static final BlockItem AVOCADO_DOOR_ITEM = registerBlockItem("avocado_door", new TexturedPolyBlockItem(AVOCADO_DOOR, new Item.Settings(), "item/avocado_door"));
    public static final BlockItem AVOCADO_SAPLING_ITEM = registerBlockItem("avocado_sapling", new TexturedPolyBlockItem(AVOCADO_SAPLING, new Item.Settings(), "item/avocado_sapling"));
    public static final BlockItem FERTILIZER_SPRAYER_ITEM = registerBlockItem("fertilizer_sprayer", new TexturedPolyBlockItem(FERTILIZER_SPRAYER, new Item.Settings(), "block/fertilizer_sprayer_off"));
    public static final BlockItem SALT_BLOCK_ITEM = registerBlockItem("salt_block", new TexturedPolyBlockItem(SALT, new Item.Settings(), "block/salt_block"));
    public static final BlockItem MEAT_PIZZA_ITEM = registerBlockItem("meat_pizza", new TexturedPolyBlockItem(MEAT_PIZZA, new Item.Settings().maxCount(1), "item/meat_pizza"));
    public static final BlockItem VEGAN_PIZZA_ITEM = registerBlockItem("vegan_pizza", new TexturedPolyBlockItem(VEGAN_PIZZA, new Item.Settings().maxCount(1), "item/vegan_pizza"));
    public static final BlockItem FUNGUS_PIZZA_ITEM = registerBlockItem("fungus_pizza", new TexturedPolyBlockItem(FUNGUS_PIZZA, new Item.Settings().maxCount(1), "item/fungus_pizza"));
    public static final BlockItem STOVE_ITEM = registerBlockItem("stove", new TexturedPolyBlockItem(STOVE, new Item.Settings(), "block/stove"));
    public static final BlockItem PAN_ITEM = registerBlockItem("pan", new TexturedPolyBlockItem(PAN, new Item.Settings(), "block/pan"));
    public static final BlockItem POT_ITEM = registerBlockItem("pot", new TexturedPolyBlockItem(POT, new Item.Settings(), "item/pot"));
    public static final BlockItem CUTTING_BOARD_ITEM = registerBlockItem("cutting_board", new TexturedPolyBlockItem(CUTTING_BOARD, new Item.Settings(), "item/cutting_board"){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            super.appendTooltip(stack, context, tooltip, type);
            tooltip.add(Text.translatable("tooltip.borukva-food.cutting_board_line1").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("tooltip.borukva-food.cutting_board_line2").formatted(Formatting.GRAY));
        }
    });
    public static final BlockItem BEETROOT_CRATE_ITEM = registerBlockItem("beetroot_crate", new TexturedPolyBlockItem(BEETROOT_CRATE, new Item.Settings(), "block/beetroot_crate"));
    public static final BlockItem CABBAGE_CRATE_ITEM = registerBlockItem("cabbage_crate", new TexturedPolyBlockItem(CABBAGE_CRATE, new Item.Settings(), "block/cabbage_crate"));
    public static final BlockItem CARROT_CRATE_ITEM = registerBlockItem("carrot_crate", new TexturedPolyBlockItem(CARROT_CRATE, new Item.Settings(), "block/carrot_crate"));
    public static final BlockItem CHILLI_CRATE_ITEM = registerBlockItem("chilli_pepper_crate", new TexturedPolyBlockItem(CHILLI_PEPPER_CRATE, new Item.Settings(), "block/chilli_pepper_crate"));
    public static final BlockItem CORN_CRATE_ITEM = registerBlockItem("corn_crate", new TexturedPolyBlockItem(CORN_CRATE, new Item.Settings(), "block/corn_crate"));
    public static final BlockItem CUCUMBER_CRATE_ITEM = registerBlockItem("cucumber_crate", new TexturedPolyBlockItem(CUCUMBER_CRATE, new Item.Settings(), "block/cucumber_crate"));
    public static final BlockItem LETTUCE_CRATE_ITEM = registerBlockItem("lettuce_crate", new TexturedPolyBlockItem(LETTUCE_CRATE, new Item.Settings(), "block/lettuce_crate"));
    public static final BlockItem POTATO_CRATE_ITEM = registerBlockItem("potato_crate", new TexturedPolyBlockItem(POTATO_CRATE, new Item.Settings(), "block/potato_crate"));
    public static final BlockItem TOMATO_CRATE_ITEM = registerBlockItem("tomato_crate", new TexturedPolyBlockItem(TOMATO_CRATE, new Item.Settings(), "block/tomato_crate"));
    public static final BlockItem ONION_CRATE_ITEM = registerBlockItem("onion_crate", new TexturedPolyBlockItem(ONION_CRATE, new Item.Settings(), "block/onion_crate"));
    public static final BlockItem RICE_CRATE_ITEM = registerBlockItem("rice_crate", new TexturedPolyBlockItem(RICE_CRATE, new Item.Settings(), "block/rice_crate"));
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
            entries.add(ONION_CRATE_ITEM);
            entries.add(RICE_CRATE_ITEM);
            entries.add(NETHER_HAY);
            entries.add(STOVE_ITEM);
            entries.add(PAN_ITEM);
            entries.add(POT_ITEM);
            entries.add(CUTTING_BOARD_ITEM);
            entries.add(ModItems.KNIFE);
            entries.add(ModItems.HARVEST_SICKLE);
            entries.add(ModItems.SOIL_ANALIZATOR);
            entries.add(ModItems.COMPOST);
            entries.add(ModItems.FERTILIZER);
            entries.add(FERTILIZER_SPRAYER_ITEM);
            entries.add(SALT_BLOCK_ITEM);
            entries.add(LEMON_SAPLING_ITEM);
            entries.add(LEMON_LEAVES_ITEM);
            entries.add(LEMON_FRUIT_LEAVES_ITEM);
            entries.add(LEMON_LOG_ITEM);
            entries.add(LEMON_WOOD_ITEM);
            entries.add(STRIPPED_LEMON_LOG_ITEM);
            entries.add(STRIPPED_LEMON_WOOD_ITEM);
            entries.add(LEMON_PLANKS_ITEM);
            entries.add(LEMON_SLAB_ITEM);
            entries.add(LEMON_TRAPDOOR_ITEM);
            entries.add(LEMON_DOOR_ITEM);
            entries.add(AVOCADO_SAPLING_ITEM);
            entries.add(AVOCADO_LEAVES_ITEM);
            entries.add(AVOCADO_FRUIT_LEAVES_ITEM);
            entries.add(AVOCADO_LOG_ITEM);
            entries.add(AVOCADO_WOOD_ITEM);
            entries.add(STRIPPED_AVOCADO_LOG_ITEM);
            entries.add(STRIPPED_AVOCADO_WOOD_ITEM);
            entries.add(AVOCADO_PLANKS_ITEM);
            entries.add(AVOCADO_SLAB_ITEM);
            entries.add(AVOCADO_TRAPDOOR_ITEM);
            entries.add(AVOCADO_DOOR_ITEM);
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
