package xyz.brassgoggledcoders.armorexpansions.content;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;
import xyz.brassgoggledcoders.armorexpansions.api.AREXRegistries;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.ExpansionType;

public class AREXExpansionTypes {

    static final DeferredRegister<ExpansionType> EXPANSION_TYPES = DeferredRegister.create(AREXRegistries.EXPANSION_TYPES, ArmorExpansions.MOD_ID);
    public static final RegistryObject<ExpansionType> DAMAGE_REDUCING = EXPANSION_TYPES.register("damage_reducing", () -> new ExpansionType(AREXAPI::getDamageReducing, AREXAPI::getDamageReducingExpansions));
    public static final RegistryObject<ExpansionType> TICKING = EXPANSION_TYPES.register("ticking", () -> new ExpansionType(AREXAPI::getTicking, AREXAPI::getTickingExpansions));

    public static void register(IEventBus bus) {
        EXPANSION_TYPES.register(bus);
    }
}
