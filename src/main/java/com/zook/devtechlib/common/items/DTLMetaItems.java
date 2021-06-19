package com.zook.devtechlib.common.items;

import gregtech.api.items.metaitem.MetaItem;

import java.util.List;

public class DTLMetaItems {
    private static List<MetaItem<?>> ITEMS = MetaItem.getMetaItems();

    public static MetaItem<?>.MetaValueItem UNIVERSAL_CELL;
    public static MetaItem<?>.MetaValueItem VIAL;
    public static MetaItem<?>.MetaValueItem BEAKER;
    public static MetaItem<?>.MetaValueItem LARGE_BEAKER;
    //public static MetaItem<?>.MetaValueItem TEST;

    public static void init() {
        DTLMetaItem item = new DTLMetaItem();
        item.setRegistryName("dtl_meta_item");
    }
}
