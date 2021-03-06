package xyz.brassgoggledcoders.armorexpansions.api;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.*;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.ExpansionHandler;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.IExpansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.ExpansionContainerHandler;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.IExpansionContainer;

public class AREXApi {
	@CapabilityInject(IExpansion.class)
	public static Capability<IExpansion> EXTENSION_CAP;

	@CapabilityInject(IExpansionContainer.class)
	public static Capability<IExpansionContainer> EXTENSION_CONTAINER_CAP;

	public static void registerCaps() {
		CapabilityManager.INSTANCE.register(IExpansionContainer.class, new Capability.IStorage<IExpansionContainer>() {
			@Override
			public NBTBase writeNBT(Capability<IExpansionContainer> capability, IExpansionContainer instance,
					EnumFacing side) {
				return new NBTTagCompound();
			}

			@Override
			public void readNBT(Capability<IExpansionContainer> capability, IExpansionContainer instance,
					EnumFacing side, NBTBase nbt) {

			}
		}, ExpansionContainerHandler::new);

		CapabilityManager.INSTANCE.register(IExpansion.class, new Capability.IStorage<IExpansion>() {
			@Override
			public NBTBase writeNBT(Capability<IExpansion> capability, IExpansion instance, EnumFacing side) {
				return new NBTTagCompound();
			}

			@Override
			public void readNBT(Capability<IExpansion> capability, IExpansion instance, EnumFacing side, NBTBase nbt) {

			}
		}, ExpansionHandler::new);
	}
}
