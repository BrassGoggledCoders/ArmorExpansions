package xyz.brassgoggledcoders.armorexpansions.api.expansion;

import net.minecraft.inventory.EquipmentSlotType;

public enum ExpansionType {
    LEGGINGS,
    CHESTPLATE,
    HELMET,
    BOOTS,
    ALLARMOR,
    WEAPON,
    GLOVE;

    public static EquipmentSlotType getEquipmentSlotTypeFromExpansionType(ExpansionType type) {
        switch(type) {
            case HELMET:
                return EquipmentSlotType.HEAD;
            case CHESTPLATE:
                return EquipmentSlotType.CHEST;
            case LEGGINGS:
                return EquipmentSlotType.LEGS;
            case BOOTS:
                return EquipmentSlotType.FEET;
            default:
                return null;
        }
    }
}
