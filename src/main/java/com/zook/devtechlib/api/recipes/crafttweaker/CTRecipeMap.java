package com.zook.devtechlib.api.recipes.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.recipes.RecipeMap;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenExpansion("mods.gregtech.recipe.RecipeMap")
@ZenRegister
public class CTRecipeMap {
    @ZenMethod
    public static CTRecipeCreator build(RecipeMap<?> map) {
        return new CTRecipeCreator(map.recipeBuilder());
    }
}
