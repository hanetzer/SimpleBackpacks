package org.sweetiebelle.ironbackpacks.common.inventory;

import org.sweetiebelle.ironbackpacks.IronBackpacks;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BackpackContainerTypes {

  public static final DeferredRegister<ContainerType<?>> CONTAINERS =  DeferredRegister.create(ForgeRegistries.CONTAINERS, IronBackpacks.MODID);

  public static final RegistryObject<ContainerType<BackpackContainer>> LEATHER_BACKPACK = CONTAINERS.register("leather_backpack", () -> new ContainerType<>(BackpackContainer::createLeatherContainer));

  public static final RegistryObject<ContainerType<BackpackContainer>> IRON_BACKPACK = CONTAINERS.register("iron_backpack", () -> new ContainerType<>(BackpackContainer::createIronContainer));

  public static final RegistryObject<ContainerType<BackpackContainer>> GOLD_BACKPACK = CONTAINERS.register("gold_backpack", () -> new ContainerType<>(BackpackContainer::createGoldContainer));

  public static final RegistryObject<ContainerType<BackpackContainer>> DIAMOND_BACKPACK = CONTAINERS.register("diamond_backpack", () -> new ContainerType<>(BackpackContainer::createDiamondContainer));


}
