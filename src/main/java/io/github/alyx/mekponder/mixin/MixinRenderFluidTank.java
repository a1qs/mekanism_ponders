package io.github.alyx.mekponder.mixin;

import mekanism.client.render.tileentity.RenderFluidTank;
import mekanism.common.tile.TileEntityFluidTank;
import net.createmod.ponder.api.level.PonderLevel;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Debug(export = true)
@Mixin(value = RenderFluidTank.class, remap = false)
public class MixinRenderFluidTank {
    @ModifyVariable(method = "render(Lmekanism/common/tile/TileEntityFluidTank;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/util/profiling/ProfilerFiller;)V", at = @At("STORE"), ordinal = 1)
    private float modifyScaleValue(float value, TileEntityFluidTank tile) {
        if (tile.getLevel() instanceof PonderLevel ) {
            return 1F;
        }

        return value;
    }
}
