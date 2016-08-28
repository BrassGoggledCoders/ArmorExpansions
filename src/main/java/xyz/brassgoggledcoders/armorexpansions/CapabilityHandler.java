package xyz.brassgoggledcoders.armorexpansions;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import xyz.brassgoggledcoders.armorexpansions.api.IExtension;
import xyz.brassgoggledcoders.armorexpansions.api.IExtensionHandler;

public class CapabilityHandler {

	@CapabilityInject(IExtension.class)
	public static final Capability<IExtension> EXTENSION_CAPABILITY = null;

	@CapabilityInject(IExtensionHandler.class)
	public static final Capability<IExtensionHandler> EXTENSION_HANDLER_CAPABILITY = null;

	public static void init() {
		// TODO Setup caps
	}
}
