package com.sheriffzon.enchantmentfreedom.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;
import net.minecraft.world.inventory.AnvilMenu;

@Mixin(AnvilMenu.class)
public abstract class AnvilMenuMixin {
    @ModifyConstant(method = "createResult", constant = @Constant(intValue = 40))
    private int enchantmentFreedom$removeTooExpensiveCap(int original) {
        return Integer.MAX_VALUE;
    }
}
