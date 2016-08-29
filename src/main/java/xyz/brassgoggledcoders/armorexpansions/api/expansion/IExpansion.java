package xyz.brassgoggledcoders.armorexpansions.api.expansion;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public interface IExpansion {
	ResourceLocation getIdentifier();

	ExpansionType getExpansionType();

	boolean canApplyTo(ItemStack targetPiece);
}
