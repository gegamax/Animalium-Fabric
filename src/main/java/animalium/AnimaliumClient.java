package animalium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import animalium.client.ClientEvents;
import animalium.client.model.ModelBear;
import animalium.client.model.ModelPiranha;
import animalium.client.model.ModelRat;
import animalium.client.model.ModelWildDog;
import animalium.client.render.entity.RenderBear;
import animalium.client.render.entity.RenderPiranha;
import animalium.client.render.entity.RenderRat;
import animalium.client.render.entity.RenderWildDog;
import animalium.init.ModEntities;

@Environment(EnvType.CLIENT)
public class AnimaliumClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		// Register entity model layers
		EntityModelLayerRegistry.registerModelLayer(ClientEvents.BEAR, ModelBear::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(ClientEvents.WILD_DOG, ModelWildDog::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(ClientEvents.RAT, ModelRat::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(ClientEvents.PIRANHA, ModelPiranha::createBodyLayer);

		// Register entity renderers
		EntityRendererRegistry.register(ModEntities.BEAR, RenderBear::new);
		EntityRendererRegistry.register(ModEntities.BEAR_TAMED, RenderBear::new);
		EntityRendererRegistry.register(ModEntities.WILD_DOG, RenderWildDog::new);
		EntityRendererRegistry.register(ModEntities.RAT, RenderRat::new);
		EntityRendererRegistry.register(ModEntities.PIRANHA, RenderPiranha::new);
	}
}