package xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.containers.slots;

import com.teamacronymcoders.base.containers.slots.SlotChanged;
import com.teamacronymcoders.base.tileentities.IOnSlotChanged;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.IItemHandler;
import xyz.brassgoggledcoders.armorexpansions.api.AREXApi;

public class SlotExpansionContainer extends SlotChanged {
	public SlotExpansionContainer(IItemHandler itemHandler, IOnSlotChanged changeReceiver, int slotIndex, int posX,
			int posY) {
		super(itemHandler, changeReceiver, slotIndex, posX, posY);
	}

	@Override
	public boolean isItemValid(ItemStack itemStack) {
		return itemStack != null && itemStack.hasCapability(AREXApi.EXTENSION_CONTAINER_CAP, EnumFacing.UP);
	}
}
