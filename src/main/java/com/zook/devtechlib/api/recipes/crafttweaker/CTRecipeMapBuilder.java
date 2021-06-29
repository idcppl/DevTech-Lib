package com.zook.devtechlib.api.recipes.crafttweaker;

import com.zook.devtechlib.api.recipes.crafttweaker.constants.ConstantMoveType;
import crafttweaker.annotations.ZenRegister;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.BlastRecipeBuilder;
import gregtech.api.recipes.builders.IntCircuitRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ZenClass("mods.devtech.RecipeMapBuilder")
@ZenRegister
public class CTRecipeMapBuilder {
    private final String name;
    private int minInputs = 0;
    private int maxInputs = 0;
    private int minOutputs = 0;
    private int maxOutputs = 0;
    private int minFluidInputs = 0;
    private int maxFluidInputs = 0;
    private int minFluidOutputs = 0;
    private int maxFluidOutputs = 0;
    private boolean ifSo = false;
    private ProgressWidget.MoveType move;
    private TextureArea progressBar;
    private final List<CTOverlaySlot> overlay = new ArrayList<>();

    public CTRecipeMapBuilder(String name) {
        this.name = name;
    }

    @ZenMethod
    public static CTRecipeMapBuilder create(String name) {
        return new CTRecipeMapBuilder(name);
    }

    @ZenMethod
    public static CTRecipeMapBuilder create(String name, int minInputs, int maxInputs, int minOutputs, int maxOutputs, int minFluidInputs, int maxFluidInputs, int minFluidOutputs, int maxFluidOutputs) {
        return create(name)
                .minInputs(minInputs)
                .maxInputs(maxInputs)
                .minOutputs(minOutputs)
                .maxOutputs(maxOutputs)
                .minFluidInputs(minFluidInputs)
                .maxFluidInputs(maxFluidInputs)
                .minFluidOutputs(minFluidOutputs)
                .maxFluidOutputs(maxFluidOutputs);
    }

    @ZenMethod
    public CTRecipeMapBuilder minInputs(int min) {
        minInputs = min;
        return this;
    }

    @ZenMethod
    public CTRecipeMapBuilder maxInputs(int max) {
        maxInputs = max;
        return this;
    }

    @ZenMethod
    public CTRecipeMapBuilder minOutputs(int min) {
        minOutputs = min;
        return this;
    }

    @ZenMethod
    public CTRecipeMapBuilder maxOutputs(int max) {
        maxOutputs = max;
        return this;
    }

    @ZenMethod
    public CTRecipeMapBuilder minFluidInputs(int min) {
        minFluidInputs = min;
        return this;
    }

    @ZenMethod
    public CTRecipeMapBuilder maxFluidInputs(int max) {
        maxFluidInputs = max;
        return this;
    }

    @ZenMethod
    public CTRecipeMapBuilder minFluidOutputs(int min) {
        minFluidOutputs = min;
        return this;
    }

    @ZenMethod
    public CTRecipeMapBuilder maxFluidOutputs(int max) {
        maxFluidOutputs = max;
        return this;
    }

    @ZenMethod
    public CTRecipeMapBuilder setOverlaySlots(CTOverlaySlot... overlaySlots) {
        overlay.addAll(Arrays.asList(overlaySlots));
        return this;
    }

    @ZenMethod
    public CTRecipeMapBuilder setProgressBar(CTTextureArea texture, ConstantMoveType type) {
        progressBar = texture.getInternal();
        move = type.getInternal();
        ifSo = true;
        return this;
    }

    @ZenMethod
    public RecipeMap<?> build() {
        RecipeMap<?> recipeMap = new RecipeMap<>(name,
                minInputs,
                maxInputs,
                minOutputs,
                maxOutputs,
                minFluidInputs,
                maxFluidInputs,
                minFluidOutputs,
                maxFluidOutputs, new SimpleRecipeBuilder());
        for (CTOverlaySlot iOverlaySlots : overlay) {
            recipeMap.setSlotOverlay(iOverlaySlots.getOutput(), iOverlaySlots.getFluid(), iOverlaySlots.getLast(), iOverlaySlots.getTextureArea());
            if(iOverlaySlots.getBoth()) {
                recipeMap.setSlotOverlay(iOverlaySlots.getOutput(), iOverlaySlots.getFluid(), true, iOverlaySlots.getTextureArea());
            }
        }
        if(ifSo) {
            recipeMap.setProgressBar(progressBar, move);
        }
        return recipeMap;
    }

    @ZenMethod
    public RecipeMap<?> build(CTRecipeBuilder<?> builder) {
        RecipeMap<?> recipeMap = new RecipeMap<>(name,
                minInputs,
                maxInputs,
                minOutputs,
                maxOutputs,
                minFluidInputs,
                maxFluidInputs,
                minFluidOutputs,
                maxFluidOutputs, new SimpleRecipeBuilder());
        for (CTOverlaySlot iOverlaySlots : overlay) {
            recipeMap.setSlotOverlay(iOverlaySlots.getOutput(), iOverlaySlots.getFluid(), iOverlaySlots.getLast(), iOverlaySlots.getTextureArea());
            if(iOverlaySlots.getBoth()) {
                recipeMap.setSlotOverlay(iOverlaySlots.getOutput(), iOverlaySlots.getFluid(), true, iOverlaySlots.getTextureArea());
            }
        }
        if(ifSo) {
            recipeMap.setProgressBar(progressBar, move);
        }
        return recipeMap;
    }
}
