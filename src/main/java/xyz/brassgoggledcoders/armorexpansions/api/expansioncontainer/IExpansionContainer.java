package xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer;

import net.minecraft.util.ResourceLocation;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.IExpansion;

public interface IExpansionContainer {
    ResourceLocation getIdentifier();

    boolean canAcceptExpansion(IExpansion extension);
}
