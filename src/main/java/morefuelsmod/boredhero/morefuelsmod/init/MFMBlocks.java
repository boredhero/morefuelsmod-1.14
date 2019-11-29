package morefuelsmod.boredhero.morefuelsmod.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.registries.ObjectHolder;

import morefuelsmod.boredhero.morefuelsmod.MoreFuelsMod;

//The purpose of this class is to allow us to reference our blocks before they are actually created.
//They are set to MFMUtils._null(); rather than regular null because this helps prevent NullPointerException errors
//We're basically tricking the compiler/runtime into looking the other way to let us do something "bad".

//Credit for this idea goes to Cadiboo

@ObjectHolder(MoreFuelsMod.modid)
public class MFMBlocks {
	public static Block block_coke = Blocks.AIR;
	public static Block block_bituminous_coal = Blocks.AIR;
	public static Block block_creative_infinite_fuel = Blocks.AIR;
	public static Block block_pellet_fuel = Blocks.AIR;
	public static Block block_compressed_pellet_fuel = Blocks.AIR;
	public static Block block_lava_ore = Blocks.AIR;
	public static Block block_bituminous_coal_ore = Blocks.AIR;
}
