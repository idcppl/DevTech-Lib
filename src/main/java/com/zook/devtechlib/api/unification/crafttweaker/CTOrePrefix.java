package com.zook.devtechlib.api.unification.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.unification.material.MaterialIconType;
import gregtech.api.unification.material.type.DustMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.loaders.oreprocessing.OreRecipeHandler;
import net.minecraftforge.common.util.EnumHelper;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import javax.annotation.Nullable;
import java.util.function.Predicate;

@ZenClass("mods.devtech.OrePrefix")
@ZenRegister
public class CTOrePrefix {
    @Nullable
    private final OrePrefix orePrefix;

    @Nullable
    CTOrePrefix(String value, String categoryName, long materialAmount, Material material, MaterialIconType materialIconType, long flags, Predicate<Material> condition) {
        this.orePrefix = EnumHelper.addEnum(OrePrefix.class, value,
                new Class[]{String.class, long.class, Material.class, MaterialIconType.class, long.class, Predicate.class},
                categoryName, materialAmount, material, materialIconType, flags, condition);
    }

    CTOrePrefix(@Nullable OrePrefix orePrefix) {
        this.orePrefix = orePrefix;
    }

    @ZenMethod
    public static CTOrePrefix createOrePrefix(String value, String materialIconType, long flags, CTMaterialPredicate condition) {
        return new CTOrePrefix(value, "Do I Really Need a Name?", -1, null, CTMaterialIconType.createMaterialIconType(materialIconType).getInternal(), flags, condition::test);
    }

    @ZenMethod
    public static CTOrePrefix createOrePrefix(String value, CTMaterialIconType materialIconType, long flags, CTMaterialPredicate condition) {
        return new CTOrePrefix(value, "Do I Really Need a Name?", -1, null, materialIconType.getInternal(), flags, condition::test);
    }

    @ZenMethod
    public static CTOrePrefix get(String value) {
        return new CTOrePrefix(OrePrefix.valueOf(value));
    }

    @ZenMethod
    public void registerRecipes() {
        if(orePrefix != null) {
            orePrefix.addProcessingHandler(DustMaterial.class, OreRecipeHandler::processOre);
        }
    }

    @Nullable
    public OrePrefix getInternal() {
        return this.orePrefix;
    }
}
