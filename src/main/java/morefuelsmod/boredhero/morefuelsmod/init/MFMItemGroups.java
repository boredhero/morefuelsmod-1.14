package morefuelsmod.boredhero.morefuelsmod.init;

import java.util.function.Supplier;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import morefuelsmod.boredhero.morefuelsmod.*;

//Credit for this class goes to Cadiboo and his excellent tutorial.
//https://cadiboo.github.io/tutorials/1.14.4/forge/1.7-itemgroup/

public class MFMItemGroups {
	
	public static final ItemGroup MFM_ITEM_GROUP = new ModItemGroup(MoreFuelsMod.modid, () -> new ItemStack(MFMItems.coke));
	
	public static class ModItemGroup extends ItemGroup {
		
		private final Supplier<ItemStack> iconSupplier;

		public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier){
			super(name);
			this.iconSupplier = iconSupplier;
		}
		
		@Override
		public ItemStack createIcon() {
			return iconSupplier.get();
		}
	}
}
