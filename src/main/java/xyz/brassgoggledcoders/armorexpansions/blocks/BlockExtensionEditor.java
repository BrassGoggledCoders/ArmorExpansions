package xyz.brassgoggledcoders.armorexpansions.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import xyz.brassgoggledcoders.armorexpansions.tileentities.TileEntityExtensionEditor;
import xyz.brassgoggledcoders.boilerplate.blocks.BlockTEBase;

public class BlockExtensionEditor extends BlockTEBase {

	public BlockExtensionEditor(Material material, String name) {
		super(material, name);
	}

	@Override
	public Class<? extends TileEntity> getTileEntityClass() {
		return TileEntityExtensionEditor.class;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityExtensionEditor();
	}

}
