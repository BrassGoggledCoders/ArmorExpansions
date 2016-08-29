package xyz.brassgoggledcoders.armorexpansions.modules.extensioneditor;

import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.modules.extensioneditor.blocks.BlockExtensionEditor;
import xyz.brassgoggledcoders.boilerplate.module.Module;
import xyz.brassgoggledcoders.boilerplate.module.ModuleBase;
import xyz.brassgoggledcoders.boilerplate.registries.BlockRegistry;
import xyz.brassgoggledcoders.boilerplate.registries.ConfigRegistry;

@Module(mod = ArmorExpansions.ID)
public class ExtensionEditorModule extends ModuleBase {
	@Override
	public String getName() {
		return "Extension Editor";
	}

	@Override
	public void registerBlocks(ConfigRegistry configRegistry, BlockRegistry blockRegistry) {
		blockRegistry.registerBlock(new BlockExtensionEditor());
	}
}
