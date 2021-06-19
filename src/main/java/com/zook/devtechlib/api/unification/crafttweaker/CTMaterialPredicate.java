package com.zook.devtechlib.api.unification.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.unification.material.type.*;
import stanhebben.zenscript.annotations.*;

import javax.annotation.Nonnull;

@FunctionalInterface
@ZenClass("mods.devtech.MaterialPredicate")
@ZenRegister
public interface CTMaterialPredicate {
    @ZenMethod
    @ZenOperator(OperatorType.CONTAINS)
    boolean test(Material mat);

    @Nonnull
    @ZenMethod
    @ZenOperator(OperatorType.OR)
    default CTMaterialPredicate or(@Nonnull CTMaterialPredicate other) {
        return t -> test(t) || other.test(t);
    }

    @Nonnull
    @ZenMethod
    @ZenOperator(OperatorType.NEG)
    default CTMaterialPredicate negate() {
        return t -> !test(t);
    }

    @Nonnull
    @ZenMethod
    @ZenOperator(OperatorType.AND)
    default CTMaterialPredicate and(@Nonnull CTMaterialPredicate other) {
        return t -> test(t) && other.test(t);
    }

    @ZenProperty CTMaterialPredicate isFluid = mat -> mat instanceof FluidMaterial;
    @ZenProperty CTMaterialPredicate isDust = mat -> mat instanceof DustMaterial;
    @ZenProperty CTMaterialPredicate isSolid = mat -> mat instanceof SolidMaterial;
    @ZenProperty CTMaterialPredicate isGem = mat -> mat instanceof GemMaterial;
    @ZenProperty CTMaterialPredicate isIngot = mat -> mat instanceof IngotMaterial;

    @ZenMethod
    static CTMaterialPredicate hasFlag(String flag) {
        return mat -> mat.hasFlag(flag);
    }
}
