package com.zook.devtechlib.api.recipes.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.recipes.RecipeBuilder;
import stanhebben.zenscript.annotations.ZenClass;

@ZenClass("mods.devtech.RecipeBuilder")
@ZenRegister
public class CTRecipeBuilder<R extends RecipeBuilder<R>> {
    private final R builder;

    public CTRecipeBuilder(R builder) {
        this.builder = builder;
    }

    public R getBuilder() {
        return builder;
    }
}
