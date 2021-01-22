package armorexpansions;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.content.AREXBlocks;
import xyz.brassgoggledcoders.armorexpansions.content.AREXItems;

public class AREXUSLanguageProvider extends LanguageProvider {

    public AREXUSLanguageProvider(DataGenerator gen) {
        super(gen, ArmorExpansions.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addBlock(AREXBlocks.EXPANSION_EDITOR, "Expansion Editor");

        this.addItem(AREXItems.EXPANDABLE_HELMET, "Basic Modular Helmet");
        this.addItem(AREXItems.EXPANDABLE_CHESTPLATE, "Basic Modular Chestplate");
        this.addItem(AREXItems.EXPANDABLE_LEGGINGS, "Basic Modular Leggings");
        this.addItem(AREXItems.EXPANDABLE_BOOTS, "Basic Modular Boots");

        this.addExpansion("test", "Test Expansion!");
    }

    public void addExpansion(String key, String name) {
        this.add("expansion.armorexpansions." + key, name);
    }
}