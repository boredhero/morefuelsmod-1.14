package morefuelsmod.boredhero.morefuelsmod.init;

import net.minecraft.block.Block;
import net.minecraftforge.registries.ObjectHolder;

import morefuelsmod.boredhero.morefuelsmod.MoreFuelsMod;

//The purpose of this class is to allow us to reference our blocks before they are actually created.
//They are set to MFMUtils._null(); rather than regular null because this helps prevent NullPointerException errors
//We're basically tricking the compiler/runtime into looking the other way to let us do something "bad".

//Credit for this idea goes to Cadiboo

@ObjectHolder(MoreFuelsMod.modid)
public class MFMBlocks {
	public static Block BLOCK_COKE = MFMUtil._null();
	public static Block BLOCK_BITUMINOUS_COAL = MFMUtil._null();
	public static Block BLOCK_CREATIVE_INFINITE_FUEL = MFMUtil._null();
	public static Block BLOCK_PELLET_FUEL = MFMUtil._null();
	public static Block BLOCK_COMPRESSED_PELLET_FUEL = MFMUtil._null();
	public static Block BLOCK_LAVA_ORE = MFMUtil._null();
	public static Block BLOCK_BITUMINOUS_COAL_ORE = MFMUtil._null();
}
