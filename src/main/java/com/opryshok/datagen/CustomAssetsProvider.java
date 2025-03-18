package com.opryshok.datagen;

import com.google.common.hash.HashCode;
import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import com.opryshok.item.ModItems;
import com.opryshok.ui.UiResourceCreator;
import eu.pb4.polymer.resourcepack.api.AssetPaths;
import eu.pb4.polymer.resourcepack.extras.api.format.item.ItemAsset;
import eu.pb4.polymer.resourcepack.extras.api.format.item.model.BasicItemModel;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class CustomAssetsProvider implements DataProvider {
    private final DataOutput output;

    public CustomAssetsProvider(FabricDataOutput output) {
        this.output = output;
    }

    public static void runWriters(BiConsumer<String, byte[]> assetWriter) {
        UiResourceCreator.generateAssets(assetWriter);
        var map = new HashMap<Identifier, ItemAsset>();
        createItems(map::put);
        map.forEach((id, asset) -> assetWriter.accept(AssetPaths.itemAsset(id), asset.toJson().getBytes(StandardCharsets.UTF_8)));
    }

    private static void createItems(BiConsumer<Identifier, ItemAsset> consumer) {
        var fromItem = new BiConsumer<Item, Function<Identifier, ItemAsset>>() {
            @Override
            public void accept(Item item, Function<Identifier, ItemAsset> function) {
                var id = Registries.ITEM.getId(item);
                consumer.accept(id, function.apply(id));
            }
        };
        for (var item : Registries.ITEM) {
            var id = Registries.ITEM.getId(item);
            if (!id.getNamespace().equals(BorukvaFood.MOD_ID)) {
                continue;
            }
            consumer.accept(id, new ItemAsset(new BasicItemModel(id.withPrefixedPath(item instanceof BlockItem ? "block/" : "item/")), ItemAsset.Properties.DEFAULT));
        }
        Item[] specialItemModels = {
            // seeds
            ModItems.TOMATO_SEEDS, ModItems.CABBAGE_SEEDS, ModItems.CHILLI_PEPPER_SEEDS, ModItems.CORN_SEEDS,
            ModItems.CUCUMBER_SEEDS, ModItems.LETTUCE_SEEDS, ModItems.ONION_SEEDS, ModItems.NETHER_WHEAT_SEEDS,
            ModItems.ENDER_INFECTED_ONION_SEEDS, ModItems.RICE, ModItems.GRAPE_SAPLING,

            // pizza / cake
            ModBlocks.MEAT_PIZZA_ITEM, ModBlocks.VEGAN_PIZZA_ITEM, ModBlocks.FUNGUS_PIZZA_ITEM,
            ModBlocks.CHOCOLATE_CAKE_ITEM, ModBlocks.HONEY_CAKE_ITEM,

            // berries
            ModItems.BLACKCURRANTS, ModItems.GOOSEBERRY,

            // (trap)doors
            ModBlocks.LEMON_TRAPDOOR_ITEM, ModBlocks.LEMON_DOOR_ITEM,
            ModBlocks.AVOCADO_TRAPDOOR_ITEM, ModBlocks.AVOCADO_DOOR_ITEM
        };
        for (Item specialItemModel : specialItemModels) {
            fromItem.accept(specialItemModel, id -> new ItemAsset(new BasicItemModel(id.withPrefixedPath("item/")), ItemAsset.Properties.DEFAULT));
        }
        fromItem.accept(ModBlocks.FERTILIZER_SPRAYER_ITEM, id -> new ItemAsset(new BasicItemModel(id.withPrefixedPath("block/").withSuffixedPath("_off")), ItemAsset.Properties.DEFAULT));
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        BiConsumer<String, byte[]> assetWriter = (path, data) -> {
            try {
                writer.write(this.output.getPath().resolve(path), data, HashCode.fromBytes(data));
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        return CompletableFuture.runAsync(() -> {
            try {
                runWriters(assetWriter);

            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }, Util.getMainWorkerExecutor());
    }

    @Override
    public String getName() {
        return "borukva-food:assets";
    }
}
