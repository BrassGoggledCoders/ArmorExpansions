package xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.guis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.containers.ContainerExpansionEditor;
import xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.tileentities.TileEntityExpansionEditor;
import xyz.brassgoggledcoders.boilerplate.client.guis.GuiScreenBase;

@SideOnly(Side.CLIENT)
public class GuiExpansionEditor extends GuiScreenBase {
	private static ResourceLocation guiTexture =
			new ResourceLocation(ArmorExpansions.NAME, "textures/gui/extension_editor.png");

	public GuiExpansionEditor(EntityPlayer player, TileEntityExpansionEditor extensionEditor) {
		super(new ContainerExpansionEditor(player, extensionEditor));
		// int x = (this.width - this.xSize) / 2;
		// int y = (this.height - this.ySize) / 2;
		// TODO
		// this.addComponent(new RenderEntityLivingBaseComponent(x + 33, y + 75, 30, (float) (x + 33) - x,
		// (float) (y + 75 - 50) - y, Minecraft.getMinecraft().thePlayer));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.mc.renderEngine.bindTexture(guiTexture);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		GuiInventory.drawEntityOnScreen(x + 33, y + 75, 30, (float) (x + 33) - mouseX, (float) (y + 75) - mouseY,
				Minecraft.getMinecraft().thePlayer);
	}
}
