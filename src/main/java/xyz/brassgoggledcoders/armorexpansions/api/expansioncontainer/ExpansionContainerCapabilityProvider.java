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
import xyz.brassgoggledcoders.armorexpansions.api.expansion.IExpansion;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class ExpansionContainerCapabilityProvider implements ICapabilityProvider, IExpansionContainer {

    public static final String NBT_KEY = "Expansions";
    @Nonnull
    protected final ItemStack container;

    public ExpansionContainerCapabilityProvider(@Nonnull ItemStack container) {
        this.container = container;
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction facing) {
        return AREXAPI.EXTENSION_CONTAINER_CAP.orEmpty(capability, LazyOptional.of(() -> this));
    }

    @Override
    public ResourceLocation getIdentifier() {
        return new ResourceLocation(ArmorExpansions.MOD_ID, "default");
    }

    @Override
    public boolean canAcceptExpansion(IExpansion extension) {
        return true;
    }

    @Override
    public int getMaximumNumberOfExpansions() {
        return 10;
    }

    //TODO Can we cache this into a java object List<IExpansion> and simply compare the size most times?
    @Override
    public ImmutableList<IExpansion> getExpansions() {
        CompoundNBT tagCompound = container.getTag();
        if (tagCompound == null || !tagCompound.contains(NBT_KEY)) {
            return ImmutableList.of();
        } else {
            CompoundNBT actualTag = tagCompound.getCompound(NBT_KEY);
            List<IExpansion> expansions = new ArrayList<>();
            for(int i = 1; i < actualTag.getInt("size"); i++) {
                IExpansion expansion = ArmorExpansions.EXPANSIONS.get(new ResourceLocation(actualTag.getString("expansion_" + i)));
                String data = "expansion_" + i + "_data";
                if(actualTag.contains(data)) {
                    //expansion.deserializeNBT(actualTag.getCompound(data));
                }
                expansions.add(expansion);
            }
            return ImmutableList.copyOf(expansions);
        }
    }

    @Override
    public void addExpansion(IExpansion expansion) {
        if (!container.hasTag())
        {
            container.setTag(new CompoundNBT());
        }
        CompoundNBT tag = container.getTag().getCompound(NBT_KEY);
        int index = tag.getInt("size") + 1;
        tag.putString("expansion_" + index, expansion.getIdentifier().toString());
        //tag.put("expansion_" + index + "_data", expansion.serializeNBT());
        tag.putInt("size", index);
        container.setTagInfo(NBT_KEY, tag);
    }
}
