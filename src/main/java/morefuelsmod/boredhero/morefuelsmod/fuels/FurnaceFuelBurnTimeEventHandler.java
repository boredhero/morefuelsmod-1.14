//https://github.com/TheGreyGhost/MinecraftByExample/blob/master/src/main/java/minecraftbyexample/mbe35_recipes/FurnaceFuelBurnTimeEventHandler.java

package morefuelsmod.boredhero.morefuelsmod.fuels;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FurnaceFuelBurnTimeEventHandler {
	public static final FurnaceFuelBurnTimeEventHandler instance = new FurnaceFuelBurnTimeEventHandler();
	
	private FurnaceFuelBurnTimeEventHandler() {
		
	};
	
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
				Items.JUNGLE_SIGN, Items.OAK_SIGN, Items.SPRUCE_SIGN);\
		//Piston container
		List<Item> pistonList = Arrays.asList(Items.PISTON, Items.STICKY_PISTON);
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
				leaves = 75, tripwire_hook = 56, dry_sponge = 140, pistons = 225, cobweb = 25;  
		
		if(planksList.contains(fuel))
			event.setBurnTime(planks);
		else if(slabsList.contains(fuel))
			event.setBurnTime(slabs);
		else if(fuel == Items.STICK)
			event.setBurnTime(sticks);
		else if(fuel== Items.BOWL)
			event.setBurnTime(bowl);
		else if(fuel == Items.COAL_BLOCK)
			event.setBurnTime(block_of_coal);
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
		else if(fuel == Items.BARREL)
			event.setBurnTime(barrel);
		else if(fuel == Items.DAYLIGHT_DETECTOR)
			event.setBurnTime(daylight_detector);
		else if(fuel == Items.JUKEBOX)
			event.setBurnTime(jukebox);
		else if(fuel == Items.NOTE_BLOCK)
			event.setBurnTime(note_block);
		else if(fuel == Items.BOW)
			event.setBurnTime(bow);
		else if(fuel == Items.FISHING_ROD)
			event.setBurnTime(fishing_rod);
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
		else if(bannerList.contains(fuel))
			event.setBurnTime(banner);
		else if(carpetList.contains(fuel))
			event.setBurnTime(carpet);
		
	}
	
}

//this is bad horribly broken 1.12 tutorial copy/paste. 
