package com.sheriffzon.enchantmentfreedom.mixin.client;

import net.minecraft.client.gui.screens.inventory.AnvilScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/**
 * Keeps the anvil screen's cost label aligned with the server-side result.
 * The server-side anvil menu already permits costs above vanilla's limit;
 * this removes the separate presentation threshold from the client screen.
 */
@Mixin(AnvilScreen.class)
public abstract class AnvilCostLabelMixin {
    @ModifyConstant(
            method = "extractLabels",
            constant = @Constant(intValue = 40)
    )
    private int enchantmentFreedom$useActualCostThreshold(int vanillaThreshold) {
        return Integer.MAX_VALUE;
    }
}
