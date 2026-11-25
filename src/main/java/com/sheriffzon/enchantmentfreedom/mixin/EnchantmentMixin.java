package com.sheriffzon.enchantmentfreedom.mixin;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Enchantment Freedom's vanilla-rule overrides.
 *
 * These small return-value hooks implement the mod's rules directly:
 * compatibility is unrestricted, item applicability is unrestricted,
 * and the supported enchantment ceiling is ten.
 */
@Mixin(Enchantment.class)
public abstract class EnchantmentMixin {

    @Inject(method = "areCompatible", at = @At("HEAD"), cancellable = true)
    private static void enchantmentFreedom$compatibilityRule(
            Holder<Enchantment> left,
            Holder<Enchantment> right,
            CallbackInfoReturnable<Boolean> result
    ) {
        result.setReturnValue(Boolean.TRUE);
    }

    @Inject(method = "canEnchant", at = @At("HEAD"), cancellable = true)
    private void enchantmentFreedom$itemApplicabilityRule(
            ItemStack candidate,
            CallbackInfoReturnable<Boolean> result
    ) {
        result.setReturnValue(Boolean.TRUE);
    }

    @Inject(method = "getMaxLevel", at = @At("HEAD"), cancellable = true)
    private void enchantmentFreedom$levelLimitRule(
            CallbackInfoReturnable<Integer> result
    ) {
        result.setReturnValue(10);
    }
}
