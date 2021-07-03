package com.zook.devtechlib.api.items.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import gregtech.api.items.metaitem.stats.IItemModelIndexProvider;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@ZenClass("mods.devtech.ModelIndexProvider")
@ZenRegister
public interface CTModelIndexProvider {
    int getModelIndex(IItemStack itemStack);

    static IItemModelIndexProvider toInternal(CTModelIndexProvider provider) {
        return itemStack -> provider.getModelIndex(CraftTweakerMC.getIItemStack(itemStack));
    }
}
