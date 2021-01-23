package xyz.brassgoggledcoders.armorexpansions.api.expansion;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import xyz.brassgoggledcoders.armorexpansions.content.AREXExpansionTypes;

import java.util.UUID;

public class AttributeExpansion extends Expansion<AttributeExpansion> {

    private final Multimap<Attribute, AttributeModifier> helmetAttributeMap, chestplateAttributeMap, leggingsAttributeMap, bootsAttributeMap;

    public AttributeExpansion(Multimap<Attribute, AttributeModifier> helmetAttributeMap, Multimap<Attribute, AttributeModifier> chestplateAttributeMap, Multimap<Attribute, AttributeModifier> leggingsAttributeMap, Multimap<Attribute, AttributeModifier> bootsAttributeMap, EquipmentSlotType... type) {
        super(AREXExpansionTypes.ATTRIBUTE::get, type);
        this.helmetAttributeMap = helmetAttributeMap;
        this.chestplateAttributeMap = chestplateAttributeMap;
        this.leggingsAttributeMap = leggingsAttributeMap;
        this.bootsAttributeMap = bootsAttributeMap;
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        switch(equipmentSlot) {
            case HEAD:
                return helmetAttributeMap;
            case CHEST:
                return chestplateAttributeMap;
            case LEGS:
                return leggingsAttributeMap;
            case FEET:
                return bootsAttributeMap;
            default:
                return ImmutableMultimap.of();
        }
    }

    public static class Builder {
        private final ImmutableMultimap.Builder<Attribute, AttributeModifier> helmetAttributeMap = new ImmutableMultimap.Builder<>();
        private final ImmutableMultimap.Builder<Attribute, AttributeModifier> chestplateAttributeMap = new ImmutableMultimap.Builder<>();
        private final ImmutableMultimap.Builder<Attribute, AttributeModifier> leggingsAttributeMap = new ImmutableMultimap.Builder<>();
        private final ImmutableMultimap.Builder<Attribute, AttributeModifier> bootsAttributeMap = new ImmutableMultimap.Builder<>();

        public Builder addAttributeModifier(Attribute attribute, String nameIn, double amountIn, AttributeModifier.Operation operationIn) {
            helmetAttributeMap.put(attribute, new AttributeModifier(UUID.randomUUID(), nameIn, amountIn, operationIn));
            chestplateAttributeMap.put(attribute, new AttributeModifier(UUID.randomUUID(), nameIn, amountIn, operationIn));
            leggingsAttributeMap.put(attribute, new AttributeModifier(UUID.randomUUID(), nameIn, amountIn, operationIn));
            bootsAttributeMap.put(attribute, new AttributeModifier(UUID.randomUUID(), nameIn, amountIn, operationIn));
            return this;
        }

        public AttributeExpansion build(EquipmentSlotType... types) {
            return new AttributeExpansion(helmetAttributeMap.build(), chestplateAttributeMap.build(), leggingsAttributeMap.build(), bootsAttributeMap.build(), types);
        }
    }
}
