package org.sweetiebelle.simplebackpacks.common.inventory;

import javax.annotation.Nonnull;

import org.sweetiebelle.simplebackpacks.SimpleBackpacks;
import org.sweetiebelle.simplebackpacks.common.BackpackType;
import org.sweetiebelle.simplebackpacks.common.item.BackpackItems;
import org.sweetiebelle.simplebackpacks.common.item.ItemBackpack;
import org.sweetiebelle.simplebackpacks.common.item.ItemDiamondBackpack;
import org.sweetiebelle.simplebackpacks.common.item.ItemGoldBackpack;
import org.sweetiebelle.simplebackpacks.common.item.ItemIronBackpack;
import org.sweetiebelle.simplebackpacks.common.item.ItemLeatherBackpack;

import com.google.common.base.Preconditions;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraftforge.common.util.INBTSerializable;

public class InventoryProvider implements INBTSerializable<ListNBT> {

    private Inventory inventory;
    private ItemStack backpack;

    private InventoryProvider(ItemStack backpack, ItemBackpack backpackItem) {
        this.backpack = backpack;
        inventory = new Inventory(backpackItem.getType().size);

    }

    @Override
    public ListNBT serializeNBT() {
        ListNBT list = new ListNBT();
        for (int i = 0; i < inventory.getSizeInventory(); i++)
            list.add(inventory.getStackInSlot(i).serializeNBT());
        return list;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(@Nonnull Inventory inventory) {
        this.inventory = Preconditions.checkNotNull(inventory);
    }
    
    public void save() {
        SimpleBackpacks.LOG.debug("Saving InventoryProvider with the following ItemStack");
        SimpleBackpacks.LOG.debug(backpack.toString());
        if(!backpack.hasTag())
            backpack.setTag(new CompoundNBT());
        
        CompoundNBT current = backpack.getTag();
        current.put("inventory", serializeNBT());
    }

    @Override
    public void deserializeNBT(ListNBT nbt) {
        if (nbt == null)
            return;
        for (int i = 0; i < nbt.size(); i++) {
            inventory.setInventorySlotContents(i, ItemStack.read(nbt.getCompound(i)));
        }
    }

    public static InventoryProvider getProviderFromStack(ItemStack stack) {
        Preconditions.checkNotNull(stack);
        Item item = stack.getItem();
        if (!(item instanceof ItemBackpack))
            return null;
        ItemBackpack backpack = (ItemBackpack) item;
        InventoryProvider provider = new InventoryProvider(stack, backpack);
        provider.deserializeNBT(stack.getTag().getList("inventory", 10));
        return provider;
    }

    public static InventoryProvider createEmptyInventoryProvider(BackpackType type) {
        switch(type) {
            case DIAMOND: {
                ItemDiamondBackpack diamondBackpack = BackpackItems.DIAMOND_BACKPACK.get();
                return new InventoryProvider(new ItemStack(diamondBackpack, 1), diamondBackpack);
            }
            case GOLD:{
                ItemGoldBackpack goldBackpack = BackpackItems.GOLD_BACKPACK.get();
                return new InventoryProvider(new ItemStack(goldBackpack, 1), goldBackpack);
            }
            case IRON:{
                ItemIronBackpack ironBackpack = BackpackItems.IRON_BACKPACK.get();
                return new InventoryProvider(new ItemStack(ironBackpack, 1), ironBackpack);
            }
            case LEATHER:{
                ItemLeatherBackpack leatherBackpack = BackpackItems.LEATHER_BACKPACK.get();
                return new InventoryProvider(new ItemStack(leatherBackpack, 1), leatherBackpack);
            }
            default:
                throw new IllegalArgumentException("Unknown type: " + type.getName());
            
        }
    }
}
