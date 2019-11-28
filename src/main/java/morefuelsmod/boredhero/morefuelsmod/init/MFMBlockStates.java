package morefuelsmod.boredhero.morefuelsmod.init;

import morefuelsmod.boredhero.morefuelsmod.MoreFuelsMod;
import net.minecraft.block.BlockState;
import net.minecraftforge.registries.ObjectHolder;

//The purpose of this class is to allow us to reference our BlockStates before they are actually created.
//They are set to MFMUtils._null(); rather than regular null because this helps prevent NullPointerException errors
//We're basically tricking the compiler/runtime into looking the other way to let us do something "bad".

//Credit for this concept goes to Cadiboo

@ObjectHolder(MoreFuelsMod.modid)
public class MFMBlockStates {
	//These are experimental. I don't know the consequences, really, they're only here so the OreGen class can work.
	//Hope they don't break anything else.
	public static BlockState BLOCK_BITUMINOUS_COAL_ORE = MFMUtil._null();
	public static BlockState BLOCK_LAVA_ORE = MFMUtil._null();
}
