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
    public static Item SOIL_ANALIZATOR = registerItem("soil_analizator", new SoilAnalizatorItem(new Item.Settings(), "soil_analizator"));
    public static Item KNIFE = registerItem("knife", new KnifeTool(new Item.Settings()));
    public static Item COMPOST = registerItem("compost", new CompostItem(new Item.Settings(), "compost"));

    public static Item TOMATO_SEEDS = registerItem("tomato_seeds", new PolySeedsItem(ModBlocks.TOMATO, new Item.Settings(), "tomato_seeds"));
    public static Item CABBAGE_SEEDS = registerItem("cabbage_seeds", new PolySeedsItem(ModBlocks.CABBAGE, new Item.Settings(), "cabbage_seeds"));
    public static Item CORN_SEEDS = registerItem("corn_seeds", new PolySeedsItem(ModBlocks.CORN, new Item.Settings(), "corn_seeds"));
    public static Item CHILLI_PEPPER_SEEDS = registerItem("chilli_pepper_seeds", new PolySeedsItem(ModBlocks.CHILLI_PEPPER, new Item.Settings(), "chilli_pepper_seeds"));
    public static Item TOMATO = registerItem("tomato", new PolyItem(new Item.Settings().food(ModFoodComponents.TOMATO), "tomato"));
    public static Item CABBAGE = registerItem("cabbage", new PolyItem(new Item.Settings(), "cabbage"));
    public static Item CHILLI_PEPPER = registerItem("chilli_pepper", new PolyItem(new Item.Settings(), "chilli_pepper"));
    public static Item CORN = registerItem("corn", new PolyItem(new Item.Settings(),"corn"));
    public static Item CUCUMBER = registerItem("cucumber", new PolyItem(new Item.Settings(), "cucumber"));
    public static Item LETTUCE = registerItem("lettuce", new PolyItem(new Item.Settings(), "lettuce"));

    public static Item WAFFLE = registerItem("waffle", new PolyItem(new Item.Settings(), "waffle"));
    public static Item CHOCOLATE_BAR = registerItem("chocolate_bar", new PolyItem(new Item.Settings(), "chocolate_bar"));
    public static Item KETCHUP = registerItem("ketchup", new PolyItem(new Item.Settings(), "ketchup"));
    public static Item MAYONNASIE = registerItem("mayonnasie", new PolyItem(new Item.Settings(), "mayonnasie"));

    public static Item MEAT_PIZZA_SLICE = registerItem("meat_pizza_slice", new PolyItem(new Item.Settings().food(ModFoodComponents.PIZZA), "meat_pizza_slice"));
    public static Item VEGAN_PIZZA_SLICE = registerItem("vegan_pizza_slice", new PolyItem(new Item.Settings().food(ModFoodComponents.PIZZA), "vegan_pizza_slice"));
    public static Item CHOCOLATE_ICE_CREAM = registerItem("chocolate_ice_cream", new PolyItem(new Item.Settings().food(ModFoodComponents.ICE_CREAM), "chocolate_ice_cream"));
    public static Item ICE_CREAM = registerItem("ice_cream", new PolyItem(new Item.Settings().food(ModFoodComponents.ICE_CREAM), "ice_cream"));
    public static Item SWEET_BERRY_COOKIE = registerItem("sweet_berry_cookie", new PolyItem(new Item.Settings().food(ModFoodComponents.COOKIE), "sweet_berry_cookie"));
    public static Item BLACKCURRANT_COOKIE = registerItem("blackcurrant_cookie", new PolyItem(new Item.Settings().food(ModFoodComponents.COOKIE), "blackcurrant_cookie"));
    public static Item BEEF_SANDWICH = registerItem("beef_sandwich", new PolyItem(new Item.Settings().food(ModFoodComponents.BEEF_SANDWICH), "beef_sandwich"));
    public static Item TOMATO_SANDWICH = registerItem("tomato_sandwich", new PolyItem(new Item.Settings().food(ModFoodComponents.TOMATO_SANDWICH), "tomato_sandwich"));
    public static Item BREAD_SLICE = registerItem("bread_slice", new PolyItem(new Item.Settings().food(ModFoodComponents.BREAD_SLICE), "bread_slice"));
    public static Item BORSCH = registerItem("borsch", new PolyItem(new Item.Settings().food(ModFoodComponents.BORSCH).maxCount(1), "borsch"));
    public static Item BROTH = registerItem("broth", new PolyItem(new Item.Settings().food(ModFoodComponents.BROTH).maxCount(1), "broth"));
    public static Item ROTTEN_SOUP = registerItem("rotten_soup", new PolyItem(new Item.Settings().food(ModFoodComponents.ROTTEN_SOUP).maxCount(1), "rotten_soup"));
    public static Item BLACKCURRANTS = registerItem("blackcurrants", new PolySeedsItem(ModBlocks.BLACKCURRANTS_BUSH, new Item.Settings().food(FoodComponents.SWEET_BERRIES), "blackcurrants"));
    public static Item GOOSEBERRY = registerItem("gooseberry", new PolySeedsItem(ModBlocks.GOOSEBERRY_BUSH, new Item.Settings().food(FoodComponents.SWEET_BERRIES), "gooseberry"));
    public static Item BEEF_SLICES = registerItem("beef_slices", new PolyItem(new Item.Settings().food(ModFoodComponents.BEEF_SLICES), "beef_slices"));
    public static Item VEGAN_BARBECUE = registerItem("vegan_barbecue", new PolyItem(new Item.Settings().food(ModFoodComponents.VEGAN_BARBECUE), "vegan_barbecue"));
    public static Item COOKED_VEGAN_BARBECUE = registerItem("cooked_vegan_barbecue", new PolyItem(new Item.Settings().food(ModFoodComponents.COOKED_VEGAN_BARBECUE), "cooked_vegan_barbecue"));
    public static Item BEEF_BARBECUE = registerItem("beef_barbecue", new PolyItem(new Item.Settings().food(ModFoodComponents.BEEF_BARBECUE), "beef_barbecue"));
    public static Item COOKED_BEEF_BARBECUE = registerItem("cooked_beef_barbecue", new PolyItem(new Item.Settings().food(ModFoodComponents.COOKED_BEEF_BARBECUE), "cooked_beef_barbecue"));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BorukvaFood.MOD_ID, name), item);
    }
    public static void registerModItems(){
        ItemGroup.Builder builder = PolymerItemGroupUtils.builder();
        builder.icon(() -> new ItemStack(ModItems.TOMATO, 1));
        builder.displayName(Text.of("Їжа"));

        builder.entries((displayContext, entries) -> {
            entries.add(TOMATO);
            entries.add(CABBAGE);
            entries.add(CHILLI_PEPPER);
            entries.add(CORN);
            entries.add(CUCUMBER);
            entries.add(LETTUCE);
            entries.add(TOMATO_SEEDS);
            entries.add(CABBAGE_SEEDS);
            entries.add(CHILLI_PEPPER_SEEDS);
            entries.add(CORN_SEEDS);

            entries.add(ModBlocks.MEAT_PIZZA);
            entries.add(ModBlocks.VEGAN_PIZZA);
            entries.add(MEAT_PIZZA_SLICE);
            entries.add(VEGAN_PIZZA_SLICE);
            entries.add(CHOCOLATE_ICE_CREAM);
            entries.add(ICE_CREAM);
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
            entries.add(BEEF_BARBECUE);
            entries.add(COOKED_BEEF_BARBECUE);
            entries.add(VEGAN_BARBECUE);
            entries.add(COOKED_VEGAN_BARBECUE);
        });
        ItemGroup polymerGroup = builder.build();
        PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of(BorukvaFood.MOD_ID, "items"), polymerGroup);

        BorukvaFood.LOGGER.info("Register Mod Items");
    }
}
