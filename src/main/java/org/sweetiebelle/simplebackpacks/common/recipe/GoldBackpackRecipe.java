package org.sweetiebelle.simplebackpacks.common.recipe;

import org.sweetiebelle.simplebackpacks.SimpleBackpacks;
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

public class GoldBackpackRecipe extends SpecialRecipe {

    public GoldBackpackRecipe(ResourceLocation idIn) {
        super(idIn);
        Recipes.RECIPES.put(idIn, this);
    }

    @Override
    public ItemStack getCraftingResult(CraftingInventory matrix) {
        ItemStack stack = matrix.getStackInSlot(4);
        SimpleBackpacks.LOG.debug(stack.toString());
        Item item = stack.getItem();
        if (!(item instanceof ItemBackpack) && !((ItemBackpack) item).getBackpackType().equals(BackpackType.IRON))
            return ItemStack.EMPTY;
        ItemStack upgraded = getRecipeOutput();
        InventoryProvider.getProviderFromStack(stack).setItemStack(upgraded);
        return upgraded;
    }

    @Override
    public boolean matches(CraftingInventory inv, World worldIn) {
        if (!Items.INGOTS_GOLD.contains(inv.getStackInSlot(0).getItem()))
            return false;
        if (!Items.CHESTS.contains(inv.getStackInSlot(1).getItem()))
            return false;
        if (!Items.INGOTS_GOLD.contains(inv.getStackInSlot(2).getItem()))
            return false;
        if (!Items.INGOTS_GOLD.contains(inv.getStackInSlot(3).getItem()))
            return false;
        Item item = inv.getStackInSlot(4).getItem();
        if (!(item instanceof ItemBackpack) && !((ItemBackpack) item).getBackpackType().equals(BackpackType.IRON))
            return false;
        if (!Items.INGOTS_GOLD.contains(inv.getStackInSlot(5).getItem()))
            return false;
        if (!Items.INGOTS_GOLD.contains(inv.getStackInSlot(6).getItem()))
            return false;
        if (!Items.INGOTS_GOLD.contains(inv.getStackInSlot(7).getItem()))
            return false;
        if (!Items.INGOTS_GOLD.contains(inv.getStackInSlot(8).getItem()))
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
    public IRecipeSerializer<GoldBackpackRecipe> getSerializer() {
        return Recipes.GOLD_BACKPACK.get();
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(BackpackItems.GOLD_BACKPACK.get(), 1, new CompoundNBT());
    }

}
