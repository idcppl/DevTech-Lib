package com.zook.devtechlib.api.items;

import gregtech.api.items.metaitem.StandardMetaItem;
import net.minecraft.item.ItemStack;

public class FixedContainerMetaItem extends StandardMetaItem {
    public FixedContainerMetaItem(short metaItemOffset) {
        super(metaItemOffset);
    }

    @Override
    protected int getColorForItemStack(ItemStack stack, int tintIndex) {
        return 0xFFFFFF;
    }
}
