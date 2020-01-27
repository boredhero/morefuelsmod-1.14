package morefuelsmod.boredhero.morefuelsmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import morefuelsmod.boredhero.morefuelsmod.config.MoreFuelsModConfig;
import morefuelsmod.boredhero.morefuelsmod.fuels.MFMFuelsEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

//TODO: BEWARE THAT THIS MAIN CLASS IS CLUTTERED AND IS A COPY - PASTE - MODIFY OF THE 1.14 EXAMPLEMOD.JAVA
//MANY THINGS THAT LOOK LIKE THEY ARE MISSING HERE ARE INSTEAD TAKEN CARE OF IN MFMEventSubscriber.java

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MoreFuelsMod.modid)
public class MoreFuelsMod {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    //This isn't really correct but I'm not sure how exactly we do this with 1.14 so until i find out more i'll use this when printing to the terminal during init stages.
    public static final String version = "1.7.0";
    public static final String mcversion = "1.14.4";
    public static final String modid = "morefuelsmod";

    public MoreFuelsMod() {
    	//Config stuff
    	ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MoreFuelsModConfig.clientSpec);
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(MFMFuelsEventHandler.instance);
    }
    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Loading morefuelsmod-" + mcversion + " " + version);
        LOGGER.info("morefuelsmod: Lets Load some F*****G ores");
        MFMOreGen.setupOreGenPart1();
        LOGGER.info("F*****G ores loaded");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("Server instance detected. Ditching the clientside.");
    }
}