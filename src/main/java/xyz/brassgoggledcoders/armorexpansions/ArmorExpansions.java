package xyz.brassgoggledcoders.armorexpansions;

import com.teamacronymcoders.base.BaseModFoundation;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import xyz.brassgoggledcoders.armorexpansions.api.AREXApi;
import xyz.brassgoggledcoders.armorexpansions.proxies.CommonProxy;

@Mod(modid = ArmorExpansions.ID, name = ArmorExpansions.NAME, version = ArmorExpansions.VERSION,
		dependencies = ArmorExpansions.DEPENDENCIES)
public class ArmorExpansions extends BaseModFoundation<ArmorExpansions> {
	public final static String ID = "armorexpansions";
	public final static String NAME = "ArmorExpansions";
	public final static String VERSION = "@VERSION@";
	public final static String DEPENDENCIES = "required-after:base";

	@SidedProxy(clientSide = "xyz.brassgoggledcoders.armorexpansions.proxies.ClientProxy",
			serverSide = "xyz.brassgoggledcoders.armorexpansions.proxies.ServerProxy")
	public static CommonProxy proxy;

	@Instance(ArmorExpansions.ID)
	public static ArmorExpansions instance;

	public ArmorExpansions() {
		super(ID, NAME, VERSION, new AREXTab());
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
	public ArmorExpansions getInstance() {
		return instance;
	}

	public static class AREXTab extends CreativeTabs {
		public static Item expansionEditor;

		public AREXTab() {
			super(ID);
		}

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Items.DIAMOND);
		}
	}
}
