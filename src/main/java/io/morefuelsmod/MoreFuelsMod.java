package io.morefuelsmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.morefuelsmod.config.MFMConfig;
import io.morefuelsmod.fuels.MFMFuelsEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreFuelsMod.modid)
public class MoreFuelsMod {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String version = "1.7.1";
    public static final String mcversion = "1.14.4";
    public static final String modid = "morefuelsmod";

    public MoreFuelsMod() {
    	ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MFMConfig.clientSpec);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(MFMFuelsEventHandler.instance);
    }
    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Loading morefuelsmod-" + mcversion + " v" + version);
        LOGGER.info("MFM: Lets Load some F*****G ores");
        MFMOreGen.setupOreGenPart1();
        LOGGER.info("MFM: F*****G ores loaded");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        LOGGER.info("MFM: Server Instance Detected");
        //MFMOreGen.setupOreGenPart1(); Had this here before, but it still didn't do anything useful.
    }
}