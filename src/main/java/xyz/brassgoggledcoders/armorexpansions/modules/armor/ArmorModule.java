package xyz.brassgoggledcoders.armorexpansions.modules.armor;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.modules.armor.items.ItemExpandableArmor;

@Module(value = ArmorExpansions.ID)
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
		itemRegistry.register(expandableHelmet);
		expandableChestplate =
				new ItemExpandableArmor(ArmorMaterial.IRON, EntityEquipmentSlot.CHEST, "expandable_chestplate");
		itemRegistry.register(expandableChestplate);
		expandableLeggings =
				new ItemExpandableArmor(ArmorMaterial.IRON, EntityEquipmentSlot.LEGS, "expandable_leggings");
		itemRegistry.register(expandableLeggings);
		expandableBoots = new ItemExpandableArmor(ArmorMaterial.IRON, EntityEquipmentSlot.FEET, "expandable_boots");
		itemRegistry.register(expandableBoots);
	}
}
