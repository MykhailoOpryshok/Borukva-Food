package com.opryshok.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModConfig {
    private int configVersion = 1;
    private float fertilityGrowthModifier = 2f;
    private boolean soilDegradation = true;
    private String c_soilDegradationChance = "Soil soil degradation chance when crop is grown in percent";
    private float soilDegradationChance = 10;
    private String c_onlyGoodEffects = "Soil with low fertility doesn't reduces vanilla grown speed if true";
    private boolean onlyGoodEffects = true;
    private String c_acidityEffects = "Changes acidity behaviour. \"default\" - if acidity lower than 3 or greater than 7 crops grown divided by 3. \"fertility\" - works same as fertility, in this case uses fertility growth modifier. \"disabled\" - disabled.";
    private String acidityEffects = "default";

    private boolean replaceCompostOutputWithFertilizer = true;
}
