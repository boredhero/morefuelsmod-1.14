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

	public static final Item coke = MFMUtil._null();
	public static final Item bituminous_coal = MFMUtil._null();
	public static final Item can_of_slimoline = MFMUtil._null();
	public static final Item coal_dust = MFMUtil._null();
	public static final Item compressed_pellet_fuel = MFMUtil._null();
	public static final Item glass_orb = MFMUtil._null();
	public static final Item lava_crystals = MFMUtil._null();
	public static final Item lava_glass_orb = MFMUtil._null();
	public static final Item pellet_fuel = MFMUtil._null();
	public static final Item tempered_glass_orb = MFMUtil._null();
}
