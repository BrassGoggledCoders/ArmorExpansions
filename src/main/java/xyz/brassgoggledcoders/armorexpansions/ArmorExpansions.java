package xyz.brassgoggledcoders.armorexpansions;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.brassgoggledcoders.armorexpansions.api.AREXApi;
import xyz.brassgoggledcoders.armorexpansions.proxies.CommonProxy;
import xyz.brassgoggledcoders.boilerplate.BaseCreativeTab;
import xyz.brassgoggledcoders.boilerplate.BoilerplateModBase;

@Mod(modid = ArmorExpansions.ID, name = ArmorExpansions.NAME, version = ArmorExpansions.VERSION,
		dependencies = ArmorExpansions.DEPENDENCIES)
public class ArmorExpansions extends BoilerplateModBase {
	public final static String ID = "armorexpansions";
	public final static String NAME = "ArmorExpansions";
	public final static String VERSION = "@VERSION@";
	public final static String DEPENDENCIES = "required-after:boilerplate";

	@SidedProxy(clientSide = "xyz.brassgoggledcoders.armorexpansions.proxies.ClientProxy",
			serverSide = "xyz.brassgoggledcoders.armorexpansions.proxies.ServerProxy")
	public static CommonProxy proxy;

	@Instance(ArmorExpansions.ID)
	public static ArmorExpansions instance;

	public ArmorExpansions() {
		super(ArmorExpansions.ID, ArmorExpansions.NAME, ArmorExpansions.VERSION, new AREXTab());
	}

	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		AREXApi.registerCaps();
	}

	@Override
	@EventHandler
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

	@Override
	public Object getInstance() {
		return instance;
	}

	public static class AREXTab extends BaseCreativeTab {
		public static Item extensionEditor;

		public AREXTab() {
			super(ID);
		}

		@Override
		public Item getTabIconItem() {
			if(extensionEditor == null) {
				Block editor = ArmorExpansions.instance.getRegistryHolder().getBlockRegistry().getBlock("extension_editor");
				extensionEditor = Item.getItemFromBlock(editor);
			}
			return extensionEditor;
		}
	}
}
