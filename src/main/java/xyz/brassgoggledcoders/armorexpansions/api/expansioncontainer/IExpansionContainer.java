package xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.ResourceLocation;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.IExpansion;

public interface IExpansionContainer {
    ResourceLocation getIdentifier();

    boolean canAcceptExpansion(IExpansion extension);

    int getMaximumNumberOfExpansions();

    //Immutable to force use of add method so it properly goes to NBT...
    ImmutableList<IExpansion> getExpansions();

    void addExpansion(IExpansion expansion);
}
