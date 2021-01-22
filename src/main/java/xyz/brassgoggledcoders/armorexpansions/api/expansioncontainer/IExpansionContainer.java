package xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.ResourceLocation;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.Expansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.TickingExpansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansionholder.IExpansionHolder;

public interface IExpansionContainer {
    boolean canAcceptExpansion(IExpansionHolder extension);

    int getMaximumNumberOfExpansions();

    ImmutableList<IExpansionHolder> getAllExpansions();

    void addExpansion(IExpansionHolder expansion);

    boolean isActive();
}
