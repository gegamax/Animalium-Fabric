package animalium.common;

import net.fabricmc.fabric.api.event.player.PlayerJumpCallback;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

import animalium.init.ModItems;

public class CommonEvents {

	public static void registerEvents() {
		PlayerJumpCallback.EVENT.register(CommonEvents::onEntityJump);
	}

	private static void onEntityJump(Player player, boolean isSprintJump) {
		ItemStack is = player.getItemBySlot(EquipmentSlot.FEET);
		if (!is.isEmpty() && is.getItem() == ModItems.WILD_DOG_PELT_BOOTS.get() && !player.isCrouching()) {
			float f = 0.82F;
			Vec3 movement = player.getDeltaMovement();
			player.setDeltaMovement(movement.x, (double) f, movement.z);
			if (player.isSprinting()) {
				float f1 = player.getYRot() * ((float) Math.PI / 180F);
				player.setDeltaMovement(player.getDeltaMovement().add((double) (-Math.sin(f1) * 0.2F), 0.0D, (double) (Math.cos(f1) * 0.2F)));
			}
			player.setOnGround(false);
		}
	}
}