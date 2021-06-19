package com.zook.devtechlib.api.unification.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.unification.material.type.*;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.devtech.Flag")
@ZenRegister
public class CTFlag {
    @ZenMethod
    public static void create(String name, long value) {
        Material.MatFlags.registerMaterialFlag(name, value, Material.class);
    }

    @ZenMethod
    public static void createFluid(String name, long value) {
        Material.MatFlags.registerMaterialFlag(name, value, FluidMaterial.class);
    }

    @ZenMethod
    public static void createDust(String name, long value) {
        Material.MatFlags.registerMaterialFlag(name, value, DustMaterial.class);
    }

    @ZenMethod
    public static void createSolid(String name, long value) {
        Material.MatFlags.registerMaterialFlag(name, value, SolidMaterial.class);
    }

    @ZenMethod
    public static void createIngot(String name, long value) {
        Material.MatFlags.registerMaterialFlag(name, value, IngotMaterial.class);
    }

    @ZenMethod
    public static void createGem(String name, long value) {
        Material.MatFlags.registerMaterialFlag(name, value, GemMaterial.class);
    }
}
