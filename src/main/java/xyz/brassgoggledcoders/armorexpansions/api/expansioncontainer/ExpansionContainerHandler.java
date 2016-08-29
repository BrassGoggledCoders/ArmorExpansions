package xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer;

import net.minecraft.util.ResourceLocation;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.IExpansion;

public class ExpansionContainerHandler implements IExpansionContainer {
	@Override
	public ResourceLocation getIdentifier() {
		return new ResourceLocation("");
	}

	@Override
	public boolean canAcceptExpansion(IExpansion extension) {
		return true;
	}
}
