package com.zook.devtechlib.common.items;

import com.zook.devtechlib.api.items.FixedContainerMetaItem;
import gregtech.api.items.metaitem.FluidStats;

import static com.zook.devtechlib.common.items.DTLMetaItems.*;
public class DTLMetaItem extends FixedContainerMetaItem {
    public DTLMetaItem() {
        super((short) 0);
    }

    @Override
    public void registerSubItems() {
        UNIVERSAL_CELL = addItem(1, "universal_cell").addComponents(new FluidStats(1000, Integer.MIN_VALUE, Integer.MAX_VALUE, true));
        VIAL = addItem(2, "vial").addComponents(new FluidStats(16, Integer.MIN_VALUE, Integer.MAX_VALUE, false));
        BEAKER = addItem(3, "beaker").addComponents(new FluidStats(144, Integer.MIN_VALUE, Integer.MAX_VALUE, false));
        LARGE_BEAKER = addItem(4, "large_beaker").addComponents(new FluidStats(1296, Integer.MIN_VALUE, Integer.MAX_VALUE, false));
        //TEST = addItem(5, "test").addComponents(new ItemProxyUI()).setMaxStackSize(1).setModelAmount(6);
    }
}
