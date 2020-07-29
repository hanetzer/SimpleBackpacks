package org.sweetiebelle.simplebackpacks.common.sounds;

import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

import org.sweetiebelle.simplebackpacks.SimpleBackpacks;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class BackpackSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SimpleBackpacks.MODID);

    public static final RegistryObject<SoundEvent> OPEN_SOUND = register("open_backpack", () -> new SoundEvent(new ResourceLocation(SimpleBackpacks.MODID, "open_backpack_sound")));

    public static final RegistryObject<SoundEvent> CLOSE_SOUND = register("close_backpack", () -> new SoundEvent(new ResourceLocation(SimpleBackpacks.MODID, "close_backpack_sound")));

    private static final <T extends SoundEvent> RegistryObject<T> register(String name, Supplier<T> sup) {
        return SOUNDS.register(name, sup);
    }
}
