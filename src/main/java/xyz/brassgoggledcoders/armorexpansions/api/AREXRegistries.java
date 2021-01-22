package xyz.brassgoggledcoders.armorexpansions.api;

import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryManager;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.Expansion;

public class AREXRegistries {
    public static final IForgeRegistry<Expansion> EXPANSIONS = getRegistry(Expansion.class);

    public static <T extends IForgeRegistryEntry<T>> IForgeRegistry<T> getRegistry(Class<T> tClass) {
        IForgeRegistry<T> forgeRegistry = RegistryManager.ACTIVE.getRegistry(tClass);
        if (forgeRegistry != null) {
            return forgeRegistry;
        } else {
            throw new IllegalStateException("Failed to Find Registry, Likely called too early");
        }
    }
}
