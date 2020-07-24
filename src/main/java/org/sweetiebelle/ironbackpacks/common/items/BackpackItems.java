package org.sweetiebelle.ironbackpacks.common.items;

import java.util.function.Supplier;

import org.sweetiebelle.ironbackpacks.IronBackpacks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BackpackItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IronBackpacks.MODID);;
	private static final Item.Properties PROPERTIES = new Item.Properties().group(ItemGroup.INVENTORY).maxStackSize(1);
	
	private static final <T extends Item> RegistryObject<T> register(String name, Supplier<T> sup) {
		return ITEMS.register(name, sup);
	}
	
	static {
		register("leather_backpack", () -> new ItemLeatherBackpack(PROPERTIES));
		register("iron_backpack", () -> new ItemIronBackpack(PROPERTIES));
		register("gold_backpack", () -> new ItemGoldBackpack(PROPERTIES));
		register("diamond_backpack", () -> new ItemDiamondBackpack(PROPERTIES));
	}
}
