package xyz.brassgoggledcoders.armorexpansions.tileentities;

import com.hrznstudio.titanium.component.inventory.InventoryComponent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.LazyOptional;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.IExpansionContainer;
import xyz.brassgoggledcoders.armorexpansions.content.AREXBlocks;
import xyz.brassgoggledcoders.workshop.tileentity.BasicInventoryTileEntity;

public class ExpansionEditorTileEntity extends BasicInventoryTileEntity<ExpansionEditorTileEntity> {

    public InventoryComponent<ExpansionEditorTileEntity> containerInventory, expansionsInventory;

    public ExpansionEditorTileEntity() {
        super(AREXBlocks.EXPANSION_EDITOR.getTileEntityType());
        this.getMachineComponent().addInventory(containerInventory = new InventoryComponent<>("container", 0, 0, 1));
        this.containerInventory.setInputFilter((stack, slot) -> stack.getCapability(AREXAPI.EXPANSION_CONTAINER_CAP).isPresent());
        this.getMachineComponent().addInventory(expansionsInventory = new InventoryComponent<>("expansions", 10, 20, 20));
        this.expansionsInventory.setRange(5, 4);
    }

    @Override
    public ExpansionEditorTileEntity getSelf() {
        return this;
    }

    @Override
    public void tick() {
        LazyOptional<IExpansionContainer> containerCapability = this.containerInventory.getStackInSlot(0).getCapability(AREXAPI.EXPANSION_CONTAINER_CAP);
        ItemStack stack = this.expansionsInventory.getStackInSlot(0);
        if(!stack.isEmpty()) {
            stack.getCapability(AREXAPI.EXPANSION_HOLDER_CAP).ifPresent(cap -> containerCapability.ifPresent(container -> {
                //if(container.getAllExpansions().size() < container.getMaximumNumberOfExpansions() && container.canAcceptExpansion(cap) && cap.getExpansion().getValidSlots().contains(this.containerInventory.getStackInSlot(0).getEquipmentSlot())) {
                    container.addExpansion(cap);
                    this.expansionsInventory.setStackInSlot(0, ItemStack.EMPTY);
                //}
            }));
        }
    }
}
