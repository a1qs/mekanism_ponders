package io.github.alyx.mekponder.mixin;

import io.github.alyx.mekponder.util.MiscUtil;
import mekanism.client.render.RenderResizableCuboid;
import net.createmod.ponder.foundation.PonderScene;
import net.minecraft.client.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.concurrent.atomic.AtomicReference;

@Mixin(value = RenderResizableCuboid.class, remap = false)
public class MixinRenderResizableCuboid {

    @ModifyVariable(method = "renderCube(Lmekanism/client/render/MekanismRenderer$Model3D;Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;[IIILmekanism/client/render/RenderResizableCuboid$FaceDisplay;Lnet/minecraft/client/Camera;Lnet/minecraft/world/phys/Vec3;)V", at = @At("HEAD"), argsOnly = true)
    private static Camera replaceCamera(Camera oldCam) {
        AtomicReference<Camera> newCam = new AtomicReference<>();
        MiscUtil.getCurrentPonderUI().ifPresent(ui -> {
            PonderScene activeScene = ((InvokerPonderUI) ui).mekanism_ponder$invokeGetActiveScene();

            newCam.set(((AccessorPonderScene) activeScene).mekanism_ponder$getCamera());
        });

        return newCam.get() != null ? newCam.get() : oldCam;
    }
}
