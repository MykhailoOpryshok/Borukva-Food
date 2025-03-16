package com.opryshok.sounds;

import com.opryshok.BorukvaFood;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class SoundRegistry {
    public static SoundEvent FRYING = registerSoundEvent("frying");
    public static SoundEvent SPRAYING = registerSoundEvent("spraying");
    public static SoundEvent BOILING = registerSoundEvent("boiling");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(BorukvaFood.MOD_ID, name);
        return SoundEvent.of(id);
    }
}
