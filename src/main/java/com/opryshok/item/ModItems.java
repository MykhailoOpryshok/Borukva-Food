package com.opryshok.item;

import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import com.opryshok.utils.ModFoodComponents;
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item FERTILIZER = registerItem("fertilizer", new FertilizerItem(new Item.Settings(), "fertilizer"));
    public static Item SOIL_ANALIZATOR = registerItem("soil_analizator", new SoilAnalizatorItem(new Item.Settings().maxCount(1), "soil_analizator"));
    public static Item KNIFE = registerItem("knife", new KnifeTool(new Item.Settings()));
    public static Item HARVEST_SICKLE = registerItem("harvest_sickle", new HarvestSickleItem(new Item.Settings()));
    public static Item COMPOST = registerItem("compost", new CompostItem(new Item.Settings(), "compost"));
    public static Item RICE = registerItem("rice", new PolySeedsItem(ModBlocks.RICE, new Item.Settings(), "rice"));
    public static Item RICE_PANICLE = registerItem("rice_panicle", new PolyItem(new Item.Settings(), "rice_panicle"));
    public static Item RICE_BOWL = registerItem("rice_bowl", new PolyItem(new Item.Settings().food(ModFoodComponents.RICE_BOWL), "rice_bowl"));
    public static Item SALMON_FILLET = registerItem("salmon_fillet", new PolyItem(new Item.Settings().food(ModFoodComponents.SALMON_FILLET), "salmon_fillet"));
    public static Item SALMON_MAKI = registerItem("salmon_maki", new PolyItem(new Item.Settings().food(ModFoodComponents.SALMON_MAKI), "salmon_maki"));
    public static Item SALMON_NIGIRI = registerItem("salmon_nigiri", new PolyItem(new Item.Settings().food(ModFoodComponents.SALMON_NIGIRI), "salmon_nigiri"));
    public static Item SALMON_URAMAKI = registerItem("salmon_uramaki", new PolyItem(new Item.Settings().food(ModFoodComponents.SALMON_URAMAKI), "salmon_uramaki"));
    public static Item ONIGIRI = registerItem("onigiri", new PolyItem(new Item.Settings().food(ModFoodComponents.ONIGIRI), "onigiri"));
    public static Item NORI = registerItem("nori", new PolyItem(new Item.Settings().food(ModFoodComponents.NORI), "nori"));
    public static Item SAUERKRAUT = registerItem("sauerkraut", new PolyItem(new Item.Settings().food(ModFoodComponents.SAUERKRAUT), "sauerkraut"));
    public static Item SALO = registerItem("salo", new PolyItem(new Item.Settings().food(ModFoodComponents.SALO), "salo"));
    public static Item SUNFLOWER_SEED = registerItem("sunflower_seed", new PolyItem(new Item.Settings().food(ModFoodComponents.SUNFLOWER_SEED), "sunflower_seed"));
    public static Item ROASTED_SUNFLOWER_SEED = registerItem("roasted_sunflower_seed", new PolyItem(new Item.Settings().food(ModFoodComponents.ROASTED_SUNFLOWER_SEED), "roasted_sunflower_seed"));
    //public static Item BOILED_CORN = registerItem("boiled_corn", new PolyItem(new Item.Settings(), "boiled_corn"));

    public static Item TOMATO_SEEDS = registerItem("tomato_seeds", new PolySeedsItem(ModBlocks.TOMATO, new Item.Settings(), "tomato_seeds"));
    public static Item CABBAGE_SEEDS = registerItem("cabbage_seeds", new PolySeedsItem(ModBlocks.CABBAGE, new Item.Settings(), "cabbage_seeds"));
    public static Item CORN_SEEDS = registerItem("corn_seeds", new PolySeedsItem(ModBlocks.CORN, new Item.Settings(), "corn_seeds"));
    public static Item CHILLI_PEPPER_SEEDS = registerItem("chilli_pepper_seeds", new PolySeedsItem(ModBlocks.CHILLI_PEPPER, new Item.Settings(), "chilli_pepper_seeds"));
    public static Item CUCUMBER_SEEDS = registerItem("cucumber_seeds", new PolySeedsItem(ModBlocks.CUCUMBER, new Item.Settings(), "cucumber_seeds"));
    public static Item LETTUCE_SEEDS = registerItem("lettuce_seeds", new PolySeedsItem(ModBlocks.LETTUCE, new Item.Settings(), "lettuce_seeds"));
    public static Item ONION_SEEDS = registerItem("onion_seeds", new PolySeedsItem(ModBlocks.ONION, new Item.Settings(), "onion_seeds"));
    public static Item TOMATO = registerItem("tomato", new PolyItem(new Item.Settings().food(ModFoodComponents.TOMATO), "tomato"));
    public static Item CABBAGE = registerItem("cabbage", new PolyItem(new Item.Settings().food(ModFoodComponents.CABBAGE), "cabbage"));
    public static Item CHILLI_PEPPER = registerItem("chilli_pepper", new PolyItem(new Item.Settings().food(ModFoodComponents.CHILLI_PEPPER), "chilli_pepper"));
    public static Item CORN = registerItem("corn", new PolyItem(new Item.Settings().food(ModFoodComponents.CORN), "corn"));
    public static Item CUCUMBER = registerItem("cucumber", new PolyItem(new Item.Settings().food(ModFoodComponents.CUCUMBER), "cucumber"));
    public static Item LETTUCE = registerItem("lettuce", new PolyItem(new Item.Settings().food(ModFoodComponents.LETTUCE), "lettuce"));
    public static Item LEMON = registerItem("lemon", new PolyItem(new Item.Settings().food(ModFoodComponents.LEMON), "lemon"));
    public static Item BLACKCURRANTS = registerItem("blackcurrants", new PolySeedsItem(ModBlocks.BLACKCURRANTS_BUSH, new Item.Settings().food(FoodComponents.SWEET_BERRIES), "blackcurrants"));
    public static Item GOOSEBERRY = registerItem("gooseberry", new PolySeedsItem(ModBlocks.GOOSEBERRY_BUSH, new Item.Settings().food(FoodComponents.SWEET_BERRIES), "gooseberry"));
    public static Item ONION = registerItem("onion", new PolyItem(new Item.Settings().food(ModFoodComponents.ONION), "onion"));
    public static Item SALT = registerItem("salt", new PolyItem(new Item.Settings(), "salt"));
    public static Item WAFFLE = registerItem("waffle", new PolyItem(new Item.Settings().food(ModFoodComponents.WAFFLE), "waffle"));
    public static Item CHOCOLATE_BAR = registerItem("chocolate_bar", new PolyItem(new Item.Settings().food(ModFoodComponents.CHOCOLATE_BAR), "chocolate_bar"));
    public static Item OIL = registerItem("oil", new PolyItem(new Item.Settings(), "oil"));
    public static Item GUACAMOLE = registerItem("guacamole", new PolyItem(new Item.Settings(), "guacamole"));
    public static Item HOT_SPICE = registerItem("hot_spice", new PolyItem(new Item.Settings(), "hot_spice"));
    public static Item KETCHUP = registerItem("ketchup", new PolyItem(new Item.Settings(), "ketchup"));
    public static Item MAYONNAISE = registerItem("mayonnaise", new PolyItem(new Item.Settings(), "mayonnaise"));
    public static Item MEAT_PIZZA_SLICE = registerItem("meat_pizza_slice", new PolyItem(new Item.Settings().food(ModFoodComponents.MEAT_PIZZA), "meat_pizza_slice"));
    public static Item VEGAN_PIZZA_SLICE = registerItem("vegan_pizza_slice", new PolyItem(new Item.Settings().food(ModFoodComponents.PIZZA), "vegan_pizza_slice"));
    public static Item CHOCOLATE_ICE_CREAM = registerItem("chocolate_ice_cream", new PolyItem(new Item.Settings().food(ModFoodComponents.CHOCOLATE_ICE_CREAM), "chocolate_ice_cream"));
    public static Item ICE_CREAM = registerItem("ice_cream", new PolyItem(new Item.Settings().food(ModFoodComponents.ICE_CREAM), "ice_cream"));
    public static Item SWEET_BERRY_COOKIE = registerItem("sweet_berry_cookie", new PolyItem(new Item.Settings().food(ModFoodComponents.COOKIE), "sweet_berry_cookie"));
    public static Item BLACKCURRANT_COOKIE = registerItem("blackcurrant_cookie", new PolyItem(new Item.Settings().food(ModFoodComponents.COOKIE), "blackcurrant_cookie"));
    public static Item BEEF_SANDWICH = registerItem("beef_sandwich", new PolyItem(new Item.Settings().food(ModFoodComponents.BEEF_SANDWICH), "beef_sandwich"));
    public static Item TOMATO_SANDWICH = registerItem("tomato_sandwich", new PolyItem(new Item.Settings().food(ModFoodComponents.TOMATO_SANDWICH), "tomato_sandwich"));
    public static Item BREAD_SLICE = registerItem("bread_slice", new PolyItem(new Item.Settings().food(ModFoodComponents.BREAD_SLICE), "bread_slice"));
    public static Item BORSCH = registerItem("borsch", new PolyItem(new Item.Settings().food(ModFoodComponents.BORSCH).maxCount(1), "borsch"));
    public static Item BROTH = registerItem("broth", new PolyItem(new Item.Settings().food(ModFoodComponents.BROTH).maxCount(1), "broth"));
    public static Item ROTTEN_SOUP = registerItem("rotten_soup", new PolyItem(new Item.Settings().food(ModFoodComponents.ROTTEN_SOUP).maxCount(1), "rotten_soup"));
    public static Item BEEF_SLICES = registerItem("beef_slices", new PolyItem(new Item.Settings().food(ModFoodComponents.BEEF_SLICES), "beef_slices"));
    public static Item VEGAN_BARBECUE = registerItem("vegan_barbecue", new PolyItem(new Item.Settings().food(ModFoodComponents.VEGAN_BARBECUE), "vegan_barbecue"));
    public static Item COOKED_VEGAN_BARBECUE = registerItem("cooked_vegan_barbecue", new PolyItem(new Item.Settings().food(ModFoodComponents.COOKED_VEGAN_BARBECUE), "cooked_vegan_barbecue"));
    public static Item BEEF_BARBECUE = registerItem("beef_barbecue", new PolyItem(new Item.Settings().food(ModFoodComponents.BEEF_BARBECUE), "beef_barbecue"));
    public static Item COOKED_BEEF_BARBECUE = registerItem("cooked_beef_barbecue", new PolyItem(new Item.Settings().food(ModFoodComponents.COOKED_BEEF_BARBECUE), "cooked_beef_barbecue"));
    public static Item PICKLE_JAR = registerItem("pickle_jar", new PickleJarItem(new Item.Settings().maxCount(16), "pickle_jar"));
    public static Item LEMON_PIE = registerItem("lemon_pie", new PolyItem(new Item.Settings().food(ModFoodComponents.FRUIT_PIE), "lemon_pie"));
    public static Item APPLE_PIE = registerItem("apple_pie", new PolyItem(new Item.Settings().food(ModFoodComponents.FRUIT_PIE), "apple_pie"));
    public static Item HONEY_PIE = registerItem("honey_pie", new PolyItem(new Item.Settings().food(ModFoodComponents.HONEY_PIE), "honey_pie"));
    public static Item PICKLE = registerItem("pickle", new PolyItem(new Item.Settings().food(ModFoodComponents.PICKLE), "pickle"));
    public static Item EMPTY_JAR = registerItem("empty_jar", new PolyItem(new Item.Settings(), "empty_jar"));
    public static Item APPLE_CANDY = registerItem("apple_candy", new PolyItem(new Item.Settings().food(ModFoodComponents.APPLE_CANDY), "apple_candy"));
    public static Item HONEY_CANDY = registerItem("honey_candy", new PolyItem(new Item.Settings().food(ModFoodComponents.HONEY_CANDY), "honey_candy"));
    public static Item JACK_CANDY = registerItem("jack_candy", new PolyItem(new Item.Settings().food(ModFoodComponents.JACK_CANDY), "jack_candy"));
    public static Item PUMPKIN_CANDY = registerItem("pumpkin_candy", new PolyItem(new Item.Settings().food(ModFoodComponents.PUMPKIN_CANDY), "pumpkin_candy"));
    public static Item LEMON_CANDY = registerItem("lemon_candy", new PolyItem(new Item.Settings().food(ModFoodComponents.LEMON_CANDY), "lemon_candy"));

    public static Item SALT_POPCORN = registerItem("salt_popcorn", new PolyItem(new Item.Settings().food(ModFoodComponents.SALT_POPCORN), "salt_popcorn"));
    public static Item CHOCOLATE_POPCORN = registerItem("chocolate_popcorn", new PolyItem(new Item.Settings().food(ModFoodComponents.CHOCOLATE_POPCORN), "chocolate_popcorn"));
    public static Item CHEESE_POPCORN = registerItem("cheese_popcorn", new PolyItem(new Item.Settings().food(ModFoodComponents.CHEESE_POPCORN), "cheese_popcorn"));
    public static Item POPCORN = registerItem("popcorn", new PolyItem(new Item.Settings().food(ModFoodComponents.POPCORN), "popcorn"));
    public static Item CHEESE = registerItem("cheese", new PolyItem(new Item.Settings().food(ModFoodComponents.CHEESE), "cheese"));
    public static Item TOMATO_SLICES = registerItem("tomato_slices", new PolyItem(new Item.Settings().food(ModFoodComponents.TOMATO_SLICES), "tomato_slices"));
    public static Item CUCUMBER_SLICES = registerItem("cucumber_slices", new PolyItem(new Item.Settings().food(ModFoodComponents.CUCUMBER_SLICES), "cucumber_slices"));
    public static Item LAVASH = registerItem("lavash", new PolyItem(new Item.Settings().food(ModFoodComponents.LAVASH), "lavash"));
    public static Item SHAWARMA = registerItem("shawarma", new PolyItem(new Item.Settings().food(ModFoodComponents.SHAWARMA), "shawarma"));
    public static Item BEEF_SALAD = registerItem("beef_salad", new PolyItem(new Item.Settings().food(ModFoodComponents.BEEF_SALAD), "beef_salad"));
    public static Item VEGETABLE_SALAD = registerItem("vegetable_salad", new PolyItem(new Item.Settings().food(ModFoodComponents.VEGETABLE_SALAD), "vegetable_salad"));
    public static Item COOKED_BEEF_SLICES = registerItem("cooked_beef_slices", new PolyItem(new Item.Settings().food(ModFoodComponents.COOKED_BEEF_SLICES), "cooked_beef_slices"));
    public static Item AVOCADO = registerItem("avocado", new PolyItem(new Item.Settings().food(ModFoodComponents.AVOCADO), "avocado"));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BorukvaFood.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ItemGroup.Builder builder = PolymerItemGroupUtils.builder();
        builder.icon(() -> new ItemStack(ModItems.TOMATO, 1));
        builder.displayName(Text.translatable("item-group.borukva-food.items"));

        builder.entries((displayContext, entries) -> {
            entries.add(TOMATO);
            entries.add(CABBAGE);
            entries.add(CHILLI_PEPPER);
            entries.add(CORN);
            entries.add(CUCUMBER);
            entries.add(LETTUCE);
            entries.add(ONION);
            entries.add(TOMATO_SEEDS);
            entries.add(CABBAGE_SEEDS);
            entries.add(CHILLI_PEPPER_SEEDS);
            entries.add(CORN_SEEDS);
            entries.add(CUCUMBER_SEEDS);
            entries.add(LETTUCE_SEEDS);
            entries.add(ONION_SEEDS);
            entries.add(LEMON);
            entries.add(AVOCADO);
            entries.add(HOT_SPICE);
            entries.add(SALT);
            entries.add(OIL);
            entries.add(MAYONNAISE);
            entries.add(KETCHUP);
            entries.add(GUACAMOLE);
            entries.add(EMPTY_JAR);
            entries.add(PICKLE_JAR);
            entries.add(PICKLE);
            entries.add(ModBlocks.MEAT_PIZZA_ITEM);
            entries.add(ModBlocks.VEGAN_PIZZA_ITEM);
            entries.add(MEAT_PIZZA_SLICE);
            entries.add(VEGAN_PIZZA_SLICE);
            entries.add(CHOCOLATE_ICE_CREAM);
            entries.add(ICE_CREAM);
            entries.add(WAFFLE);
            entries.add(CHOCOLATE_BAR);
            entries.add(SWEET_BERRY_COOKIE);
            entries.add(BLACKCURRANT_COOKIE);
            entries.add(BEEF_SANDWICH);
            entries.add(TOMATO_SANDWICH);
            entries.add(BREAD_SLICE);
            entries.add(BORSCH);
            entries.add(BROTH);
            entries.add(ROTTEN_SOUP);
            entries.add(BLACKCURRANTS);
            entries.add(GOOSEBERRY);
            entries.add(BEEF_SLICES);
            entries.add(COOKED_BEEF_SLICES);
            entries.add(BEEF_BARBECUE);
            entries.add(COOKED_BEEF_BARBECUE);
            entries.add(VEGAN_BARBECUE);
            entries.add(COOKED_VEGAN_BARBECUE);
            entries.add(LEMON_PIE);
            entries.add(APPLE_PIE);
            entries.add(HONEY_PIE);
            entries.add(APPLE_CANDY);
            entries.add(HONEY_CANDY);
            entries.add(JACK_CANDY);
            entries.add(PUMPKIN_CANDY);
            entries.add(LEMON_CANDY);
            entries.add(TOMATO_SLICES);
            entries.add(CUCUMBER_SLICES);
            entries.add(CHEESE);
            entries.add(LAVASH);
            entries.add(SHAWARMA);
            entries.add(VEGETABLE_SALAD);
            entries.add(BEEF_SALAD);
            entries.add(POPCORN);
            entries.add(SALT_POPCORN);
            entries.add(CHOCOLATE_POPCORN);
            entries.add(CHEESE_POPCORN);
            entries.add(ModBlocks.CHOCOLATE_CAKE_ITEM);
            entries.add(ModBlocks.HONEY_CAKE_ITEM);
            entries.add(RICE);
            entries.add(RICE_PANICLE);
            entries.add(RICE_BOWL);
            entries.add(SALMON_FILLET);
            entries.add(SALMON_MAKI);
            entries.add(SALMON_NIGIRI);
            entries.add(SALMON_URAMAKI);
            entries.add(ONIGIRI);
            entries.add(NORI);
            entries.add(SAUERKRAUT);
            entries.add(SALO);
            entries.add(SUNFLOWER_SEED);
            entries.add(ROASTED_SUNFLOWER_SEED);
        });
        ItemGroup polymerGroup = builder.build();
        PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of(BorukvaFood.MOD_ID, "items"), polymerGroup);
        HarvestSickleItem.registerAttackAction();
        BorukvaFood.LOGGER.info("Register Mod Items");
    }
}
