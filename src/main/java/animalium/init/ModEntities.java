package animalium.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

import animalium.common.entities.EntityBear;
import animalium.common.entities.EntityNeutralBear;
import animalium.common.entities.EntityPiranha;
import animalium.common.entities.EntityRat;
import animalium.common.entities.EntityWildDog;
import animalium.utils.Util;

public class ModEntities {

	public static EntityType<EntityPiranha> PIRANHA;
	public static EntityType<EntityWildDog> WILD_DOG;
	public static EntityType<EntityBear> BEAR;
	public static EntityType<EntityNeutralBear> BEAR_TAMED;
	public static EntityType<EntityRat> RAT;

	public static void registerEntities() {
		PIRANHA = registerEntity("piranha", FabricEntityTypeBuilder.create(MobCategory.MONSTER, EntityPiranha::new)
				.dimensions(0.9F, 0.9F)
				.build());

		WILD_DOG = registerEntity("wild_dog", FabricEntityTypeBuilder.create(MobCategory.MONSTER, EntityWildDog::new)
				.dimensions(0.9F, 1.2F)
				.build());

		BEAR = registerEntity("bear", FabricEntityTypeBuilder.create(MobCategory.MONSTER, EntityBear::new)
				.dimensions(2F, 2F)
				.build());

		BEAR_TAMED = registerEntity("bear_tamed", FabricEntityTypeBuilder.create(MobCategory.MONSTER, EntityNeutralBear::new)
				.dimensions(2F, 2F)
				.trackRangeChunks(3)
				.trackedUpdateRate(1)
				.build());

		RAT = registerEntity("rat", FabricEntityTypeBuilder.create(MobCategory.MONSTER, EntityRat::new)
				.dimensions(0.9F, 0.9F)
				.build());

		registerSpawnPlacements();
	}

	private static <T extends EntityType<?>> T registerEntity(String name, T entityType) {
		Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(Util.MOD_ID, name), entityType);
		return entityType;
	}

	private static void registerSpawnPlacements() {
		SpawnPlacements.register(BEAR, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityBear::canSpawnHere);
		SpawnPlacements.register(PIRANHA, SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityPiranha::canSpawnHere);
		SpawnPlacements.register(WILD_DOG, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityWildDog::canSpawnHere);
		SpawnPlacements.register(RAT, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityRat::canSpawnHere);
	}
}