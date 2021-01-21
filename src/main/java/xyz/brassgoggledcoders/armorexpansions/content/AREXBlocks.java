package xyz.brassgoggledcoders.armorexpansions.content;

import com.hrznstudio.titanium.registry.BlockRegistryObjectGroup;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.blocks.ExpansionEditorBlock;
import xyz.brassgoggledcoders.armorexpansions.tileentities.ExpansionEditorTileEntity;

import java.util.function.Function;

public class AREXBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ArmorExpansions.MOD_ID);
    private static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ArmorExpansions.MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ArmorExpansions.MOD_ID);

    public static final BlockRegistryObjectGroup<ExpansionEditorBlock, BlockItem, ExpansionEditorTileEntity> EXPANSION_EDITOR =
            new BlockRegistryObjectGroup<>("expansion_editor", ExpansionEditorBlock::new, blockItemCreator(), ExpansionEditorTileEntity::new)
                    .register(BLOCKS, ITEMS, TILE_ENTITIES);

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
        TILE_ENTITIES.register(bus);
        ITEMS.register(bus);
    }

    private static <B extends Block> Function<B, BlockItem> blockItemCreator() {
        return block -> new BlockItem(block, new Item.Properties().group(ArmorExpansions.ITEM_GROUP));
    }
}
