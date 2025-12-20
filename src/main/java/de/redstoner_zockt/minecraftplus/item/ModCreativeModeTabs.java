package de.redstoner_zockt.minecraftplus.item;

import de.redstoner_zockt.minecraftplus.Minecraftplus;
import de.redstoner_zockt.minecraftplus.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Minecraftplus.MOD_ID);

    public static final Supplier<CreativeModeTab> DECOSTUFPLUS = CREATIVE_MODE_TAB.register("decostufplus",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TABLE.get())).title(Component.translatable("creativetab.minecraftplus.decostufplus"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(new ItemStack(ModBlocks.TABLE.get()));
                        output.accept(new ItemStack(ModBlocks.PLATE.get()));
                        output.accept(new ItemStack(ModBlocks.CHAIR.get()));
                    }).build());

    public static final Supplier<CreativeModeTab> TOOLSPLUS = CREATIVE_MODE_TAB.register("toolsplus",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KNIFE.get())).title(Component.translatable("creativetab.minecraftplus.toolsplus"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(new ItemStack(ModItems.KNIFE.get()));
                        output.accept(new ItemStack(ModItems.DEAMON_KNIFE.get()));
                        output.accept(new ItemStack(ModItems.FORK.get()));
                    }).build());

    public static final Supplier<CreativeModeTab> ITEMSPLUS = CREATIVE_MODE_TAB.register("itemsplus",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KASE_BROTCHEN.get())).title(Component.translatable("creativetab.minecraftplus.itemsplus"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(new ItemStack(ModItems.PORZELLAN.get()));
                        output.accept(new ItemStack(ModItems.BROTCHEN.get()));
                        output.accept(new ItemStack(ModItems.KASE.get()));
                        output.accept(new ItemStack(ModItems.KASE_BROTCHEN.get()));
                        output.accept(new ItemStack(ModItems.WARMES_KASE_BROTCHEN.get()));
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
