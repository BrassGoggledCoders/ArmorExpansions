package xyz.brassgoggledcoders.armorexpansions.modules.armor.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.common.FMLLog;
import xyz.brassgoggledcoders.armorexpansions.api.AREXApi;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.ExpansionContainerHandler;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.IExpansionContainer;
import xyz.brassgoggledcoders.boilerplate.items.ItemArmorBase;

public class ItemExpandableArmor extends ItemArmorBase {

	EntityEquipmentSlot slot;

	public ItemExpandableArmor(ArmorMaterial mat, EntityEquipmentSlot slot, String name) {
		super(mat, slot, name, "expandable");
		this.slot = slot;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack is) {
		FMLLog.warning(is.getCapability(AREXApi.EXTENSION_CONTAINER_CAP, null).getContainedExpansions().toString());
	}

	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
		return new CapabilityProvider(slot);
	}

	public static class CapabilityProvider implements ICapabilityProvider {
		private IExpansionContainer container;

		public CapabilityProvider(EntityEquipmentSlot slot) {
			// switch(slot) {
			// case HEAD: {
			// container = new HelmetExpansionHandler();
			// break;
			// }
			// case CHEST: {
			// container = new ChestplateExpansionHandler();
			// break;
			// }
			// case LEGS: {
			// container = new LeggingsExpansionHandler();
			// break;
			// }
			// case FEET: {
			// container = new BootsExpansionHandler();
			// break;
			// }
			// default: {
			// container = new ExpansionContainerHandler();
			// break;
			// }
			// }
			container = new ExpansionContainerHandler();
		}

		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
			if(capability == AREXApi.EXTENSION_CONTAINER_CAP)
				return true;
			return false;
		}

		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
			return AREXApi.EXTENSION_CONTAINER_CAP.cast(container);
		}
	}

}
