package xyz.brassgoggledcoders.armorexpansions.content;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.api.AREXRegistries;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.DamageReducingExpansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.TickingExpansion;

public class AREXExpansions {
    public static final EquipmentSlotType[] ALLARMOR = new EquipmentSlotType[] { EquipmentSlotType.FEET, EquipmentSlotType.LEGS, EquipmentSlotType.CHEST, EquipmentSlotType.HEAD };

    private static final DeferredRegister<TickingExpansion> TICKING_EXPANSIONS = DeferredRegister.create(AREXRegistries.TICKING_EXPANSIONS, ArmorExpansions.MOD_ID);
    public static final RegistryObject<TickingExpansion> TEST = TICKING_EXPANSIONS.register("test", () -> new TickingExpansion((stack, world, entity) -> ArmorExpansions.LOGGER.warn("Ticking"), ALLARMOR));

    private static final DeferredRegister<DamageReducingExpansion> DAMAGE_REDUCING_EXPANSIONS = DeferredRegister.create(AREXRegistries.DAMAGE_REDUCING_EXPANSIONS, ArmorExpansions.MOD_ID);
    public static final RegistryObject<DamageReducingExpansion> LEATHER_PLATING = DAMAGE_REDUCING_EXPANSIONS.register("leather_plating", () -> new DamageReducingExpansion(10, ALLARMOR));

    public static void register(IEventBus bus) {
        TICKING_EXPANSIONS.register(bus);
        DAMAGE_REDUCING_EXPANSIONS.register(bus);
    }
}
