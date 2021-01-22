package xyz.brassgoggledcoders.armorexpansions.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;
import xyz.brassgoggledcoders.armorexpansions.api.expansionholder.ItemStackExpansionProvider;
import xyz.brassgoggledcoders.armorexpansions.content.AREXExpansions;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class TestModuleItem extends Item {
    public TestModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("Valid Slots:"));
        stack.getCapability(AREXAPI.EXPANSION_HOLDER_CAP).ifPresent(cap ->
                cap.getExpansion().getModule().getValidSlots().forEach(type -> tooltip.add(new StringTextComponent(type.toString()))));
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
        return new ICapabilityProvider() {
            @Nonnull
            @Override
            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
                return AREXAPI.EXPANSION_HOLDER_CAP.orEmpty(cap, LazyOptional.of(() -> new ItemStackExpansionProvider(stack, AREXExpansions.TEST.get().createInstance())));
            }
        };
    }
}
