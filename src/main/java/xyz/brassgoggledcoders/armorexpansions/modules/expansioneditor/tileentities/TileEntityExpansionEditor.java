package xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.tileentities;

import com.teamacronymcoders.base.guisystem.IHasGui;
import com.teamacronymcoders.base.tileentities.IOnSlotChanged;
import com.teamacronymcoders.base.tileentities.TileEntityInventoryBase;

import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.containers.ContainerExpansionEditor;
import xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.guis.GuiExpansionEditor;

public class TileEntityExpansionEditor extends TileEntityInventoryBase implements IHasGui, IOnSlotChanged {
	public TileEntityExpansionEditor() {
		super(13);
	}

	@Override
	public void onSlotChanged(Slot slot) {

	}

	@Override
	public Gui getGui(EntityPlayer entityPlayer, World world, BlockPos blockPos) {
		// TODO Auto-generated method stub
		return new GuiExpansionEditor(entityPlayer, this);
	}

	@Override
	public Container getContainer(EntityPlayer entityPlayer, World world, BlockPos blockPos) {
		// TODO Auto-generated method stub
		return new ContainerExpansionEditor(entityPlayer, this);
	}
}
