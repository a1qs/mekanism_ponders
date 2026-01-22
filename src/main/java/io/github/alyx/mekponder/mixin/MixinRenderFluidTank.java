package io.github.alyx.mekponder.mixin;

import io.github.alyx.mekponder.util.MiscUtil;
import mekanism.client.render.tileentity.RenderFluidTank;
import mekanism.common.tile.TileEntityFluidTank;
import net.createmod.ponder.api.level.PonderLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = RenderFluidTank.class, remap = false)
public class MixinRenderFluidTank {
    @ModifyVariable(method = "render(Lmekanism/common/tile/TileEntityFluidTank;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/util/profiling/ProfilerFiller;)V", at = @At("STORE"), ordinal = 1)
    private float modifyScaleValue(float value, TileEntityFluidTank tile) {
        if (MiscUtil.isInPonderLevel(tile.getLevel())) {
            return 1F;
        }

        return value;
    }
}
