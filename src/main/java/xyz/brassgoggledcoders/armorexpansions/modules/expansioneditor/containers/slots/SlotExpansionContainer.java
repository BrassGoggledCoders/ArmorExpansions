package xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.containers.slots;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.IItemHandler;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;
import xyz.brassgoggledcoders.boilerplate.containers.slots.SlotChanged;
import xyz.brassgoggledcoders.boilerplate.tileentities.IOnSlotChanged;

public class SlotExpansionContainer extends SlotChanged {
	public SlotExpansionContainer(IItemHandler itemHandler, IOnSlotChanged changeReceiver, int slotIndex, int posX,
			int posY) {
		super(itemHandler, changeReceiver, slotIndex, posX, posY);
	}

	@Override
	public boolean isItemValid(ItemStack itemStack) {
		return itemStack != null && itemStack.hasCapability(AREXAPI.EXTENSION_CONTAINER_CAP, EnumFacing.UP);
	}
}
