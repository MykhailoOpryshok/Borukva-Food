package com.opryshok.ui;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opryshok.BorukvaFood;
import eu.pb4.polymer.resourcepack.api.AssetPaths;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import eu.pb4.sgui.api.elements.GuiElementBuilder;
import it.unimi.dsi.fastutil.chars.Char2IntMap;
import it.unimi.dsi.fastutil.chars.Char2IntOpenHashMap;
import it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import it.unimi.dsi.fastutil.chars.Char2ObjectOpenHashMap;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;


public class UiResourceCreator {
    public static final String BASE_MODEL = "minecraft:item/generated";
    private static final String ITEM_TEMPLATE = """
            {
              "parent": "|BASE|",
              "textures": {
                "layer0": "|ID|"
              }
            }
            """.replace(" ", "").replace("\n", "");
    private static final Style STYLE = Style.EMPTY.withColor(0xFFFFFF).withFont(Identifier.of(BorukvaFood.MOD_ID, "gui"));
    private static char character = 'a';
    private static final Char2IntMap SPACES = new Char2IntOpenHashMap();
    private static final Char2ObjectMap<Identifier> TEXTURES = new Char2ObjectOpenHashMap<>();
    private static final List<Pair<PolymerModelData, String>> SIMPLE_MODEL = new ArrayList<>();
    private static final List<SlicedTexture> VERTICAL_PROGRESS = new ArrayList<>();
    private static final char CHEST_SPACE0 = character++;
    private static final char CHEST_SPACE1 = character++;

    public static Function<Text, Text> background(String path) {
        var builder = new StringBuilder().append(CHEST_SPACE0);
        var c = (character++);
        builder.append(c);
        builder.append(CHEST_SPACE1);
        TEXTURES.put(c, Identifier.of(BorukvaFood.MOD_ID, "sgui/" + path));

        return new TextBuilders(Text.literal(builder.toString()).setStyle(STYLE));
    }
    public static Supplier<GuiElementBuilder> icon16(String path) {
        var model = genericIconRaw(Items.ALLIUM, path, BASE_MODEL);
        return () -> new GuiElementBuilder(model.item()).setName(Text.empty()).hideDefaultTooltip().setCustomModelData(model.value());
    }
    public static PolymerModelData genericIconRaw(Item item, String path, String base) {
        var model = PolymerResourcePackUtils.requestModel(item, elementPath(path));
        SIMPLE_MODEL.add(new Pair<>(model, base));
        return model;
    }
    public static IntFunction<GuiElementBuilder> verticalProgress16(String path, int start, int stop, boolean reverse) {
        return genericProgress(path, start, stop, reverse, BASE_MODEL, VERTICAL_PROGRESS);
    }
    public static IntFunction<GuiElementBuilder> genericProgress(String path, int start, int stop, boolean reverse, String base, List<SlicedTexture> progressType) {

        var models = new PolymerModelData[stop - start];

        progressType.add(new SlicedTexture(path, start, stop, reverse));

        for (var i = start; i < stop; i++) {
            models[i - start] = genericIconRaw(Items.ALLIUM,  "gen/" + path + "_" + i, base);
        }
        return (i) -> new GuiElementBuilder(models[i].item()).setName(Text.empty()).hideDefaultTooltip().setCustomModelData(models[i].value());
    }
    private static void generateProgress(BiConsumer<String, byte[]> assetWriter) {
        for (var pair : UiResourceCreator.VERTICAL_PROGRESS) {
            var sourceImage = ResourceUtils.getTexture(elementPath(pair.path()));

            var image = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), BufferedImage.TYPE_INT_ARGB);

            var xw = image.getWidth();

            var mult = pair.reverse ? -1 : 1;
            var offset = pair.reverse ? pair.stop + pair.start - 1 : 0;

            for (var y = pair.start; y < pair.stop; y++) {
                var path = elementPath("gen/" + pair.path + "_" + y);
                var pos = offset + y * mult;

                for (var x = 0; x < xw; x++) {
                    image.setRGB(x, pos, sourceImage.getRGB(x, pos));
                }

                var out = new ByteArrayOutputStream();
                try {
                    ImageIO.write(image, "png", out);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                assetWriter.accept(AssetPaths.texture(path.getNamespace(), path.getPath() + ".png"), out.toByteArray());
            }
        }
    }
    public static void generateAssets(BiConsumer<String, byte[]> assetWriter) {
        for (var texture : SIMPLE_MODEL) {
            assetWriter.accept("assets/" + texture.getLeft().modelPath().getNamespace() + "/models/" + texture.getLeft().modelPath().getPath() + ".json",
                    ITEM_TEMPLATE.replace("|ID|", texture.getLeft().modelPath().toString()).replace("|BASE|", texture.getRight()).getBytes(StandardCharsets.UTF_8));
        }

        generateProgress(assetWriter);

        var fontBase = new JsonObject();
        var providers = new JsonArray();

        {
            var spaces = new JsonObject();
            spaces.addProperty("type", "space");
            var advances = new JsonObject();
            SPACES.char2IntEntrySet().stream().sorted(Comparator.comparing(Char2IntMap.Entry::getCharKey)).forEach((c) -> advances.addProperty(Character.toString(c.getCharKey()), c.getIntValue()));
            spaces.add("advances", advances);
            providers.add(spaces);
        }

        TEXTURES.char2ObjectEntrySet().stream().sorted(Comparator.comparing(Char2ObjectMap.Entry::getCharKey)).forEach((entry) -> {
            var bitmap = new JsonObject();
            bitmap.addProperty("type", "bitmap");
            bitmap.addProperty("file", entry.getValue().toString() + ".png");
            bitmap.addProperty("ascent", 13);
            bitmap.addProperty("height", 256);
            var chars = new JsonArray();
            chars.add(Character.toString(entry.getCharKey()));
            bitmap.add("chars", chars);
            providers.add(bitmap);
        });

        fontBase.add("providers", providers);

        assetWriter.accept("assets/borukva-food/font/gui.json", fontBase.toString().getBytes(StandardCharsets.UTF_8));
    }

    private record TextBuilders(Text base) implements Function<Text, Text> {
        @Override
        public Text apply(Text text) {
            return Text.empty().append(base).append(text);
        }
    }

    public static void setup() {
        SPACES.put(CHEST_SPACE0, -8);
        SPACES.put(CHEST_SPACE1, -168);
        PolymerResourcePackUtils.RESOURCE_PACK_CREATION_EVENT.register((b) -> UiResourceCreator.generateAssets(b::addData));
    }
    private static Identifier elementPath(String path) {
        return Identifier.of(BorukvaFood.MOD_ID,"item/elements/" + path);
    }
    public record SlicedTexture(String path, int start, int stop, boolean reverse) {}
}
