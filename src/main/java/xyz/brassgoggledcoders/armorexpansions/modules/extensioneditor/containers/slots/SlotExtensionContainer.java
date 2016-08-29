package xyz.brassgoggledcoders.armorexpansions.modules.extensioneditor.containers.slots;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.IItemHandler;
import xyz.brassgoggledcoders.armorexpansions.api.AREXApi;
import xyz.brassgoggledcoders.boilerplate.containers.slots.SlotChanged;
import xyz.brassgoggledcoders.boilerplate.tileentities.IOnSlotChanged;

public class SlotExtensionContainer extends SlotChanged {
	public SlotExtensionContainer(IItemHandler itemHandler, IOnSlotChanged changeReceiver, int slotIndex, int posX,
			int posY) {
		super(itemHandler, changeReceiver, slotIndex, posX, posY);
	}

	@Override
	public boolean isItemValid(ItemStack itemStack) {
		return itemStack != null && itemStack.hasCapability(AREXApi.EXTENSION_CONTAINER_CAP, EnumFacing.UP);
	}
}
