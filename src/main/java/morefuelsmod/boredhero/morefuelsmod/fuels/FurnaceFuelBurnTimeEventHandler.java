//https://github.com/TheGreyGhost/MinecraftByExample/blob/master/src/main/java/minecraftbyexample/mbe35_recipes/FurnaceFuelBurnTimeEventHandler.java

package morefuelsmod.boredhero.morefuelsmod.fuels;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/*public class FurnaceFuelBurnTimeEventHandler {
	public static final FurnaceFuelBurnTimeEventHandler instance = new FurnaceFuelBurnTimeEventHandler();
	
	private FurnaceFuelBurnTimeEventHandler() {
		@SubscribeEvent
		public void onFurnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
			ItemStack fuel = event.getItemStack();
			final int BURN_TIME_SECONDS = 5;
			final int TICKS_PER_SECOND = 20;
			if(fuel.getItem() == Items.WHEAT) {
				event.setBurnTime(BURN_TIME_SECONDS * TICKS_PER_SECOND);
			}
		}
	}
} 
*/
//this is bad horribly broken 1.12 tutorial copy/paste. 
