package com.blackout.nofallingblocks.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import org.apache.commons.lang3.tuple.Pair;

public class NoFallingBlocksConfig {

    public static class Common {
        public final ConfigValue<Boolean> vanillaFallingBlocks;
        public final ConfigValue<Boolean> bopFallingBlocks;
        public final ConfigValue<Boolean> espFallingBlocks;

        public final ConfigValue<Boolean> showUpdateMessage;

        Common(ForgeConfigSpec.Builder builder) {
            builder.push("Falling Blocks");
            vanillaFallingBlocks = builder.comment("Will ALL the Falling Blocks in Vanilla Minecraft fall?").define("Vanilla Falling Blocks", false);
            bopFallingBlocks = builder.comment("Will ALL the Falling Blocks in Biomes O' Plenty fall?").define("Biomes O' Plenty Falling Blocks", false);
            espFallingBlocks = builder.comment("Will ALL the Falling Blocks in Extended Slabs Plus fall?").define("Extended Slabs Plus Falling Blocks", false);
            builder.pop();
            builder.push("Update Checker");
            showUpdateMessage = builder.comment("Send messages when there is a new update!").define("Show Update Messages", true);
            builder.pop();
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }
}
