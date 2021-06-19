package com.zook.devtechlib.api.recipes.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.gui.resources.TextureArea;
import net.minecraft.util.ResourceLocation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.devtech.TextureArea")
@ZenRegister
public class CTTextureArea {
    private final TextureArea inner;
    public CTTextureArea(TextureArea inner) {
        this.inner = inner;
    }

    public TextureArea getInternal() {
        return this.inner;
    }

    @ZenMethod
    public CTTextureArea getSubArea(double offsetX, double offsetY, double width, double height) {
        return new CTTextureArea(inner.getSubArea(offsetX, offsetY, width, height));
    }

    @ZenMethod
    static CTTextureArea areaOfImage(String imageLocation, int imageSizeX, int imageSizeY, int u, int v, int width, int height) {
        return new CTTextureArea(TextureArea.areaOfImage(imageLocation, imageSizeX, imageSizeY, u, v, width, height));
    }

    @ZenMethod
    static CTTextureArea fullImage(String imageLocation) {
        return new CTTextureArea(new TextureArea(new ResourceLocation(imageLocation), 0, 0, 1, 1));
    }
}
