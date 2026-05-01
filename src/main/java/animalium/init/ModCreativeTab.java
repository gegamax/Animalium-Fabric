package animalium.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import animalium.utils.Util;

public class ModCreativeTab {

	public static CreativeModeTab TAB_ANIMALIUM;

	public static void registerCreativeTabs() {
		TAB_ANIMALIUM = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Util.MOD_ID, "animalium_tab"),
				CreativeModeTab.builder()
				.icon(() -> new ItemStack(ModItems.BEAR_CLAW))
				.title(Component.literal("Animalium"))
				.displayItems((parameters, output) -> ModItems.CREATIVE_TAB_ITEMS.forEach(output::accept))
				.build());
	}
}