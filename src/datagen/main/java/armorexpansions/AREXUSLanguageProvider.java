package armorexpansions;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.content.AREXBlocks;

public class AREXUSLanguageProvider extends LanguageProvider {

    public AREXUSLanguageProvider(DataGenerator gen) {
        super(gen, ArmorExpansions.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addBlock(AREXBlocks.EXPANSION_EDITOR, "Expansion Editor");
    }
}