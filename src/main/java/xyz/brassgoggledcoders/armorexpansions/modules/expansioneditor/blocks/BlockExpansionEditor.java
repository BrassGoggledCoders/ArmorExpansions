package xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.blocks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.tileentities.TileEntityExpansionEditor;
import xyz.brassgoggledcoders.boilerplate.blocks.BlockTEBase;

public class BlockExpansionEditor extends BlockTEBase<TileEntityExpansionEditor> {
	public BlockExpansionEditor() {
		super(Material.IRON, "expansion_editor");
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			@Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityExpansionEditor tileEntityExpansionEditor = getTileEntity(world, pos);
		if(tileEntityExpansionEditor != null && !player.isSneaking()) {
			player.openGui(ArmorExpansions.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
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
