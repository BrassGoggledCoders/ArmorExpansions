package xyz.brassgoggledcoders.armorexpansions.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;
import xyz.brassgoggledcoders.armorexpansions.api.expansion.TickingExpansion;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.ExpansionContainer;
import xyz.brassgoggledcoders.armorexpansions.api.expansioncontainer.ItemStackExpansionContainerProvider;
import xyz.brassgoggledcoders.armorexpansions.content.AREXExpansionTypes;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class ExpandableArmorItem extends ArmorItem {

    private static final UUID[] ARMOR_MODIFIERS = new UUID[]{UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};

    public ExpandableArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties builderIn) {
        super(materialIn, slot, builderIn.maxStackSize(1));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        stack.getCapability(AREXAPI.EXPANSION_CONTAINER_CAP).ifPresent(cap -> {
            if(cap instanceof ExpansionContainer) {
                ((ExpansionContainer) cap).load();
                tooltip.add(new StringTextComponent("Maximum Number of Expansions: " + cap.getMaximumNumberOfExpansions()));
                cap.getAllExpansions().forEach(expansion -> tooltip.add(expansion.getDisplayName()));
            }
        });
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
        return new ItemStackExpansionContainerProvider(stack, 10);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        stack.getCapability(AREXAPI.EXPANSION_CONTAINER_CAP).ifPresent(cap -> {
            if (cap instanceof ExpansionContainer && cap.isActive()) {
                ((ExpansionContainer) cap).load();
                cap.getExpansionsOfType(AREXExpansionTypes.TICKING.get(), TickingExpansion.class).forEach(expansion -> expansion.getTick().accept(stack, world, player));
            }
        });
    }

    /*@Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        UUID uuid = ARMOR_MODIFIERS[slot.getIndex()];
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        //builder.put(Attributes.ARMOR, new AttributeModifier(uuid, "Armor modifier", (double)this.damageReduceAmount, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "Armor toughness", this.getToughness(), AttributeModifier.Operation.ADDITION));
        if (this.knockbackResistance > 0) {
            builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "Armor knockback resistance", (double)this.knockbackResistance, AttributeModifier.Operation.ADDITION));
        }
        stack.getCapability(AREXAPI.EXPANSION_CONTAINER_CAP).ifPresent(cap -> {
            if (cap.isActive()) {
                builder.put(Attributes.ARMOR, new AttributeModifier(uuid, "Armor modifier", this.getDamageReduceAmount() + cap.getAllExpansions().stream().filter(holder -> holder.getExpansion() instanceof DamageReducingExpansion)
                        .mapToInt(holder -> ((DamageReducingExpansion) holder.getExpansion()).getDamageReduction())
                        .sum(), AttributeModifier.Operation.ADDITION));
            }
        });
        return equipmentSlot == this.slot ? builder.build() : super.getAttributeModifiers(equipmentSlot);
    }*/
}