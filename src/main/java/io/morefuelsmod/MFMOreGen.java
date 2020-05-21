package io.morefuelsmod;

import org.apache.commons.lang3.ArrayUtils;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import io.morefuelsmod.block.ModBlocks;
import io.morefuelsmod.config.MFMConfig;

/*
 * Base class that I heavily *heavily* modified was based from here:
 * Source: https://www.minecraftforge.net/forum/topic/72953-1143-working-ore-generation-class/
 */

public class MFMOreGen {
	//These should pull from the config...
	private static boolean enableBituminousGeneration = MFMConfig.enableBituminousGeneration;
	private static boolean enableLavaOreNetherGeneration = MFMConfig.enableLavaOreNetherGeneration;
	private static boolean enableLavaOreOverworldGeneration = MFMConfig.enableLavaOreOverworldGeneration;
	//Space savers when calling setupOreGenPart2();
	private static final OreFeatureConfig.FillerBlockType stone = OreFeatureConfig.FillerBlockType.NATURAL_STONE;
	private static final OreFeatureConfig.FillerBlockType nether = OreFeatureConfig.FillerBlockType.NETHERRACK;
    //These are vein sizes
    //Ex: private static final int blockNameVeinSize = a positive integer for the number of blocks in the vein
    private static final int bituminousVeinSize = 5;
    private static final int lavaOreVeinSize = 3;
    
    //CountRangeConfig(Veins Per Chunk Count, MinHeight, MaxHeightBase, MaxHeight)
    //Ex: private static final CountRangeConfig blockNameCfg = new CountRangeConfig(Veins Per Chunk Count, MinHeight, MaxHeightBase, MaxHeight);
    //As far as I can tell, MaxHeightBase should always be 0 in most if not all ore generation cases.
    private static final CountRangeConfig bituminousCfg = new CountRangeConfig(30, 1, 0, 128);
    private static final CountRangeConfig lavaOreCfg = new CountRangeConfig(30, 1, 0, 128);
    private static final CountRangeConfig lavaOreOverworldCfg = new CountRangeConfig(18, 1, 0, 30);

    //These are static Category arrays of Biome.Category.BIOMETYPE to pass into setupOreGenPart2 to do its thing.
    //This is an experimental thing on my part.
    static Category[] allOverworldBiomes = {};
    static Category[] netherBiome = {Biome.Category.NETHER};
    
    //The first part of my redesigned OreGen class. This just calls another method that does all the work and feeds it what it needs.
    public static void setupOreGenPart1() {
    	//Call setupOreGenPart2 and feed it all the pre-configured data we've set up that it needs.
    	//The syntax is setupOreGenPart2 (static Category[] of Biome.Category.BIOMEs or uninitialized,
    	//OreFeatureConfig.FillerBlockType.BLOCKTYPE (NETHERRACK or NATURAL_STONE)
    	//A boolean that you can check with your config, or just hard code send it a false to avoid that step
    	//A vein size integer
    	//A CountRangeConfig object with the Veins Per Chunk, MinHeight, MaxHeightBase (should be 0), and MaxHeight
    	setupOreGenPart2(netherBiome, nether, ModBlocks.BLOCK_LAVA_ORE.get(), enableLavaOreNetherGeneration, lavaOreVeinSize, lavaOreCfg, "enableLavaOreNetherGeneration");
    	setupOreGenPart2(allOverworldBiomes, stone, ModBlocks.BLOCK_BITUMINOUS_COAL_ORE.get(), enableBituminousGeneration, bituminousVeinSize, bituminousCfg, "enableBituminousGeneration");
    	setupOreGenPart2(allOverworldBiomes, stone, ModBlocks.BLOCK_LAVA_ORE.get(), enableLavaOreOverworldGeneration, lavaOreVeinSize, lavaOreOverworldCfg, "enableLavaOreOverworldGeneration");
    }
    
    //This baby does all the hard work.
    //I have rewritten this damn thing so many times.
    //As it is now, you can generate an ore in any one biome, any specific combination of biomes, or the whole overworld.
    //It's only flaw is that you cannot easily have it generate an ore in all biomes. If you wanted that, you could add an extra boolean for it and set up another if else that doesn't exclude NETHER and THEEND from the catchall.
    //To generate it in the whole overworld, just pass in an empty Category[]
    //To generate it in a specific overworld biome(s), pass a Category[] with those biome(s). Biomes include NETHER and THEEND.
    public static void setupOreGenPart2(Category[] wantedBiomes, OreFeatureConfig.FillerBlockType stoneType, Block wantedBlock, boolean configSwitch, int veinSize, CountRangeConfig cfg, String configSwitchName) {
    //Check for and handle requests for one specific biome or multiple specific biomes	
    if(wantedBiomes.length > 0) {
    	//Loop through biomes in the forge registry (this allows modded biomes too, hypothetically, that's why we don't loop through vanilla biomes only)
		if(configSwitch == true){
    		for(Biome biome : ForgeRegistries.BIOMES.getValues()) {
    		//Use ArrayUtils to see if our Category[] wantedBiomes contains the current biome in the loop, and if so, generate the ore.
    			if(ArrayUtils.contains(wantedBiomes, biome.getCategory()))
    			{
    				//This is how we actually add the ore generation to the biome(s)
    				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
							new OreFeatureConfig(stoneType, wantedBlock.getDefaultState(), veinSize))
							.withPlacement(Placement.COUNT_RANGE.configure(cfg)));

					MoreFuelsMod.LOGGER.info("MFM: Added an ore: " + wantedBlock + " to biome: " + biome.getCategory());
    			}
    		}
    	} 
    	else if(configSwitch == false) {
			//If !configSwitch (i.e. disabled by end user in config file), terminate the loop and return without inserting the ore into any biome.]
			MoreFuelsMod.LOGGER.info("MFM: Skipping OreGen because " + configSwitchName + " = false");
    		return;
    	}
  
    }
    
    //Check for and handle requests for generating an ore in all the overworld biomes. This is what happens if you pass in an empty Character[]
    else if(wantedBiomes.length == 0) {
    //This if statement is what allows us to control this ore generation with a config
    if(configSwitch == true) {
    	for(Biome biome : ForgeRegistries.BIOMES.getValues()) {
    		//For any biome that ISN'T the end of the nether, we're going to execute our oregen code
    		if(!(biome.getCategory() == Biome.Category.THEEND || biome.getCategory() == Biome.Category.NETHER))
    		{
				//This is how we actually add the ore generation to the biome(s)
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
						new OreFeatureConfig(stoneType, wantedBlock.getDefaultState(), veinSize))
						.withPlacement(Placement.COUNT_RANGE.configure(cfg)));
			}
		}
		MoreFuelsMod.LOGGER.info("MFM: Added an ore: " + wantedBlock + " to all Overworld biomes");
    }
    else if(configSwitch == false) {
    	//If !configSwitch (i.e. disabled by end user in config file), terminate the loop and return without inserting the ore into any biome.
		MoreFuelsMod.LOGGER.info("MFM: Skipping OreGen because " + configSwitchName + " = false");
		return;
    			}
    		}
    	}
	
}