package xyz.brassgoggledcoders.armorexpansions.api.expansion;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import xyz.brassgoggledcoders.armorexpansions.content.AREXExpansionTypes;

public class AttributeExpansion extends Expansion<AttributeExpansion> {

    private final Multimap<Attribute, AttributeModifier> attributeMap;

    public AttributeExpansion(Multimap<Attribute, AttributeModifier> attributeMap, EquipmentSlotType... type) {
        super(AREXExpansionTypes.ATTRIBUTE::get, type);
        this.attributeMap = attributeMap;
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        return attributeMap;
    }

    public static class Builder {
        private final ImmutableMultimap.Builder<Attribute, AttributeModifier> attributeMap = new ImmutableMultimap.Builder<>();

        public Builder addAttributeModifier(Attribute attribute, AttributeModifier modifier) {
            attributeMap.put(attribute, modifier);
            return this;
        }

        public AttributeExpansion build(EquipmentSlotType... types) {
            return new AttributeExpansion(attributeMap.build(), types);
        }
    }
}
