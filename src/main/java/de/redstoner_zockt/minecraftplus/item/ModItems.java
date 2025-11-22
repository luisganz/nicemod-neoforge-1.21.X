package de.redstoner_zockt.minecraftplus.item;

import de.redstoner_zockt.minecraftplus.Minecraftplus;
import de.redstoner_zockt.minecraftplus.item.custom.KnifeItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Minecraftplus.MOD_ID);

    //example
    //public static final DeferredItem<Item> (NAME) = ITEMS.register("(name)",
    //        () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>KNIFE = ITEMS.register("knife",
            () -> new KnifeItem(new Item.Properties().durability(2)));

    public static final DeferredItem<Item>FORK = ITEMS.register("fork",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
