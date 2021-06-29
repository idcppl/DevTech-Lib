package com.zook.devtechlib.api.recipes.crafttweaker.constants;

import com.zook.devtechlib.api.recipes.crafttweaker.CTRecipeBuilder;
import crafttweaker.annotations.ZenRegister;
import gregtech.api.recipes.builders.*;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenClass("mods.devtech.RecipeBuilders")
@ZenRegister
public class ConstantRecipeBuilder {
    @ZenProperty public static final CTRecipeBuilder<SimpleRecipeBuilder> SIMPLE_RECIPE_BUILDER = new CTRecipeBuilder<>(new SimpleRecipeBuilder());
    @ZenProperty public static final CTRecipeBuilder<BlastRecipeBuilder> BLAST_RECIPE_BUILDER = new CTRecipeBuilder<>(new BlastRecipeBuilder());
    @ZenProperty public static final CTRecipeBuilder<IntCircuitRecipeBuilder> INT_CIRCUIT_RECIPE_BUILDER = new CTRecipeBuilder<>(new IntCircuitRecipeBuilder());
    @ZenProperty public static final CTRecipeBuilder<ImplosionRecipeBuilder> IMPLOSION_RECIPE_BUILDER = new CTRecipeBuilder<>(new ImplosionRecipeBuilder());
    @ZenProperty public static final CTRecipeBuilder<CutterRecipeBuilder> CUTTER_RECIPE_BUILDER = new CTRecipeBuilder<>(new CutterRecipeBuilder());
}
