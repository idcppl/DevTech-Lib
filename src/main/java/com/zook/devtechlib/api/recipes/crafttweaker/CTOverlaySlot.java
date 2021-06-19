package com.zook.devtechlib.api.recipes.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.gui.resources.TextureArea;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.devtech.OverlaySlot")
@ZenRegister
public class CTOverlaySlot {
    private final boolean output;
    private final boolean fluid;
    private final boolean last;
    private final TextureArea textureArea;
    private final boolean both;
    public CTOverlaySlot(boolean isOutput, boolean isFluid, boolean isLast, TextureArea texture, boolean isBoth) {
        output = isOutput;
        fluid = isFluid;
        last = isLast;
        textureArea = texture;
        both = isBoth;
    }

    @ZenMethod
    public static CTOverlaySlot create(boolean isOutput, boolean isFluid, boolean isLast, CTTextureArea texture) {
        return new CTOverlaySlot(isOutput, isFluid, isLast, texture.getInternal(), false);
    }

    @ZenMethod
    public static CTOverlaySlot create(boolean isOutput, boolean isFluid, CTTextureArea texture) {
        return new CTOverlaySlot(isOutput, isFluid, false, texture.getInternal(), true);
    }

    public boolean getOutput() {
        return output;
    }

    public boolean getFluid() {
        return fluid;
    }

    public boolean getLast() {
        return last;
    }

    public TextureArea getTextureArea() {
        return textureArea;
    }

    public boolean getBoth() {
        return both;
    }
}
