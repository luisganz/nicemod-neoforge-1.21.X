package de.redstoner_zockt.nicemod.item;

import de.redstoner_zockt.nicemod.Minecrafti;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Minecrafti.MOD_ID);

    //example
    //public static final DeferredItem<Item> (NAME) = ITEMS.register("(name)",
    //        () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
