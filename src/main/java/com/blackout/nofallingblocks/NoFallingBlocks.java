package com.blackout.nofallingblocks;

import net.minecraft.world.level.GameRules;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forgespi.language.IModInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.maven.artifact.versioning.ArtifactVersion;

import java.util.Optional;

@Mod(NoFallingBlocks.MODID)
public class NoFallingBlocks {
	public static final String MODID = "nofallingblocks";
	public static final String MODNAME = "No Falling Blocks";
	public static ArtifactVersion VERSION = null;
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public static final GameRules.Key<GameRules.BooleanValue> PREVENT_BLOCK_FALLING_RULE = GameRules.register("preventBlockFalling", GameRules.Category.UPDATES, GameRules.BooleanValue.create(true));

	public NoFallingBlocks() {
		Optional<? extends ModContainer> opt = ModList.get().getModContainerById(MODID);
		if (opt.isPresent()) {
			IModInfo modInfo = opt.get().getModInfo();
			VERSION = modInfo.getVersion();
		} else {
			LOGGER.warn("Cannot get version from mod info");
		}

		LOGGER.debug(MODNAME + " Version is: " + VERSION);
		LOGGER.debug("Mod ID for " + MODNAME + " is: " + MODID);

		MinecraftForge.EVENT_BUS.register(this);
	}
}