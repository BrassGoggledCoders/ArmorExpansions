package xyz.brassgoggledcoders.armorexpansions.api.expansionholder;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.Expansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.ExpansionType;

import javax.annotation.Nonnull;

public class ItemStackExpansionProvider implements IExpansionHolder, ICapabilityProvider {

    protected final ItemStack container;
    protected final Expansion<?> expansion;

    public ItemStackExpansionProvider(@Nonnull ItemStack container, Expansion<?> expansion) {
        this.container = container;
        this.expansion = expansion;
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction facing) {
        return AREXAPI.EXPANSION_HOLDER_CAP.orEmpty(capability, LazyOptional.of(() -> this));
    }

    public ItemStack getContainer() {
        return container;
    }

    @Override
    public ExpansionType getExpansionType() {
        return expansion.getType();
    }

    @Override
    public Expansion<?> getExpansion() {
        return expansion;
    }

}
