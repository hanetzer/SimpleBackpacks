package org.sweetiebelle.simplebackpacks.common.container;

import org.sweetiebelle.simplebackpacks.common.BackpackType;
import org.sweetiebelle.simplebackpacks.common.inventory.InventoryProvider;
import org.sweetiebelle.simplebackpacks.common.item.ItemBackpack;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class BackpackContainerProvider implements INamedContainerProvider {

    private BackpackType type;
    private InventoryProvider provider;

    public BackpackContainerProvider(ItemStack stack) {
        if(!(stack.getItem() instanceof ItemBackpack))
            throw new IllegalArgumentException(stack.getItem().getClass() + " is not a ItemBackpack.");
        this.type = ((ItemBackpack) stack.getItem()).getType();
        this.provider = InventoryProvider.getProviderFromStack(stack);
    }

    @Override
    public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity player) {
        switch(type) {
            case DIAMOND:
                return BackpackContainer.createDiamondContainer(windowId, playerInventory, provider);
            case GOLD:
                return BackpackContainer.createGoldContainer(windowId, playerInventory, provider);
            case IRON:
                return BackpackContainer.createIronContainer(windowId, playerInventory, provider);
            case LEATHER:
                return BackpackContainer.createLeatherContainer(windowId, playerInventory, provider); 
            default:
                throw new IllegalStateException("Unknown backpack type: " + type);
            
        }
    }

    @Override
    public ITextComponent getDisplayName() {
        return new StringTextComponent(type.getName());
    }

}
