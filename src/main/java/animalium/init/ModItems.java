package animalium.init;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

import com.google.common.collect.Sets;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

import animalium.common.items.ItemBearClawPaxel;
import animalium.common.items.ItemDogPeltBoots;
import animalium.common.items.ItemRatMeat;
import animalium.utils.Util;

public class ModItems {

	public static LinkedHashSet<Item> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

	// Items
	public static Item WILD_DOG_PELT;
	public static Item BEAR_MEAT;
	public static Item BEAR_MEAT_COOKED;
	public static Item BEAR_CLAW;
	public static Item BEAR_CLAW_PAXEL;
	public static Item RAT_MEAT;
	public static Item RAT_MEAT_COOKED;
	public static Item WILD_DOG_PELT_BOOTS;
	public static Item PIRANHA_STEAK;
	public static Item PIRANHA_STEAK_COOKED;

	public static void registerItems() {
		WILD_DOG_PELT = registerWithTab("wild_dog_pelt", () -> new Item(basicItem()));
		BEAR_MEAT = registerWithTab("bear_meat", () -> new Item(basicItem().food(foodItem().nutrition(3).saturationMod(0.3F).meat().build())));
		BEAR_MEAT_COOKED = registerWithTab("bear_meat_cooked", () -> new Item(basicItem().food(foodItem().nutrition(8).saturationMod(0.1f).build())));
		BEAR_CLAW = registerWithTab("bear_claw", () -> new Item(basicItem()));
		BEAR_CLAW_PAXEL = registerWithTab("bear_claw_paxel", () -> new ItemBearClawPaxel(ModToolTiers.PAXEL, properties -> properties.rarity(Rarity.RARE)));
		RAT_MEAT = registerWithTab("rat_meat", () -> new ItemRatMeat(basicItem().food(foodItem()
				.nutrition(2).saturationMod(0.3f)
				.effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3f).build())));
		RAT_MEAT_COOKED = registerWithTab("rat_meat_cooked", () -> new Item(basicItem().food(foodItem().nutrition(4).saturationMod(0.6f).build())));
		WILD_DOG_PELT_BOOTS = registerWithTab("wild_dog_pelt_boots", () -> new ItemDogPeltBoots(ModArmourMaterials.ARMOUR_DOG_PELT, ArmorItem.Type.BOOTS, basicItem()));
		PIRANHA_STEAK = registerWithTab("piranha_steak", () -> new Item(basicItem().food(foodItem().nutrition(2).saturationMod(0.8f).build())));
		PIRANHA_STEAK_COOKED = registerWithTab("piranha_steak_cooked", () -> new Item(basicItem().food(foodItem().nutrition(4).saturationMod(0.6F).build())));

		// Register spawn eggs
		registerSpawnEggs();
	}

	public static Item registerWithTab(final String name, final Supplier<Item> supplier) {
		Item item = supplier.get();
		Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Util.MOD_ID, name), item);
		CREATIVE_TAB_ITEMS.add(item);
		return item;
	}

	public static Item.Properties basicItem() {
		return new Item.Properties();
	}

	public static FoodProperties.Builder foodItem() {
		return new FoodProperties.Builder();
	}

	private static void registerSpawnEggs() {
		// Spawn eggs using Fabric's built-in SpawnEggItem
		registerWithTab("bear_spawn_egg", () -> new net.minecraft.world.item.SpawnEggItem(ModEntities.BEAR, -3546547, -65179583, basicItem()));
		registerWithTab("wild_dog_spawn_egg", () -> new net.minecraft.world.item.SpawnEggItem(ModEntities.WILD_DOG, -310, -65179583, basicItem()));
		registerWithTab("rat_spawn_egg", () -> new net.minecraft.world.item.SpawnEggItem(ModEntities.RAT, -3546547, -65179583, basicItem()));
		registerWithTab("piranha_spawn_egg", () -> new net.minecraft.world.item.SpawnEggItem(ModEntities.PIRANHA, -126, -48326583, basicItem()));
	}
}