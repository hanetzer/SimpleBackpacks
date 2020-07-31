package org.sweetiebelle.simplebackpacks.common.item;

import java.util.function.Supplier;

import org.sweetiebelle.simplebackpacks.SimpleBackpacks;
import org.sweetiebelle.simplebackpacks.common.BackpackType;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BackpackItems {
    private static final Item.Properties BACKPACK_PROPS = new Item.Properties().defaultMaxDamage(0).maxStackSize(1).group(ItemGroup.TOOLS);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SimpleBackpacks.MODID);;


    public static final RegistryObject<ItemBackpack> LEATHER_BACKPACK = register("leather_backpack", () -> new ItemBackpack(BACKPACK_PROPS, BackpackType.LEATHER));
    public static final RegistryObject<ItemBackpack> IRON_BACKPACK = register("iron_backpack", () -> new ItemBackpack(BACKPACK_PROPS, BackpackType.IRON));
    public static final RegistryObject<ItemBackpack> GOLD_BACKPACK = register("gold_backpack", () -> new ItemBackpack(BACKPACK_PROPS, BackpackType.GOLD));
    public static final RegistryObject<ItemBackpack> DIAMOND_BACKPACK = register("diamond_backpack", () -> new ItemBackpack(BACKPACK_PROPS, BackpackType.DIAMOND));

    private static final <T extends ItemBackpack> RegistryObject<T> register(String name, Supplier<T> sup) {
        return ITEMS.register(name, sup);
    }

}
