package xyz.brassgoggledcoders.armorexpansions.api;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.ExpansionHandler;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.IExpansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.ExpansionContainerHandler;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.IExpansionContainer;
import xyz.brassgoggledcoders.workshop.api.capabilities.NOPStorage;

public class AREXAPI {
    @CapabilityInject(IExpansion.class)
    public static Capability<IExpansion> EXTENSION_CAP;

    @CapabilityInject(IExpansionContainer.class)
    public static Capability<IExpansionContainer> EXTENSION_CONTAINER_CAP;

    public static void registerCaps() {
        CapabilityManager.INSTANCE.register(IExpansionContainer.class, new NOPStorage<>(), ExpansionContainerHandler::new);
        CapabilityManager.INSTANCE.register(IExpansion.class, new NOPStorage<>(), ExpansionHandler::new);
    }
}
