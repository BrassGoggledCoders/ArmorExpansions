package xyz.brassgoggledcoders.armorexpansions.modules.expansions.items;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.ExpansionHandler;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.IExpansion;
import xyz.brassgoggledcoders.boilerplate.items.ItemBase;

public class ItemDummyExpansion extends ItemBase {

	public ItemDummyExpansion(String name) {
		super(name);
	}

	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
		return new CapabilityProvider(stack);
	}

	public static class CapabilityProvider implements ICapabilityProvider {
		private IExpansion extension;

		public CapabilityProvider(ItemStack stack) {
			extension = new DummyExpansion();
		}

		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
			if(capability == AREXAPI.EXTENSION_CAP)
				return true;
			return false;
		}

		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
			return AREXAPI.EXTENSION_CAP.cast(extension);
		}
	}

	public static class DummyExpansion extends ExpansionHandler {
		@Override
		public ResourceLocation getIdentifier() {
			return new ResourceLocation(ArmorExpansions.ID, "dummy");
		}

	}
}
