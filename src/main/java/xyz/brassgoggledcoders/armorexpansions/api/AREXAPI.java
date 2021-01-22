package xyz.brassgoggledcoders.armorexpansions.api;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.IExpansionContainer;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.ItemStackExpansionContainerProvider;
import xyz.brassgoggledcoders.armorexpansions.api.expansionholder.IExpansionHolder;
import xyz.brassgoggledcoders.armorexpansions.api.expansionholder.ItemStackExpansionProvider;
import xyz.brassgoggledcoders.armorexpansions.content.AREXExpansions;
import xyz.brassgoggledcoders.workshop.Workshop;
import xyz.brassgoggledcoders.workshop.api.capabilities.NOPStorage;

/*
An ExpansionHolder is to an Expansion roughly what an ItemStack is to an Item. ExpansionContainers by contrast, contain a list of Expansions.
 */
@Mod.EventBusSubscriber(modid = Workshop.MOD_ID)
public class AREXAPI {
    @CapabilityInject(IExpansionHolder.class)
    public static Capability<IExpansionHolder> EXPANSION_HOLDER_CAP;
    @CapabilityInject(IExpansionContainer.class)
    public static Capability<IExpansionContainer> EXPANSION_CONTAINER_CAP;

    static {
        CapabilityManager.INSTANCE.register(IExpansionContainer.class, new NOPStorage<>(), () -> new ItemStackExpansionContainerProvider(ItemStack.EMPTY, 0));
        CapabilityManager.INSTANCE.register(IExpansionHolder.class, new NOPStorage<>(), () -> new ItemStackExpansionProvider(ItemStack.EMPTY, AREXExpansions.TEST));
    }
}
