package com.zook.devtechlib.api.metatileentities.crafttweaker;

import com.zook.devtechlib.DevTechLib;
import com.zook.devtechlib.api.render.OverlayRenderer;
import crafttweaker.annotations.ZenRegister;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.SimpleGeneratorMetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.machines.FuelRecipeMap;
import gregtech.api.unification.material.type.SolidMaterial;
import gregtech.common.metatileentities.electric.MetaTileEntityMacerator;
import gregtech.common.metatileentities.storage.MetaTileEntityChest;
import gregtech.common.metatileentities.storage.MetaTileEntityQuantumChest;
import gregtech.common.metatileentities.storage.MetaTileEntityQuantumTank;
import gregtech.common.metatileentities.storage.MetaTileEntityTank;
import net.minecraft.util.ResourceLocation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.devtech.Machine")
@ZenRegister
public class CTMachine {
    @ZenMethod
    public static void createSimpleMachine(int id, String nameID, RecipeMap<?> recipeMap, OverlayRenderer renderer, int tier) {
        GregTechAPI.registerMetaTileEntity(id, new SimpleMachineMetaTileEntity(new ResourceLocation(DevTechLib.MODID, nameID), recipeMap, renderer.getInternal(), tier));
    }

    @ZenMethod
    public static void createSimpleGenerator(int id, String nameID, FuelRecipeMap fuelRecipeMap, OverlayRenderer renderer, int tier) {
        GregTechAPI.registerMetaTileEntity(id, new SimpleGeneratorMetaTileEntity(new ResourceLocation(DevTechLib.MODID, nameID), fuelRecipeMap, renderer.getInternal(), tier));
    }

    @ZenMethod
    public static void createMacerator(int id, String nameID, RecipeMap<?> recipeMap, OverlayRenderer renderer, int tier, int outputAmount) {
        GregTechAPI.registerMetaTileEntity(id, new MetaTileEntityMacerator(new ResourceLocation(DevTechLib.MODID, nameID), recipeMap, outputAmount, renderer.getInternal(), tier));
    }

    @ZenMethod
    public static void createChest(int id, String nameID, SolidMaterial material, int rowSize, int amountRows) {
        GregTechAPI.registerMetaTileEntity(id, new MetaTileEntityChest(new ResourceLocation(DevTechLib.MODID, nameID), material, rowSize, amountRows));
    }

    @ZenMethod
    public static void createTank(int id, String nameID, SolidMaterial material, int tankSize, int maxSizeVertical, int maxSizeHorizontal) {
        GregTechAPI.registerMetaTileEntity(id, new MetaTileEntityTank(new ResourceLocation(DevTechLib.MODID, nameID), material, tankSize, maxSizeVertical, maxSizeHorizontal));
    }

    @ZenMethod
    public static void createQuantumChest(int id, String nameID, int tier, long storage) {
        GregTechAPI.registerMetaTileEntity(id, new MetaTileEntityQuantumChest(new ResourceLocation(DevTechLib.MODID, nameID), tier, storage));
    }

    @ZenMethod
    public static void createQuantumTank(int id, String nameID, int tier, int storage) {
        GregTechAPI.registerMetaTileEntity(id, new MetaTileEntityQuantumTank(new ResourceLocation(DevTechLib.MODID, nameID), tier, storage));
    }
}
