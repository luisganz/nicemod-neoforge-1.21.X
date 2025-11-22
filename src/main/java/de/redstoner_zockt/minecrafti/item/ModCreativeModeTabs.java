package de.redstoner_zockt.minecrafti.item;

import de.redstoner_zockt.minecrafti.Minecrafti;
import de.redstoner_zockt.minecrafti.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Minecrafti.MOD_ID);

    public static final Supplier<CreativeModeTab> DECOSTUF = CREATIVE_MODE_TAB.register("decostuf",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TABLE.get())).title(Component.translatable("creativetab.minecrafti.decostuf"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(new ItemStack(ModBlocks.TABLE.get()));
                        output.accept(new ItemStack(ModBlocks.PLATE.get()));
                        output.accept(new ItemStack(ModBlocks.CHAIR.get()));
                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
