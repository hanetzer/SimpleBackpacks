package org.sweetiebelle.simplebackpacks.common.recipe;

import org.sweetiebelle.simplebackpacks.SimpleBackpacks;
import org.sweetiebelle.simplebackpacks.common.inventory.InventoryProvider;
import org.sweetiebelle.simplebackpacks.common.item.BackpackItems;
import org.sweetiebelle.simplebackpacks.common.item.ItemLeatherBackpack;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags.Items;

public class IronBackpackRecipe extends SpecialRecipe   {
    public IronBackpackRecipe(ResourceLocation idIn) {
        super(idIn);
        Recipes.RECIPES.put(idIn, this);
    }

    @Override
    public ItemStack getCraftingResult(CraftingInventory matrix) {
        SimpleBackpacks.LOG.debug("Now calling getCraftingResult...");
        ItemStack stack = matrix.getStackInSlot(4);
        SimpleBackpacks.LOG.debug(stack.toString());
        if (!(stack.getItem() instanceof ItemLeatherBackpack))
            return ItemStack.EMPTY;
        ItemStack upgraded = getRecipeOutput();
        InventoryProvider.getProviderFromStack(stack).setItemStack(upgraded);
        return upgraded;
    }

    @Override
    public boolean matches(CraftingInventory inv, World worldIn) {
        SimpleBackpacks.LOG.debug("Now calling matches...");
        if (!Items.INGOTS_IRON.contains(inv.getStackInSlot(0).getItem()))
            return false;
        if (!Items.CHESTS.contains(inv.getStackInSlot(1).getItem()))
            return false;
        if (!Items.INGOTS_IRON.contains(inv.getStackInSlot(2).getItem()))
            return false;
        if (!Items.INGOTS_IRON.contains(inv.getStackInSlot(3).getItem()))
            return false;
        if (!(inv.getStackInSlot(4).getItem() instanceof ItemLeatherBackpack))
            return false;
        if (!Items.INGOTS_IRON.contains(inv.getStackInSlot(5).getItem()))
            return false;
        if (!Items.INGOTS_IRON.contains(inv.getStackInSlot(6).getItem()))
            return false;
        if (!Items.INGOTS_IRON.contains(inv.getStackInSlot(7).getItem()))
            return false;
        if (!Items.INGOTS_IRON.contains(inv.getStackInSlot(8).getItem()))
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
    public IRecipeSerializer<IronBackpackRecipe> getSerializer() {
        return Recipes.IRON_BACKPACK.get();
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(BackpackItems.IRON_BACKPACK.get(), 1, new CompoundNBT());
    }

}
