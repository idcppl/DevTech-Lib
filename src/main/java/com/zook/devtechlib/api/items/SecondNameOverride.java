package com.zook.devtechlib.api.items;

import gregtech.api.items.metaitem.stats.IItemNameProvider;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashMap;
import java.util.Map;

public class SecondNameOverride implements IItemNameProvider {
    public final Map<String, String> translations = new HashMap<>();

    public static final String EN_US = "en_us";
    public static final String RU_RU = "ru_ru";
    public static final String ZH_CN = "zh_cn";

    public SecondNameOverride() {}

    public SecondNameOverride setEntry(String locale, String name) {
        translations.put(locale, name);
        return this;
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack, String s) {
        return getItemStackDisplayName(itemStack, s, getLanguage());
    }

    public String getItemStackDisplayName(ItemStack itemStack, String s, String locale) {
        return translations.get(locale) == null ? s : translations.get(locale);
    }

    private static String getLanguage() {
        return FMLCommonHandler.instance().getSide() == Side.SERVER ? null : FMLClientHandler.instance().getCurrentLanguage();
    }
}
