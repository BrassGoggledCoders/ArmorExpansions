package xyz.brassgoggledcoders.armorexpansions.api.expansion;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.INBTSerializable;

public interface IExpansion extends INBTSerializable<CompoundNBT> {

    ResourceLocation getIdentifier();

    ExpansionType getExpansionType();

    boolean canApplyTo(ItemStack targetPiece);

    @Override
    default CompoundNBT serializeNBT() {
        return new CompoundNBT();
    }

    @Override
    default void deserializeNBT(CompoundNBT nbt) {

    }
}
