package xyz.brassgoggledcoders.armorexpansions.api;

import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryManager;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.AttributeExpansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.ExpansionType;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.TickingExpansion;

public class AREXRegistries {
    public static final IForgeRegistry<ExpansionType> EXPANSION_TYPES = getRegistry(ExpansionType.class);
    public static final IForgeRegistry<TickingExpansion> TICKING_EXPANSIONS = getRegistry(TickingExpansion.class);
    public static final IForgeRegistry<AttributeExpansion> ATTRIBUTE_EXPANSIONS = getRegistry(AttributeExpansion.class);

    public static <T extends IForgeRegistryEntry<T>> IForgeRegistry<T> getRegistry(Class<T> tClass) {
        IForgeRegistry<T> forgeRegistry = RegistryManager.ACTIVE.getRegistry(tClass);
        if (forgeRegistry != null) {
            return forgeRegistry;
        } else {
            throw new IllegalStateException("Failed to Find Registry, Likely called too early");
        }
    }
}
