package com.zook.devtechlib.api.items.crafttweaker;

import com.zook.devtechlib.api.unification.crafttweaker.CTOrePrefix;
import crafttweaker.annotations.ZenRegister;
import gregtech.api.GTValues;
import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IElectricItem;
import gregtech.api.items.materialitem.MaterialMetaItem;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fluids.capability.IFluidTankProperties;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemHandlerHelper;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

@ZenClass("mods.devtech.MetaItem")
@ZenRegister
public class CTMetaItem extends MaterialMetaItem {
    private MetaItem<?>.MetaValueItem item;

    public CTMetaItem(String name, OrePrefix... ores) {
        super(ores);
        this.setRegistryName(name);
    }

    @ZenMethod
    public static CTMetaItem build(String name, CTOrePrefix... ores) {
        OrePrefix[] arr = new OrePrefix[32];
        for (int i = 0; i < ores.length; i++) {
            arr[i] = ores[i].getInternal();
        }
        return new CTMetaItem(name, arr);
    }

    @ZenMethod
    public CTMetaItem create(int id, String name) {
        this.item = addItem(id, name);
        return this;
    }

    @ZenMethod
    public CTMetaItem addComponents(CTItemComponent... components) {
        for(CTItemComponent component : components) {
            item.addComponents(component.getInternal());
        }
        return this;
    }

    @ZenMethod
    public CTMetaItem oreDict(String oreDictName) {
        item.addOreDict(oreDictName);
        return this;
    }

    @ZenMethod
    public CTMetaItem invisible() {
        item.setInvisible();
        return this;
    }

    @ZenMethod
    public CTMetaItem stackSize(int maxStackSize) {
        item.setMaxStackSize(maxStackSize);
        return this;
    }

    @ZenMethod
    public CTMetaItem burnTime(int burnValue) {
        item.setBurnValue(burnValue);
        return this;
    }

    @ZenMethod
    public CTMetaItem modelAmount(int amount) {
        item.setModelAmount(amount);
        return this;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, @Nullable World worldIn, List<String> lines, ITooltipFlag tooltipFlag) {
        MetaItem<?>.MetaValueItem item = getItem(itemStack);
        if (item == null) return;
        String unlocalizedTooltip = "metaitem." + item.unlocalizedName + ".tooltip";
        if (I18n.hasKey(unlocalizedTooltip)) {
            lines.addAll(Arrays.asList(I18n.format(unlocalizedTooltip).split("/n")));
        }

        IElectricItem electricItem = itemStack.getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
        if (electricItem != null) {
            String[] values = new String[] {"ULV", "LV", "MV", "HV", "EV", "IV", "LuV", "ZPM", "UV", "MAX"};
            if(GTValues.isModLoaded("gtadditions") && GTValues.isModLoaded("devtechgregicality")) {
                values = new String[] {"ULV", "LV", "MV", "HV", "EV", "IV", "LuV", "ZPM", "UV", "UHV", "UEV", "UIV", "UMV", "UXV", "MAX"};
            }
            lines.add(I18n.format("metaitem.generic.electric_item.tooltip",
                    electricItem.getCharge(),
                    electricItem.getMaxCharge(),
                    values[electricItem.getTier()]));
        }

        IFluidHandlerItem fluidHandler = ItemHandlerHelper.copyStackWithSize(itemStack, 1)
                .getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
        if (fluidHandler != null) {
            IFluidTankProperties fluidTankProperties = fluidHandler.getTankProperties()[0];
            FluidStack fluid = fluidTankProperties.getContents();
            if (fluid != null) {
                lines.add(I18n.format("metaitem.generic.fluid_container.tooltip",
                        fluid.amount,
                        fluidTankProperties.getCapacity(),
                        fluid.getLocalizedName()));
            } else lines.add(I18n.format("metaitem.generic.fluid_container.tooltip_empty"));
        }

        for (IItemBehaviour behaviour : getBehaviours(itemStack)) {
            behaviour.addInformation(itemStack, lines);
        }
    }
}
