package com.zook.devtechlib.api.unification.material;

import com.google.common.collect.ImmutableList;
import com.zook.devtechlib.DevTechLib;
import gregtech.api.unification.stack.MaterialStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.HashMap;
import java.util.Map;

public class SimpleFluidMaterial extends SimpleMaterial {
    public static Map<String, SimpleFluidMaterial> DTL_FLUIDS = new HashMap<>();
    public FluidTextures fluidTexture;
    public int temperature;
    public Fluid fluid;
    public String materialComponents;
    public String chemicalFormula;

    public SimpleFluidMaterial(String name, int color, FluidTextures texture) {
        this(name, color, 300, texture);
    }

    public SimpleFluidMaterial(String name, int color, ImmutableList<MaterialStack> materialComponents, FluidTextures texture) {
        this(name, color, 300, texture);
        this.materialComponents = calculateChemicalFormula(materialComponents);
    }

    public SimpleFluidMaterial(String name, int color, String materialComponents, FluidTextures texture) {
        this(name, color, 300, texture);
        this.materialComponents = materialComponents;
    }

    public SimpleFluidMaterial(String name, int color, int temperature, FluidTextures texture) {
        this.name = name;
        this.color = color;
        this.temperature = temperature;
        this.chemicalFormula = calculateChemicalFormula();
        this.fluidTexture = texture;
        DTL_FLUIDS.put(name, this);
    }

    public FluidStack getFluid(int amount) {
        return new FluidStack(fluid, amount);
    }

    private String calculateChemicalFormula() {
        if (materialComponents != null) {
            return materialComponents;
        }
        return "";
    }

    public enum FluidTextures {
        liquid(new ResourceLocation(DevTechLib.MODID, "blocks/fluids/fluid.liquid"), new ResourceLocation(DevTechLib.MODID, "blocks/fluids/fluid.liquid")),
        smooth(new ResourceLocation(DevTechLib.MODID, "blocks/fluids/fluid.smooth"), new ResourceLocation(DevTechLib.MODID, "blocks/fluids/fluid.smooth")),
        molten(new ResourceLocation(DevTechLib.MODID, "blocks/fluids/fluid.molten"), new ResourceLocation(DevTechLib.MODID, "blocks/fluids/fluid.molten")),
        lava(new ResourceLocation(DevTechLib.MODID, "blocks/fluids/fluid.lava"), new ResourceLocation(DevTechLib.MODID, "blocks/fluids/fluid.lava")),
        powder(new ResourceLocation(DevTechLib.MODID, "blocks/fluids/fluid.powder"), new ResourceLocation(DevTechLib.MODID, "blocks/fluids/fluid.powder"));
        public ResourceLocation flowing;
        public ResourceLocation still;

        FluidTextures(ResourceLocation still, ResourceLocation flowing) {
            this.still = still;
            this.flowing = flowing;
        }

        public ResourceLocation getStill() {
            return still;
        }

        public ResourceLocation getFlowing() {
            return flowing;
        }
    }
}