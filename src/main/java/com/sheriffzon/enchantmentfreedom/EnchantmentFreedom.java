package com.sheriffzon.enchantmentfreedom;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class EnchantmentFreedom implements ModInitializer {
    public static final String MOD_ID = "enchantment_freedom";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Enchantment Freedom initialising for Minecraft 26.2.");
    }
}
