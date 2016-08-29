package xyz.brassgoggledcoders.armorexpansions.modules.extensioneditor.blocks;

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
import xyz.brassgoggledcoders.armorexpansions.modules.extensioneditor.tileentities.TileEntityExtensionEditor;
import xyz.brassgoggledcoders.boilerplate.blocks.BlockTEBase;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BlockExtensionEditor extends BlockTEBase<TileEntityExtensionEditor> {
	public BlockExtensionEditor() {
		super(Material.IRON, "extension_editor");
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			@Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityExtensionEditor tileEntityExtensionEditor = getTileEntity(world, pos);
		if(tileEntityExtensionEditor != null && !player.isSneaking()) {
			player.openGui(ArmorExpansions.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}
		return false;
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
