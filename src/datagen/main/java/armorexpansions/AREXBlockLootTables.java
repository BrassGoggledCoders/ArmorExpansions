package armorexpansions;

import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.fml.RegistryObject;
import xyz.brassgoggledcoders.armorexpansions.content.AREXBlocks;

import javax.annotation.Nonnull;
import java.util.stream.Collectors;

public class AREXBlockLootTables extends BlockLootTables {
    @Override
    @Nonnull
    protected Iterable<Block> getKnownBlocks() {
        return AREXBlocks.getAllBlocks()
                .stream()
                .map(RegistryObject::get)
                .collect(Collectors.toList());
    }

    @Override
    protected void addTables() {
        this.registerDropSelfLootTable(AREXBlocks.EXPANSION_EDITOR.getBlock());
    }
}