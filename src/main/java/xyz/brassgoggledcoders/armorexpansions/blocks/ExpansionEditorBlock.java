package xyz.brassgoggledcoders.armorexpansions.blocks;

import net.minecraft.block.Blocks;
import xyz.brassgoggledcoders.armorexpansions.tileentities.ExpansionEditorTileEntity;
import xyz.brassgoggledcoders.workshop.block.GUITileBlock;

public class ExpansionEditorBlock extends GUITileBlock<ExpansionEditorTileEntity> {
    public ExpansionEditorBlock() {
        super(Properties.from(Blocks.IRON_BLOCK), ExpansionEditorTileEntity::new);
    }
}
