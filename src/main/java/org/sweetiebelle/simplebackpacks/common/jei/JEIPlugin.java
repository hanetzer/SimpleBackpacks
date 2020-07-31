package org.sweetiebelle.simplebackpacks.common.jei;

import org.sweetiebelle.simplebackpacks.SimpleBackpacks;
import org.sweetiebelle.simplebackpacks.common.recipe.Recipes;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    
    public JEIPlugin() {
        
    }
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(SimpleBackpacks.MODID, "jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(Recipes.RECIPES.values(), VanillaRecipeCategoryUid.CRAFTING);
    }
}
