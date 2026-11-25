package com.sheriffzon.enchantmentfreedom.mixin.client;

import net.minecraft.client.gui.screens.inventory.AnvilScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(AnvilScreen.class)
public abstract class AnvilScreenMixin {
    @ModifyConstant(method = "extractLabels", constant = @Constant(intValue = 40))
    private int enchantmentFreedom$showActualAnvilCost(int original) {
        return Integer.MAX_VALUE;
    }
}
