package com.zook.devtechlib.common;

import codechicken.lib.texture.TextureUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    public void onPreLoad() {
        super.onPreLoad();
        TextureUtils.addIconRegister(DTLFluids::registerSprites);
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onPostLoad() {

    }
}