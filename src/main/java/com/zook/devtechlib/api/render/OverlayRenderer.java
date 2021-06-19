package com.zook.devtechlib.api.render;

import com.zook.devtechlib.api.render.constants.ConstantOverlayFace;
import crafttweaker.annotations.ZenRegister;
import gregtech.api.render.OrientedOverlayRenderer;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;


@ZenClass("mods.devtech.OverlayRenderer")
@ZenRegister
public class OverlayRenderer {
    private final OrientedOverlayRenderer inner;
    public OverlayRenderer(String name, OrientedOverlayRenderer.OverlayFace... faces) {
        this.inner = new OrientedOverlayRenderer(name, faces);
    }

    public OverlayRenderer(OrientedOverlayRenderer renderer) {
        this.inner = renderer;
    }

    public OrientedOverlayRenderer getInternal() {
        return this.inner;
    }

    @ZenMethod
    static OverlayRenderer create(String path, ConstantOverlayFace... faces) {
        OrientedOverlayRenderer.OverlayFace[] arr = new OrientedOverlayRenderer.OverlayFace[faces.length];
        for (int i = 0; i < faces.length; i++) {
            arr[i] = faces[i].getInternal();
        }
        return new OverlayRenderer(path, arr);
    }
}
