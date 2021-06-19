package com.zook.devtechlib.api.metatileentities;

import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.SteamMetaTileEntity;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.render.OrientedOverlayRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class SimpleSteamMetaTileEntity extends SteamMetaTileEntity {
    public SimpleSteamMetaTileEntity(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap, OrientedOverlayRenderer renderer, boolean isHighPressure) {
        super(metaTileEntityId, recipeMap, renderer, isHighPressure);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder metaTileEntityHolder) {
        return null;
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        return null;
    }
}
