package xyz.brassgoggledcoders.armorexpansions.api.extensionhandler;

import net.minecraft.util.ResourceLocation;
import xyz.brassgoggledcoders.armorexpansions.api.extension.IExtension;

public interface IExtensionHandler {
	ResourceLocation getIdentifier();

	boolean canAcceptExtension(IExtension extension);
}
