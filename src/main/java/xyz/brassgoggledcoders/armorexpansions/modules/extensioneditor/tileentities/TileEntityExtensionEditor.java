package xyz.brassgoggledcoders.armorexpansions.modules.extensioneditor.tileentities;

import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.brassgoggledcoders.armorexpansions.modules.extensioneditor.containers.ContainerExtensionEditor;
import xyz.brassgoggledcoders.armorexpansions.modules.extensioneditor.guis.GuiExtensionEditor;
import xyz.brassgoggledcoders.boilerplate.client.guis.IOpenableGUI;
import xyz.brassgoggledcoders.boilerplate.tileentities.IOnSlotChanged;
import xyz.brassgoggledcoders.boilerplate.tileentities.TileEntityInventoryBase;

public class TileEntityExtensionEditor extends TileEntityInventoryBase implements IOpenableGUI, IOnSlotChanged{
	public TileEntityExtensionEditor() {
		super(13);
	}

	@Override
	public Gui getClientGuiElement(int ID, EntityPlayer player, World world, BlockPos blockPos) {
		return new GuiExtensionEditor(player, this);
	}

	@Override
	public Container getServerGuiElement(int ID, EntityPlayer player, World world, BlockPos blockPos) {
		return new ContainerExtensionEditor(player, this);
	}

	@Override
	public void onSlotChanged(Slot slot) {

	}
}
