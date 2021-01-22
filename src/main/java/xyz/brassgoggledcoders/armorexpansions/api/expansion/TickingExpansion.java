package xyz.brassgoggledcoders.armorexpansions.api.expansion;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.apache.logging.log4j.util.TriConsumer;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;

import java.util.function.Function;

public class TickingExpansion extends Expansion<TickingExpansion> {

    private final TriConsumer<ItemStack, World, Entity> tick;

    public TickingExpansion(TriConsumer<ItemStack, World, Entity> tick, EquipmentSlotType... type) {
        super(() -> AREXAPI.getExpansionType("ticking"), type);
        this.tick = tick;
    }

    public TriConsumer<ItemStack, World, Entity> getTick() {
        return tick;
    }
}
