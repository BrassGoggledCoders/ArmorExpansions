package xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.INBTSerializable;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.Expansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.ExpansionType;
import xyz.brassgoggledcoders.armorexpansions.api.expansionholder.IExpansionHolder;

import javax.annotation.Nonnull;

public class ExpansionContainer implements IExpansionContainer, INBTSerializable<CompoundNBT> {
    public static final String NBT_KEY = "Expansions";
    @Nonnull
    protected final ItemStack container;
    protected final int size;

    private boolean dirty = false;
    private boolean loaded = false;

    private final Multimap<ExpansionType, Expansion<?>> expansionsByType;

    public ExpansionContainer(@Nonnull ItemStack container, int size) {
        this.container = container;
        this.size = size;
        this.expansionsByType = HashMultimap.create();
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
        return ImmutableList.copyOf(this.expansionsByType.values());
        //return ImmutableList.copyOf(this.expansions.values().stream().flatMap(Collection::stream).collect(Collectors.toList()));
    }

    //TODO
    @SuppressWarnings("unchecked")
    public <E extends Expansion<E>> ImmutableList<E> getExpansionsOfType(ExpansionType type, Class<E> clazz) {
        this.loadIfNotLoaded();
        return (ImmutableList<E>) ImmutableList.copyOf(this.expansionsByType.get(type));
    }

    @Override
    public void addExpansion(IExpansionHolder expansion) {
        if(expansion != null && expansion.getExpansion() != null) {
            Expansion<?> ex = expansion.getExpansion();
            this.expansionsByType.put(ex.getType(), ex);
            //this.expansionsByType.get(ex.getType()).add(ex);
            this.dirty = true;
            this.save();
        }
    }

    public int getSpace() {
        return this.size - this.getAllExpansions().size();
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
        ListNBT listNBT = new ListNBT();
        this.expansionsByType.values().forEach(ex -> listNBT.add(Expansion.toCompoundNBT(ex, new CompoundNBT())));
        tag.put("expansions", listNBT);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        ListNBT listNBT = nbt.getList("expansions", Constants.NBT.TAG_COMPOUND);
        for(INBT tag : listNBT) {
            CompoundNBT ctag = (CompoundNBT) tag;
            Expansion<?> ex = Expansion.fromCompoundNBT(ctag);
            this.expansionsByType.put(ex.getType(), ex);
        }
    }
}
