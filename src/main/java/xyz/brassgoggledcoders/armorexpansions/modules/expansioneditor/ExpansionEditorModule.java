package xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor;

import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.blocks.BlockExpansionEditor;
import xyz.brassgoggledcoders.boilerplate.module.Module;
import xyz.brassgoggledcoders.boilerplate.module.ModuleBase;
import xyz.brassgoggledcoders.boilerplate.registries.BlockRegistry;
import xyz.brassgoggledcoders.boilerplate.registries.ConfigRegistry;

@Module(mod = ArmorExpansions.ID)
public class ExpansionEditorModule extends ModuleBase {
	@Override
	public String getName() {
		return "Expansion Editor";
	}

	@Override
	public void registerBlocks(ConfigRegistry configRegistry, BlockRegistry blockRegistry) {
		blockRegistry.registerBlock(new BlockExpansionEditor());
	}
}
