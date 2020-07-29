package org.sweetiebelle.ironbackpacks.common.container;

import org.sweetiebelle.ironbackpacks.common.BackpackType;
import org.sweetiebelle.ironbackpacks.common.inventory.InventoryProvider;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BackpackContainer extends Container {

    private final IInventory inventory;
    private final BackpackType backpackType;
    private InventoryProvider provider;

    public static BackpackContainer createLeatherContainer(int windowId, PlayerInventory playerInventory) {
        return new BackpackContainer(BackpackContainerTypes.LEATHER_BACKPACK.get(), windowId, playerInventory, InventoryProvider.createEmptyInventoryProvider(BackpackType.LEATHER), BackpackType.LEATHER);
    }

    public static BackpackContainer createLeatherContainer(int windowId, PlayerInventory playerInventory, InventoryProvider provider) {
        return new BackpackContainer(BackpackContainerTypes.LEATHER_BACKPACK.get(), windowId, playerInventory, provider, BackpackType.LEATHER);
    }

    public static BackpackContainer createIronContainer(int windowId, PlayerInventory playerInventory) {
        return new BackpackContainer(BackpackContainerTypes.IRON_BACKPACK.get(), windowId, playerInventory, InventoryProvider.createEmptyInventoryProvider(BackpackType.IRON), BackpackType.IRON);
    }

    public static BackpackContainer createIronContainer(int windowId, PlayerInventory playerInventory, InventoryProvider provider) {
        return new BackpackContainer(BackpackContainerTypes.IRON_BACKPACK.get(), windowId, playerInventory, provider, BackpackType.IRON);
    }

    public static BackpackContainer createGoldContainer(int windowId, PlayerInventory playerInventory) {
        return new BackpackContainer(BackpackContainerTypes.GOLD_BACKPACK.get(), windowId, playerInventory, InventoryProvider.createEmptyInventoryProvider(BackpackType.GOLD), BackpackType.GOLD);
    }

    public static BackpackContainer createGoldContainer(int windowId, PlayerInventory playerInventory, InventoryProvider provider) {
        return new BackpackContainer(BackpackContainerTypes.GOLD_BACKPACK.get(), windowId, playerInventory, provider, BackpackType.GOLD);
    }

    public static BackpackContainer createDiamondContainer(int windowId, PlayerInventory playerInventory) {
        return new BackpackContainer(BackpackContainerTypes.DIAMOND_BACKPACK.get(), windowId, playerInventory, InventoryProvider.createEmptyInventoryProvider(BackpackType.DIAMOND), BackpackType.DIAMOND);
    }

    public static BackpackContainer createDiamondContainer(int windowId, PlayerInventory playerInventory, InventoryProvider provider) {
        return new BackpackContainer(BackpackContainerTypes.DIAMOND_BACKPACK.get(), windowId, playerInventory, provider, BackpackType.DIAMOND);
    }

    public BackpackContainer(ContainerType<? extends BackpackContainer> containerType, int windowId, PlayerInventory playerInventory, InventoryProvider provider, BackpackType backpackType) {
        super(containerType, windowId);
        this.provider = provider;
        this.inventory = provider.getInventory();
        assertInventorySize(inventory, backpackType.size);

        this.backpackType = backpackType;

        inventory.openInventory(playerInventory.player);

        for (int chestRow = 0; chestRow < backpackType.getRowCount(); chestRow++)
            for (int chestCol = 0; chestCol < backpackType.rowLength; chestCol++)
                addSlot(new Slot(inventory, chestCol + chestRow * backpackType.rowLength, 12 + chestCol * 18, 18 + chestRow * 18));
        int leftCol = (backpackType.xSize - 162) / 2 + 1;

        for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++)
            for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++)
                addSlot(new Slot(playerInventory, playerInvCol + playerInvRow * 9 + 9, leftCol + playerInvCol * 18, backpackType.ySize - (4 - playerInvRow) * 18 - 10));

        for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++) {
            if (hotbarSlot == playerInventory.currentItem)
                addSlot(new Slot(playerInventory, hotbarSlot, leftCol + hotbarSlot * 18, backpackType.ySize - 24) {
                    @Override
                    public boolean canTakeStack(final PlayerEntity player) {
                        return false;
                    }
                });
            else
                addSlot(new Slot(playerInventory, hotbarSlot, leftCol + hotbarSlot * 18, backpackType.ySize - 24));
        }
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return inventory.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < backpackType.size) {
                if (!mergeItemStack(itemstack1, backpackType.size, inventorySlots.size(), true))
                    return ItemStack.EMPTY;
            } else if (!mergeItemStack(itemstack1, 0, backpackType.size, false))
                return ItemStack.EMPTY;

            if (itemstack1.isEmpty())
                slot.putStack(ItemStack.EMPTY);
            else
                slot.onSlotChanged();
        }

        return itemstack;
    }

    @Override
    public void onContainerClosed(PlayerEntity playerIn) {
        super.onContainerClosed(playerIn);
        inventory.closeInventory(playerIn);
        provider.setInventory((Inventory) inventory);
        provider.save();
        
    }

    @OnlyIn(Dist.CLIENT)
    public BackpackType getChestType() {
        return backpackType;
    }

}
