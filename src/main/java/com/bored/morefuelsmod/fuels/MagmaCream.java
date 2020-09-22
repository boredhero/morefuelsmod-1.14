package com.bored.morefuelsmod.fuels;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class MagmaCream implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel){
		if(fuel.getItem() == Items.MAGMA_CREAM){
			return 2000;
		}
		return 0;
	}
}