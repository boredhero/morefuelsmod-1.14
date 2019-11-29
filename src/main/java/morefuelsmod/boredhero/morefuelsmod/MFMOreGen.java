package morefuelsmod.boredhero.morefuelsmod;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

import morefuelsmod.boredhero.morefuelsmod.init.MFMBlockStates;
import morefuelsmod.boredhero.morefuelsmod.init.MFMBlocks;

/*
 * Base class that I heavily *heavily* modified was based from here:
 * Source: https://www.minecraftforge.net/forum/topic/72953-1143-working-ore-generation-class/
 */

public class MFMOreGen {
    
    //These are switches for a config to eventually change. For now, they are always set to true.
    //Ex: final static boolean enableBlockNameGeneration = true;
    final static boolean enableBituminousGeneration = true;
    final static boolean enableLavaOreGeneration = true;
    
    //These are vein sizes
    //Ex: private static final int blockNameVeinSize = a positive integer for the number of blocks in the vein
    private static final int bituminousVeinSize = 5;
    private static final int lavaOreVeinSize = 3;
    
    //CountRangeConfig(Veins Per Chunk Count, MinHeight, MaxHeightBase, MaxHeight)
    //Ex: private static final CountRangeConfig blockNameCfg = new CountRangeConfig(Veins Per Chunk Count, MinHeight, MaxHeightBase, MaxHeight);
    //As far as I can tell, MaxHeightBase should always be 0 in most if not all ore generation cases.
    private static final CountRangeConfig bituminousCfg = new CountRangeConfig(30, 1, 0, 128);
    private static final CountRangeConfig lavaOreCfg = new CountRangeConfig(30, 1, 0, 128);
    //These are static Category arrays of Biome.Category.BIOMETYPE to pass into setupOreGenPart2 to do its thing.
    //This is an experimental thing on my part.
    static Category[] lavaOreBiomes = {Biome.Category.NETHER};
    static Category[] bituminousBiomes = {};
    
    //The first part of my redesigned OreGen class. This just calls another method that does all the work and feeds it what it needs.
    public static void setupOreGenPart1() {
    	//Call setupOreGenPart2 and feed it all the pre-configured data we've set up that it needs.
    	//The syntax is setupOreGenPart2 (static Category[] of Biome.Category.BIOMEs or uninitialized,
    	//OreFeatureConfig.FillerBlockType.BLOCKTYPE (NETHERRACK or NATURAL_STONE)
    	//A boolean that you can check with your config, or just hard code send it a false to avoid that step
    	//A vein size integer
    	//A CountRangeConfig object with the Veins Per Chunk, MinHeight, MaxHeightBase (should be 0), and MaxHeight
    	setupOreGenPart2(lavaOreBiomes, OreFeatureConfig.FillerBlockType.NETHERRACK, MFMBlocks.block_lava_ore, enableLavaOreGeneration, lavaOreVeinSize, lavaOreCfg);
    	setupOreGenPart2(bituminousBiomes, OreFeatureConfig.FillerBlockType.NATURAL_STONE, MFMBlocks.block_bituminous_coal_ore, enableBituminousGeneration, bituminousVeinSize, bituminousCfg);
    }
    
    //This baby does all the hard work.
    //I have rewritten this damn thing so many times.
    //As it is now, you can generate an ore in any one biome, any specific combination of biomes, or the whole overworld.
    //It's only flaw is that you cannot easily have it generate an ore in all biomes. If you wanted that, you could add an extra boolean for it and set up another if else that doesn't exclude NETHER and THEEND from the catchall.
    //To generate it in the whole overworld, just pass in an empty Category[]
    //To generate it in a specific overworld biome(s), pass a Category[] with those biome(s). Biomes include NETHER and THEEND.
    public static void setupOreGenPart2(Category[] wantedBiomes, OreFeatureConfig.FillerBlockType stoneType, Block wantedBlock, boolean configSwitch, int veinSize, CountRangeConfig cfg) {
    
    //Check for and handle requests for one specific biome or multiple specific biomes	
    if(wantedBiomes.length > 0) {
    	//Loop through biomes in the forge registry (this allows modded biomes too, hypothetically, that's why we don't loop through vanilla biomes only)
    	if(configSwitch) {
    		for(Biome biome : ForgeRegistries.BIOMES.getValues()) {
    		//Use ArrayUtils to see if our Category[] wantedBiomes contains the current biome in the loop, and if so, generate the ore.
    			if(ArrayUtils.contains(wantedBiomes, biome.getCategory())) {
    				//This is how we actually add the ore generation to the biome(s)
    					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(stoneType, wantedBlock.getDefaultState(), veinSize), Placement.COUNT_RANGE, cfg));
    				} //end if(ArrayUtils.contains(wantedBiomes...)
    			} //End for loop
    	} //End if(configSwitch)
    	else if(!configSwitch) {
    		//If !configSwitch (i.e. disabled by end user in config file), terminate the loop and return without inserting the ore into any biome.
    		return;
    	}//End else if(!configSwitch)
  
    } //End check for length > 0
    
    //Check for and handle requests for generating an ore in all the overworld biomes. This is what happens if you pass in an empty Character[]
    else if(wantedBiomes.length == 0) {
    //This if statement is what allows us to control this ore generation with a config
    if(configSwitch) {
    	for(Biome biome : ForgeRegistries.BIOMES.getValues()) {
    		//For any biome that ISN'T the end of the nether, we're going to execute our oregen code
    		if(!(biome.getCategory() == Biome.Category.THEEND || biome.getCategory() == Biome.Category.NETHER)) {
    			//This is how we actually add the ore generation to the biome(s)
    			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(stoneType, wantedBlock.getDefaultState(), veinSize), Placement.COUNT_RANGE, cfg));
    		}//End if check
    	}// End for loop
    }//End if(configSwitch) check
    else if(!configSwitch) {
    	//If !configSwitch (i.e. disabled by end user in config file), terminate the loop and return without inserting the ore into any biome.
    	return;
    }
    }//End else if
    }//End setup oreGenPart2
	
 //NOTE/TODO: IF THE AVOVE METHOD FAILS, FALLBACK TO THIS COMMENTED CODE!   
 /*
    public static void setupOreGen()
    {
    	for (Biome biome: ForgeRegistries.BIOMES.getValues())
        {
            // we have no End or Nether ores, so skip those.
            if (  biome.getCategory() == Biome.Category.THEEND || biome.getCategory() == Biome.Category.NETHER)
            {
                continue;
            }
            
            // Overworld-type Ore generation
            
            
            
            if (enableBituminousGeneration)
            {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, MFMBlockStates.BLOCK_BITUMINOUS_COAL_ORE, bituminousVeinSize),Placement.COUNT_RANGE, bituminousCfg));
        	} // end if copper_ore
		} // end for biomes
    	
    	
    	 This is sloppy, probably, but I want to make sure the LavaOre only generates in the nether. Should be looked over and condensed back into one for loop later...
    	 
    	for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
    		//ignore OVERWORLD and THEEND
    		if(biome.getCategory() != Biome.Category.NETHER)
    			continue;
    		
    		if(enableLavaOreGeneration) {
    			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,  MFMBlockStates.BLOCK_LAVA_ORE, lavaOreVeinSize),Placement.COUNT_RANGE, lavaOreCfg);
    		}
    		
    	}
	} // end setupOreGen() */
    
} // END OF MFMOREGEN.JAVA