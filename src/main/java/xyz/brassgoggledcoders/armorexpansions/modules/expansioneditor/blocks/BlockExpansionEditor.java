package xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.blocks;

import javax.annotation.Nonnull;

import com.teamacronymcoders.base.blocks.BlockTEBase;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.tileentities.TileEntityExpansionEditor;

public class BlockExpansionEditor extends BlockTEBase<TileEntityExpansionEditor> {
	public BlockExpansionEditor() {
		super(Material.IRON, "expansion_editor");
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		TileEntityExpansionEditor tileEntityExpansionEditor = getTileEntity(worldIn, pos).get();
		if(tileEntityExpansionEditor != null && !playerIn.isSneaking()) {
			playerIn.openGui(ArmorExpansions.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}
		return false;
	}

	@Nonnull
	@Override
	public TileEntity createTileEntity(@Nonnull World world, @Nonnull IBlockState blockState) {
		return new TileEntityExpansionEditor();
	}

	@Override
	public Class<? extends TileEntity> getTileEntityClass() {
		return TileEntityExpansionEditor.class;
	}
}
