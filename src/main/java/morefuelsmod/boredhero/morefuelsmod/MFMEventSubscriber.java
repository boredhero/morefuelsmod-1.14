package morefuelsmod.boredhero.morefuelsmod;
//Credit for this lovely class goes to Cadiboo
//https://github.com/Cadiboo/Example-Mod/blob/1.14.4/src/main/java/io/github/cadiboo/examplemod/ModEventSubscriber.java

import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;

import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import morefuelsmod.boredhero.morefuelsmod.config.MoreFuelsModConfig;
import morefuelsmod.boredhero.morefuelsmod.init.MFMItemGroups;

@EventBusSubscriber(modid = MoreFuelsMod.modid, bus = EventBusSubscriber.Bus.MOD)
public final class MFMEventSubscriber {

	@SubscribeEvent
	public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				//Fill in blocks here in the following format.
				//setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)), "test_block"),

				//Real MFM blocks start here
				setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 5.0F)), "block_coke"),
				setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 5.0F)), "block_bituminous_coal"),
				setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 5.0F)), "block_creative_infinite_fuel"),
				//TODO: Set item drop for block_lava_ore
				setup(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 5.0F)), "block_lava_ore"),
				setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 5.0F)), "block_bituminous_coal_ore"),
				setup(new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F)), "block_dried_plant")

				);
	}

	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event) {

		final IForgeRegistry<Item> registry = event.getRegistry();

		event.getRegistry().registerAll(
				//Fill in items here in the following format.
				//setup(new Item(new Item.Properties().group(MFMItemGroups.MFM_ITEM_GROUP)), "test_item"),
				//Lots of properties can come after .Properties() as .Thing() tack-ons. StackSize(), etc.

				//Real MFM Items start here. We are going for v1.6.2 compliance with this intial port.
				setup(new Item(new Item.Properties().group(MFMItemGroups.MFM_ITEM_GROUP)), "coke"),
				setup(new Item(new Item.Properties().group(MFMItemGroups.MFM_ITEM_GROUP)), "bituminous_coal"),
				setup(new Item(new Item.Properties().group(MFMItemGroups.MFM_ITEM_GROUP)), "can_of_slimoline"),
				setup(new Item(new Item.Properties().group(MFMItemGroups.MFM_ITEM_GROUP)), "coal_dust"),
				setup(new Item(new Item.Properties().group(MFMItemGroups.MFM_ITEM_GROUP)), "glass_orb"),
				setup(new Item(new Item.Properties().group(MFMItemGroups.MFM_ITEM_GROUP)), "lava_crystals"),
				setup(new Item(new Item.Properties().group(MFMItemGroups.MFM_ITEM_GROUP)), "lava_glass_orb"),
				setup(new Item(new Item.Properties().group(MFMItemGroups.MFM_ITEM_GROUP)), "tempered_glass_orb"),
				setup(new Item(new Item.Properties().group(MFMItemGroups.MFM_ITEM_GROUP)), "dried_plant")
				);


				for(final Block block : ForgeRegistries.BLOCKS.getValues()) {
					final ResourceLocation blockRegistryName = block.getRegistryName();
					//Make sure there are no null blocknames.
					Preconditions.checkNotNull(blockRegistryName, "Registry Name of Block \"" + block + "\" of class \"" + block.getClass().getName() + "\"is null! This is not allowed!");
					//Check if block is from morefuelsmod or not. We don't need to check vanilla blocks or other mods blocks
					if (!blockRegistryName.getNamespace().equals(MoreFuelsMod.modid)) {
						continue;
					}
					// If you have blocks that don't have a corresponding BlockItem, uncomment this code and create
					// an Interface - or even better an Annotation - called NoAutomaticBlockItem with no methods
					// and implement it on your blocks that shouldn't have BlockItems autmatically made for them
					//					if (block instanceof NoAutomaticBlockItem) {
					//						continue;
					//					} Comment taken from Cadiboo

					//Make ItemBlock properties and send to our tab
					final Item.Properties properties = new Item.Properties().group(MFMItemGroups.MFM_ITEM_GROUP);
					//Create the new BlockItem with the block and its properties
					final BlockItem blockItem = new BlockItem(block, properties);
					//Setup the new BlockItem with the block's registry name and register it
					registry.register(setup(blockItem, blockRegistryName));
				}
	}

	@SubscribeEvent
	public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
	    MoreFuelsModConfig.bakeConfig();
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(MoreFuelsMod.modid, name));
	}
	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
	}
}
