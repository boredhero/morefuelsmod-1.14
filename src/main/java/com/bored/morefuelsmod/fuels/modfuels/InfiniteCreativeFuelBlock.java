package com.bored.morefuelsmod.fuels.modfuels;

import com.bored.morefuelsmod.block.ModBlocks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class InfiniteCreativeFuelBlock implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel){
		if(fuel.getItem() == Item.getItemFromBlock(ModBlocks.blockCreativeInfiniteFuel)){
			return 63072000; //2 Years!
		}
		return 0;
	}
}