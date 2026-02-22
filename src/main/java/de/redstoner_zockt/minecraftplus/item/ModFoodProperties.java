package de.redstoner_zockt.minecraftplus.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties BROTCHEN = new FoodProperties.Builder().nutrition(2).saturationModifier(1).build();
    public static final FoodProperties KASE_BROTCHEN = new FoodProperties.Builder().nutrition(5).saturationModifier(3).build();
    public static final FoodProperties WARMES_KASE_BROTCHEN = new FoodProperties.Builder().nutrition(7).saturationModifier(4).build();
    public static final FoodProperties BLOOD_BOTTLE = new FoodProperties.Builder().nutrition(2).saturationModifier(1).build();
}
