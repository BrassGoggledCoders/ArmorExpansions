package xyz.brassgoggledcoders.armorexpansions.modules.extensioneditor.guis;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.modules.extensioneditor.containers.ContainerExtensionEditor;
import xyz.brassgoggledcoders.armorexpansions.modules.extensioneditor.tileentities.TileEntityExtensionEditor;
import xyz.brassgoggledcoders.boilerplate.client.guis.GuiScreenBase;
import xyz.brassgoggledcoders.boilerplate.client.guis.components.RenderEntityLivingBaseComponent;

@SideOnly(Side.CLIENT)
public class GuiExtensionEditor extends GuiScreenBase {
	private static ResourceLocation guiTexture = new ResourceLocation(ArmorExpansions.NAME, "textures/gui/extension_editor.png");

	public GuiExtensionEditor(EntityPlayer player, TileEntityExtensionEditor extensionEditor) {
		super(new ContainerExtensionEditor(player, extensionEditor));
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.addComponent(new RenderEntityLivingBaseComponent(x + 33, y + 75, 30, (float) (x + 33) - x,
				(float) (y + 75 - 50) - y, Minecraft.getMinecraft().thePlayer));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.mc.renderEngine.bindTexture(guiTexture);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
	}
}
