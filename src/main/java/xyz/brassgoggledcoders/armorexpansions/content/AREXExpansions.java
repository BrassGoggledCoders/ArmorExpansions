package xyz.brassgoggledcoders.armorexpansions.content;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.api.AREXRegistries;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.AttributeExpansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.TickingExpansion;

public class AREXExpansions {
    public static final EquipmentSlotType[] ALLARMOR = new EquipmentSlotType[] { EquipmentSlotType.FEET, EquipmentSlotType.LEGS, EquipmentSlotType.CHEST, EquipmentSlotType.HEAD };

    private static final DeferredRegister<TickingExpansion> TICKING_EXPANSIONS = DeferredRegister.create(AREXRegistries.TICKING_EXPANSIONS, ArmorExpansions.MOD_ID);
    public static final RegistryObject<TickingExpansion> TEST = TICKING_EXPANSIONS.register("test", () -> new TickingExpansion((stack, world, entity) -> ArmorExpansions.LOGGER.warn("Ticking"), ALLARMOR));

    private static final DeferredRegister<AttributeExpansion> ATTRIBUTE_EXPANSIONS = DeferredRegister.create(AREXRegistries.ATTRIBUTE_EXPANSIONS, ArmorExpansions.MOD_ID);
    public static final RegistryObject<AttributeExpansion> LEATHER_PLATING = ATTRIBUTE_EXPANSIONS.register("leather_plating", () -> new AttributeExpansion.Builder()
            .addAttributeModifier(Attributes.ARMOR, new AttributeModifier("Armor modifier", 3, AttributeModifier.Operation.ADDITION))
            .build(ALLARMOR));
    public static final RegistryObject<AttributeExpansion> OBSIDIAN_PLATING = ATTRIBUTE_EXPANSIONS.register("obsidian_plating", () -> new AttributeExpansion.Builder()
            .addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier("Armor knockback resistance", 2, AttributeModifier.Operation.ADDITION))
            .build(ALLARMOR));

    public static void register(IEventBus bus) {
        TICKING_EXPANSIONS.register(bus);
        ATTRIBUTE_EXPANSIONS.register(bus);
    }
}
