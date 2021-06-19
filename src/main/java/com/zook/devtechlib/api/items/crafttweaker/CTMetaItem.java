package com.zook.devtechlib.api.items.crafttweaker;

import com.zook.devtechlib.api.unification.crafttweaker.CTOrePrefix;
import crafttweaker.annotations.ZenRegister;
import gregtech.api.items.materialitem.MaterialMetaItem;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.unification.ore.OrePrefix;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

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
}
