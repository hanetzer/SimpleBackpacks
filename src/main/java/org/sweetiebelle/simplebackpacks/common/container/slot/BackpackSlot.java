package org.sweetiebelle.simplebackpacks.common.container.slot;

import org.sweetiebelle.simplebackpacks.common.item.ItemBackpack;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;

public class BackpackSlot extends Slot {

    public BackpackSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }
    
    @Override
    public boolean canTakeStack(final PlayerEntity player) {
        if(this.getStack().getItem() instanceof ItemBackpack)
            return false;
        return super.canTakeStack(player);
    }
    
    

}
