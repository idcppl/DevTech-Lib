package com.zook.devtechlib.api.items.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.GTValues;
import gregtech.api.items.metaitem.ElectricStats;
import gregtech.api.items.metaitem.FluidStats;
import gregtech.api.items.metaitem.FoodStats;
import gregtech.api.items.metaitem.stats.IItemComponent;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.devtech.ItemComponent")
@ZenRegister
public class CTItemComponent {
    private final IItemComponent itemComponent;

    public CTItemComponent(IItemComponent itemComponent) {
        this.itemComponent = itemComponent;
    }

    public IItemComponent getInternal() {
        return itemComponent;
    }

    @ZenMethod
    public static CTItemComponent foodStats(int foodLevel, float saturation, boolean isDrink) {
        return new CTItemComponent(new FoodStats(foodLevel, saturation, isDrink));
    }

    @ZenMethod
    public static CTItemComponent foodStats(int foodLevel, float saturation) {
        return new CTItemComponent(new FoodStats(foodLevel, saturation));
    }
    @ZenMethod
    public static CTItemComponent electricStats(long maxCharge, int tier) {
        if(GTValues.isModLoaded("devtechgregicality") && tier >= 9) {
            throw new IllegalArgumentException("DevTech: Gregicality loaded, Please use ItemComponent#GAElectricStats when using 9+ tiers.");
        }
        return new CTItemComponent(new ElectricStats(maxCharge, tier, true, true));
    }

    @ZenMethod
    public static CTItemComponent electricStats(long maxCharge, int tier, boolean rechargeable) {
        if(GTValues.isModLoaded("devtechgregicality") && tier >= 9) {
            throw new IllegalArgumentException("DevTech: Gregicality loaded, Please use ItemComponent#GAElectricStats when using 9+ tiers.");
        }
        return new CTItemComponent(new ElectricStats(maxCharge, tier, rechargeable, true));
    }

    @ZenMethod
    public static CTItemComponent electricStats(long maxCharge, int tier, boolean rechargeable, boolean dischrgeable) {
        if(GTValues.isModLoaded("devtechgregicality") && tier >= 9) {
            throw new IllegalArgumentException("DevTech: Gregicality loaded, Please use ItemComponent#GAElectricStats when using 9+ tiers.");
        }
        return new CTItemComponent(new ElectricStats(maxCharge, tier, rechargeable, dischrgeable));
    }

    @ZenMethod
    public static CTItemComponent fluidStats(int maxCapacity, int minFluidTemperature, int maxFluidTemperature, boolean allowPartlyFill) {
        return new CTItemComponent(new FluidStats(maxCapacity, minFluidTemperature, maxFluidTemperature, allowPartlyFill));
    }

    @ZenMethod
    public static CTItemComponent fluidStats(int maxCapacity, boolean allowPartlyFill) {
        return new CTItemComponent(new FluidStats(maxCapacity, Integer.MIN_VALUE, Integer.MAX_VALUE, allowPartlyFill));
    }

    @ZenMethod
    public static CTItemComponent fluidStats(int maxCapacity) {
        return new CTItemComponent(new FluidStats(maxCapacity, Integer.MIN_VALUE, Integer.MAX_VALUE, false));
    }

    @ZenMethod
    public static CTItemComponent colorProvider(CTColorProvider colorProvider) {
        return new CTItemComponent(CTColorProvider.toInternal(colorProvider));
    }

    @ZenMethod
    public static CTItemComponent modelIndexProvider(CTModelIndexProvider modelProvider) {
        return new CTItemComponent(CTModelIndexProvider.toInternal(modelProvider));
    }

    @ZenMethod
    public static CTItemComponent nameProvider(CTNameProvider nameProvider) {
        return new CTItemComponent(CTNameProvider.toInternal(nameProvider));
    }
}
