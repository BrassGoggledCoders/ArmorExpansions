package xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLLog;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.IExpansion;

public class ExpansionContainerHandler implements IExpansionContainer {

	private ArrayList<ItemStack> containedExpansions = new ArrayList<ItemStack>();

	@Override
	public ResourceLocation getIdentifier() {
		return new ResourceLocation("");
	}

	@Override
	public boolean canAcceptExpansion(IExpansion extension) {
		return true;
	}

	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound tag = new NBTTagCompound();
		// if(!containedExpansions.isEmpty()) {
		tag.setInteger("expansionCount", containedExpansions.size());
		for(int i = 0; i < containedExpansions.size(); i++) {
			tag.setTag("extension" + i, containedExpansions.get(i).serializeNBT());
		}
		// }
		return tag;
	}

	@Override
	public void deserializeNBT(NBTTagCompound tag) {
		for(int i = 0; i < tag.getInteger("expansionCount"); i++) {
			ItemStack expansion = ItemStack.loadItemStackFromNBT((NBTTagCompound) tag.getTag("extension" + i));
			containedExpansions.add(expansion);
		}
	}

	@Override
	public ArrayList<ItemStack> getContainedExpansions() {
		return containedExpansions;
	}

	@Override
	public boolean addExpansion(ItemStack expansion) {
		if(!containedExpansions.contains(expansion)) {
			containedExpansions.add(expansion);
			FMLLog.warning(getContainedExpansions().toString());
			return true;
		}
		else
			return false;
	}
}
