package com.zook.devtechlib.api.items;

import gregtech.api.items.metaitem.stats.IItemNameProvider;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

public class NameOverride implements IItemNameProvider {
    private final String langKey;

    public NameOverride(String langKey) {
        this.langKey = langKey;
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack, String s) {
        return I18n.format(langKey);
    }
}