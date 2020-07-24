package org.sweetiebelle.ironbackpacks.common.inventory;

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
	private final BackpackTypes backpackType;

	public static BackpackContainer createLeatherContainer(int windowId, PlayerInventory playerInventory) {
		return new BackpackContainer(BackpackContainerTypes.LEATHER_BACKPACK.get(), windowId, playerInventory,
				new Inventory(BackpackTypes.LEATHER.size), BackpackTypes.LEATHER);
	}

	public static BackpackContainer createIronContainer(int windowId, PlayerInventory playerInventory) {
		return new BackpackContainer(BackpackContainerTypes.IRON_BACKPACK.get(), windowId, playerInventory,
				new Inventory(BackpackTypes.IRON.size), BackpackTypes.IRON);
	}

	public static BackpackContainer createGoldContainer(int windowId, PlayerInventory playerInventory) {
		return new BackpackContainer(BackpackContainerTypes.GOLD_BACKPACK.get(), windowId, playerInventory,
				new Inventory(BackpackTypes.GOLD.size), BackpackTypes.GOLD);
	}

	public static BackpackContainer createDiamondContainer(int windowId, PlayerInventory playerInventory) {
		return new BackpackContainer(BackpackContainerTypes.DIAMOND_BACKPACK.get(), windowId, playerInventory,
				new Inventory(BackpackTypes.DIAMOND.size), BackpackTypes.DIAMOND);
	}

	public BackpackContainer(ContainerType<? extends Object> containerType, int windowId,
			PlayerInventory playerInventory, IInventory inventory, BackpackTypes backpackType) {
		super(containerType, windowId);
		assertInventorySize(inventory, backpackType.size);

		this.inventory = inventory;
		this.backpackType = backpackType;

		inventory.openInventory(playerInventory.player);

		for (int chestRow = 0; chestRow < backpackType.getRowCount(); chestRow++) {
			for (int chestCol = 0; chestCol < backpackType.rowLength; chestCol++) {
				this.addSlot(new Slot(inventory, chestCol + chestRow * backpackType.rowLength, 12 + chestCol * 18,
						18 + chestRow * 18));
			}
		}
		int leftCol = (backpackType.xSize - 162) / 2 + 1;

		for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++) {
			for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++) {
				this.addSlot(new Slot(playerInventory, playerInvCol + playerInvRow * 9 + 9, leftCol + playerInvCol * 18,
						backpackType.ySize - (4 - playerInvRow) * 18 - 10));
			}

		}

		for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++) {
			this.addSlot(new Slot(playerInventory, hotbarSlot, leftCol + hotbarSlot * 18, backpackType.ySize - 24));
		}
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return this.inventory.isUsableByPlayer(playerIn);
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (index < this.backpackType.size) {
				if (!this.mergeItemStack(itemstack1, this.backpackType.size, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, this.backpackType.size, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}

	@Override
	public void onContainerClosed(PlayerEntity playerIn) {
		super.onContainerClosed(playerIn);
		this.inventory.closeInventory(playerIn);
	}

	@OnlyIn(Dist.CLIENT)
	public BackpackTypes getChestType() {
		return this.backpackType;
	}

}
