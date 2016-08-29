package xyz.brassgoggledcoders.armorexpansions.modules.armor;

import net.minecraft.util.ResourceLocation;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.ExpansionContainerHandler;

public class HelmetExpansionHandler extends ExpansionContainerHandler {
	@Override
	public ResourceLocation getIdentifier() {
		return new ResourceLocation(ArmorExpansions.ID, "expandable_helmet");
	}
}