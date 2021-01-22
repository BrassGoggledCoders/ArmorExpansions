package xyz.brassgoggledcoders.armorexpansions.api.expansion;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Util;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.registries.ForgeRegistryEntry;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public abstract class Expansion<MOD extends Expansion<MOD>> extends ForgeRegistryEntry<MOD> implements INBTSerializable<CompoundNBT> {
    private final Supplier<ExpansionType> componentType;
    private String translationKey;
    private ITextComponent name;
    private final List<EquipmentSlotType> validSlots;

    public Expansion(Supplier<ExpansionType> componentType, EquipmentSlotType... type) {
        this.componentType = componentType;
        this.validSlots = Arrays.asList(type);
    }

    @Nonnull
    public String getTranslationKey() {
        if (translationKey == null) {
            translationKey = Util.makeTranslationKey(componentType.get().getName(), this.getRegistryName());
        }
        return translationKey;
    }

    @Nonnull
    public ITextComponent getDisplayName() {
        if (name == null) {
            name = new TranslationTextComponent(this.getTranslationKey());
        }
        return name;
    }

    public ExpansionType getType() {
        return componentType.get();
    }

    public boolean isActive() {
        return true;
    }

    public static Expansion<?> fromCompoundNBT(CompoundNBT compoundNBT) {
        ExpansionType moduleType = AREXAPI.getExpansionType(compoundNBT.getString("type"));
        if (moduleType != null) {
            return moduleType.load(compoundNBT.getString("module"));
        } else {
            return null;
        }
    }

    public static void toCompoundNBT(Expansion<?> module, CompoundNBT compoundNBT) {
        compoundNBT.putString("type", String.valueOf(module.getType().getRegistryName()));
        compoundNBT.putString("module", String.valueOf(module.getRegistryName()));
    }

    public List<EquipmentSlotType> getValidSlots() {
        return validSlots;
    }

    @Override
    public CompoundNBT serializeNBT() {
        return new CompoundNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
    }

}
