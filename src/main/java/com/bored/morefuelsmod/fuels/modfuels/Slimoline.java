package com.bored.morefuelsmod.fuels.modfuels;

import com.bored.morefuelsmod.item.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class Slimoline implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel){
		if(fuel.getItem() == ModItems.canOfSlimoline){
			return 20000;
		}
		return 0;
	}
}