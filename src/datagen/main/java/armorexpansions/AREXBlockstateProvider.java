package armorexpansions;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.brassgoggledcoders.armorexpansions.content.AREXBlocks;
import xyz.brassgoggledcoders.workshop.Workshop;

public class AREXBlockstateProvider extends BlockStateProvider {

    private final ExistingFileHelper exFileHelper;

    public AREXBlockstateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Workshop.MOD_ID, exFileHelper);
        this.exFileHelper = exFileHelper;
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlock(AREXBlocks.EXPANSION_EDITOR.getBlock());
    }
}