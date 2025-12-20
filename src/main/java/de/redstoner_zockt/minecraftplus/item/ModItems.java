package de.redstoner_zockt.minecraftplus.item;

import de.redstoner_zockt.minecraftplus.Minecraftplus;
import de.redstoner_zockt.minecraftplus.item.custom.KnifeItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Minecraftplus.MOD_ID);

    //example
    //public static final DeferredItem<Item> (NAME) = ITEMS.register("(name)",
    //        () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>PORZELLAN = ITEMS.register("porzellan",
            () -> new KnifeItem(new Item.Properties()));

    public static final DeferredItem<Item>DEAMON_KNIFE = ITEMS.register("deamon_knife",
            () -> new KnifeItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item>KNIFE = ITEMS.register("knife",
            () -> new KnifeItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item>FORK = ITEMS.register("fork",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item>BLOOD_BOTTLE = ITEMS.register("blood_bottle",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BLOOD_BOTTLE)));

    public static final DeferredItem<Item>BLOOD = ITEMS.register("blood",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>BROTCHEN = ITEMS.register("brotchen",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BROTCHEN)));

    public static final DeferredItem<Item>KASE_BROTCHEN = ITEMS.register("kase_brotchen",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KASE_BROTCHEN)));

    public static final DeferredItem<Item>KASE = ITEMS.register("kase",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item>WARMES_KASE_BROTCHEN = ITEMS.register("warmes_kase_brotchen",
            () -> new Item(new Item.Properties().food(ModFoodProperties.WARMES_KASE_BROTCHEN)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
