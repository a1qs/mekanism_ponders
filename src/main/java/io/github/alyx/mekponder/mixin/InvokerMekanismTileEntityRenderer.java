package io.github.alyx.mekponder.mixin;

import mekanism.client.render.tileentity.MekanismTileEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = MekanismTileEntityRenderer.class, remap = false)
public interface InvokerMekanismTileEntityRenderer {
    @Invoker("endIfNeeded")
    void mekanism_ponders$invokeEndIfNeeded(MultiBufferSource renderer, @Nullable RenderType renderType);
}
