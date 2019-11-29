package morefuelsmod.boredhero.morefuelsmod.config;

//Credit to Cadiboo on config file

import org.apache.commons.lang3.tuple.Pair;

import morefuelsmod.boredhero.morefuelsmod.MoreFuelsMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class MoreFuelsModConfig {

	public static final Common COMMON;
	public static final ForgeConfigSpec clientSpec;
	static {
		final Pair<Common, ForgeConfigSpec> specPair = new Builder().configure(Common::new);
        clientSpec = specPair.getRight();
        COMMON = specPair.getLeft();
	}
	
	public static boolean aBoolean;
    public static int anInt;

    public static void bakeConfig() {
        aBoolean = COMMON.aBoolean.get();
        anInt = COMMON.anInt.get();
    }
	//Internal class
	public class Common{
        public final BooleanValue aBoolean;
        public final IntValue anInt;

        public Common(Builder builder) {
            aBoolean = builder
                    .comment("aBoolean usage description")
                    .translation(MoreFuelsMod.modid + ".config." + "aBoolean")
                    .define("aBoolean", false);

            anInt = builder
                    .comment("anInt usage description")
                    .translation(MoreFuelsMod.modid + ".config." + "anInt")
                    .defineInRange("anInt", 10, 0, 100);
	}
}
}
