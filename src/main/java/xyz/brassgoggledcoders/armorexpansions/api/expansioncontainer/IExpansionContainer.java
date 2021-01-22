package xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.ResourceLocation;
import xyz.brassgoggledcoders.armorexpansions.api.expansionholder.IExpansionHolder;

public interface IExpansionContainer {
    ResourceLocation getIdentifier();

    boolean canAcceptExpansion(IExpansionHolder extension);

    int getMaximumNumberOfExpansions();

    //Immutable to force use of add method so it properly goes to NBT...
    ImmutableList<IExpansionHolder> getExpansions();

    void addExpansion(IExpansionHolder expansion);
}
