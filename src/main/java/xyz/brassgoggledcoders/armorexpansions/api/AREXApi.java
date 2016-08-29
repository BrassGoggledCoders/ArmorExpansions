package xyz.brassgoggledcoders.armorexpansions.api;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import xyz.brassgoggledcoders.armorexpansions.api.extension.ExtensionHandler;
import xyz.brassgoggledcoders.armorexpansions.api.extension.IExtension;
import xyz.brassgoggledcoders.armorexpansions.api.extensioncontainer.ExtensionContainerHandler;
import xyz.brassgoggledcoders.armorexpansions.api.extensioncontainer.IExtensionContainer;

public class AREXApi {
	@CapabilityInject(IExtension.class)
	public static Capability<IExtension> EXTENSION_CAP;

	@CapabilityInject(IExtensionContainer.class)
	public static Capability<IExtensionContainer> EXTENSION_CONTAINER_CAP;

	public static void registerCaps() {
		CapabilityManager.INSTANCE.register(IExtensionContainer.class, new Capability.IStorage<IExtensionContainer>() {
			@Override
			public NBTBase writeNBT(Capability<IExtensionContainer> capability, IExtensionContainer instance,
					EnumFacing side) {
				return new NBTTagCompound();
			}

			@Override
			public void readNBT(Capability<IExtensionContainer> capability, IExtensionContainer instance,
					EnumFacing side, NBTBase nbt) {

			}
		}, ExtensionContainerHandler::new);

		CapabilityManager.INSTANCE.register(IExtension.class, new Capability.IStorage<IExtension>() {
			@Override
			public NBTBase writeNBT(Capability<IExtension> capability, IExtension instance, EnumFacing side) {
				return new NBTTagCompound();
			}

			@Override
			public void readNBT(Capability<IExtension> capability, IExtension instance, EnumFacing side, NBTBase nbt) {

			}
		}, ExtensionHandler::new);
	}
}
