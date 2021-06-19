package com.zook.devtechlib.api.unification.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.unification.Element;
import net.minecraftforge.common.util.EnumHelper;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ZenExpansion("mods.gregtech.material.Element")
@ZenRegister
public class CTElement {
    @ZenMethodStatic
    public static Element create(String value, long protons, long neutrons, long halfLifeSeconds, String decayTo, String name, boolean isIsotope) {
        return EnumHelper.addEnum(Element.class, value,
                new Class[]{long.class, long.class, long.class, String.class, String.class, boolean.class},
                protons, neutrons, halfLifeSeconds, decayTo, name, isIsotope);
    }
}
