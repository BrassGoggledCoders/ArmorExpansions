package xyz.brassgoggledcoders.armorexpansions.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.TickingExpansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.ItemStackExpansionContainerProvider;

import javax.annotation.Nullable;
import java.util.List;

public class ExpandableArmorItem extends ArmorItem {

    public ExpandableArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties builderIn) {
        super(materialIn, slot, builderIn.maxStackSize(1));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        stack.getCapability(AREXAPI.EXPANSION_CONTAINER_CAP).ifPresent(cap -> {
            tooltip.add(new StringTextComponent("Maximum Number of Expansions: " + cap.getMaximumNumberOfExpansions()));
            cap.getAllExpansions().forEach(expansion -> tooltip.add(expansion.getExpansion().getDisplayName()));
        });
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
        return new ItemStackExpansionContainerProvider(stack, 10);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        //TODO Cache these filtered lists
        stack.getCapability(AREXAPI.EXPANSION_CONTAINER_CAP).ifPresent(cap -> {
            if(cap.isActive()) {
                cap.getAllExpansions()
                        .stream()
                        .filter(holder -> holder.getExpansion() instanceof TickingExpansion)
                        .map(holder -> (TickingExpansion)holder.getExpansion())
                        .forEach(expansion -> expansion.getTick().accept(stack, worldIn, entityIn));
            }
        });
    }
}
