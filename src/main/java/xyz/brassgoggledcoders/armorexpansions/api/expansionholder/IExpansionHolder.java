package xyz.brassgoggledcoders.armorexpansions.api.expansionholder;

import xyz.brassgoggledcoders.armorexpansions.api.expansion.Expansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.ExpansionType;

public interface IExpansionHolder {
    ExpansionType getExpansionType();
    Expansion<?> getExpansion();
}
