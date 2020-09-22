package com.bored.morefuelsmod.fuels.modfuels;

import com.bored.morefuelsmod.block.ModBlocks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class ConcentratedPelletBlock implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel){
		if(fuel.getItem() == Item.getItemFromBlock(ModBlocks.blockCompressedPelletFuel)){
			return 291600;
		}
		return 0;
	}
}