package de.redstoner_zockt.minecraftplus.item.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class HelmetItem extends Item {
    public HelmetItem(Properties properties) {
        super(properties);
    }

    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.HEAD;
    }
}
