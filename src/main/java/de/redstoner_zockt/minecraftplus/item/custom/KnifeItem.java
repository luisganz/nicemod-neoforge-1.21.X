package de.redstoner_zockt.minecraftplus.item.custom;

import de.redstoner_zockt.minecraftplus.block.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.Map;


public class KnifeItem extends Item {
    private static final Map<Block, Block> KNIFE_MAP=
            Map.of(
                    ModBlocks.STEAK_PLATE.get(), ModBlocks.STEAK_PLATE_SLICED.get()
            );

    public KnifeItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clicedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(KNIFE_MAP.containsKey(clicedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), KNIFE_MAP.get(clicedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
            }
        }

        return InteractionResult.SUCCESS;
    }
}