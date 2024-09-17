package com.opryshok.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opryshok.BorukvaFood;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ConfigManager {
    private static final File CONFIG_FILE = FabricLoader.getInstance().getConfigDir().resolve("borukva-food.json").toFile();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static ModConfig load() {
        try (FileReader reader = new FileReader(CONFIG_FILE)) {
            return GSON.fromJson(reader, ModConfig.class);
        } catch (IOException e) {
            // If the file doesn't exist or there's an error, create a new config with defaults
            ModConfig config = new ModConfig();
            save(config);
            return config;
        }
    }

    public static void save(ModConfig config) {

        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(config, writer);
        } catch (IOException e) {
            BorukvaFood.LOGGER.error("Error saving config: {}", e.getMessage());
        }
    }
}
