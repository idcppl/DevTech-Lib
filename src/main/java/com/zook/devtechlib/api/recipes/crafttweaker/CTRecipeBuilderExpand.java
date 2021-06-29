package com.zook.devtechlib.api.recipes.crafttweaker;

import com.zook.devtechlib.api.unification.crafttweaker.CTOrePrefix;
import crafttweaker.annotations.ZenRegister;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.unification.material.type.Material;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

import java.lang.reflect.Field;

@ZenExpansion("mods.gregtech.recipe.RecipeBuilder")
@ZenRegister
public class CTRecipeBuilderExpand {
    public static Field test = ObfuscationReflectionHelper.findField(gregtech.api.recipes.crafttweaker.CTRecipeBuilder.class, "backingBuilder");

    @ZenMethod
    public static gregtech.api.recipes.crafttweaker.CTRecipeBuilder inputs(gregtech.api.recipes.crafttweaker.CTRecipeBuilder builder, CTOrePrefix orePrefix, Material material) throws IllegalAccessException {
        RecipeBuilder<?> recipe = null;
        try {
            recipe = (RecipeBuilder<?>) test.get(builder);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if(recipe != null) {
            recipe.inputs(CountableIngredient.from(orePrefix.getInternal(), material));
            return builder;
        }
        return builder;
    }
}
