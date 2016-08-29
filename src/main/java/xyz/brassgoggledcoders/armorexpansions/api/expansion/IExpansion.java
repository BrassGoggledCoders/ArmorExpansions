package xyz.brassgoggledcoders.armorexpansions.api.expansion;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.INBTSerializable;

public interface IExpansion extends INBTSerializable<NBTTagCompound> {
	ResourceLocation getIdentifier();

	ExpansionType getExpansionType();

	boolean canApplyTo(ItemStack targetPiece);
}
