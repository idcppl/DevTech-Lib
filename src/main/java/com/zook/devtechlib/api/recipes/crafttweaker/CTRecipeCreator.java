package com.zook.devtechlib.api.recipes.crafttweaker;

import com.zook.devtechlib.api.unification.crafttweaker.CTOrePrefix;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.material.type.Material;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * Old GTCE CTRecipeBuilder lacked depth and couldn't be expanded upon.
 */

@ZenClass("mods.devtech.RecipeCreator")
@ZenRegister
public class CTRecipeCreator {
    private final RecipeBuilder<?> backingBuilder;

    public CTRecipeCreator(RecipeBuilder<?> backingBuilder) {
        this.backingBuilder = backingBuilder;
    }

    public RecipeBuilder<?> getBackingBuilder() {
        return backingBuilder;
    }

    @ZenMethod
    public CTRecipeCreator duration(int duration) {
        this.backingBuilder.duration(duration);
        return this;
    }

    @ZenMethod
    public CTRecipeCreator EUt(int EUt) {
        this.backingBuilder.EUt(EUt);
        return this;
    }

    @ZenMethod
    public CTRecipeCreator hidden() {
        this.backingBuilder.hidden();
        return this;
    }

    @ZenMethod
    public CTRecipeCreator inputs(IIngredient... ingredients) {
        for(IIngredient ingredient : ingredients) {
            this.backingBuilder.inputs(new CountableIngredient(CraftTweakerMC.getIngredient(ingredient), ingredient.getAmount()));
        }
        return this;
    }

    @ZenMethod
    public CTRecipeCreator inputs(CTOrePrefix orePrefix, Material material) {
        this.backingBuilder.inputs(CountableIngredient.from(orePrefix.getInternal(), material));
        return this;
    }

    @ZenMethod
    public CTRecipeCreator notConsumable(IIngredient ingredient) {
        this.backingBuilder.notConsumable(CraftTweakerMC.getIngredient(ingredient));
        return this;
    }

    @ZenMethod
    public CTRecipeCreator notConsumable(IIngredient... ingredients) {
        for(IIngredient ingredient : ingredients) {
            this.backingBuilder.inputs(new CountableIngredient(CraftTweakerMC.getIngredient(ingredient), 0));
        }
        return this;
    }

    @ZenMethod
    public CTRecipeCreator notConsumable(ILiquidStack ingredient) {
        this.backingBuilder.notConsumable(CraftTweakerMC.getLiquidStack(ingredient));
        return this;
    }

    @ZenMethod
    public CTRecipeCreator circuit(int num) {
        this.backingBuilder.notConsumable(IntCircuitIngredient.getIntegratedCircuit(num));
        return this;
    }

    @ZenMethod
    public CTRecipeCreator fluidInputs(ILiquidStack... ingredients) {
        for(ILiquidStack ingredient : ingredients) {
            this.backingBuilder.fluidInputs(CraftTweakerMC.getLiquidStack(ingredient));
        }
        return this;
    }

    @ZenMethod
    public CTRecipeCreator outputs(IItemStack... ingredients) {
        for(IItemStack ingredient : ingredients) {
            this.backingBuilder.outputs(CraftTweakerMC.getItemStack(ingredient));
        }
        return this;
    }

    @ZenMethod
    public CTRecipeCreator chancedOutput(IItemStack outputStack, int chanceValue, int tierChanceBoost) {
        this.backingBuilder.chancedOutput(CraftTweakerMC.getItemStack(outputStack), chanceValue, tierChanceBoost);
        return this;
    }

    @ZenMethod
    public CTRecipeCreator fluidOutputs(ILiquidStack... ingredients) {
        for(ILiquidStack ingredient : ingredients) {
            this.backingBuilder.fluidOutputs(CraftTweakerMC.getLiquidStack(ingredient));
        }
        return this;
    }

    @ZenMethod
    public CTRecipeCreator property(String key, int value) {
        boolean applied = this.backingBuilder.applyProperty(key, value);
        if (!applied) {
            throw new IllegalArgumentException("Property " +
                    key + " cannot be applied to recipe type " +
                    backingBuilder.getClass().getSimpleName());
        }
        return this;
    }

    @ZenMethod
    public CTRecipeCreator property(String key, IItemStack item) {
        boolean applied = this.backingBuilder.applyProperty(key, CraftTweakerMC.getItemStack(item));
        if (!applied) {
            throw new IllegalArgumentException("Property " +
                    key + " cannot be applied to recipe type " +
                    backingBuilder.getClass().getSimpleName() + " for Item " + CraftTweakerMC.getItemStack(item).getDisplayName());
        }
        return this;
    }

    @ZenMethod
    public void buildAndRegister() {
        this.backingBuilder.buildAndRegister();
    }
}
