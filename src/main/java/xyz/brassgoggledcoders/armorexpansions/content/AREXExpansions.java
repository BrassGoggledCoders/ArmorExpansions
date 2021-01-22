package xyz.brassgoggledcoders.armorexpansions.content;

import com.google.common.collect.Lists;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;
import xyz.brassgoggledcoders.armorexpansions.api.AREXRegistries;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.Expansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.ExpansionType;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.TickingExpansion;

public class AREXExpansions {
    public static final EquipmentSlotType[] ALLARMOR = new EquipmentSlotType[] { EquipmentSlotType.FEET, EquipmentSlotType.LEGS, EquipmentSlotType.CHEST, EquipmentSlotType.HEAD };

    private static final DeferredRegister<ExpansionType> EXPANSION_TYPES = DeferredRegister.create(AREXRegistries.EXPANSION_TYPES, ArmorExpansions.MOD_ID);
    public static final RegistryObject<ExpansionType> TICKING = EXPANSION_TYPES.register("ticking", () -> new ExpansionType(AREXAPI::getTicking, AREXAPI::getTickingExpansions));
    public static final RegistryObject<ExpansionType> DAMAGE_REDUCING = EXPANSION_TYPES.register("damage_reducing", () -> new ExpansionType(AREXAPI::getDamageReducing, AREXAPI::getDamageReducingExpansions));

    private static final DeferredRegister<TickingExpansion> TICKING_EXPANSIONS = DeferredRegister.create(AREXRegistries.TICKING_EXPANSIONS, ArmorExpansions.MOD_ID);
    public static final RegistryObject<TickingExpansion> TEST = TICKING_EXPANSIONS.register("test", () -> new TickingExpansion((stack, world, entity) -> ArmorExpansions.LOGGER.warn("Ticking"), ALLARMOR));

    public static void register(IEventBus bus) {
        EXPANSION_TYPES.register(bus);
        TICKING_EXPANSIONS.register(bus);
    }
}
