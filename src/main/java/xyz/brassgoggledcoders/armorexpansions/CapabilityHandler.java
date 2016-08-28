package xyz.brassgoggledcoders.armorexpansions;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import xyz.brassgoggledcoders.armorexpansions.api.IModule;
import xyz.brassgoggledcoders.armorexpansions.api.IModuleHandler;

public class CapabilityHandler {

	@CapabilityInject(IModule.class)
	public static final Capability<IModule> MODULE_CAPABILITY = null;

	@CapabilityInject(IModuleHandler.class)
	public static final Capability<IModuleHandler> MODULE_HANDLER_CAPABILITY = null;

	public static void init() {
		// TODO Setup caps
	}
}
