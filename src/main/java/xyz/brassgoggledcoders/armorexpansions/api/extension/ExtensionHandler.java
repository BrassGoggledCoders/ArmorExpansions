package xyz.brassgoggledcoders.armorexpansions.api.extension;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ExtensionHandler implements IExtension {
	@Override
	public ResourceLocation getIdentifier() {
		return new ResourceLocation("");
	}

	@Override
	public ExtensionType getExtensionType() {
		return ExtensionType.ALLARMOR;
	}

	@Override
	public boolean canApplyTo(ItemStack targetPiece) {
		return true;
	}
}
