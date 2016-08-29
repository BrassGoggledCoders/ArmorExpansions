package xyz.brassgoggledcoders.armorexpansions.modules.expansions;

import net.minecraft.item.Item;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.modules.expansions.items.ItemDummyExpansion;
import xyz.brassgoggledcoders.boilerplate.module.Module;
import xyz.brassgoggledcoders.boilerplate.module.ModuleBase;
import xyz.brassgoggledcoders.boilerplate.registries.ConfigRegistry;
import xyz.brassgoggledcoders.boilerplate.registries.ItemRegistry;

@Module(mod = ArmorExpansions.ID)
public class ExpansionsModule extends ModuleBase {

	public static Item dummy;

	@Override
	public String getName() {
		return "Expansions";
	}

	@Override
	public void registerItems(ConfigRegistry configRegistry, ItemRegistry itemRegistry) {
		dummy = new ItemDummyExpansion("dummy");
		itemRegistry.registerItem(dummy);
	}
}
