package xyz.brassgoggledcoders.armorexpansions.api.expansion;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ExpansionHandler implements IExpansion {
	@Override
	public ResourceLocation getIdentifier() {
		return new ResourceLocation("");
	}

	@Override
	public ExpansionType getExpansionType() {
		return ExpansionType.ALLARMOR;
	}

	@Override
	public boolean canApplyTo(ItemStack targetPiece) {
		return true;
	}
}
