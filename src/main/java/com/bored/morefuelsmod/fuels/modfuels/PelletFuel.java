package com.bored.morefuelsmod.fuels.modfuels;

import com.bored.morefuelsmod.item.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class PelletFuel implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel){
		if(fuel.getItem() == ModItems.pelletFuel){
			return 900;
		}
		return 0;
	}
}