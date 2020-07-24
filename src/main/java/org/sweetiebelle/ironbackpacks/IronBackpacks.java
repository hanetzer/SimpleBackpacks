package org.sweetiebelle.ironbackpacks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sweetiebelle.ironbackpacks.client.ClientProxy;
import org.sweetiebelle.ironbackpacks.common.CommonProxy;
import org.sweetiebelle.ironbackpacks.common.items.BackpackItems;
import org.sweetiebelle.ironbackpacks.sever.ServerProxy;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(IronBackpacks.MODID)
public class IronBackpacks {

	public static final String MODID = "ironbackpacks";
	public static final Logger LOG = LogManager.getLogger();
	public static CommonProxy PROXY = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

	public IronBackpacks() {
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

		DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> () -> {
			modBus.addListener(this::setupClient);
		});
		
		BackpackItems.ITEMS.register(modBus);
	}

	@OnlyIn(Dist.CLIENT)
	private void setupClient(FMLClientSetupEvent event) {

	}

}
