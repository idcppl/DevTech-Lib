package com.zook.devtechlib.api.items.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import gregtech.api.items.metaitem.stats.IItemNameProvider;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@FunctionalInterface
@ZenClass("mods.devtech.NameProvider")
@ZenRegister
public interface CTNameProvider {
    @ZenMethod
    String getItemStackDisplayName(IItemStack itemStack, String unlocalizedName);

    static IItemNameProvider toInternal(CTNameProvider provider) {
        return (itemStack, s) -> provider.getItemStackDisplayName(CraftTweakerMC.getIItemStack(itemStack), s);
    }
}
