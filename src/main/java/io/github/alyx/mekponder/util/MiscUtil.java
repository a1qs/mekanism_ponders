package io.github.alyx.mekponder.util;

import net.createmod.ponder.foundation.ui.PonderUI;
import net.minecraft.client.Minecraft;

import java.util.Optional;

public class MiscUtil {

    public static Optional<PonderUI> getCurrentPonderUI() {
        if (Minecraft.getInstance().screen instanceof PonderUI ui) {
            return Optional.of(ui);
        }
        return Optional.empty();
    }
}
