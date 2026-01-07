package io.github.alyx.mekponder.util;

import net.createmod.catnip.math.VecHelper;
import net.createmod.catnip.theme.Color;
import net.createmod.ponder.Ponder;
import net.createmod.ponder.api.ParticleEmitter;
import net.createmod.ponder.api.scene.EffectInstructions;
import net.createmod.ponder.api.scene.PositionUtil;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.foundation.instruction.EmitParticlesInstruction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

public class SceneUtil {

    /**
     * Helper method that (attempts) to mimick the sparkle animation of Mekanism Multiblocks upon completing them.
     *
     * @param scene             The SceneBuilder object of the Ponder
     * @param corner1           The first corner of the Multiblock
     * @param corner2           The second corner of the Multiblock
     * @param particlesPerSide  The amount of particles it should display per block per side
     */
    public static void multiBlockFormParticles(SceneBuilder scene, BlockPos corner1, BlockPos corner2, int particlesPerSide) {
        Vec3 c1 = new Vec3(corner1.getX() - 0.25, corner1.getY() - 0.25, corner1.getZ() - 0.25);
        Vec3 c2 = new Vec3(corner2.getX() + 0.25, corner2.getY() + 0.25, corner2.getZ() + 0.25);

        sparkleSide(c1, new Vec3(c1.x(), c2.y(), c2.z()), scene, particlesPerSide / 6);
        sparkleSide(c1, new Vec3(c1.x(), c1.y(), c2.z()), scene, particlesPerSide / 6);
        sparkleSide(c1, new Vec3(c2.x(), c2.y(), c1.z()), scene, particlesPerSide / 6);

        sparkleSide(new Vec3(c1.x(), c2.y(), c1.z()), c2, scene, particlesPerSide / 6); // TOP
        sparkleSide(new Vec3(c2.x(), c1.y(), c1.z()), c2, scene, particlesPerSide / 6); // EAST
        sparkleSide(new Vec3(c1.x(), c1.y(), c2.z()), c2, scene, particlesPerSide / 6); // SOUTH
    }


    /**
     * Loops through a block properties a specified amount with a possible delay
     *
     * @param scene     The SceneBuilder object of the Ponder
     * @param position  The BlockPos at which the block is located at
     * @param property  The BlockProperty to cycle
     * @param toCycle   The amount of times it should cycle the property
     * @param delay     The ticks it should wait per cycle
     */
    public static void loopBlockProperty(SceneBuilder scene, BlockPos position, Property<?> property, int toCycle, int delay) {
        for (int i = 0; i < toCycle; i++) {
            scene.world().cycleBlockProperty(position, property);
            if (delay > 0) scene.idle(delay);
        }
    }


    /**
     * Copy of particleEmitterWithinBlockSpace but uses exact coordinates instead of flooring the coordinates.
     *
     * @param data      The particle to display in the PonderLevel
     * @param motion    The Motion of the given particle to display
     * @return          A ParticleEmitter to be used for the EmitEffectInstructions call
     * @param <T>       Any object extending ParticleOptions
     */
    public static <T extends ParticleOptions>ParticleEmitter particleEmitterVec3(T data, Vec3 motion) {
        return (w, x, y, z) -> w.addParticle(data, x + Ponder.RANDOM.nextFloat(),
                y + Ponder.RANDOM.nextFloat(), z + Ponder.RANDOM.nextFloat(), motion.x,
                motion.y, motion.z);


    }



    private static void sparkleSide(Vec3 side1, Vec3 side2, SceneBuilder sceneBuilder, int particleAmount) {
        for (double i = side1.x(); i <= side2.x(); i++) {
            for (double j = side1.y(); j <= side2.y(); j++) {
                for (double k = side1.z(); k <= side2.z(); k++) {
                    redstoneParticles(sceneBuilder, new Vec3(i, j, k), 0xFF1100, particleAmount);
                }
            }
        }
    }

    private static void redstoneParticles(SceneBuilder scene, Vec3 pos, int color, int amount) {
        Vector3f rgb = new Color(color).asVectorF();
        scene.addInstruction(new EmitParticlesInstruction(pos, particleEmitterVec3(new DustParticleOptions(rgb, 1), Vec3.ZERO), amount, 2));
    }



}
