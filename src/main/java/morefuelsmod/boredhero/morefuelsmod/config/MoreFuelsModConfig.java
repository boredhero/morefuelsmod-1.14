package morefuelsmod.boredhero.morefuelsmod.config;

/*
 * Credit to Cadiboo on the file
 * Source: https://gist.github.com/Cadiboo/f0a2d9c103e7d9aefa8b03d571390f82
 */


import org.apache.commons.lang3.tuple.Pair;

import morefuelsmod.boredhero.morefuelsmod.MoreFuelsMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.Builder;

public class MoreFuelsModConfig {

	public static final Common COMMON;
	public static final ForgeConfigSpec clientSpec;
	static {
		final Pair<Common, ForgeConfigSpec> specPair = new Builder().configure(Common::new);
        clientSpec = specPair.getRight();
        COMMON = specPair.getLeft();
	}
	
    public static boolean enableBituminousGeneration;
    public static boolean enableLavaOreNetherGeneration;
    public static boolean enableLavaOreOverworldGeneration;

    public static void bakeConfig() {
        enableBituminousGeneration = COMMON.enableBituminousGeneration.get();
        enableLavaOreNetherGeneration = COMMON.enableLavaOreNetherGeneration.get();
        enableLavaOreOverworldGeneration = COMMON.enableLavaOreOverworldGeneration.get();
    }
	//Internal class
	public static class Common{
        public final BooleanValue enableBituminousGeneration;
        public final BooleanValue enableLavaOreNetherGeneration;
        public final BooleanValue enableLavaOreOverworldGeneration;

        public Common(Builder builder) {
        	
            enableBituminousGeneration = builder
                    .comment("Enable Bituminous Coal Ore Generation")
                    .translation(MoreFuelsMod.modid + ".config." + "enableBituminousGeneration")
                    .define("enableBituminousGeneration", true);
            
            enableLavaOreNetherGeneration = builder
                    .comment("Enable Lava Ore Genereation in the Nether")
                    .translation(MoreFuelsMod.modid + ".config." + "enableLaveOreNetherGeneration")
                    .define("enableLavaOreNetherGeneration", true);
            
            enableLavaOreOverworldGeneration = builder
            		.comment("Enable Lava Ore Generation in the Overworld")
            		.translation(MoreFuelsMod.modid + ".config." + "enableLavaOreOverworldGeneration")
            		.define("enableLavaOreOverworldGeneration", true);
	}	
}
}
