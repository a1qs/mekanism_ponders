package io.github.alyx.mekponder.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.alyx.mekponder.util.MiscUtil;
import mekanism.generators.client.render.RenderIndustrialTurbine;
import mekanism.generators.common.content.turbine.TurbineMultiblockData;
import mekanism.generators.common.tile.turbine.TileEntityTurbineCasing;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RenderIndustrialTurbine.class, remap = false)
public class MixinRenderIndustrialTurbine {
    @Inject(method = "render(Lmekanism/generators/common/tile/turbine/TileEntityTurbineCasing;Lmekanism/generators/common/content/turbine/TurbineMultiblockData;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/util/profiling/ProfilerFiller;)V", at = @At("HEAD"), cancellable = true)
    private void cancelPonderRender(TileEntityTurbineCasing tile, TurbineMultiblockData multiblock, float partialTick, PoseStack matrix, MultiBufferSource renderer, int light, int overlayLight, ProfilerFiller profiler, CallbackInfo ci) {
        if (MiscUtil.isInPonderLevel(tile.getLevel())) ci.cancel();
    }
}
