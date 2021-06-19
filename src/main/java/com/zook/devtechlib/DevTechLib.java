package com.zook.devtechlib;

import com.zook.devtechlib.common.CommonProxy;
import com.zook.devtechlib.common.DTLFluids;
import com.zook.devtechlib.common.items.DTLMetaItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import org.apache.logging.log4j.Logger;

@Mod(modid = DevTechLib.MODID, name = DevTechLib.NAME, version = DevTechLib.VERSION)
public class DevTechLib {
    public static final String MODID = "devtech";
    public static final String NAME = "DevTech: Lib";
    public static final String VERSION = "0.0.2";

    public static Logger logger;

    @SidedProxy(modId = DevTechLib.MODID, clientSide = "com.zook.devtechlib.common.ClientProxy", serverSide = "com.zook.devtechlib.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        DTLMetaItems.init();
        DTLFluids.init();
        proxy.onPreLoad();
    }
}
