package com.opryshok.compat.tags;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class FarmersDelightTags {
    private static final String FarmersDelightModId = "farmersdelight";

    // -- Blocks --

    // Blocks that are efficiently mined with a Knife.
    public static final TagKey<Block> MINEABLE_WITH_KNIFE = modBlockTag("mineable/knife");

    // Blocks commonly present in biome surfaces. Populated by "minecraft:dirt" and "minecraft:sand" by default.
    public static final TagKey<Block> TERRAIN = modBlockTag("terrain");

    // Blocks made mostly of straw.
    public static final TagKey<Block> STRAW_BLOCKS = modBlockTag("straw_blocks");

    // Blocks that represent the wild form of a farmable crop.
    public static final TagKey<Block> WILD_CROPS = modBlockTag("wild_crops");

    // Blocks that represent a rope, for gameplay purposes.
    public static final TagKey<Block> ROPES = modBlockTag("ropes");

    // Blocks that can heat up cooking workstations.
    public static final TagKey<Block> HEAT_SOURCES = modBlockTag("heat_sources");

    // Blocks that can transfer heat to cooking workstations, if directly above a heat source.
    public static final TagKey<Block> HEAT_CONDUCTORS = modBlockTag("heat_conductors");

    // Blocks to which a Cooking Pot/Skillet will render a tray over. Included in HEAT_SOURCES.
    public static final TagKey<Block> TRAY_HEAT_SOURCES = modBlockTag("tray_heat_sources");

    // Blocks that accelerate decomposition of Organic Compost if placed adjacent to it.
    public static final TagKey<Block> COMPOST_ACTIVATORS = modBlockTag("compost_activators");

    // Blocks in which Mushroom Colonies can keep growing on, if it's dark enough. These blocks cannot form new colonies.
    public static final TagKey<Block> MUSHROOM_COLONY_GROWABLE_ON = modBlockTag("mushroom_colony_growable_on");

    // Blocks that should not have their growth boosted by Rich Soil, if planted on it.
    public static final TagKey<Block> UNAFFECTED_BY_RICH_SOIL = modBlockTag("unaffected_by_rich_soil");

    // Candle cakes that should drop the vanilla cake slice when sliced by a knife.
    public static final TagKey<Block> DROPS_CAKE_SLICE = modBlockTag("drops_cake_slice");

    // Blocks which cause Campfires to emit signal smoke when placed underneath them.
    public static final TagKey<Block> CAMPFIRE_SIGNAL_SMOKE = modBlockTag("campfire_signal_smoke");

    // -- Items --

    // Items which are compatible with the Backstabbing enchantment. Populated by #tools/knives.
    public static final TagKey<Item> KNIFE_ENCHANTABLE = modItemTag("enchantable/knife");

    // Items that represent a feast: a larger, placeable meal which can serve many portions.
    public static final TagKey<Item> FEASTS = modItemTag("feasts");

    // Items that represent a meal: prepared food contained in a bowl or plate.
    public static final TagKey<Item> MEALS = modItemTag("meals");

    // Items that represent a drink: a bottled consumable that isn't a potion.
    public static final TagKey<Item> DRINKS = modItemTag("drinks");

    // Items that represent the wild form of a farmable crop.
    public static final TagKey<Item> WILD_CROPS_ITEM = modItemTag("wild_crops");

    // Items (ideally tools) that can obtain straw when harvesting grassy plants. Populated by all knives by default.
    public static final TagKey<Item> STRAW_HARVESTERS = modItemTag("straw_harvesters");

    // Foods and items that serve as filling for Cabbage Rolls
    public static final TagKey<Item> CABBAGE_ROLL_INGREDIENTS = modItemTag("cabbage_roll_ingredients");

    // Items commonly held in the off-hand. Cutting Boards won't let them be placed from the off-hand, for convenience.
    public static final TagKey<Item> OFFHAND_EQUIPMENT = modItemTag("offhand_equipment");

    // Knife items for game logic.
    public static final TagKey<Item> KNIVES = modItemTag("tools/knives");

    // Canvas Signs items for crafting.
    public static final TagKey<Item> CANVAS_SIGNS = modItemTag("canvas_signs");

    // Canvas Signs items for crafting.
    public static final TagKey<Item> HANGING_CANVAS_SIGNS = modItemTag("hanging_canvas_signs");

    // Wooden Cabinet items for crafting.
    public static final TagKey<Item> WOODEN_CABINETS = modItemTag("cabinets/wooden");

    // All Cabinet items for crafting.
    public static final TagKey<Item> CABINETS = modItemTag("cabinets");

    // Items commonly used to contain products. Used by the Cooking Pot for sneak-clicking actions.
    public static final TagKey<Item> SERVING_CONTAINERS = modItemTag("serving_containers");

    // Items which render in 2D, laying down flat, when placed on the Cutting Board.
    public static final TagKey<Item> FLAT_ON_CUTTING_BOARD = modItemTag("flat_on_cutting_board");

    public static final TagKey<Block> SURVIVES_RICH_SOIL = modBlockTag("survives/rich_soil");
    public static final TagKey<Block> DOES_NOT_SURVIVE_RICH_SOIL = modBlockTag("does_not_survive/rich_soil");

    public static final TagKey<Block> SURVIVES_RICH_SOIL_FARMLAND = modBlockTag("survives/rich_soil_farmland");
    public static final TagKey<Block> DOES_NOT_SURVIVE_RICH_SOIL_FARMLAND = modBlockTag("does_not_survive/rich_soil_farmland");

    // Latest Minecraft Version Tags
    public static final TagKey<Item> FLINT_TOOL_MATERIALS = modItemTag("flint_tool_materials");

    private static TagKey<Item> modItemTag(String path) {
        return TagKey.of(Registries.ITEM.getKey(), Identifier.of(FarmersDelightModId, path));
    }

    private static TagKey<Block> modBlockTag(String path) {
        return TagKey.of(Registries.BLOCK.getKey(), Identifier.of(FarmersDelightModId, path));
    }
}
