package com.sheriffzon.enchantmentfreedom.mixin;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public abstract class EnchantmentMixin {
    @Inject(method = "areCompatible", at = @At("TAIL"), cancellable = true)
    private static void enchantmentFreedom$allowAllCombinations(
            Holder<Enchantment> first,
            Holder<Enchantment> second,
            CallbackInfoReturnable<Boolean> cir
    ) {
        cir.setReturnValue(true);
    }

    @Inject(method = "canEnchant", at = @At("TAIL"), cancellable = true)
    private void enchantmentFreedom$allowAllItems(
            ItemStack stack,
            CallbackInfoReturnable<Boolean> cir
    ) {
        cir.setReturnValue(true);
    }

    @Inject(method = "getMaxLevel", at = @At("HEAD"), cancellable = true)
    private void enchantmentFreedom$raiseMaximumLevel(
            CallbackInfoReturnable<Integer> cir
    ) {
        cir.setReturnValue(10);
    }
}
