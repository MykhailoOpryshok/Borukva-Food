package com.opryshok.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModConfig {
    private boolean soilDegradation = true;
    private boolean replaceCompostOutputWithFertilizer = true;
}
