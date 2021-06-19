package com.zook.devtechlib.api.unification.crafttweaker;

import com.google.common.collect.ImmutableList;
import crafttweaker.annotations.ZenRegister;
import gregtech.api.unification.Element;
import gregtech.api.unification.material.MaterialIconSet;
import gregtech.api.unification.material.type.DustMaterial;
import gregtech.api.unification.material.type.FluidMaterial;
import gregtech.api.unification.material.type.GemMaterial;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.stack.MaterialStack;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

import javax.annotation.Nullable;

@ZenExpansion("mods.gregtech.material.MaterialRegistry")
@ZenRegister
public class CTMaterialRegistry {
    private static ImmutableList<MaterialStack> validateComponentList(@Nullable MaterialStack[] components) {
        return components == null || components.length == 0 ? ImmutableList.of() : ImmutableList.copyOf(components);
    }

    @ZenMethodStatic
    public static FluidMaterial createFluidMaterial(int metaItemSubId, String name, int color, String iconSet, @Optional MaterialStack[] materialComponents, @Optional Element element) {
        return new FluidMaterial(metaItemSubId, name, color,
                MaterialIconSet.getByName(iconSet),
                validateComponentList(materialComponents), 0);
    }

    @ZenMethodStatic
    public static DustMaterial createDustMaterial(int metaItemSubId, String name, int color, String iconSet, int harvestLevel, @Optional MaterialStack[] materialComponents, @Optional Element element) {
        return new DustMaterial(metaItemSubId, name, color,
                MaterialIconSet.getByName(iconSet), harvestLevel,
                validateComponentList(materialComponents), 0, element);
    }

    @ZenMethodStatic
    public static GemMaterial createGemMaterial(int metaItemSubId, String name, int color, String iconSet, int harvestLevel, @Optional MaterialStack[] materialComponents, @Optional float toolSpeed, @Optional float attackDamage, @Optional int toolDurability, @Optional Element element) {
        return new GemMaterial(metaItemSubId, name, color,
                MaterialIconSet.getByName(iconSet), harvestLevel,
                validateComponentList(materialComponents), 0, element,
                Math.max(0.0f, toolSpeed), Math.max(0.0f, attackDamage), Math.max(0, toolDurability));
    }

    @ZenMethodStatic
    public static IngotMaterial createIngotMaterial(int metaItemSubId, String name, int color, String iconSet, int harvestLevel, @Optional MaterialStack[] materialComponents, @Optional float toolSpeed, @Optional float attackDamage, @Optional int toolDurability, @Optional int blastFurnaceTemperature, @Optional Element element) {
        return new IngotMaterial(metaItemSubId, name, color,
                MaterialIconSet.getByName(iconSet), harvestLevel,
                validateComponentList(materialComponents), 0, element,
                Math.max(0.0f, toolSpeed), Math.max(0.0f, attackDamage), Math.max(0, toolDurability), blastFurnaceTemperature);
    }
}
