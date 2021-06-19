package com.zook.devtechlib.api.recipes.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.recipes.machines.FuelRecipeMap;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ZenExpansion("mods.gregtech.recipe.FuelRecipeMap")
@ZenRegister
public class CTFuelRecipeMap {
    @ZenMethodStatic
    public static FuelRecipeMap build(String name) {
        return new FuelRecipeMap(name);
    }
}
