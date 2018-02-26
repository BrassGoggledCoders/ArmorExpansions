package xyz.brassgoggledcoders.armorexpansions.modules.armor.items;

import com.teamacronymcoders.base.items.ItemArmorBase;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.EnumHelper;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.api.AREXApi;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.ExpansionContainerHandler;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.IExpansionContainer;

public class ItemExpandableArmor extends ItemArmorBase {

	static ArmorMaterial expandable = EnumHelper.addArmorMaterial("expandable", ArmorExpansions.ID + ":warlord", -1,
			new int[] {0, 0, 0, 0}, 0, null, -1);

	public ItemExpandableArmor(ArmorMaterial mat, EntityEquipmentSlot slot, String name) {
		super(expandable, slot, name);
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
