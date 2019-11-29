package morefuelsmod.boredhero.morefuelsmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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
    public static final String version = "0.0.1";
    public static final String mcversion = "1.14.4";
    public static final String modid = "morefuelsmod";

    public MoreFuelsMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    //Pre-Init
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

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void blockRegister(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
        	//TODO: REMOVE THIS. I HAVE IT HANDLED IN MFMEventSubscriber.java.
        	//This is just leftover from the ExampleMod built in class.
        }
        public static void itemRegister(final RegistryEvent.Register<Item> itemRegistryEvent) {
           	//TODO: REMOVE THIS. I HAVE IT HANDLED IN MFMEventSubscriber.java.
        	//This is just leftover from the ExampleMod built in class.
        }
    }
}