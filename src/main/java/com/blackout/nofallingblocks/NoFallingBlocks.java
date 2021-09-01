package com.blackout.nofallingblocks;

import com.blackout.nofallingblocks.config.NoFallingBlocksConfig;
import com.blackout.nofallingblocks.events.LoginEventHandler;
import com.blackout.nofallingblocks.registry.NFBBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("nofallingblocks")
public class NoFallingBlocks {
    public static final String MODID = "nofallingblocks";
    public static final String MODNAME = "No Falling Blocks";
    public static final String VERSION = "0.1-BETA";

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public NoFallingBlocks() {
        LOGGER.debug("The Mod ID of " + MODNAME + " is: " + MODID);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        if (!NoFallingBlocksConfig.COMMON.vanillaFallingBlocks.get()) {
            NFBBlocks.MINECRAFT_ITEM_BLOCK_OVERRIDES.register(eventBus);
            NFBBlocks.MINECRAFT_BLOCK_OVERRIDES.register(eventBus);
        }
        if (ModList.get().isLoaded("biomesoplenty")) {
            if (!NoFallingBlocksConfig.COMMON.bopFallingBlocks.get()) {
                NFBBlocks.BOP_ITEM_BLOCK_OVERRIDES.register(eventBus);
                NFBBlocks.BOP_BLOCK_OVERRIDES.register(eventBus);
                LOGGER.debug(MODNAME + ": Biomes O' Plenty Compat Loaded");
            }
        }
        if (ModList.get().isLoaded("extendedslabs")) {
            if (!NoFallingBlocksConfig.COMMON.espFallingBlocks.get()) {
                NFBBlocks.ESP_ITEM_BLOCK_OVERRIDES.register(eventBus);
                NFBBlocks.ESP_BLOCK_OVERRIDES.register(eventBus);
                LOGGER.debug(MODNAME + ": Extended Slabs Plus Compat Loaded");
            }
        }

        MinecraftForge.EVENT_BUS.register(new LoginEventHandler());
        if (NoFallingBlocksConfig.COMMON.showUpdateMessage.get())
            UpdateHandler.init();
        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, NoFallingBlocksConfig.COMMON_SPEC);
    }

    public static ResourceLocation location(String name) {
        return new ResourceLocation(MODID, name);
    }
}