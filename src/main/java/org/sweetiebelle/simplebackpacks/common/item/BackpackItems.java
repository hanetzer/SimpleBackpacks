package org.sweetiebelle.simplebackpacks.common.item;

import java.util.function.Supplier;

import org.sweetiebelle.simplebackpacks.SimpleBackpacks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BackpackItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SimpleBackpacks.MODID);;

    public static final RegistryObject<ItemLeatherBackpack> LEATHER_BACKPACK = register("leather_backpack", () -> new ItemLeatherBackpack(new Item.Properties().defaultMaxDamage(0).maxStackSize(1).group(ItemGroup.TOOLS)));
    public static final RegistryObject<ItemIronBackpack> IRON_BACKPACK = register("iron_backpack", () -> new ItemIronBackpack(new Item.Properties().defaultMaxDamage(0).maxStackSize(1).group(ItemGroup.TOOLS)));
    public static final RegistryObject<ItemGoldBackpack> GOLD_BACKPACK = register("gold_backpack", () -> new ItemGoldBackpack(new Item.Properties().defaultMaxDamage(0).maxStackSize(1).group(ItemGroup.TOOLS)));
    public static final RegistryObject<ItemDiamondBackpack> DIAMOND_BACKPACK = register("diamond_backpack", () -> new ItemDiamondBackpack(new Item.Properties().defaultMaxDamage(0).maxStackSize(1).group(ItemGroup.TOOLS)));

    private static final <T extends ItemBackpack> RegistryObject<T> register(String name, Supplier<T> sup) {
        return ITEMS.register(name, sup);
    }

}
