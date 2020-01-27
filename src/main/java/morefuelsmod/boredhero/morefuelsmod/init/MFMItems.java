package morefuelsmod.boredhero.morefuelsmod.init;

import morefuelsmod.boredhero.morefuelsmod.MoreFuelsMod;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

//The purpose of this class is to allow us to reference our BlockStates before they are actually created.
//They are set to MFMUtils._null(); rather than regular null because this helps prevent NullPointerException errors
//We're basically tricking the compiler/runtime into looking the other way to let us do something "bad".

//Credit for this idea goes to Cadiboo

@ObjectHolder(MoreFuelsMod.modid)
public class MFMItems {

	public static final Item COKE = MFMUtil._null();
	public static final Item BITUMINOUS_COAL = MFMUtil._null();
	public static final Item CAN_OF_SLIMOLINE = MFMUtil._null();
	public static final Item COAL_DUST = MFMUtil._null();
	public static final Item COMPRESSED_PELLET_FUEL = MFMUtil._null();
	public static final Item GLASS_ORB = MFMUtil._null();
	public static final Item LAVA_CRYSTALS = MFMUtil._null();
	public static final Item LAVA_GLASS_ORB = MFMUtil._null();
	public static final Item PELLET_FUEL = MFMUtil._null();
	public static final Item TEMPERED_GLASS_ORB = MFMUtil._null();
	public static final Item DRIED_PLANT = MFMUtil._null();
	//Need these here as items in order to use them in MFMFuelsEventHandler
	public static final Item BLOCK_COKE = MFMUtil._null();
	public static final Item BLOCK_BITUMINOUS_COAL = MFMUtil._null();
	public static final Item BLOCK_CREATIVE_INFINITE_FUEL = MFMUtil._null();
	public static final Item BLOCK_PELLET_FUEL = MFMUtil._null();
	public static final Item BLOCK_COMPRESSED_PELLET_FUEL = MFMUtil._null();
	public static final Item BLOCK_LAVA_ORE = MFMUtil._null();
	public static final Item BLOCK_BITUMINOUS_COAL_ORE = MFMUtil._null();
	public static final Item BLOCK_DRIED_PLANT = MFMUtil._null();
}
