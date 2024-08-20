package com.opryshok.sounds;

import com.opryshok.BorukvaFood;
import eu.pb4.polymer.core.api.other.PolymerSoundEvent;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class SoundRegistry {
    public static SoundEvent FRYING = registerSoundEvent("frying", SoundEvents.BLOCK_CAMPFIRE_CRACKLE);
    public static SoundEvent SPRAYING = registerSoundEvent("spraying", null);

    private static SoundEvent registerSoundEvent(String name, SoundEvent soundEvent) {
        Identifier id = Identifier.of(BorukvaFood.MOD_ID, name);
        return PolymerSoundEvent.of(id, soundEvent);
    }
}
