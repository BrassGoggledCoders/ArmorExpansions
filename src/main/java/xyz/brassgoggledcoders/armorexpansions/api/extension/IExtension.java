package xyz.brassgoggledcoders.armorexpansions.api.extension;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public interface IExtension {
	ResourceLocation getIdentifier();

	ExtensionType getExtensionType();

	boolean canApplyTo(ItemStack targetPiece);
}
