package io.github.alyx.mekponder.mixin;

import net.createmod.ponder.foundation.PonderScene;
import net.createmod.ponder.foundation.ui.PonderUI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = PonderUI.class, remap = false)
public interface InvokerPonderUI {
    @Invoker("getActiveScene")
    PonderScene mekanism_ponder$invokeGetActiveScene();
}
