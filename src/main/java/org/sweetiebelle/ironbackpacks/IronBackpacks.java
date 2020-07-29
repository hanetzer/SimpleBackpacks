package org.sweetiebelle.ironbackpacks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sweetiebelle.ironbackpacks.client.screen.IronBackpacksScreen;
import org.sweetiebelle.ironbackpacks.common.container.BackpackContainerProvider;
import org.sweetiebelle.ironbackpacks.common.container.BackpackContainerTypes;
import org.sweetiebelle.ironbackpacks.common.item.BackpackItems;
import org.sweetiebelle.ironbackpacks.common.sounds.BackpackSounds;

import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.network.NetworkHooks;

@Mod(IronBackpacks.MODID)
public class IronBackpacks {

    public static final String MODID = "ironbackpacks";
    public static final Logger LOG = LogManager.getLogger();
    

    @SuppressWarnings("deprecation")
    public IronBackpacks() {

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            modBus.addListener(this::setupClient);
        });

        BackpackItems.ITEMS.register(modBus);
        BackpackContainerTypes.CONTAINERS.register(modBus);
        BackpackSounds.SOUNDS.register(modBus);
    }

    @OnlyIn(Dist.CLIENT)
    private void setupClient(FMLClientSetupEvent event) {
        ScreenManager.registerFactory(BackpackContainerTypes.LEATHER_BACKPACK.get(), IronBackpacksScreen::new);
        ScreenManager.registerFactory(BackpackContainerTypes.IRON_BACKPACK.get(), IronBackpacksScreen::new);
        ScreenManager.registerFactory(BackpackContainerTypes.GOLD_BACKPACK.get(), IronBackpacksScreen::new);
        ScreenManager.registerFactory(BackpackContainerTypes.DIAMOND_BACKPACK.get(), IronBackpacksScreen::new);
    }

}
