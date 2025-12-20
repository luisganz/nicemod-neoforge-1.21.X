package de.redstoner_zockt.minecraftplus.item.custom;

import de.redstoner_zockt.minecraftplus.Minecraftplus;
import de.redstoner_zockt.minecraftplus.block.ModBlocks;
import de.redstoner_zockt.minecraftplus.item.ModItems;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;

import java.util.Map;

@EventBusSubscriber(modid = Minecraftplus.MOD_ID)
public class KnifeItem extends Item {
    //private static final Map<Block, Block> KNIFE_MAP=
    //        Map.of(
    //                ModBlocks.STEAK_PLATE.get(), ModBlocks.STEAK_PLATE_SLICED.get()
    //        );

    public KnifeItem(Properties properties) {
        super(properties);
    }

    //public InteractionResult useOn(UseOnContext context) {
    //    Level level = context.getLevel();
    //    Block clicedBlock = level.getBlockState(context.getClickedPos()).getBlock();
    //    if(KNIFE_MAP.containsKey(clicedBlock)) {
    //        if(!level.isClientSide()) {
    //            level.setBlockAndUpdate(context.getClickedPos(), KNIFE_MAP.get(clicedBlock).defaultBlockState());
    //            context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
    //                    item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
    //        }
    //    }
    //    return InteractionResult.SUCCESS;
    //}

    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {

        Player player = event.getEntity();
        Entity target = event.getTarget();

        // Ziel muss lebendig sein
        if (!(target instanceof LivingEntity livingTarget)) return;

        // Untote ausschließen
        if (livingTarget.getType().is(EntityTypeTags.UNDEAD)) return;

        Level level = player.level();
        if (level.isClientSide) return;

        ItemStack offhand = player.getOffhandItem();

        // Nur Glasflasche
        if (!offhand.is(Items.GLASS_BOTTLE)) return;

        // Glasflasche verbrauchen
        offhand.shrink(1);

        // Neue Blutflasche (als eigenes Item)
        ItemStack bloodBottle = new ItemStack(ModItems.BLOOD_BOTTLE.get());

        // Ins Inventar legen oder droppen
        if (!player.getInventory().add(bloodBottle)) {
            player.drop(bloodBottle, false);
        }
    }
}