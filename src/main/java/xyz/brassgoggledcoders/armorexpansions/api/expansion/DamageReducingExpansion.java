package xyz.brassgoggledcoders.armorexpansions.api.expansion;

import net.minecraft.inventory.EquipmentSlotType;
import xyz.brassgoggledcoders.armorexpansions.content.AREXExpansionTypes;

//TODO Convert to more generic attribute modifying type
public class DamageReducingExpansion extends Expansion<DamageReducingExpansion> {

    int damageReduction;

    public DamageReducingExpansion(int damageReduction, EquipmentSlotType... type) {
        super(AREXExpansionTypes.DAMAGE_REDUCING::get, type);
        this.damageReduction = damageReduction;
    }

    public int getDamageReduction() {
        return damageReduction;
    }
}
