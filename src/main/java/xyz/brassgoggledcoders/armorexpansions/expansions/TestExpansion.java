package xyz.brassgoggledcoders.armorexpansions.expansions;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.ExpansionType;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.IExpansion;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TestExpansion implements IExpansion, ICapabilityProvider {

    private final LazyOptional<IExpansion> holder = LazyOptional.of(() -> this);

    @Override
    public ResourceLocation getIdentifier() {
        return new ResourceLocation(ArmorExpansions.MOD_ID, "test");
    }

    @Override
    public ExpansionType getExpansionType() {
        return ExpansionType.ALLARMOR;
    }

    @Override
    public boolean canApplyTo(ItemStack targetPiece) {
        return true;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == AREXAPI.EXTENSION_CAP ? holder.cast() : LazyOptional.empty();
    }
}
