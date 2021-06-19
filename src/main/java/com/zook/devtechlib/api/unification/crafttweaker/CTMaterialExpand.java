package com.zook.devtechlib.api.unification.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.unification.crafttweaker.CTMaterialCasting;
import gregtech.api.unification.material.type.*;
import stanhebben.zenscript.annotations.ZenCaster;
import stanhebben.zenscript.annotations.ZenExpansion;

@ZenExpansion("mods.gregtech.material.Material")
@ZenRegister
public class CTMaterialExpand {
    @ZenCaster
    public FluidMaterial asFluid(Material self) {
        return CTMaterialCasting.toFluid(self);
    }

    @ZenCaster
    public DustMaterial asDust(Material self) {
        return CTMaterialCasting.toDust(self);
    }

    @ZenCaster
    public SolidMaterial asSolid(Material self) {
        return CTMaterialCasting.toSolid(self);
    }

    @ZenCaster
    public IngotMaterial asIngot(Material self) {
        return CTMaterialCasting.toIngot(self);
    }

    @ZenCaster
    public GemMaterial asGem(Material self) {
        return CTMaterialCasting.toGem(self);
    }

    @ZenCaster
    public RoughSolidMaterial asRoughSolid(Material self) {
        return CTMaterialCasting.toRoughSolid(self);
    }
}
