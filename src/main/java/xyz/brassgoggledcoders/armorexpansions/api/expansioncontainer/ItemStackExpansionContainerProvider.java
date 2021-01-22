package xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer;

import com.google.common.collect.ImmutableList;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;
import xyz.brassgoggledcoders.armorexpansions.api.expansionholder.IExpansionHolder;
import xyz.brassgoggledcoders.armorexpansions.api.expansionholder.ItemStackExpansionProvider;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class ItemStackExpansionContainerProvider implements ICapabilityProvider, IExpansionContainer {

    public static final String NBT_KEY = "Expansions";
    @Nonnull
    protected final ItemStack container;
    protected final int size;

    public ItemStackExpansionContainerProvider(@Nonnull ItemStack container, int size) {
        this.container = container;
        this.size = size;
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction facing) {
        return AREXAPI.EXPANSION_CONTAINER_CAP.orEmpty(capability, LazyOptional.of(() -> this));
    }

    @Override
    public boolean canAcceptExpansion(IExpansionHolder extension) {
        return true;
    }

    @Override
    public int getMaximumNumberOfExpansions() {
        return size;
    }

    //TODO Can we cache this into a java object List<IExpansion> and simply compare the size most times?
    @Override
    public ImmutableList<IExpansionHolder> getAllExpansions() {
        CompoundNBT tagCompound = container.getTag();
        if (tagCompound == null || !tagCompound.contains(NBT_KEY)) {
            return ImmutableList.of();
        } else {
            CompoundNBT actualTag = tagCompound.getCompound(NBT_KEY);
            List<IExpansionHolder> expansions = new ArrayList<>();
            for(int i = 1; i < actualTag.getInt("size"); i++) {
                IExpansionHolder expansion = getFromNBT(actualTag.getCompound("expansion_" + i));
                expansions.add(expansion);
            }
            return ImmutableList.copyOf(expansions);
        }
    }

    @Override
    public void addExpansion(IExpansionHolder expansion) {
        if(expansion instanceof ItemStackExpansionProvider) {
            CompoundNBT tag = container.getOrCreateTag().getCompound(NBT_KEY);
            int index = tag.getInt("size") + 1;
            tag.put("expansion_" + index, writeToNBT((ItemStackExpansionProvider) expansion));
            tag.putInt("size", index);
            container.setTagInfo(NBT_KEY, tag);
        } else {
            //TODO
            ArmorExpansions.LOGGER.warn("Uh oh");
        }
    }

    @Override
    public boolean isActive() {
        return true;
    }

    public static ItemStackExpansionProvider getFromNBT(CompoundNBT tag) {
        return new ItemStackExpansionProvider(ItemStack.read(tag.getCompound("stack")), AREXAPI.getExpansionType(new ResourceLocation(tag.getString("type"))).load(tag.getString("expansion")));
    }

    public static CompoundNBT writeToNBT(ItemStackExpansionProvider provider) {
        CompoundNBT tag = new CompoundNBT();
        tag.put("stack", provider.getContainer().write(new CompoundNBT()));
        tag.putString("type", provider.getExpansion().getType().getRegistryName().toString());
        tag.putString("expansion", provider.getExpansion().getRegistryName().toString());
        return tag;
    }
}
