//https://github.com/TheGreyGhost/MinecraftByExample/blob/master/src/main/java/minecraftbyexample/mbe35_recipes/FurnaceFuelBurnTimeEventHandler.java

package morefuelsmod.boredhero.morefuelsmod.fuels;

import java.util.Arrays;
import java.util.List;

import morefuelsmod.boredhero.morefuelsmod.init.MFMItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MFMFuelsEventHandler {
	public static final MFMFuelsEventHandler instance = new MFMFuelsEventHandler();
	
	private MFMFuelsEventHandler() {
		//I don't really know why this is here or what it does, just that it has to be here and nothing should
	}
	
	@SubscribeEvent
	public void onFurnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack fuelStack = event.getItemStack();
		Item fuel = fuelStack.getItem();
		//Lets containerize some things so we can do "contains" checks rather than ||
		//Banners container
		List<Item> bannerList = Arrays.asList(Items.BLACK_BANNER, Items.BLUE_BANNER, Items.BROWN_BANNER,
				Items.CYAN_BANNER, Items.GRAY_BANNER, Items.GREEN_BANNER, Items.LIGHT_BLUE_BANNER,
				Items.LIGHT_GRAY_BANNER, Items.LIME_BANNER, Items.MAGENTA_BANNER, Items.ORANGE_BANNER,
				Items.PINK_BANNER, Items.PURPLE_BANNER, Items.RED_BANNER, Items.WHITE_BANNER, Items.YELLOW_BANNER);
		//Carpets container
		List<Item> carpetList = Arrays.asList(Items.BLACK_CARPET, Items.BLUE_CARPET, Items.BROWN_CARPET,
				Items.CYAN_CARPET, Items.GRAY_CARPET, Items.GREEN_CARPET, Items.LIGHT_BLUE_CARPET, 
				Items.LIGHT_GRAY_CARPET, Items.LIME_CARPET, Items.MAGENTA_CARPET, Items.ORANGE_CARPET,
				Items.PINK_CARPET, Items.PURPLE_CARPET, Items.RED_CARPET, Items.WHITE_CARPET, Items.YELLOW_CARPET);
		//Bed container
		List<Item> bedList = Arrays.asList(Items.BLACK_BED, Items.BLUE_BED, Items.BROWN_BED,
				Items.CYAN_BED, Items.GRAY_BED, Items.GREEN_BED, Items.LIGHT_BLUE_BED,
				Items.LIGHT_GRAY_BED, Items.LIME_BED, Items.MAGENTA_BED, Items.ORANGE_BED,
				Items.PINK_BED, Items.PURPLE_BED, Items.RED_BED, Items.WHITE_BED, Items.YELLOW_BED);
		//Planks container
		List<Item> planksList = Arrays.asList(Items.ACACIA_PLANKS, Items.BIRCH_PLANKS, Items.DARK_OAK_PLANKS,
				Items.JUNGLE_PLANKS, Items.OAK_PLANKS, Items.SPRUCE_PLANKS);
		//Slabs container
		List<Item> slabsList = Arrays.asList(Items.ACACIA_SLAB, Items.BIRCH_SLAB, Items.DARK_OAK_SLAB,
				Items.JUNGLE_SLAB, Items.OAK_SLAB, Items.SPRUCE_SLAB);
		//Doors container
		List<Item> doorsList = Arrays.asList(Items.ACACIA_DOOR, Items.BIRCH_DOOR, Items.DARK_OAK_DOOR,
				Items.JUNGLE_DOOR, Items.OAK_DOOR, Items.SPRUCE_DOOR);
		//Boats container
		List<Item> boatsList = Arrays.asList(Items.ACACIA_BOAT, Items.BIRCH_BOAT, Items.DARK_OAK_BOAT,
				Items.JUNGLE_BOAT, Items.OAK_BOAT, Items.SPRUCE_BOAT);
		//Fence container
		List<Item> fenceList = Arrays.asList(Items.ACACIA_FENCE, Items.BIRCH_FENCE, Items.DARK_OAK_FENCE,
				Items.JUNGLE_FENCE, Items.OAK_FENCE, Items.SPRUCE_FENCE);
		//Stairs container
		List<Item> stairsList = Arrays.asList(Items.ACACIA_STAIRS, Items.BIRCH_STAIRS, Items.DARK_OAK_STAIRS,
				Items.JUNGLE_STAIRS, Items.OAK_STAIRS, Items.SPRUCE_STAIRS);
		//Trapdoor container
		List<Item> trapdoorsList = Arrays.asList(Items.ACACIA_TRAPDOOR, Items.BIRCH_TRAPDOOR, Items.DARK_OAK_TRAPDOOR,
				Items.JUNGLE_TRAPDOOR, Items.OAK_TRAPDOOR, Items.SPRUCE_TRAPDOOR);
		//Button container
		List<Item> buttonList = Arrays.asList(Items.ACACIA_BUTTON, Items.BIRCH_BUTTON, Items.DARK_OAK_BUTTON,
				Items.JUNGLE_BUTTON, Items.OAK_BUTTON, Items.SPRUCE_BUTTON);
		//Sign container
		List<Item> signList = Arrays.asList(Items.ACACIA_SIGN, Items.BIRCH_SIGN, Items.DARK_OAK_SIGN,
				Items.JUNGLE_SIGN, Items.OAK_SIGN, Items.SPRUCE_SIGN);
		//Leaves Container
		List<Item> leavesList = Arrays.asList(Items.ACACIA_LEAVES, Items.BIRCH_LEAVES, Items.DARK_OAK_LEAVES,
				Items.JUNGLE_LEAVES, Items.OAK_LEAVES, Items.SPRUCE_LEAVES);
		//Piston container
		List<Item> pistonList = Arrays.asList(Items.PISTON, Items.STICKY_PISTON);
		//Chorus container
		List<Item> chorusList = Arrays.asList(Items.CHORUS_PLANT, Items.CHORUS_FLOWER, Items.POPPED_CHORUS_FRUIT);
		//Purpur Block & Pillar Container
		List<Item> purpurBlockPillarList = Arrays.asList(Items.PURPUR_BLOCK, Items.PURPUR_PILLAR);
		//Mushroom Blocks Container
		List<Item> mushroomBlockList = Arrays.asList(Items.BROWN_MUSHROOM_BLOCK, Items.MUSHROOM_STEM, Items.RED_MUSHROOM_BLOCK);
		//Books Container
		List<Item> booksList = Arrays.asList(Items.BOOK, Items.ENCHANTED_BOOK, Items.KNOWLEDGE_BOOK, Items.WRITABLE_BOOK, Items.WRITTEN_BOOK);
		//Maps Container
		List<Item> mapsList = Arrays.asList(Items.FILLED_MAP, Items.MAP);
		//Banner Pattern Container
		List<Item> bannerPatternList = Arrays.asList(Items.CREEPER_BANNER_PATTERN, Items.FLOWER_BANNER_PATTERN, Items.GLOBE_BANNER_PATTERN,
				Items.MOJANG_BANNER_PATTERN, Items.SKULL_BANNER_PATTERN);
		//First off, lets fix Mojang's own shit for them...
		//All timings are in ticks. 20t = 1 second. See fuels.md for mor details.
		final int planks = 75, slabs = 38, sticks = 38, bowl = 56,
				wood_door = 150, boat = 375, scaffolding = 325,
				wood_fence = 125, wood_stairs = 113, wood_trapdoor = 450,
				cartography_table = 580, loom = 200, bookshelf = 1710,
				lectern = 1860, composter = 263, chest = 600, trapped_chest = 656,
				barrel = 525, daylight_detector = 113, jukebox = 600, note_block = 600,
				banner = 638, bow = 188, fishing_rod = 163, ladder = 88, wooden_button = 75,
				wooden_pickaxe = 300, wooden_shovel = 150, wooden_hoe = 225, wooden_axe = 300,
				wooden_sword = 188, wooden_sign = 163, carpet = 67, block_of_coal = 14400, 
		//Now lets get onto adding new items as fuel
				leaves = 75, tripwire_hook = 56, dry_sponge = 140, piston = 225, cobweb = 25,
				torch = 410, redstone_torch = 38, chorus = 300, purpur_block_pillar = 300,
				purpur_slab = 150, purpur_stairs = 450, end_rod = 675, lever = 38,
				mushroom_block = 300, string = 25, feather = 25, painting = 400, paper = 140,
				books = 420, minecart_with_chest = 600, bed = 525, dried_kelp = 444, 
				blaze_powder = 1200, item_frame = 300, map = 1200, carrot_on_a_stick = 163,
				armor_stand = 225, shield = 450, banner_pattern = 140, campfire = 2613,
		//And lastly...modded fuel items...
				dried_plant = 140, dried_plant_block = 1260, bituminous_coal = 1600,
				bituminous_coal_block = 14400, coke = 3200, coke_block = 28800,
				lava_orb = 20000, can_of_slimoline = 20000, coal_dust = 1600,
				infinite_creative_fuel = 63072000; /*Two years in real time!*/
		
		if(fuel == MFMItems.DRIED_PLANT)
			event.setBurnTime(dried_plant);
		else if(fuel == MFMItems.BLOCK_DRIED_PLANT)
			event.setBurnTime(dried_plant_block);
		else if(fuel == MFMItems.BITUMINOUS_COAL)
			event.setBurnTime(bituminous_coal);
		else if(fuel == MFMItems.BLOCK_BITUMINOUS_COAL)
			event.setBurnTime(bituminous_coal_block);
		else if(fuel == MFMItems.COKE)
			event.setBurnTime(coke);
		else if(fuel == MFMItems.BLOCK_COKE)
			event.setBurnTime(coke_block);
		else if(fuel == MFMItems.LAVA_GLASS_ORB)
			event.setBurnTime(lava_orb);
		else if(fuel == MFMItems.CAN_OF_SLIMOLINE)
			event.setBurnTime(can_of_slimoline);
		else if(fuel == MFMItems.COAL_DUST)
			event.setBurnTime(coal_dust);
		else if(fuel == MFMItems.BLOCK_CREATIVE_INFINITE_FUEL)
			event.setBurnTime(infinite_creative_fuel);
		else if(planksList.contains(fuel))
			event.setBurnTime(planks);
		else if(slabsList.contains(fuel))
			event.setBurnTime(slabs);
		else if(mushroomBlockList.contains(fuel))
			event.setBurnTime(mushroom_block);
		else if(bedList.contains(fuel))
			event.setBurnTime(bed);
		else if(leavesList.contains(fuel))
			event.setBurnTime(leaves);
		else if(signList.contains(fuel))
			event.setBurnTime(wooden_sign);
		else if(buttonList.contains(fuel))
			event.setBurnTime(wooden_button);
		else if(fenceList.contains(fuel))
			event.setBurnTime(wood_fence);
		else if(stairsList.contains(fuel))
			event.setBurnTime(wood_stairs);
		else if(trapdoorsList.contains(fuel))
			event.setBurnTime(wood_trapdoor);
		else if(doorsList.contains(fuel))
			event.setBurnTime(wood_door);
		else if(boatsList.contains(fuel))
			event.setBurnTime(boat);
		else if(fuel == Items.STICK)
			event.setBurnTime(sticks);
		else if(fuel == Items.STRING)
			event.setBurnTime(string);
		else if(fuel == Items.FEATHER)
			event.setBurnTime(feather);
		else if(fuel == Items.PAINTING)
			event.setBurnTime(painting);
		else if(fuel == Items.PAPER)
			event.setBurnTime(paper);
		else if(booksList.contains(fuel))
			event.setBurnTime(books);
		else if(fuel== Items.BOWL)
			event.setBurnTime(bowl);
		else if(fuel == Items.ARMOR_STAND)
			event.setBurnTime(armor_stand);
		else if(fuel == Items.SHIELD)
			event.setBurnTime(shield);
		else if(fuel == Items.CAMPFIRE)
			event.setBurnTime(campfire);
		else if(fuel == Items.COAL_BLOCK)
			event.setBurnTime(block_of_coal);
		else if(fuel == Items.ITEM_FRAME)
			event.setBurnTime(item_frame);
		else if(fuel == Items.SCAFFOLDING)
			event.setBurnTime(scaffolding);
		else if(fuel == Items.CARTOGRAPHY_TABLE)
			event.setBurnTime(cartography_table);
		else if(fuel == Items.LOOM)
			event.setBurnTime(loom);
		else if(fuel == Items.BOOKSHELF)
			event.setBurnTime(bookshelf);
		else if(fuel == Items.LECTERN)
			event.setBurnTime(lectern);
		else if(fuel == Items.COMPOSTER)
			event.setBurnTime(composter);
		else if(fuel == Items.CHEST)
			event.setBurnTime(chest);
		else if(fuel == Items.TRAPPED_CHEST)
			event.setBurnTime(trapped_chest);
		else if(fuel == Items.CHEST_MINECART)
			event.setBurnTime(minecart_with_chest);
		else if(fuel == Items.BARREL)
			event.setBurnTime(barrel);
		else if(fuel == Items.DRIED_KELP)
			event.setBurnTime(dried_kelp);
		else if(fuel == Items.DAYLIGHT_DETECTOR)
			event.setBurnTime(daylight_detector);
		else if(fuel == Items.JUKEBOX)
			event.setBurnTime(jukebox);
		else if(fuel == Items.NOTE_BLOCK)
			event.setBurnTime(note_block);
		else if(fuel == Items.BOW)
			event.setBurnTime(bow);
		else if(fuel == Items.LEVER)
			event.setBurnTime(lever);
		else if(fuel == Items.FISHING_ROD)
			event.setBurnTime(fishing_rod);
		else if(fuel == Items.CARROT_ON_A_STICK)
			event.setBurnTime(carrot_on_a_stick);
		else if(fuel == Items.LADDER)
			event.setBurnTime(ladder);
		else if(fuel == Items.WOODEN_PICKAXE)
			event.setBurnTime(wooden_pickaxe);
		else if(fuel == Items.WOODEN_HOE)
			event.setBurnTime(wooden_hoe);
		else if(fuel == Items.WOODEN_AXE)
			event.setBurnTime(wooden_axe);
		else if(fuel == Items.WOODEN_SHOVEL)
			event.setBurnTime(wooden_shovel);
		else if(fuel == Items.WOODEN_SWORD)
			event.setBurnTime(wooden_sword);
		else if(fuel == Items.TRIPWIRE_HOOK)
			event.setBurnTime(tripwire_hook);
		else if(fuel == Items.SPONGE)
			event.setBurnTime(dry_sponge);
		else if(fuel == Items.COBWEB)
			event.setBurnTime(cobweb);
		else if(fuel == Items.TORCH)
			event.setBurnTime(torch);
		else if(fuel == Items.REDSTONE_TORCH)
			event.setBurnTime(redstone_torch);
		else if(fuel == Items.PURPUR_SLAB)
			event.setBurnTime(purpur_slab);
		else if(fuel == Items.PURPUR_STAIRS)
			event.setBurnTime(purpur_stairs);
		else if(fuel == Items.END_ROD)
			event.setBurnTime(end_rod);
		else if(fuel == Items.BLAZE_POWDER)
			event.setBurnTime(blaze_powder);
		else if(mapsList.contains(fuel))
			event.setBurnTime(map);
		else if(purpurBlockPillarList.contains(fuel))
			event.setBurnTime(purpur_block_pillar);
		else if(bannerPatternList.contains(fuel))
			event.setBurnTime(banner_pattern);
		else if(chorusList.contains(fuel))
			event.setBurnTime(chorus);
		else if(pistonList.contains(fuel))
			event.setBurnTime(piston);
		else if(bannerList.contains(fuel))
			event.setBurnTime(banner);
		else if(carpetList.contains(fuel))
			event.setBurnTime(carpet);
		
	}
	
}
