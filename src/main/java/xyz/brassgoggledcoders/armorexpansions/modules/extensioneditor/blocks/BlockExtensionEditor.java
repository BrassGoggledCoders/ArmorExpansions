package xyz.brassgoggledcoders.armorexpansions.modules.extensioneditor.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import xyz.brassgoggledcoders.armorexpansions.modules.extensioneditor.tileentities.TileEntityExtensionEditor;
import xyz.brassgoggledcoders.boilerplate.blocks.BlockTEBase;

import javax.annotation.Nonnull;

public class BlockExtensionEditor extends BlockTEBase {

	public BlockExtensionEditor() {
		super(Material.IRON, "extension_editor");
	}

	@Nonnull
	@Override
	public TileEntity createTileEntity(@Nonnull World world, @Nonnull IBlockState blockState) {
		return new TileEntityExtensionEditor();
	}

	@Override
	public Class<? extends TileEntity> getTileEntityClass() {
		return TileEntityExtensionEditor.class;
	}

}
