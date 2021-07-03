package com.zook.devtechlib.api.items.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import gregtech.api.items.metaitem.stats.IItemColorProvider;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@FunctionalInterface
@ZenClass("mods.devtech.ColorProvider")
@ZenRegister
public interface CTColorProvider {
    @ZenMethod
    int getItemStackColor(IItemStack itemStack, int i);

    static CTColorProvider withColor(int color) {
        return (itemStack, i) -> color;
    }

    @ZenMethod
    static CTColorProvider evenWithColor(int color) {
        return (itemStack, i) -> {
            if(i % 2 == 0) {
                return color;
            } else {
                return 0xFFFFFF;
            }
        };
    }

    @ZenMethod
    static CTColorProvider oddWithColor(int color) {
        return (itemStack, i) -> {
            if(i % 2 == 1) {
                return color;
            } else {
                return 0xFFFFFF;
            }
        };
    }

    static IItemColorProvider toInternal(CTColorProvider provider) {
        return (itemStack, i) -> provider.getItemStackColor(CraftTweakerMC.getIItemStack(itemStack), i);
    }
}
