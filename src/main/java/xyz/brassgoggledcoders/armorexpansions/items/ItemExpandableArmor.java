package xyz.brassgoggledcoders.armorexpansions.items;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.ExpansionContainerHandler;

public class ItemExpandableArmor extends ArmorItem {

    public ItemExpandableArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties builderIn) {
        super(materialIn, slot, builderIn.maxStackSize(1));
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
        return new CapabilityProvider();
    }

    public static class CapabilityProvider implements ICapabilityProvider {
        @Override
        public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction facing) {
            return capability == AREXAPI.EXTENSION_CONTAINER_CAP ? LazyOptional.of(ExpansionContainerHandler::new).cast() : LazyOptional.empty();
        }
    }

}
