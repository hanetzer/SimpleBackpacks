package org.sweetiebelle.simplebackpacks.client;

import org.sweetiebelle.simplebackpacks.SimpleBackpacks;
import org.sweetiebelle.simplebackpacks.client.screen.BackpacksScreen;
import org.sweetiebelle.simplebackpacks.common.container.BackpackContainerTypes;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(value = Dist.CLIENT, modid = SimpleBackpacks.MODID, bus = Bus.MOD)
public class BackpacksClient {

    
    public static void setupClient(FMLClientSetupEvent event) {
        ScreenManager.registerFactory(BackpackContainerTypes.LEATHER_BACKPACK.get(), BackpacksScreen::new);
        ScreenManager.registerFactory(BackpackContainerTypes.IRON_BACKPACK.get(), BackpacksScreen::new);
        ScreenManager.registerFactory(BackpackContainerTypes.GOLD_BACKPACK.get(), BackpacksScreen::new);
        ScreenManager.registerFactory(BackpackContainerTypes.DIAMOND_BACKPACK.get(), BackpacksScreen::new);
    }
}
