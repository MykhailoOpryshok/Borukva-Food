package com.opryshok.polydex;

import net.minecraft.text.Text;

import static com.opryshok.ui.UiResourceCreator.polydexBackground;

public class PolydexTextures {
    public static final Text CUTTING_BOARD;
    public static final Text PAN;
    public static final Text POT;

    public static void register() {

    }

    static {
        var t0 = polydexBackground("0");
        var t1 = polydexBackground("1");
        var t2 = polydexBackground("2");
        CUTTING_BOARD = t0.getLeft();
        PAN = t1.getLeft();
        POT = t2.getLeft();
    }
}
