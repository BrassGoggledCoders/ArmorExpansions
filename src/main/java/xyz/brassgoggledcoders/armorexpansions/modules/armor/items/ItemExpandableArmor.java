package xyz.brassgoggledcoders.armorexpansions.modules.armor.items;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import xyz.brassgoggledcoders.armorexpansions.api.AREXApi;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.ExpansionContainerHandler;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.IExpansionContainer;
import xyz.brassgoggledcoders.boilerplate.items.ItemArmorBase;

public class ItemExpandableArmor extends ItemArmorBase {

	public ItemExpandableArmor(ArmorMaterial mat, EntityEquipmentSlot slot, String name) {
		super(mat, slot, name, "expandable");
	}

	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
		return new CapabilityProvider();
	}

	public static class CapabilityProvider implements ICapabilityProvider {
		private IExpansionContainer container;

		public CapabilityProvider() {
			this.container = new ExpansionContainerHandler();
		}

		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
			if(capability == AREXApi.EXTENSION_CONTAINER_CAP)
				return true;
			return false;
		}

		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
			if(capability == AREXApi.EXTENSION_CONTAINER_CAP)
				return AREXApi.EXTENSION_CONTAINER_CAP.cast(container);
			return null;
		}
	}

}
