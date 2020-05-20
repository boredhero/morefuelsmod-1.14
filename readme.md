![mf-logo](https://raw.githubusercontent.com/boredhero/morefuelsmod-1.14/master/src/main/resources/mf-logo.png)
# morefuelsmod
This is the active developemnt repo for MoreFuelsMod for Minecraft 1.14.4 and Onwards

### Author
* Noah Martino (personal.boredhero@gmail.com)

### License
* GNU GPLv3

### Basic Setup Instructions

#### Dependencies:
* Eclipse for Java Developers
* JDK 8 (preferred), 9, or 10+
	* Linux users of the world, yes, OpenJDK is just fine. 
* git command line tools (preferred) OR GUI git client

#### Steps:
* run command: ```git clone https://github.com/boredhero/morefuelsmod```
* ```cd``` into morefuelsmod folder
* ```git checkout {branchNameHere}```
	* We have two branches: ```1.14.4``` and ```1.15.2```
* run ```chmod +x gradlew1``` if using Linux or Mac

#### Eclipse
* run command: ```gradlew eclipse``` or ```./gradlew eclipse``` (Linux/Mac)
* run command: ```gradlew genEclipseRuns``` or ```./gradlew genEclipseRuns``` (Linux/Mac)
* Open Eclipse, File > Import > Existing Project > Select Folder > Import

#### IntelliJ IDEA
* run command: ```gradlew idea``` or ```./gradlew idea``` (Linux/Mac)
* run command: ```gradlew genIntellijRuns``` or ```./gradlew genIntellijRuns```
* Import to IntelliJ IDEA

#### VSCode
* run command: ```gradlew genVSCodeRuns``` or ```./gradlew genVSCodeRuns``` (Linux/Mac)
* Open as folder in VSCode

#### Further Notes:
* You can configure the amount of RAM used for script operations/build operations in gradle.properties. Default for this repo is 5 GB but adjust accordingly.

### Building a Jar

#### Basic Instructions:
* ```cd``` into morefuelsmod directory
* run command: ```gradlew build``` or ```./gradlew build``` (Linux/Mac)
* jar file will be in /morefuelsmod/build/libs/

#### Advanced:
* jar filename is set to modid-minecraftversion-version.jar
* You can change these variables in the file "build.gradle"
	* version = 'minecraftversion-version"
		* Please use something like Semantic Versioning for the "version" part of this!
	* group = 'io.modid'
		* The packaging format for forge mods must be this way.
		* Your main class file should be your modid.
		* The last level/directory name of your package should be your modid.
	* archivesBaseName = 'modid'
		* This can actually be whatever you want but **should** be your modid.
		* It will show up on the other side of the - before the version in the outputted built jar file.

### Test in Game without building
* Use the run tasks we made.
* If all else fails, run the commands above again to make new runs.
* If even this fails, there's always ```./gradlew runClient``` and ```./gradlew runServer``` but these are slower and shouldn't be default.

## TODO:

* Make a stripped down version and release as More Fuels Mod Light
	* Try to do this as a branch on this GitHub repo for better organization going forward

## Planned Features for v1.8.0
* Look into dynamically generating all json files ala [this](https://wiki.mcjty.eu/modding/index.php?title=Tut14_Ep7) to help aid in making them enableable/disableable via a config switch.
* GUI Config
* Allow RFtL disable from config.
* Investigate supporting Forge 1.14.2 and 1.14.3 as one jar
	* This may be a little more complicated now because of the mods.toml format. Not sure if it'll allow this at all.
* Make chorus and purpur flammable using rEfLeCtIoN (or Block Properties??)
* Add scrap metal
	* Make a furance that burns all the wood and outputs scrap metal
* Add processing methods for scrap metal to return back to usable ingots