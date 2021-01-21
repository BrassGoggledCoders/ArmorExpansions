package armorexpansions;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;

public class AREXItemModelProvider extends ItemModelProvider {

    public AREXItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ArmorExpansions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.singleTexture("expandable_helmet", mcLoc("item/generated"), "layer0", modLoc("item/expandable_helmet"));
        this.singleTexture("expandable_chestplate", mcLoc("item/generated"), "layer0", modLoc("item/expandable_chestplate"));
        this.singleTexture("expandable_leggings", mcLoc("item/generated"), "layer0", modLoc("item/expandable_leggings"));
        this.singleTexture("expandable_boots", mcLoc("item/generated"), "layer0", modLoc("item/expandable_boots"));
    }
}
