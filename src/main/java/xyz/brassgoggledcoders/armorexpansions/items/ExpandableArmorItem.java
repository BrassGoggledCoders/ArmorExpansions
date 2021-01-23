package xyz.brassgoggledcoders.armorexpansions.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
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
import xyz.brassgoggledcoders.armorexpansions.api.expansion.AttributeExpansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.TickingExpansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.ExpansionContainer;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.ItemStackExpansionContainerProvider;
import xyz.brassgoggledcoders.armorexpansions.content.AREXExpansionTypes;

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
            if(cap instanceof ExpansionContainer) {
                ((ExpansionContainer) cap).load();
                tooltip.add(new StringTextComponent("Maximum Number of Expansions: " + cap.getMaximumNumberOfExpansions()));
                cap.getAllExpansions().forEach(expansion -> tooltip.add(expansion.getDisplayName()));
            }
        });
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
        return new ItemStackExpansionContainerProvider(stack, 10);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        stack.getCapability(AREXAPI.EXPANSION_CONTAINER_CAP).ifPresent(cap -> {
            if (cap instanceof ExpansionContainer && cap.isActive()) {
                cap.getExpansionsOfType(AREXExpansionTypes.TICKING.get(), TickingExpansion.class).forEach(expansion -> expansion.getTick().accept(stack, world, player));
            }
        });
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        stack.getCapability(AREXAPI.EXPANSION_CONTAINER_CAP).ifPresent(cap -> {
            if (cap instanceof ExpansionContainer && cap.isActive()) {
                cap.getExpansionsOfType(AREXExpansionTypes.ATTRIBUTE.get(), AttributeExpansion.class).forEach(expansion -> builder.putAll(expansion.getAttributeModifiers(equipmentSlot, stack)));
            }
        });
        return equipmentSlot == this.slot ? builder.build() : super.getAttributeModifiers(equipmentSlot);
    }
}