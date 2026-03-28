package io.github.alyx.mekponder.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.alyx.mekponder.util.MiscUtil;
import mekanism.client.render.tileentity.RenderThermalEvaporationPlant;
import mekanism.common.content.evaporation.EvaporationMultiblockData;
import mekanism.common.tile.multiblock.TileEntityThermalEvaporationController;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RenderThermalEvaporationPlant.class, remap = false)
public class MixinRenderThermalEvaporationPlant {

    @Inject(method = "render(Lmekanism/common/tile/multiblock/TileEntityThermalEvaporationController;Lmekanism/common/content/evaporation/EvaporationMultiblockData;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/util/profiling/ProfilerFiller;)V", at = @At("HEAD"), cancellable = true)
    private void cancelRenderInPonder(TileEntityThermalEvaporationController tile, EvaporationMultiblockData multiblock, float partialTick, PoseStack matrix, MultiBufferSource renderer, int light, int overlayLight, ProfilerFiller profiler, CallbackInfo ci) {
        if (MiscUtil.isInPonderLevel(tile.getLevel())) {
            ci.cancel();
        }
    }
}
