package com.zook.devtechlib.common;

import com.zook.devtechlib.DevTechLib;
import com.zook.devtechlib.api.unification.material.SimpleFluidMaterial;
import gregtech.api.util.GTUtility;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import java.util.HashMap;
import java.util.Map;

public class DTLFluids {
    private static final Map<String, SimpleFluidMaterial> simpleFluid = new HashMap<>();

    public static void registerSprites(TextureMap textureMap) {
        textureMap.registerSprite(new ResourceLocation(DevTechLib.MODID, "blocks/fluids/fluid.liquid"));
        textureMap.registerSprite(new ResourceLocation(DevTechLib.MODID, "blocks/fluids/fluid.smooth"));
        textureMap.registerSprite(new ResourceLocation(DevTechLib.MODID, "blocks/fluids/fluid.lava"));
        textureMap.registerSprite(new ResourceLocation(DevTechLib.MODID, "blocks/fluids/fluid.powder"));
        textureMap.registerSprite(new ResourceLocation(DevTechLib.MODID, "blocks/fluids/fluid.molten"));
    }

    public static void init() {
        for (SimpleFluidMaterial fluidMat : SimpleFluidMaterial.DTL_FLUIDS.values()) {
            Fluid fluid = new Fluid(fluidMat.name, fluidMat.fluidTexture.still, fluidMat.fluidTexture.flowing, GTUtility.convertRGBtoOpaqueRGBA_MC(fluidMat.color));
            fluid.setTemperature(fluidMat.temperature);
            if (!FluidRegistry.isFluidRegistered(fluid.getName())) {
                FluidRegistry.registerFluid(fluid);
                FluidRegistry.addBucketForFluid(fluid);
                fluidMat.fluid = fluid;
            } else {
                if (!FluidRegistry.hasBucket(FluidRegistry.getFluid(fluid.getName()))) {
                    FluidRegistry.addBucketForFluid(fluid);
                }
                fluidMat.fluid = FluidRegistry.getFluid(fluid.getName());
            }
            simpleFluid.put(fluidMat.fluid.getName(), fluidMat);
        }
    }
    public static SimpleFluidMaterial getSimpleFluid(Fluid fluid) {
        return simpleFluid.get(fluid.getName());
    }
}