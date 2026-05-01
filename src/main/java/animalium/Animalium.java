package animalium;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.loader.api.FabricLoader;

import animalium.init.ModCreativeTab;
import animalium.init.ModEntities;
import animalium.init.ModItems;
import animalium.utils.Util;
import animalium.configs.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Animalium implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger(Util.MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Animalium Fabric Mod");

		// Register items
		ModItems.registerItems();

		// Register entities
		ModEntities.registerEntities();

		// Register creative tabs
		ModCreativeTab.registerCreativeTabs();

		// Load config
		if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
			LOGGER.info("Animalium loaded in development environment");
		}
	}
}