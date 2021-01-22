package xyz.brassgoggledcoders.armorexpansions;

import com.hrznstudio.titanium.tab.TitaniumTab;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.Expansion;
import xyz.brassgoggledcoders.armorexpansions.content.AREXBlocks;
import xyz.brassgoggledcoders.armorexpansions.content.AREXExpansions;
import xyz.brassgoggledcoders.armorexpansions.content.AREXItems;

@Mod(ArmorExpansions.MOD_ID)
@Mod.EventBusSubscriber(modid = ArmorExpansions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmorExpansions {
    public final static String MOD_ID = "armorexpansions";

    public static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup ITEM_GROUP = new TitaniumTab(MOD_ID,
            () -> new ItemStack(Items.BEDROCK));

    private static boolean registriesSetup = false;

    public ArmorExpansions() {
        super();
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        setupRegistries();

        AREXExpansions.register(modBus);
        AREXBlocks.register(modBus);
        AREXItems.register(modBus);
    }

    public static void setupRegistries() {
        if (!registriesSetup) {
            makeRegistry("expansion", Expansion.class);
            registriesSetup = true;
        }
    }

    private static <T extends IForgeRegistryEntry<T>> void makeRegistry(String name, Class<T> type) {
        new RegistryBuilder<T>()
                .setName(new ResourceLocation(ArmorExpansions.MOD_ID, name))
                .setType(type)
                .create();
    }
}
