package xyz.brassgoggledcoders.armorexpansions.content;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.api.AREXRegistries;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.Expansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.ExpansionType;

public class AREXExpansions {
    private static final DeferredRegister<Expansion> EXPANSIONS = DeferredRegister.create(AREXRegistries.EXPANSIONS, ArmorExpansions.MOD_ID);

    public static final RegistryObject<Expansion> TEST = EXPANSIONS.register("test", () -> new Expansion(ExpansionType.ALLARMOR));

    public static void register(IEventBus bus) {
        EXPANSIONS.register(bus);
    }
}
