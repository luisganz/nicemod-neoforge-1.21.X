package com.example.mod.event;

import de.redstoner_zockt.minecraftplus.Minecraftplus;
import de.redstoner_zockt.minecraftplus.item.ModItems;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;

@EventBusSubscriber(modid = Minecraftplus.MOD_ID)
public class LightningEvents {

    @SubscribeEvent
    public static void onLightningSpawn(EntityJoinLevelEvent event) {

        Entity entity = event.getEntity();

        if (!(event.getLevel() instanceof ServerLevel level)) return;

        if (!(entity instanceof LightningBolt lightning)) return;

        // Spieler mit Helm suchen
        for (Player player : level.players()) {

            ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);

            if (head.getItem() == ModItems.ALU_HAT.get()) {

                lightning.moveTo(
                        player.getX(),
                        player.getY(),
                        player.getZ()
                );

                break;
            }
        }
    }
}