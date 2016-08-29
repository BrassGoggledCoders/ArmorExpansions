package xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.INBTSerializable;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.IExpansion;

public interface IExpansionContainer extends INBTSerializable<NBTTagCompound> {
	ResourceLocation getIdentifier();

	boolean canAcceptExpansion(IExpansion expansion);

	ArrayList<ItemStack> getContainedExpansions();

	boolean addExpansion(ItemStack expansion);
}
