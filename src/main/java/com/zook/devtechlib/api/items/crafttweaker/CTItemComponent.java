package com.zook.devtechlib.api.items.crafttweaker;

import crafttweaker.annotations.ZenRegister;
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
    public CTItemComponent foodStats(int foodLevel, float saturation, boolean isDrink) {
        return new CTItemComponent(new FoodStats(foodLevel, saturation, isDrink));
    }

    @ZenMethod
    public CTItemComponent foodStats(int foodLevel, float saturation) {
        return new CTItemComponent(new FoodStats(foodLevel, saturation));
    }
    @ZenMethod
    public static CTItemComponent electricStats(long maxCharge, int tier) {
        return new CTItemComponent(new ElectricStats(maxCharge, tier, true, true));
    }

    @ZenMethod
    public static CTItemComponent electricStats(long maxCharge, int tier, boolean rechargeable) {
        return new CTItemComponent(new ElectricStats(maxCharge, tier, rechargeable, true));
    }

    @ZenMethod
    public static CTItemComponent electricStats(long maxCharge, int tier, boolean rechargeable, boolean dischrgeable) {
        return new CTItemComponent(new ElectricStats(maxCharge, tier, rechargeable, dischrgeable));
    }

    @ZenMethod
    public CTItemComponent fluidStats(int maxCapacity, int minFluidTemperature, int maxFluidTemperature, boolean allowPartlyFill) {
        return new CTItemComponent(new FluidStats(maxCapacity, minFluidTemperature, maxFluidTemperature, allowPartlyFill));
    }

    @ZenMethod
    public CTItemComponent fluidStats(int maxCapacity, boolean allowPartlyFill) {
        return new CTItemComponent(new FluidStats(maxCapacity, Integer.MIN_VALUE, Integer.MAX_VALUE, allowPartlyFill));
    }

    @ZenMethod
    public CTItemComponent fluidStats(int maxCapacity) {
        return new CTItemComponent(new FluidStats(maxCapacity, Integer.MIN_VALUE, Integer.MAX_VALUE, false));
    }
}
