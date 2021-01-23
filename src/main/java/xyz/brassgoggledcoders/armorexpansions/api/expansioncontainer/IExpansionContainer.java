package xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableList;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.Expansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.ExpansionType;
import xyz.brassgoggledcoders.armorexpansions.api.expansionholder.IExpansionHolder;

public interface IExpansionContainer {
    boolean canAcceptExpansion(IExpansionHolder extension);

    int getMaximumNumberOfExpansions();

    ImmutableList<Expansion<?>> getAllExpansions();

    <E extends Expansion<E>> ImmutableList<E> getExpansionsOfType(ExpansionType type, Class<E> clazz);

    void addExpansion(IExpansionHolder expansion);

    @Beta
    boolean isActive();
}
