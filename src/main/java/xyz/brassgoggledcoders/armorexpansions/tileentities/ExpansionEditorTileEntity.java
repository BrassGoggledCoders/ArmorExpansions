package xyz.brassgoggledcoders.armorexpansions.tileentities;

import xyz.brassgoggledcoders.armorexpansions.content.AREXBlocks;
import xyz.brassgoggledcoders.workshop.tileentity.BasicInventoryTileEntity;

public class ExpansionEditorTileEntity extends BasicInventoryTileEntity<ExpansionEditorTileEntity> {
    public ExpansionEditorTileEntity() {
        super(AREXBlocks.EXPANSION_EDITOR.getTileEntityType());
    }

    @Override
    public ExpansionEditorTileEntity getSelf() {
        return this;
    }
}
