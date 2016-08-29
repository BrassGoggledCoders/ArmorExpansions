package xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.tileentities;

import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.containers.ContainerExpansionEditor;
import xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.guis.GuiExpansionEditor;
import xyz.brassgoggledcoders.boilerplate.client.guis.IOpenableGUI;
import xyz.brassgoggledcoders.boilerplate.tileentities.IOnSlotChanged;
import xyz.brassgoggledcoders.boilerplate.tileentities.TileEntityInventoryBase;

public class TileEntityExpansionEditor extends TileEntityInventoryBase implements IOpenableGUI, IOnSlotChanged{
	public TileEntityExpansionEditor() {
		super(13);
	}

	@Override
	public Gui getClientGuiElement(int ID, EntityPlayer player, World world, BlockPos blockPos) {
		return new GuiExpansionEditor(player, this);
	}

	@Override
	public Container getServerGuiElement(int ID, EntityPlayer player, World world, BlockPos blockPos) {
		return new ContainerExpansionEditor(player, this);
	}

	@Override
	public void onSlotChanged(Slot slot) {

	}
}
