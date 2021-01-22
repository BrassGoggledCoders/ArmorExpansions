package xyz.brassgoggledcoders.armorexpansions.api.expansion;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.apache.logging.log4j.util.TriConsumer;

import javax.annotation.Nonnull;

public class Expansion extends ForgeRegistryEntry<Expansion> {
    ExpansionType type;
    TriConsumer<ItemStack, World, Entity> tick;
    private String translationKey;
    private ITextComponent name;

    public Expansion(ExpansionType type) {
        this.type = type;
    }

    public Expansion(ExpansionType type, TriConsumer<ItemStack, World, Entity> tick) {
        this(type);
        this.tick = tick;
    }

    public ExpansionType getType() {
        return type;
    }

    public void tick(ItemStack stack, World world, Entity entity) {
        if(tick != null) {
            tick.accept(stack, world, entity);
        }
    }

    @Nonnull
    public String getTranslationKey() {
        if (translationKey == null) {
            translationKey = Util.makeTranslationKey("expansion", this.getRegistryName());
        }
        return translationKey;
    }

    @Nonnull
    public ITextComponent getDisplayName() {
        if (name == null) {
            name = new TranslationTextComponent(this.getTranslationKey());
        }
        return name;
    }
}
