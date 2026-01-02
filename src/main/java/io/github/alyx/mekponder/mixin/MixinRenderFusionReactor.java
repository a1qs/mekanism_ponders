package io.github.alyx.mekponder.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mekanism.api.text.EnumColor;
import mekanism.client.model.ModelEnergyCore;
import mekanism.generators.client.render.RenderFusionReactor;
import mekanism.generators.common.content.fusion.FusionReactorMultiblockData;
import mekanism.generators.common.tile.fusion.TileEntityFusionReactorController;
import net.createmod.ponder.api.level.PonderLevel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RenderFusionReactor.class, remap = false)
public abstract class MixinRenderFusionReactor {
    @Shadow @Final private static double SCALE;

    @Shadow @Final private ModelEnergyCore core;

    @Shadow
    private static float sinDegrees(float degrees) { return 0; }

    @Shadow protected abstract void renderPart(PoseStack matrix, VertexConsumer buffer, int overlayLight, EnumColor color, float scale, float ticks, int mult1, int mult2, int shift1, int shift2);

    @Inject(method = "render(Lmekanism/generators/common/tile/fusion/TileEntityFusionReactorController;Lmekanism/generators/common/content/fusion/FusionReactorMultiblockData;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/util/profiling/ProfilerFiller;)V", at = @At("HEAD"), cancellable = true)
    private void fusionPonderLevelRenderer(TileEntityFusionReactorController tile, FusionReactorMultiblockData multiblock, float partialTicks, PoseStack matrix, MultiBufferSource renderer, int light, int overlayLight, ProfilerFiller profiler, CallbackInfo ci) {
        Level level = tile.getLevel();
        if (level instanceof PonderLevel) {
            var e = tile.saveWithFullMetadata(tile.getLevel().registryAccess());
            if (e.getByte("redstone") == 0) { // why
                ci.cancel();
                return;
            }

            long scaledTemp = Math.round(15_000_000_00 / SCALE);
            float ticks = ((float) ((AccessorMinecraft) Minecraft.getInstance()).mekanism_ponder$getClientTickCount() / 2) + partialTicks;
            VertexConsumer buffer = renderer.getBuffer(core.RENDER_TYPE);
            matrix.pushPose();
            matrix.translate(0.5, -1.5, 0.5);
            float scale = 1 + 0.7F * sinDegrees(3.14F * scaledTemp + 135);
            renderPart(matrix, buffer, overlayLight, EnumColor.RED, scale, ticks, -6, -7, 0, 36);

            scale = 1 + 0.8F * sinDegrees(3 * scaledTemp);
            renderPart(matrix, buffer, overlayLight, EnumColor.PINK, scale, ticks, 4, 4, 0, 36);

            scale = 1 - 0.9F * sinDegrees(4 * scaledTemp + 90);
            renderPart(matrix, buffer, overlayLight, EnumColor.ORANGE, scale, ticks, 5, -3, -35, 106);

            matrix.popPose();

            ((InvokerMekanismTileEntityRenderer) this).mekanism_ponders$invokeEndIfNeeded(renderer, core.RENDER_TYPE);
            ci.cancel();
        }
    }
}
