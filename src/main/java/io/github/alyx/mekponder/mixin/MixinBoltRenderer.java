package io.github.alyx.mekponder.mixin;

import mekanism.client.render.lib.effect.BoltRenderer;
import mekanism.common.lib.effect.BoltEffect;
import net.createmod.ponder.foundation.ui.PonderUI;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = BoltRenderer.class, remap = false)
public abstract class MixinBoltRenderer {

    // yeah this is kind of hacky, bu
    @ModifyVariable(method = "render(FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/world/phys/Vec3;)V", at = @At(value = "STORE"), ordinal = 0)
    private BoltRenderer.Timestamp replaceTimestampRender(BoltRenderer.Timestamp timestamp, float partialTicks) {
        if (Minecraft.getInstance().screen instanceof PonderUI) {
            return new BoltRenderer.Timestamp(PonderUI.ponderTicks, partialTicks);
        }
        return timestamp;
    }

    @ModifyVariable(method = "update", at = @At(value = "STORE", ordinal = 0))
    private BoltRenderer.Timestamp replaceTimestampUpdate(BoltRenderer.Timestamp timestamp, Object owner, BoltEffect newBoltData, float partialTicks) {
        if (Minecraft.getInstance().screen instanceof PonderUI) {
            return new BoltRenderer.Timestamp(PonderUI.ponderTicks, partialTicks);
        }
        return timestamp;
    }
}
