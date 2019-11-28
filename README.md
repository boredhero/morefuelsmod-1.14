# morefuelsmod-1.14
Super early testing. This is buggy and may not work at all. Use at your own risk.

### Contributors
* Noah Martino (personal.boredhero@gmail.com)

### Basic Setup Instructions

#### Dependencies:
* Eclipse for Java Developers
* JDK 8 (preferred), 9, or 10 (11+ will not work with this version of Minecraft/Forge)
	* Linux users of the world, yes, OpenJDK is just fine. 
* git command line tools OR GUI git client

#### Steps:
* cd into morefuelsmod-1.14 folder
* run command: "gradlew eclipse" or "./gradlew eclipse" (for Linux/Mac)
* run command: "gradlew genEclipseRuns" or "./gradlew genEclipseRuns" (for Linux/Mac)
* Open Eclipse, Import > Existing Gradle Project > Select Folder or run "gradlew eclipse" to generate the project.

#### Building a Jar:
* cd into morefuelsmod-1.14 folder
* run command: "gradlew build" or "./gradlew build" (for Linux/Mac)

#### Further Notes:
* While it *IS* possible to use IntelliJ IDEA, I **strongly prefer** contributors to use Eclipse just to keep the code nice n pure since this repo has more than just the src folder.
* You can configure the amount of RAM used for script operations/build operations in gradle.properties. Default for this repo is 4 but adjust accordingly.

### Building

#### Basic Instructions:
* cd into morefuelsmod-1.14 directory
* run command: "gradlew build" or "./gradlew build" (for Linux/Mac)
* jar file will be in /morefuelsmod-1.14/build/libs/

#### Advanced:
* jar filename is set to modid-version.jar
* You can change these variables in the file "build.gradle"
	* version = 'version-number"
		* Please use something like Semantic Versioning.
	* group = 'com.yourname.modid'
		* The packaging format for forge mods must be this way.
		* Your main class file should be your modid.
		* The last level/directory name of your package should be your modid.
	* archivesBaseName = 'modid'
		* This can actually be whatever you want but **should** be your modid.
		* It will show up on the other side of the - before the version in the outputted built jar file.

### Test in Game without building
* Make sure you edit the launch files to make sure any reference to "examplemod" is replaced with your modid
* You can run this from Eclipse if you want, but I've had issues with this working on 1.14
* The easiest way is to run command: "gradlew runClient"/"gradlew runServer" or "./gradlew runClient"/"./gradlew runServer" (for Linux/Mac)

## TODO:

* Set textures/models for blocks.
* Figure out how to get the ore blocks to drop specific items rather than their own ItemBlocks
* Do an assessment of what fuel tweaks are necessary in 1.14.4 before implemeneting them.
* Implement fuel tweaks as per assessment.
* Implement block/item crafting recipies and fuel timings.
* Do some polishing work on the mods.toml file
* Make a stripped down version and release as More Fuels Mod Light
* Adjust versioning number to 1.6.3 before final build.
