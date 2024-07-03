package com.opryshok.utils;

import net.minecraft.state.property.IntProperty;

public class ModProperties {
    public static final IntProperty FERTILITY;
    public static final IntProperty ACIDITY;

    static{
        FERTILITY = IntProperty.of("fertility", 0, 10);
        ACIDITY = IntProperty.of("acidity", 0, 10);
    }
}
