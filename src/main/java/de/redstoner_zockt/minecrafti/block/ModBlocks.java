package de.redstoner_zockt.minecrafti.block;

import de.redstoner_zockt.minecrafti.Minecrafti;
import de.redstoner_zockt.minecrafti.block.custom.PlateBlock;
import de.redstoner_zockt.minecrafti.block.custom.TableBlock;
import de.redstoner_zockt.minecrafti.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Minecrafti.MOD_ID);

    //example
    //public static final DeferredBlock<Block> (NAME) = registerBlock("(name)",
    //    () -> new Block(BlockBehaviour.Properties.of()
    //            .strength(strength)f.requiresCorrectToolForDrops().sound(SoundType.(SOUNDTYPE))));

    public static final DeferredBlock<Block> TABLE = registerBlock("table",
    () -> new TableBlock(BlockBehaviour.Properties.of()
            .noOcclusion()));

    public static final DeferredBlock<Block> PLATE = registerBlock("plate",
    () -> new PlateBlock(BlockBehaviour.Properties.of()
            .noOcclusion()));

    public static final DeferredBlock<Block> CHAIR = registerBlock("chair",
            () -> new PlateBlock(BlockBehaviour.Properties.of()
                    .noOcclusion()));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}