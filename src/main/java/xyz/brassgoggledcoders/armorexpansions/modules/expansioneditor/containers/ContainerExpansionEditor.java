package xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.containers.slots.SlotExpansionContainer;
import xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.tileentities.TileEntityExpansionEditor;
import xyz.brassgoggledcoders.boilerplate.containers.ContainerBase;
import xyz.brassgoggledcoders.boilerplate.containers.slots.SlotArmor;

import javax.annotation.Nonnull;

public class ContainerExpansionEditor extends ContainerBase {
	private TileEntityExpansionEditor expansionEditor;

	public ContainerExpansionEditor(EntityPlayer player, TileEntityExpansionEditor expansionEditor) {
		this.expansionEditor = expansionEditor;
		IItemHandler inventory =
				expansionEditor.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
		for(int i = 0; i < 4; ++i) {
			this.addSlotToContainer(new SlotArmor(player, i, 62, 8 + i * 18));
		}

		this.addSlotToContainer(new SlotExpansionContainer(inventory, expansionEditor, 0, 89, 26));

		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				//TODO Why does this go 1 too far
				//this.addSlotToContainer(
				//		new SlotExtension(inventory, extensionEditor, j + (i * 4), 116 + j * 18, 8 + (i * 18)));
			}
		}

		this.createPlayerSlots(player.inventory);
	}

	@Override
	public boolean canInteractWith(@Nonnull EntityPlayer player) {
		return true;
	}
}
