package armorexpansions;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;

@Mod.EventBusSubscriber(modid = ArmorExpansions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AREXDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        final DataGenerator dataGenerator = event.getGenerator();
        final ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        if(event.includeClient()) {
            dataGenerator.addProvider(new AREXUSLanguageProvider(dataGenerator));
            dataGenerator.addProvider(new AREXBlockstateProvider(dataGenerator, existingFileHelper));
            dataGenerator.addProvider(new AREXItemModelProvider(dataGenerator, existingFileHelper));
        }
        if(event.includeServer()) {
            dataGenerator.addProvider(new AREXLootTableProvider(dataGenerator));
        }
    }
}
