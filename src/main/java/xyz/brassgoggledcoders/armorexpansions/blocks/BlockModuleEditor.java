package xyz.brassgoggledcoders.armorexpansions.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import xyz.brassgoggledcoders.armorexpansions.tileentities.TileEntityModuleEditor;
import xyz.brassgoggledcoders.boilerplate.blocks.BlockTEBase;

public class BlockModuleEditor extends BlockTEBase {

	public BlockModuleEditor(Material material, String name) {
		super(material, name);
	}

	@Override
	public Class<? extends TileEntity> getTileEntityClass() {
		return TileEntityModuleEditor.class;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityModuleEditor();
	}

}
