package org.sweetiebelle.simplebackpacks.common.recipe;

import java.util.HashMap;
import java.util.function.Supplier;

import org.sweetiebelle.simplebackpacks.SimpleBackpacks;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Recipes {
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPES_REGISTRY = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SimpleBackpacks.MODID);
    
    public static final RegistryObject<SpecialRecipeSerializer<IronBackpackRecipe>> IRON_BACKPACK = register("crafting_iron_backpack", () -> new SpecialRecipeSerializer<IronBackpackRecipe>(IronBackpackRecipe::new));
    public static final RegistryObject<SpecialRecipeSerializer<GoldBackpackRecipe>> GOLD_BACKPACK = register("crafting_gold_backpack", () -> new SpecialRecipeSerializer<GoldBackpackRecipe>(GoldBackpackRecipe::new));
    public static final RegistryObject<SpecialRecipeSerializer<DiamondBackpackRecipe>> DIAMOND_BACKPACK = register("crafting_diamond_backpack", () -> new SpecialRecipeSerializer<DiamondBackpackRecipe>(DiamondBackpackRecipe::new));
    
    
    public static final HashMap<ResourceLocation, SpecialRecipe> RECIPES = new HashMap<ResourceLocation, SpecialRecipe>(3);
    private static final <T extends IRecipeSerializer<? extends SpecialRecipe>> RegistryObject<T> register(String name, Supplier<T> sup) {
        return RECIPES_REGISTRY.register(name, sup);
    }
    
    

}
