package xyz.brassgoggledcoders.armorexpansions.content;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.items.ItemExpandableArmor;

public class AREXItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ArmorExpansions.MOD_ID);

    public static final RegistryObject<Item> EXPANDABLE_HELMET = ITEMS.register("expandable_helmet", () -> new ItemExpandableArmor(ArmorMaterial.IRON, EquipmentSlotType.HEAD, defaultProperties()));
    public static final RegistryObject<Item> EXPANDABLE_CHESTPLATE = ITEMS.register("expandable_chestplate", () -> new ItemExpandableArmor(ArmorMaterial.IRON, EquipmentSlotType.CHEST, defaultProperties()));
    public static final RegistryObject<Item> EXPANDABLE_LEGGINGS = ITEMS.register("expandable_leggings", () -> new ItemExpandableArmor(ArmorMaterial.IRON, EquipmentSlotType.LEGS, defaultProperties()));
    public static final RegistryObject<Item> EXPANDABLE_BOOTS = ITEMS.register("expandable_boots", () -> new ItemExpandableArmor(ArmorMaterial.IRON, EquipmentSlotType.FEET, defaultProperties()));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    private static Item.Properties defaultProperties() {
        return new Item.Properties().group(ArmorExpansions.ITEM_GROUP);
    }
}
