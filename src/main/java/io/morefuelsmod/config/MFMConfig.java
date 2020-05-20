package io.morefuelsmod.config;

/*
 * Credit to Cadiboo on the file
 * Source: https://gist.github.com/Cadiboo/f0a2d9c103e7d9aefa8b03d571390f82
 */

import org.apache.commons.lang3.tuple.Pair;

import io.morefuelsmod.common.Defines;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.Builder;

public class MFMConfig {

	public static final Common COMMON;
	public static final ForgeConfigSpec COMMON_SPEC;
	static {
		final Pair<Common, ForgeConfigSpec> specPair = new Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
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
            builder.push("worldgen");
        	
            enableBituminousGeneration = builder
                    .comment("Enable Bituminous Coal Ore Generation: THIS IS CURRENTLY BROKEN, SORRY")
                    .translation(Defines.MODID + ".config." + "enableBituminousGeneration")
                    .define("enableBituminousGeneration", true);
            
            enableLavaOreNetherGeneration = builder
                    .comment("Enable Lava Ore Genereation in the Nether: THIS IS CURRENTLY BROKEN, SORRY")
                    .translation(Defines.MODID + ".config." + "enableLaveOreNetherGeneration")
                    .define("enableLavaOreNetherGeneration", true);
            
            enableLavaOreOverworldGeneration = builder
            		.comment("Enable Lava Ore Generation in the Overworld: THIS IS CURRENTLY BROKEN, SORRY")
            		.translation(Defines.MODID + ".config." + "enableLavaOreOverworldGeneration")
                    .define("enableLavaOreOverworldGeneration", true);


            builder.pop();
                }	
        }
}
