package com.blackout.nofallingblocks;

import net.minecraft.util.text.TextFormatting;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class UpdateHandler {
    private static String currentVersion = NoFallingBlocks.VERSION;

    private static String newestVersion;

    public static String updateStatus = "NULL";

    public static boolean show = false;

    public static void init() {
        getNewestVersion();
        if (newestVersion != null) {
            if (!newestVersion.equalsIgnoreCase(currentVersion))
                if (!newestVersion.equalsIgnoreCase(currentVersion)) {
                    show = true;
                    updateStatus = TextFormatting.WHITE + "Version " + TextFormatting.GOLD + newestVersion + TextFormatting.WHITE + " of " + TextFormatting.GOLD + TextFormatting.BOLD + NoFallingBlocks.MODNAME + TextFormatting.WHITE + " is now available from " + TextFormatting.GOLD + "https://www.curseforge.com/minecraft/mc-mods/no-falling-blocks";
                }
        } else {
            show = false;
            updateStatus = "Failed to connect to see if an update to " + TextFormatting.GREEN + NoFallingBlocks.MODNAME + TextFormatting.WHITE + " is available";
        }
    }

    private static void getNewestVersion() {
        try {
            URL url = new URL("https://blackout03.github.io/versions/no_falling_blocks_versionchecker.txt");
            Scanner s = new Scanner(url.openStream());
            if (s.hasNext())
                newestVersion = s.next();
            s.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
