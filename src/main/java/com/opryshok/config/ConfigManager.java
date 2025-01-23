package com.opryshok.config;

import com.google.gson.*;
import com.opryshok.BorukvaFood;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigManager {
    private static final File CONFIG_FILE = FabricLoader.getInstance().getConfigDir().resolve("borukva-food.json").toFile();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static ModConfig load() {
        ModConfig config = new ModConfig(); // Start with default config
        if (!CONFIG_FILE.exists()) {
            save(config); // Save default config
            return config;
        }

        try (FileReader reader = new FileReader(CONFIG_FILE)) {
            JsonObject jsonConfig =  JsonParser.parseReader(reader).getAsJsonObject();
            config =  GSON.fromJson(jsonConfig, ModConfig.class);
            JsonObject defaultJsonConfig = GSON.toJsonTree(new ModConfig()).getAsJsonObject();
            for (var entry : defaultJsonConfig.entrySet()) {
                if (!jsonConfig.has(entry.getKey())) {
                    jsonConfig.add(entry.getKey(),entry.getValue());
                }
            }

            config = GSON.fromJson(jsonConfig, ModConfig.class);

            save(config);


        } catch (IOException e) {
            // If there's an error (could be parsing), create a new config with defaults and save
            BorukvaFood.LOGGER.error("Error loading config, using default: {}", e.getMessage());
            save(config);
        }
        return config;
    }

    public static void save(ModConfig config) {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(config, writer);
        } catch (IOException e) {
            BorukvaFood.LOGGER.error("Error saving config: {}", e.getMessage());
        }
    }
}