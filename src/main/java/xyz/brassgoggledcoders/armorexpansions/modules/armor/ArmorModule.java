package xyz.brassgoggledcoders.armorexpansions.modules.armor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.modules.armor.items.ItemExpandableArmor;
import xyz.brassgoggledcoders.boilerplate.module.Module;
import xyz.brassgoggledcoders.boilerplate.module.ModuleBase;
import xyz.brassgoggledcoders.boilerplate.registries.ConfigRegistry;
import xyz.brassgoggledcoders.boilerplate.registries.ItemRegistry;

@Module(mod = ArmorExpansions.ID)
public class ArmorModule extends ModuleBase {

	public static Item expandableHelmet, expandableChestplate, expandableLeggings, expandableBoots;

	@Override
	public String getName() {
		return "Armor";
	}

	@Override
	public void registerItems(ConfigRegistry configRegistry, ItemRegistry itemRegistry) {
		// TODO custom unbreakable armor material?
		expandableHelmet = new ItemExpandableArmor(ArmorMaterial.IRON, EntityEquipmentSlot.HEAD, "expandable_helmet");
		itemRegistry.registerItem(expandableHelmet);
		expandableChestplate =
				new ItemExpandableArmor(ArmorMaterial.IRON, EntityEquipmentSlot.CHEST, "expandable_chestplate");
		itemRegistry.registerItem(expandableChestplate);
		expandableLeggings =
				new ItemExpandableArmor(ArmorMaterial.IRON, EntityEquipmentSlot.LEGS, "expandable_leggings");
		itemRegistry.registerItem(expandableLeggings);
		expandableBoots = new ItemExpandableArmor(ArmorMaterial.IRON, EntityEquipmentSlot.FEET, "expandable_boots");
		itemRegistry.registerItem(expandableBoots);
	}
}
