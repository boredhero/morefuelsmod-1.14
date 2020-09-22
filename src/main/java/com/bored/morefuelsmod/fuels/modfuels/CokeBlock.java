package com.bored.morefuelsmod.fuels.modfuels;

import com.bored.morefuelsmod.block.ModBlocks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class CokeBlock implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel){
		if(fuel.getItem() == Item.getItemFromBlock(ModBlocks.blockCoke)){
			return 28800;
		}
		return 0;
	}
}