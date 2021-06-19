package com.zook.devtechlib.api.unification.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.unification.material.MaterialIconType;
import net.minecraftforge.common.util.EnumHelper;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.devtech.MaterialIconType")
@ZenRegister
public class CTMaterialIconType {
    private final MaterialIconType materialIconType;
    CTMaterialIconType(String value) {
        this.materialIconType = EnumHelper.addEnum(MaterialIconType.class, value,
                new Class[]{});
    }

    CTMaterialIconType(MaterialIconType value) {
        this.materialIconType = value;
    }

    @ZenMethod
    public static CTMaterialIconType createMaterialIconType(String value) {
        return new CTMaterialIconType(value);
    }

    @ZenMethod
    public static CTMaterialIconType get(String name) {
        return new CTMaterialIconType(MaterialIconType.valueOf(name));
    }

    public MaterialIconType getInternal() {
        return this.materialIconType;
    }
}
