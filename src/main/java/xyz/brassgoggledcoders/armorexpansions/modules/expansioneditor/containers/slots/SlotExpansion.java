package xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.containers.slots;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.IItemHandler;
import xyz.brassgoggledcoders.armorexpansions.api.AREXApi;
import xyz.brassgoggledcoders.boilerplate.containers.slots.SlotChanged;
import xyz.brassgoggledcoders.boilerplate.tileentities.IOnSlotChanged;

public class SlotExpansion extends SlotChanged {

	public SlotExpansion(IItemHandler itemHandler, IOnSlotChanged changeReceiver, int index, int xPos, int yPos) {
		super(itemHandler, changeReceiver, index, xPos, yPos);
	}

	@Override
	public boolean isItemValid(ItemStack itemStack) {
		return itemStack != null && itemStack.hasCapability(AREXApi.EXTENSION_CAP, EnumFacing.UP);
	}
}
