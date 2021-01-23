package xyz.brassgoggledcoders.armorexpansions.api;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.AttributeExpansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.ExpansionType;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.TickingExpansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.ExpansionContainer;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.IExpansionContainer;
import xyz.brassgoggledcoders.armorexpansions.api.expansionholder.IExpansionHolder;
import xyz.brassgoggledcoders.armorexpansions.api.expansionholder.ItemStackExpansionProvider;
import xyz.brassgoggledcoders.armorexpansions.content.AREXExpansions;
import xyz.brassgoggledcoders.workshop.Workshop;
import xyz.brassgoggledcoders.workshop.api.capabilities.NOPStorage;

import java.util.Collection;

/*
An ExpansionHolder is to an Expansion roughly what an ItemStack is to an Item. ExpansionContainers by contrast, contain a list of Expansions.
 */
@Mod.EventBusSubscriber(modid = Workshop.MOD_ID)
public class AREXAPI {
    @CapabilityInject(IExpansionHolder.class)
    public static Capability<IExpansionHolder> EXPANSION_HOLDER_CAP;
    @CapabilityInject(IExpansionContainer.class)
    public static Capability<IExpansionContainer> EXPANSION_CONTAINER_CAP;

    public static Lazy<IForgeRegistry<ExpansionType>> EXPANSION_TYPE = Lazy.of(() -> RegistryManager.ACTIVE.getRegistry(ExpansionType.class));
    public static Lazy<IForgeRegistry<TickingExpansion>> TICKING_EXPANSION = Lazy.of(() -> RegistryManager.ACTIVE.getRegistry(TickingExpansion.class));
    public static Lazy<IForgeRegistry<AttributeExpansion>> ATTRIBUTE_EXPANSION = Lazy.of(() -> RegistryManager.ACTIVE.getRegistry(AttributeExpansion.class));

    static {
        CapabilityManager.INSTANCE.register(IExpansionContainer.class, new NOPStorage<>(), () -> new ExpansionContainer(ItemStack.EMPTY, 0));
        CapabilityManager.INSTANCE.register(IExpansionHolder.class, new NOPStorage<>(), () -> new ItemStackExpansionProvider(ItemStack.EMPTY, AREXExpansions.TEST.get()));
    }

    public static ExpansionType getExpansionType(String name) {
        return getExpansionType(new ResourceLocation(name));
    }

    public static ExpansionType getExpansionType(ResourceLocation resourceLocation) {
        return EXPANSION_TYPE.get().getValue(resourceLocation);
    }

    public static TickingExpansion getTicking(ResourceLocation name) {
        return TICKING_EXPANSION.get().getValue(name);
    }

    public static Collection<TickingExpansion> getTickingExpansions() {
        return TICKING_EXPANSION.get().getValues();
    }

    public static AttributeExpansion getAttribute(ResourceLocation name) {
        return ATTRIBUTE_EXPANSION.get().getValue(name);
    }

    public static Collection<AttributeExpansion> getAttributeExpansions() {
        return ATTRIBUTE_EXPANSION.get().getValues();
    }
}
