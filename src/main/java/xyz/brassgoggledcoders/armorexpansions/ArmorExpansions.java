package xyz.brassgoggledcoders.armorexpansions;

import com.hrznstudio.titanium.tab.TitaniumTab;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.IExpansion;
import xyz.brassgoggledcoders.armorexpansions.content.AREXBlocks;
import xyz.brassgoggledcoders.armorexpansions.content.AREXItems;
import xyz.brassgoggledcoders.armorexpansions.expansions.TestExpansion;

import java.util.HashMap;
import java.util.Map;

@Mod(ArmorExpansions.MOD_ID)
@Mod.EventBusSubscriber(modid = ArmorExpansions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmorExpansions {
    public final static String MOD_ID = "armorexpansions";

    public static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup ITEM_GROUP = new TitaniumTab(MOD_ID,
            () -> new ItemStack(Items.BEDROCK));

    //TODO Investigate converting this to a Forge Registry. Is there any benefit?
    public static final Map<ResourceLocation, IExpansion> EXPANSIONS = new HashMap<>();

    public ArmorExpansions() {
        super();
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        AREXBlocks.register(modBus);
        AREXItems.register(modBus);
        //TODO
        TestExpansion e = new TestExpansion();
        EXPANSIONS.put(e.getIdentifier(), e);
    }
}
