package xyz.brassgoggledcoders.armorexpansions.tileentities;

import com.hrznstudio.titanium.component.inventory.InventoryComponent;
import xyz.brassgoggledcoders.armorexpansions.content.AREXBlocks;
import xyz.brassgoggledcoders.workshop.tileentity.BasicInventoryTileEntity;

public class ExpansionEditorTileEntity extends BasicInventoryTileEntity<ExpansionEditorTileEntity> {

    public InventoryComponent<ExpansionEditorTileEntity> containerInventory, expansionsInventory;

    public ExpansionEditorTileEntity() {
        super(AREXBlocks.EXPANSION_EDITOR.getTileEntityType());
        this.getMachineComponent().addInventory(containerInventory = new InventoryComponent<>("container", 0, 0, 1));
        this.getMachineComponent().addInventory(expansionsInventory = new InventoryComponent<>("expansions", 0, 0, 20));
    }

    @Override
    public ExpansionEditorTileEntity getSelf() {
        return this;
    }
}
