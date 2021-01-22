package xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.INBTSerializable;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.Expansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.ExpansionType;
import xyz.brassgoggledcoders.armorexpansions.api.expansionholder.IExpansionHolder;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExpansionContainer implements IExpansionContainer, INBTSerializable<CompoundNBT> {
    public static final String NBT_KEY = "Expansions";
    @Nonnull
    protected final ItemStack container;
    protected final int size;

    private boolean dirty = false;
    private boolean loaded = false;

    private final Map<ExpansionType, List<Expansion<?>>> expansions;

    public ExpansionContainer(@Nonnull ItemStack container, int size) {
        this.container = container;
        this.size = size;
        this.expansions = Maps.newHashMap();
    }

    @Override
    public boolean canAcceptExpansion(IExpansionHolder extension) {
        return true;
    }

    @Override
    public int getMaximumNumberOfExpansions() {
        return size;
    }

    @Override
    public ImmutableList<Expansion<?>> getAllExpansions() {
        this.loadIfNotLoaded();
        return ImmutableList.copyOf(this.expansions.values().stream().flatMap(Collection::stream).collect(Collectors.toList()));
    }

    //TODO
    public <E extends Expansion<E>> ImmutableList<E> getExpansionsOfType(ExpansionType type, Class<E> clazz) {
        this.loadIfNotLoaded();
        return (ImmutableList<E>) ImmutableList.copyOf(this.expansions.getOrDefault(type, new ArrayList<>()));
    }

    @Override
    public void addExpansion(IExpansionHolder expansion) {
        this.expansions.getOrDefault(expansion.getExpansion().getType(), new ArrayList<>()).add(expansion.getExpansion());
        this.dirty = true;
        this.save();
    }

    @Override
    public boolean isActive() {
        return true;
    }

    public void load() {
        load(container.getOrCreateTag());
    }

    public void loadIfNotLoaded() {
        if (!loaded) {
            load();
        }
        loaded = true;
    }

    public void load(@Nonnull CompoundNBT nbt) {
        if (nbt.contains(NBT_KEY)) {
            this.deserializeNBT(nbt.getCompound(NBT_KEY));
        }
    }

    public void save() {
        if (dirty) {
            CompoundNBT nbt = container.getOrCreateTag();
            nbt.put(NBT_KEY, this.serializeNBT());
            dirty = false;
        }
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        for (Map.Entry<ExpansionType, List<Expansion<?>>> e : this.expansions.entrySet()) {
            ExpansionType type = e.getKey();
            List<? extends Expansion<?>> list = e.getValue();
            ListNBT listNBT = new ListNBT();
            list.forEach(ex -> listNBT.add(Expansion.toCompoundNBT(ex, new CompoundNBT())));
            tag.put(String.valueOf(type.getRegistryName()), listNBT);
        }
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        AREXAPI.EXPANSION_TYPE.get().forEach(et -> {
            String key = String.valueOf(et.getRegistryName());
            if (nbt.contains(key)) {
                ListNBT listNBT = nbt.getList(key, Constants.NBT.TAG_COMPOUND);
                ArrayList<Expansion<?>> list = new ArrayList<>();
                listNBT.forEach(tag -> list.add(Expansion.fromCompoundNBT((CompoundNBT) tag)));
                this.expansions.put(et, list);
            }
        });
    }
}
