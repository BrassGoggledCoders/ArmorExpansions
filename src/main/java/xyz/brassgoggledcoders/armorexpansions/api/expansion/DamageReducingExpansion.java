package xyz.brassgoggledcoders.armorexpansions.api.expansion;

import net.minecraft.inventory.EquipmentSlotType;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;

import java.util.function.Function;

//TODO Convert to more generic attribute modifying type
public class DamageReducingExpansion extends Expansion<DamageReducingExpansion> {

    int damageReduction;

    public DamageReducingExpansion(int damageReduction, EquipmentSlotType... type) {
        super(() -> AREXAPI.getExpansionType("damage_reduction"), type);
        this.damageReduction = damageReduction;
    }

    public int getDamageReduction() {
        return damageReduction;
    }
}
