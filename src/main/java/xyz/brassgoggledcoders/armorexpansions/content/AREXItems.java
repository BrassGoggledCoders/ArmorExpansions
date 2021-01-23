package xyz.brassgoggledcoders.armorexpansions.content;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.items.BaseExpansionItem;
import xyz.brassgoggledcoders.armorexpansions.items.ExpandableArmorItem;

public class AREXItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ArmorExpansions.MOD_ID);

    public static final RegistryObject<Item> EXPANDABLE_HELMET = ITEMS.register("expandable_helmet", () -> new ExpandableArmorItem(ArmorMaterial.IRON, EquipmentSlotType.HEAD, defaultProperties()));
    public static final RegistryObject<Item> EXPANDABLE_CHESTPLATE = ITEMS.register("expandable_chestplate", () -> new ExpandableArmorItem(ArmorMaterial.IRON, EquipmentSlotType.CHEST, defaultProperties()));
    public static final RegistryObject<Item> EXPANDABLE_LEGGINGS = ITEMS.register("expandable_leggings", () -> new ExpandableArmorItem(ArmorMaterial.IRON, EquipmentSlotType.LEGS, defaultProperties()));
    public static final RegistryObject<Item> EXPANDABLE_BOOTS = ITEMS.register("expandable_boots", () -> new ExpandableArmorItem(ArmorMaterial.IRON, EquipmentSlotType.FEET, defaultProperties()));

    public static final RegistryObject<Item> TEST_MODULE = ITEMS.register("test_module", () -> new BaseExpansionItem(defaultProperties(), AREXExpansions.TEST::get));
    public static final RegistryObject<Item> LEATHER_PLATING = ITEMS.register("leather_plating", () -> new BaseExpansionItem(defaultProperties(), AREXExpansions.LEATHER_PLATING::get));
    public static final RegistryObject<Item> OBSIDIAN_PLATING = ITEMS.register("obsidian_plating", () -> new BaseExpansionItem(defaultProperties(), AREXExpansions.OBSIDIAN_PLATING::get));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    private static Item.Properties defaultProperties() {
        return new Item.Properties().group(ArmorExpansions.ITEM_GROUP);
    }
}
