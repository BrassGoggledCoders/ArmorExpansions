package xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;

import javax.annotation.Nonnull;

public class ItemStackExpansionContainerProvider implements ICapabilitySerializable<CompoundNBT> {

    protected final ItemStack container;
    protected final int size;
    private final ExpansionContainer expansionContainer;
    private final LazyOptional<IExpansionContainer> optional;

    public ItemStackExpansionContainerProvider(@Nonnull ItemStack container, int size) {
        this.container = container;
        this.size = size;
        this.expansionContainer = new ExpansionContainer(container, size);
        this.optional = LazyOptional.of(() -> expansionContainer);
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction facing) {
        return AREXAPI.EXPANSION_CONTAINER_CAP.orEmpty(capability, optional);
    }

    @Override
    public CompoundNBT serializeNBT() {
        this.expansionContainer.save();
        return new CompoundNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.expansionContainer.load();
    }
}
