package org.sweetiebelle.simplebackpacks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sweetiebelle.simplebackpacks.common.container.BackpackContainerTypes;
import org.sweetiebelle.simplebackpacks.common.item.BackpackItems;
import org.sweetiebelle.simplebackpacks.common.recipe.Recipes;
import org.sweetiebelle.simplebackpacks.common.sounds.BackpackSounds;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SimpleBackpacks.MODID)
@EventBusSubscriber
public class SimpleBackpacks {

    public static final String MODID = "simplebackpacks";
    public static final Logger LOG = LogManager.getLogger();

    public SimpleBackpacks() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        BackpackItems.ITEMS.register(modBus);
        BackpackContainerTypes.CONTAINERS.register(modBus);
        BackpackSounds.SOUNDS.register(modBus);
        Recipes.RECIPES_REGISTRY.register(modBus);
    }
}
