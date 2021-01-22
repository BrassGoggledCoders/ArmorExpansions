package xyz.brassgoggledcoders.armorexpansions.api.expansionholder;

import com.hrznstudio.titanium.nbthandler.data.ItemStackHandlerNBTHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;
import xyz.brassgoggledcoders.armorexpansions.api.AREXRegistries;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.Expansion;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class ItemStackExpansionProvider implements IExpansionHolder, ICapabilityProvider {

    protected final ItemStack container;
    protected final Supplier<Expansion> expansion;

    public ItemStackExpansionProvider(@Nonnull ItemStack container, Supplier<Expansion> expansion) {
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
    public Expansion getExpansion() {
        return expansion.get();
    }

    public static ItemStackExpansionProvider getFromNBT(CompoundNBT tag) {
        return new ItemStackExpansionProvider(ItemStack.read(tag.getCompound("stack")), () -> AREXRegistries.EXPANSIONS.getValue(new ResourceLocation(tag.getString("expansion"))));
    }

    public static CompoundNBT writeToNBT(ItemStackExpansionProvider provider) {
        CompoundNBT tag = new CompoundNBT();
        tag.put("stack", provider.container.write(new CompoundNBT()));
        tag.putString("expansion", provider.expansion.get().getRegistryName().toString());
        return tag;
    }
}
