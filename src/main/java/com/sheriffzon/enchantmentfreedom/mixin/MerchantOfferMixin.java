package com.sheriffzon.enchantmentfreedom.mixin;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(MerchantOffer.class)
public abstract class MerchantOfferMixin {
    @Inject(
        method = "<init>(Lnet/minecraft/world/item/trading/ItemCost;Ljava/util/Optional;Lnet/minecraft/world/item/ItemStack;IIZIIFI)V",
        at = @At("RETURN")
    )
    private void enchantmentFreedom$raiseLibrarianBookLevels(
            ItemCost costA, Optional<?> costB, ItemStack result,
            int uses, int maxUses, boolean rewardExp, int specialPriceDiff,
            int demand, float priceMultiplier, int xp, CallbackInfo ci
    ) {
        if (result.getItem() != Items.ENCHANTED_BOOK) return;
        ItemEnchantments stored = result.get(DataComponents.STORED_ENCHANTMENTS);
        if (stored == null || stored.isEmpty()) return;

        RandomSource random = RandomSource.create();
        for (Object2IntMap.Entry<Holder<Enchantment>> entry : stored.entrySet()) {
            double roll = random.nextDouble();
            int level = roll < 0.002 ? 10
                    : roll < 0.007 ? 9
                    : roll < 0.015 ? 8
                    : roll < 0.03 ? 7
                    : roll < 0.06 ? 6
                    : roll < 0.12 ? 5
                    : roll < 0.22 ? 4
                    : roll < 0.38 ? 3
                    : roll < 0.62 ? 2 : 1;
            result.enchant(entry.getKey(), level);
        }
    }
}
