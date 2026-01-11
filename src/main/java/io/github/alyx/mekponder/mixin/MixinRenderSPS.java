package io.github.alyx.mekponder.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import mekanism.client.render.lib.effect.BoltRenderer;
import mekanism.client.render.tileentity.RenderSPS;
import mekanism.common.content.sps.SPSMultiblockData;
import mekanism.common.lib.effect.BoltEffect;
import mekanism.common.lib.math.Plane;
import mekanism.common.lib.math.voxel.VoxelCuboid;
import mekanism.common.tile.multiblock.TileEntitySPSCasing;
import net.createmod.ponder.api.level.PonderLevel;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.util.RandomSource;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Mixin(value = RenderSPS.class, remap = false)
public abstract class MixinRenderSPS {

    @Shadow @Final private static Map<UUID, BoltRenderer> boltRendererMap;

    @Shadow
    private static BoltEffect getBoltFromData(SPSMultiblockData.CoilData data, BlockPos pos, Vec3 center) {
        return null;
    }

    @Shadow @Final private static RandomSource rand;

    @Shadow
    private static float getBoundedScale(float scale, float min, float max) {
        return 0;
    }

    @Inject(method = "render(Lmekanism/common/tile/multiblock/TileEntitySPSCasing;Lmekanism/common/content/sps/SPSMultiblockData;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/util/profiling/ProfilerFiller;)V", at = @At("HEAD"), cancellable = true)
    private void spsPonderLevelRenderer(TileEntitySPSCasing tile, SPSMultiblockData multiblock, float partialTick, PoseStack matrix, MultiBufferSource renderer, int light, int overlayLight, ProfilerFiller profiler, CallbackInfo ci) {
        if (tile.getLevel() instanceof PonderLevel) {

            if (tile.getBlockPos().equals(new BlockPos(5, 1, 3))) {

                var e = tile.saveWithFullMetadata(tile.getLevel().registryAccess());
                if (e.getByte("redstone") == 0) { // why
                    ci.cancel();
                    return;
                }

                BoltRenderer bolts = boltRendererMap.computeIfAbsent(multiblock.inventoryID, mb -> new BoltRenderer());
                Vec3 center = Vec3.atLowerCornerOf(new Vec3i(1, 1, 1)).add(Vec3.atLowerCornerOf(new Vec3i(7, 7, 7)))
                        .add(new Vec3(1, 1, 1)).scale(0.5);
                Vec3 renderCenter = new Vec3(-0.5, 3, 1.5);

                for (SPSMultiblockData.CoilData data : multiblock.coilData.coilMap.values()) {
                    if (data.prevLevel > 0) {
                        bolts.update(data.coilPos.hashCode(), getBoltFromData(data, tile.getBlockPos(), renderCenter), partialTick);
                    }
                }

                float energyScale = 1;
                int targetEffectCount = 0;


                if (rand.nextDouble() < getBoundedScale(energyScale, 0.01F, 0.4F)) {
                    VoxelCuboid.CuboidSide side = Util.getRandom(VoxelCuboid.CuboidSide.SIDES, rand);
                    VoxelCuboid c = new VoxelCuboid(new BlockPos(1, 1, 1), new BlockPos(7, 7, 7));
                    Plane plane = Plane.getInnerCuboidPlane(c, side);
                    Vec3 endPos = plane.getRandomPoint(rand).subtract(tile.getBlockPos().getX(), tile.getBlockPos().getY(), tile.getBlockPos().getZ());

                    BoltEffect bolt = new BoltEffect(BoltEffect.BoltRenderInfo.ELECTRICITY, renderCenter, endPos, 15)
                            .size(0.01F * getBoundedScale(energyScale, 0.5F, 5))
                            .lifespan(8)
                            .spawn(BoltEffect.SpawnFunction.NO_DELAY);
                    bolts.update(Objects.hash(side, endPos), bolt, partialTick);
                }

                bolts.render(partialTick, matrix, renderer);
            }

            ci.cancel();
        }
    }
}
