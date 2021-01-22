package xyz.brassgoggledcoders.armorexpansions.api;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.ExpansionHandler;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.IExpansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.ExpansionContainerCapabilityProvider;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.IExpansionContainer;
import xyz.brassgoggledcoders.workshop.Workshop;
import xyz.brassgoggledcoders.workshop.api.capabilities.NOPStorage;

@Mod.EventBusSubscriber(modid = Workshop.MOD_ID)
public class AREXAPI {
    @CapabilityInject(IExpansion.class)
    public static Capability<IExpansion> EXTENSION_CAP;
    @CapabilityInject(IExpansionContainer.class)
    public static Capability<IExpansionContainer> EXTENSION_CONTAINER_CAP;

    static {
        CapabilityManager.INSTANCE.register(IExpansionContainer.class, new NOPStorage<>(), () -> new ExpansionContainerCapabilityProvider(ItemStack.EMPTY));
        CapabilityManager.INSTANCE.register(IExpansion.class, new NOPStorage<>(), ExpansionHandler::new);
    }
}
