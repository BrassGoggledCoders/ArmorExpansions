package xyz.brassgoggledcoders.armorexpansions.api.extensioncontainer;

import net.minecraft.util.ResourceLocation;
import xyz.brassgoggledcoders.armorexpansions.api.extension.IExtension;

public class ExtensionContainerHandler implements IExtensionContainer {
	@Override
	public ResourceLocation getIdentifier() {
		return new ResourceLocation("");
	}

	@Override
	public boolean canAcceptExtension(IExtension extension) {
		return true;
	}
}
