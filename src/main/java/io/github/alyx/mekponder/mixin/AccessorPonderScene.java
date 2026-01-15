package io.github.alyx.mekponder.mixin;

import net.createmod.ponder.foundation.PonderScene;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = PonderScene.class, remap = false)
public interface AccessorPonderScene {

    @Accessor("camera")
    PonderScene.SceneCamera mekanism_ponder$getCamera();
}
