package io.github.alyx.mekponder.util;

import net.createmod.ponder.api.level.PonderLevel;
import net.createmod.ponder.foundation.ui.PonderUI;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class MiscUtil {

    public static Optional<PonderUI> getCurrentPonderUI() {
        if (Minecraft.getInstance().screen instanceof PonderUI ui) {
            return Optional.of(ui);
        }
        return Optional.empty();
    }

    public static boolean isInPonderLevel(Level level) {
        return level instanceof PonderLevel;
    }
}
