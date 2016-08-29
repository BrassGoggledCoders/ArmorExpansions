package xyz.brassgoggledcoders.armorexpansions.api.extensioncontainer;

import net.minecraft.util.ResourceLocation;
import xyz.brassgoggledcoders.armorexpansions.api.extension.IExtension;

public interface IExtensionContainer {
	ResourceLocation getIdentifier();

	boolean canAcceptExtension(IExtension extension);
}
