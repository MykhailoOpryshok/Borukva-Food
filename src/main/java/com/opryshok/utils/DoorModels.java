package com.opryshok.utils;

import com.opryshok.BorukvaFood;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import java.util.HashMap;

public class DoorModels {
    public static final HashMap<String, Pair<ItemStack, ItemStack>> DOOR_MODELS = new HashMap<>();
    public static final ItemStack AVOCADO_MODEL_LEFT = ItemDisplayElementUtil.getModel(Identifier.of(BorukvaFood.MOD_ID, "block/avocado_door_left"));
    public static final ItemStack AVOCADO_MODEL_RIGHT = ItemDisplayElementUtil.getModel(Identifier.of(BorukvaFood.MOD_ID, "block/avocado_door_right"));
    public static final ItemStack LEMON_MODEL_LEFT = ItemDisplayElementUtil.getModel(Identifier.of(BorukvaFood.MOD_ID, "block/lemon_door_left"));
    public static final ItemStack LEMON_MODEL_RIGHT = ItemDisplayElementUtil.getModel(Identifier.of(BorukvaFood.MOD_ID, "block/lemon_door_right"));
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void register(){
        DOOR_MODELS.put("avocado_door", new Pair<>(AVOCADO_MODEL_LEFT, AVOCADO_MODEL_RIGHT));
        DOOR_MODELS.put("lemon_door", new Pair<>(LEMON_MODEL_LEFT, LEMON_MODEL_RIGHT));
        AVOCADO_MODEL_LEFT.isEmpty();
        AVOCADO_MODEL_RIGHT.isEmpty();
        LEMON_MODEL_LEFT.isEmpty();
        LEMON_MODEL_RIGHT.isEmpty();
    }
}
