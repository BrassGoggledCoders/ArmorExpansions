package xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.containers.slots;

import com.teamacronymcoders.base.containers.slots.SlotChanged;
import com.teamacronymcoders.base.tileentities.IOnSlotChanged;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.IItemHandler;
import xyz.brassgoggledcoders.armorexpansions.api.AREXApi;

public class SlotExpansion extends SlotChanged {

	public SlotExpansion(IItemHandler itemHandler, IOnSlotChanged changeReceiver, int index, int xPos, int yPos) {
		super(itemHandler, changeReceiver, index, xPos, yPos);
	}

	@Override
	public boolean isItemValid(ItemStack itemStack) {
		return itemStack != null && itemStack.hasCapability(AREXApi.EXTENSION_CAP, EnumFacing.UP);
	}
}
