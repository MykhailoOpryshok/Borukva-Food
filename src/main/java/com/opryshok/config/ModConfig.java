package com.opryshok.config;

import com.google.gson.annotations.SerializedName;
import eu.midnightdust.lib.config.MidnightConfig;

public class ModConfig extends MidnightConfig {
    @Entry @Hidden public static int configVersion = 1;
    @Entry public static float fertilityGrowthModifier = 2f;
    @Entry public static boolean soilDegradation = true;
    @Hidden @Entry public static String c_soilDegradationChance = "Soil degradation chance when crop is grown (in percent)";
    @Condition(requiredOption = "soilDegradation", visibleButLocked = true)
    @Entry(isSlider = true, min = 0, max = 100, precision = 10) public static float soilDegradationChance = 10;
    @Hidden @Entry public static String c_onlyGoodEffects = "Soil with low fertility doesn't reduce vanilla grown speed if true";
    @Entry public static boolean onlyGoodEffects = true;
    @Hidden @Entry public static String c_acidityEffects = "Changes acidity behaviour. \"default\" - if acidity lower than 3 or greater than 7 crops grown divided by 3. \"fertility\" - works same as fertility, in this case uses fertility growth modifier. \"disabled\" - disabled.";
    @Entry public static AcidityEffects acidityEffects = AcidityEffects.DEFAULT;

    @Entry public static boolean replaceCompostOutputWithFertilizer = true;

    public enum AcidityEffects {
        @SerializedName("default") DEFAULT, @SerializedName("fertility") FERTILITY, @SerializedName("disabled") DISABLED;
    }
}
