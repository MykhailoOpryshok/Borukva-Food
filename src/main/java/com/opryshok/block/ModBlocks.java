package com.opryshok.block;

import com.opryshok.BorukvaFood;
import com.opryshok.block.bushes.BlackcurrantsBush;
import com.opryshok.block.bushes.GooseberryBush;
import com.opryshok.block.bushes.GrapeCrop;
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
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.Entity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.nucleoid.packettweaker.PacketContext;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ModBlocks {
    // Blocks:
    public static final Block TOMATO = registerBlock("tomato_crop", TomatoCrop::new, Block.Settings.copy(Blocks.WHEAT));
    public static final Block CABBAGE = registerBlock("cabbage_crop", CabbageCrop::new, Block.Settings.copy(Blocks.WHEAT));
    public static final Block CORN = registerBlock("corn_crop", CornCrop::new, Block.Settings.copy(Blocks.WHEAT));
    public static final Block CHILLI_PEPPER = registerBlock("chilli_pepper_crop", ChilliPepperCrop::new, Block.Settings.copy(Blocks.WHEAT));
    public static final Block LETTUCE = registerBlock("lettuce_crop", LettuceCrop::new, Block.Settings.copy(Blocks.WHEAT));
    public static final Block CUCUMBER = registerBlock("cucumber_crop", CucumberCrop::new, Block.Settings.copy(Blocks.WHEAT));
    public static final Block ONION = registerBlock("onion_crop", OnionCrop::new, Block.Settings.copy(Blocks.WHEAT));
    public static final Block RICE = registerBlock("rice_crop", RiceCrop::new, Block.Settings.copy(Blocks.WHEAT));
    public static final Block NETHER_WHEAT = registerBlock("nether_wheat_crop", NetherWheatCrop::new, Block.Settings.copy(Blocks.WHEAT));
    public static final Block ENDER_INFECTED_ONION = registerBlock("ender_infected_onion", EnderInfectedOnionCrop::new, Block.Settings.copy(Blocks.WHEAT));
    public static final Block NETHER_HAY = registerBlock("nether_hay", settings -> new PolyLogBlock(settings){
        @Override
        public BlockState getPolymerBreakEventBlockState(BlockState state, PacketContext context) {return Blocks.HAY_BLOCK.getDefaultState();}
        @Override
        public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, double fallDistance) {entity.handleFallDamage(fallDistance, 0.2F, world.getDamageSources().fall());}
    }, Block.Settings.copy(Blocks.HAY_BLOCK));
    public static final Block WORMWOOD_GRASS = registerBlock("wormwood_grass", WormwoodGrass::new, Block.Settings.copy(Blocks.GRASS_BLOCK));
    public static final Item WORMWOOD = registerBlockItem("wormwood", settings -> new TexturedPolyBlockItem(WORMWOOD_GRASS, settings){
        protected boolean canPlace(ItemPlacementContext context, BlockState state) {
            BlockPos posBelow = context.getBlockPos().down();
            BlockState stateBelow = context.getWorld().getBlockState(posBelow);
            return stateBelow.isIn(BlockTags.DIRT) && super.canPlace(context, state);
        }
    }, new Item.Settings());
    public static final Block FERTILIZER_SPRAYER = registerBlock("fertilizer_sprayer", FertilizerSprayerBlock::new, Block.Settings.copy(Blocks.IRON_BLOCK));
    public static final Block BETTER_FARMLAND = registerBlock("better_farmland", BetterFarmlandBlock::new, Block.Settings.copy(Blocks.FARMLAND));
    public static final Block MEAT_PIZZA = registerBlock("meat_pizza", MeatPizza::new, Block.Settings.copy(Blocks.CAKE));
    public static final Block VEGAN_PIZZA = registerBlock("vegan_pizza", VeganPizza::new, Block.Settings.copy(Blocks.CAKE));
    public static final Block FUNGUS_PIZZA = registerBlock("fungus_pizza", FungusPizza::new, Block.Settings.copy(Blocks.CAKE));
    public static final Block STOVE = registerBlock("stove", Stove::new, Block.Settings.copy(Blocks.MUD_BRICKS));
    public static final Block PAN = registerBlock("pan", Pan::new, Block.Settings.copy(Blocks.OAK_PRESSURE_PLATE));
    public static final Block POT = registerBlock("pot", Pot::new, Block.Settings.copy(Blocks.OAK_PRESSURE_PLATE));
    public static final Block CUTTING_BOARD = registerBlock("cutting_board", CuttingBoard::new, Block.Settings.copy(Blocks.OAK_PRESSURE_PLATE));
    public static final Block BEETROOT_CRATE = registerBlock("beetroot_crate", settings -> new SimplePolyBlock(settings, "beetroot_crate"), Block.Settings.copy(Blocks.COMPOSTER));
    public static final Block CABBAGE_CRATE = registerBlock("cabbage_crate", settings -> new SimplePolyBlock(settings, "cabbage_crate"), Block.Settings.copy(Blocks.COMPOSTER));
    public static final Block CARROT_CRATE = registerBlock("carrot_crate", settings -> new SimplePolyBlock(settings, "carrot_crate"), Block.Settings.copy(Blocks.COMPOSTER));
    public static final Block CHILLI_PEPPER_CRATE = registerBlock("chilli_pepper_crate", settings -> new SimplePolyBlock(settings, "chilli_pepper_crate"), Block.Settings.copy(Blocks.COMPOSTER));
    public static final Block CORN_CRATE = registerBlock("corn_crate", settings -> new SimplePolyBlock(settings, "corn_crate"), Block.Settings.copy(Blocks.COMPOSTER));
    public static final Block CUCUMBER_CRATE = registerBlock("cucumber_crate", settings -> new SimplePolyBlock(settings, "cucumber_crate"), Block.Settings.copy(Blocks.COMPOSTER));
    public static final Block LETTUCE_CRATE = registerBlock("lettuce_crate", settings -> new SimplePolyBlock(settings, "lettuce_crate"), Block.Settings.copy(Blocks.COMPOSTER));
    public static final Block POTATO_CRATE = registerBlock("potato_crate", settings -> new SimplePolyBlock(settings, "potato_crate"), Block.Settings.copy(Blocks.COMPOSTER));
    public static final Block TOMATO_CRATE = registerBlock("tomato_crate", settings -> new SimplePolyBlock(settings, "tomato_crate"), Block.Settings.copy(Blocks.COMPOSTER));
    public static final Block ONION_CRATE = registerBlock("onion_crate", settings -> new SimplePolyBlock(settings, "onion_crate"), Block.Settings.copy(Blocks.COMPOSTER));
    public static final Block RICE_CRATE = registerBlock("rice_crate", settings -> new SimplePolyBlock(settings, "rice_crate"), Block.Settings.copy(Blocks.COMPOSTER));
    public static final Block BLACKCURRANTS_BUSH = registerBlock("blackcurrants_bush", BlackcurrantsBush::new, Block.Settings.copy(Blocks.SWEET_BERRY_BUSH));
    public static final Block GOOSEBERRY_BUSH = registerBlock("gooseberry_bush", GooseberryBush::new, Block.Settings.copy(Blocks.SWEET_BERRY_BUSH));
    public static final Block GRAPE = registerBlock("grape_crop", GrapeCrop::new, Block.Settings.copy(Blocks.SWEET_BERRY_BUSH));
    public static final Block CHORUS_CRATE = registerBlock("chorus_crate", settings -> new SimplePolyBlock(settings, "chorus_crate"), Block.Settings.copy(Blocks.COMPOSTER));
    public static final Block SALT = registerBlock("salt_block", settings -> new SimplePolyBlock(settings, "salt_block"){
        @Override
        public BlockState getPolymerBreakEventBlockState(BlockState state, PacketContext context) {
            return Blocks.STONE.getDefaultState();
        }
    }, Block.Settings.copy(Blocks.STONE));
    public static final Block LEMON_LOG = registerBlock("lemon_log", PolyLogBlock::new, Block.Settings.copy(Blocks.OAK_LOG));
    public static final Block LEMON_WOOD = registerBlock("lemon_wood", PolyLogBlock::new, Block.Settings.copy(Blocks.OAK_WOOD));
    public static final Block STRIPPED_LEMON_LOG = registerBlock("stripped_lemon_log", PolyLogBlock::new, Block.Settings.copy(Blocks.OAK_LOG));
    public static final Block STRIPPED_LEMON_WOOD = registerBlock("stripped_lemon_wood", PolyLogBlock::new, Block.Settings.copy(Blocks.OAK_WOOD));
    public static final Block LEMON_LEAVES = registerBlock("lemon_leaves", settings -> new PolyLeavesBlock(settings, "lemon_leaves"), Block.Settings.copy(Blocks.OAK_LEAVES));
    public static final Block LEMON_PLANKS = registerBlock("lemon_planks", settings -> new SimplePolyBlock(settings, "lemon_planks"), Block.Settings.copy(Blocks.OAK_PLANKS));
    public static final Block LEMON_SLAB = registerBlock("lemon_slab", settings -> new PolySlabBlock(settings, "lemon_slab", LEMON_PLANKS.getDefaultState()), Block.Settings.copy(Blocks.OAK_SLAB));
    public static final Block LEMON_TRAPDOOR = registerBlock("lemon_trapdoor", settings -> new PolyTrapdoorBlock(settings, "lemon_trapdoor"), Block.Settings.copy(Blocks.OAK_TRAPDOOR));
    public static final Block LEMON_SAPLING = registerBlock("lemon_sapling", settings -> new PolySaplingBlock(ModSaplingGenerator.LEMON, settings, "lemon_sapling"), Block.Settings.copy(Blocks.OAK_SAPLING));
    public static final Block LEMON_DOOR = registerBlock("lemon_door", settings -> new PolyDoorBlock(settings, "lemon_door"), Block.Settings.copy(Blocks.OAK_DOOR));
    public static final Block AVOCADO_LOG = registerBlock("avocado_log", PolyLogBlock::new, Block.Settings.copy(Blocks.OAK_LOG));
    public static final Block AVOCADO_WOOD = registerBlock("avocado_wood", PolyLogBlock::new, Block.Settings.copy(Blocks.OAK_WOOD));
    public static final Block STRIPPED_AVOCADO_LOG = registerBlock("stripped_avocado_log", PolyLogBlock::new, Block.Settings.copy(Blocks.OAK_LOG));
    public static final Block STRIPPED_AVOCADO_WOOD = registerBlock("stripped_avocado_wood", PolyLogBlock::new, Block.Settings.copy(Blocks.OAK_WOOD));
    public static final Block AVOCADO_LEAVES = registerBlock("avocado_leaves", settings -> new PolyLeavesBlock(settings, "avocado_leaves"), Block.Settings.copy(Blocks.OAK_LEAVES));
    public static final Block AVOCADO_PLANKS = registerBlock("avocado_planks", settings -> new SimplePolyBlock(settings, "avocado_planks"), Block.Settings.copy(Blocks.OAK_PLANKS));
    public static final Block AVOCADO_TRAPDOOR = registerBlock("avocado_trapdoor", settings -> new PolyTrapdoorBlock(settings, "avocado_trapdoor"), Block.Settings.copy(Blocks.OAK_TRAPDOOR));
    public static final Block AVOCADO_DOOR = registerBlock("avocado_door", settings -> new PolyDoorBlock(settings, "avocado_door"), Block.Settings.copy(Blocks.OAK_DOOR));
    public static final Block AVOCADO_SLAB = registerBlock("avocado_slab", settings -> new PolySlabBlock(settings, "avocado_slab", AVOCADO_PLANKS.getDefaultState()), Block.Settings.copy(Blocks.OAK_SLAB));
    public static final Block AVOCADO_SAPLING = registerBlock("avocado_sapling", settings -> new PolySaplingBlock(ModSaplingGenerator.AVOCADO, settings, "avocado_sapling"), Block.Settings.copy(Blocks.OAK_SAPLING));
    public static final Block CHOCOLATE_CAKE = registerBlock("chocolate_cake", ChocolateCake::new, Block.Settings.copy(Blocks.CAKE));
    public static final Block HONEY_CAKE = registerBlock("honey_cake", HoneyCake::new, Block.Settings.copy(Blocks.CAKE));
    public static final Block LEMON_FRUIT_LEAVES = registerBlock("lemon_fruit_leaves", LemonFruitLeaves::new, Block.Settings.copy(Blocks.OAK_LEAVES));
    public static final Block AVOCADO_FRUIT_LEAVES = registerBlock("avocado_fruit_leaves", AvocadoFruitLeaves::new, Block.Settings.copy(Blocks.OAK_LEAVES));
    // Block Items:
    public static final BlockItem NETHER_HAY_ITEM = registerBlockItem("nether_hay", settings -> new TexturedPolyBlockItem(NETHER_HAY, settings), new Item.Settings());
    public static final BlockItem AVOCADO_FRUIT_LEAVES_ITEM = registerBlockItem("avocado_fruit_leaves", settings -> new TexturedPolyBlockItem(AVOCADO_FRUIT_LEAVES, settings), new Item.Settings());
    public static final BlockItem LEMON_FRUIT_LEAVES_ITEM =registerBlockItem("lemon_fruit_leaves", settings -> new TexturedPolyBlockItem(LEMON_FRUIT_LEAVES, settings), new Item.Settings());
    public static final BlockItem HONEY_CAKE_ITEM = registerBlockItem("honey_cake", settings -> new TexturedPolyBlockItem(HONEY_CAKE, settings), new Item.Settings());
    public static final BlockItem CHOCOLATE_CAKE_ITEM = registerBlockItem("chocolate_cake", settings -> new TexturedPolyBlockItem(CHOCOLATE_CAKE, settings), new Item.Settings());
    public static final BlockItem LEMON_LOG_ITEM = registerBlockItem("lemon_log", settings -> new TexturedPolyBlockItem(LEMON_LOG, settings), new Item.Settings());
    public static final BlockItem LEMON_WOOD_ITEM = registerBlockItem("lemon_wood", settings -> new TexturedPolyBlockItem(LEMON_WOOD, settings), new Item.Settings());
    public static final BlockItem STRIPPED_LEMON_LOG_ITEM = registerBlockItem("stripped_lemon_log", settings -> new TexturedPolyBlockItem(STRIPPED_LEMON_LOG, settings), new Item.Settings());
    public static final BlockItem STRIPPED_LEMON_WOOD_ITEM = registerBlockItem("stripped_lemon_wood", settings -> new TexturedPolyBlockItem(STRIPPED_LEMON_WOOD, settings), new Item.Settings());
    public static final BlockItem LEMON_LEAVES_ITEM = registerBlockItem("lemon_leaves", settings -> new TexturedPolyBlockItem(LEMON_LEAVES, settings), new Item.Settings());
    public static final BlockItem LEMON_PLANKS_ITEM = registerBlockItem("lemon_planks", settings -> new TexturedPolyBlockItem(LEMON_PLANKS, settings), new Item.Settings());
    public static final BlockItem LEMON_SLAB_ITEM = registerBlockItem("lemon_slab", settings -> new TexturedPolyBlockItem(LEMON_SLAB, settings), new Item.Settings());
    public static final BlockItem LEMON_TRAPDOOR_ITEM = registerBlockItem("lemon_trapdoor", settings -> new TexturedPolyBlockItem(LEMON_TRAPDOOR, settings), new Item.Settings());
    public static final BlockItem LEMON_DOOR_ITEM = registerBlockItem("lemon_door", settings -> new TexturedPolyBlockItem(LEMON_DOOR, settings), new Item.Settings());
    public static final BlockItem LEMON_SAPLING_ITEM = registerBlockItem("lemon_sapling", settings -> new TexturedPolyBlockItem(LEMON_SAPLING, settings), new Item.Settings());
    public static final BlockItem AVOCADO_LOG_ITEM = registerBlockItem("avocado_log", settings -> new TexturedPolyBlockItem(AVOCADO_LOG, settings), new Item.Settings());
    public static final BlockItem AVOCADO_WOOD_ITEM = registerBlockItem("avocado_wood", settings -> new TexturedPolyBlockItem(AVOCADO_WOOD, settings), new Item.Settings());
    public static final BlockItem STRIPPED_AVOCADO_LOG_ITEM = registerBlockItem("stripped_avocado_log", settings -> new TexturedPolyBlockItem(STRIPPED_AVOCADO_LOG, settings), new Item.Settings());
    public static final BlockItem STRIPPED_AVOCADO_WOOD_ITEM = registerBlockItem("stripped_avocado_wood", settings -> new TexturedPolyBlockItem(STRIPPED_AVOCADO_WOOD, settings), new Item.Settings());
    public static final BlockItem AVOCADO_LEAVES_ITEM = registerBlockItem("avocado_leaves", settings -> new TexturedPolyBlockItem(AVOCADO_LEAVES, settings), new Item.Settings());
    public static final BlockItem AVOCADO_PLANKS_ITEM = registerBlockItem("avocado_planks", settings -> new TexturedPolyBlockItem(AVOCADO_PLANKS, settings), new Item.Settings());
    public static final BlockItem AVOCADO_SLAB_ITEM = registerBlockItem("avocado_slab", settings -> new TexturedPolyBlockItem(AVOCADO_SLAB, settings), new Item.Settings());
    public static final BlockItem AVOCADO_TRAPDOOR_ITEM = registerBlockItem("avocado_trapdoor", settings -> new TexturedPolyBlockItem(AVOCADO_TRAPDOOR, settings), new Item.Settings());
    public static final BlockItem AVOCADO_DOOR_ITEM = registerBlockItem("avocado_door", settings -> new TexturedPolyBlockItem(AVOCADO_DOOR, settings), new Item.Settings());
    public static final BlockItem AVOCADO_SAPLING_ITEM = registerBlockItem("avocado_sapling", settings -> new TexturedPolyBlockItem(AVOCADO_SAPLING, settings), new Item.Settings());
    public static final BlockItem FERTILIZER_SPRAYER_ITEM = registerBlockItem("fertilizer_sprayer", settings -> new TexturedPolyBlockItem(FERTILIZER_SPRAYER, settings), new Item.Settings());
    public static final BlockItem SALT_BLOCK_ITEM = registerBlockItem("salt_block", settings -> new TexturedPolyBlockItem(SALT, settings), new Item.Settings());
    public static final BlockItem MEAT_PIZZA_ITEM = registerBlockItem("meat_pizza", settings -> new TexturedPolyBlockItem(MEAT_PIZZA, settings), new Item.Settings().maxCount(1));
    public static final BlockItem VEGAN_PIZZA_ITEM = registerBlockItem("vegan_pizza", settings -> new TexturedPolyBlockItem(VEGAN_PIZZA, settings), new Item.Settings().maxCount(1));
    public static final BlockItem FUNGUS_PIZZA_ITEM = registerBlockItem("fungus_pizza", settings -> new TexturedPolyBlockItem(FUNGUS_PIZZA, settings), new Item.Settings().maxCount(1));
    public static final BlockItem STOVE_ITEM = registerBlockItem("stove", settings -> new TexturedPolyBlockItem(STOVE, settings), new Item.Settings());
    public static final BlockItem PAN_ITEM = registerBlockItem("pan", settings -> new TexturedPolyBlockItem(PAN, settings), new Item.Settings());
    public static final BlockItem POT_ITEM = registerBlockItem("pot", settings -> new TexturedPolyBlockItem(POT, settings), new Item.Settings());
    public static final BlockItem CUTTING_BOARD_ITEM = registerBlockItem("cutting_board", settings -> new TexturedPolyBlockItem(CUTTING_BOARD, settings){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
            super.appendTooltip(stack, context, displayComponent, tooltip, type);
            tooltip.accept(Text.translatable("tooltip.borukva-food.cutting_board_line1").formatted(Formatting.GRAY));
            tooltip.accept(Text.translatable("tooltip.borukva-food.cutting_board_line2").formatted(Formatting.GRAY));
        }
    }, new Item.Settings());
    public static final BlockItem BEETROOT_CRATE_ITEM = registerBlockItem("beetroot_crate", settings -> new TexturedPolyBlockItem(BEETROOT_CRATE, settings), new Item.Settings());
    public static final BlockItem CABBAGE_CRATE_ITEM = registerBlockItem("cabbage_crate", settings -> new TexturedPolyBlockItem(CABBAGE_CRATE, settings), new Item.Settings());
    public static final BlockItem CARROT_CRATE_ITEM = registerBlockItem("carrot_crate", settings -> new TexturedPolyBlockItem(CARROT_CRATE, settings), new Item.Settings());
    public static final BlockItem CHILLI_CRATE_ITEM = registerBlockItem("chilli_pepper_crate", settings -> new TexturedPolyBlockItem(CHILLI_PEPPER_CRATE, settings), new Item.Settings());
    public static final BlockItem CORN_CRATE_ITEM = registerBlockItem("corn_crate", settings -> new TexturedPolyBlockItem(CORN_CRATE, settings), new Item.Settings());
    public static final BlockItem CUCUMBER_CRATE_ITEM = registerBlockItem("cucumber_crate", settings -> new TexturedPolyBlockItem(CUCUMBER_CRATE, settings), new Item.Settings());
    public static final BlockItem LETTUCE_CRATE_ITEM = registerBlockItem("lettuce_crate", settings -> new TexturedPolyBlockItem(LETTUCE_CRATE, settings), new Item.Settings());
    public static final BlockItem POTATO_CRATE_ITEM = registerBlockItem("potato_crate", settings -> new TexturedPolyBlockItem(POTATO_CRATE, settings), new Item.Settings());
    public static final BlockItem TOMATO_CRATE_ITEM = registerBlockItem("tomato_crate", settings -> new TexturedPolyBlockItem(TOMATO_CRATE, settings), new Item.Settings());
    public static final BlockItem ONION_CRATE_ITEM = registerBlockItem("onion_crate", settings -> new TexturedPolyBlockItem(ONION_CRATE, settings), new Item.Settings());
    public static final BlockItem RICE_CRATE_ITEM = registerBlockItem("rice_crate", settings -> new TexturedPolyBlockItem(RICE_CRATE, settings), new Item.Settings());
    public static final BlockItem CHORUS_CRATE_ITEM = registerBlockItem("chorus_crate", settings -> new TexturedPolyBlockItem(CHORUS_CRATE, settings), new Item.Settings());

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
            entries.add(CHORUS_CRATE_ITEM);
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
            entries.add(ModItems.GRAPE_SAPLING);
        });
        ItemGroup polymerGroup = builder.build();
        PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of(BorukvaFood.MOD_ID, "blocks"), polymerGroup);

        BorukvaFood.LOGGER.info("Blocks register");
    }
    public static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings){
        var key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(BorukvaFood.MOD_ID, name));
        Block block = factory.apply(settings.registryKey(key));

        return Registry.register(Registries.BLOCK, key, block);
    }
    public static BlockItem registerBlockItem(String name, Function<Item.Settings, BlockItem> factory, Item.Settings settings){
        var key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BorukvaFood.MOD_ID, name));
        BlockItem item = factory.apply(settings.registryKey(key).useBlockPrefixedTranslationKey());

        return Registry.register(Registries.ITEM, key, item);
    }
}
