package xyz.brassgoggledcoders.armorexpansions.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;
import xyz.brassgoggledcoders.armorexpansions.api.expansionholder.ItemStackExpansionProvider;
import xyz.brassgoggledcoders.armorexpansions.content.AREXExpansions;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TestModuleItem extends Item {
    public TestModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
        return new ICapabilityProvider() {
            @Nonnull
            @Override
            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
                return AREXAPI.EXPANSION_HOLDER_CAP.orEmpty(cap, LazyOptional.of(() -> new ItemStackExpansionProvider(stack, AREXExpansions.TEST)));
            }
        };
    }
}
