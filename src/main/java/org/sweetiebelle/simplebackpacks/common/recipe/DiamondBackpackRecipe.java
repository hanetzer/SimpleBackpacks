package org.sweetiebelle.simplebackpacks.common.recipe;

import org.sweetiebelle.simplebackpacks.common.BackpackType;
import org.sweetiebelle.simplebackpacks.common.inventory.InventoryProvider;
import org.sweetiebelle.simplebackpacks.common.item.BackpackItems;
import org.sweetiebelle.simplebackpacks.common.item.ItemBackpack;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags.Items;

public class DiamondBackpackRecipe extends SpecialRecipe {

    public DiamondBackpackRecipe(ResourceLocation idIn) {
        super(idIn);
        Recipes.RECIPES.put(idIn, this);
    }

    @Override
    public ItemStack getCraftingResult(CraftingInventory matrix) {
        ItemStack stack = matrix.getStackInSlot(4);
        Item item = stack.getItem();
        if (!(item instanceof ItemBackpack) && !((ItemBackpack) item).getBackpackType().equals(BackpackType.GOLD))
            return ItemStack.EMPTY;
        ItemStack upgraded = getRecipeOutput();
        InventoryProvider.getProviderFromStack(stack).setItemStack(upgraded);
        return upgraded;
    }

    @Override
    public boolean matches(CraftingInventory inv, World worldIn) {
        if (!Items.GEMS_DIAMOND.contains(inv.getStackInSlot(0).getItem()))
            return false;
        if (!Items.CHESTS.contains(inv.getStackInSlot(1).getItem()))
            return false;
        if (!Items.GEMS_DIAMOND.contains(inv.getStackInSlot(2).getItem()))
            return false;
        if (!Items.GEMS_DIAMOND.contains(inv.getStackInSlot(3).getItem()))
            return false;
        Item item = inv.getStackInSlot(4).getItem();
        if (!(item instanceof ItemBackpack) && !((ItemBackpack) item).getBackpackType().equals(BackpackType.GOLD))
            return false;
        if (!Items.GEMS_DIAMOND.contains(inv.getStackInSlot(5).getItem()))
            return false;
        if (!Items.GEMS_DIAMOND.contains(inv.getStackInSlot(6).getItem()))
            return false;
        if (!Items.GEMS_DIAMOND.contains(inv.getStackInSlot(7).getItem()))
            return false;
        if (!Items.GEMS_DIAMOND.contains(inv.getStackInSlot(8).getItem()))
            return false;
        return true;
    }
    
    @Override
    public boolean isDynamic() {
        return false;
    }

    @Override
    public boolean canFit(int width, int height) {
        return width >= 3 && height >= 3;
    }

    @Override
    public IRecipeSerializer<DiamondBackpackRecipe> getSerializer() {
        return Recipes.DIAMOND_BACKPACK.get();
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(BackpackItems.DIAMOND_BACKPACK.get(), 1, new CompoundNBT());
    }

}
