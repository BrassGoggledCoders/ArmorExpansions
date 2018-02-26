package xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.registrysystem.BlockRegistry;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;

import xyz.brassgoggledcoders.armorexpansions.ArmorExpansions;
import xyz.brassgoggledcoders.armorexpansions.modules.expansioneditor.blocks.BlockExpansionEditor;

@Module(value = ArmorExpansions.ID)
public class ExpansionEditorModule extends ModuleBase {
	@Override
	public String getName() {
		return "Expansion Editor";
	}

	@Override
	public void registerBlocks(ConfigRegistry configRegistry, BlockRegistry blockRegistry) {
		blockRegistry.register(new BlockExpansionEditor());
	}
}
