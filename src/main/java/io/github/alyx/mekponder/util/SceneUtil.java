package io.github.alyx.mekponder.util;

import io.github.alyx.mekponder.mixin.AccessorAttributeStateActive;
import mekanism.common.block.attribute.Attributes;
import net.createmod.ponder.api.scene.EffectInstructions;
import net.createmod.ponder.api.scene.PositionUtil;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.properties.Property;

public class SceneUtil {

    /**
     * Helper method that (attempts) to mimick the sparkle animation of Mekanism Multiblocks upon completing them.
     *
     * @param scene             The SceneBuilder object of the Ponder
     * @param util              The utility object of the Ponder
     * @param corner1           The first corner of the Multiblock
     * @param corner2           The second corner of the Multiblock
     * @param particlesPerSide  The amount of particles it should display per block per side
     */
    public static void multiBlockFormParticles(SceneBuilder scene, SceneBuildingUtil util, BlockPos corner1, BlockPos corner2, int particlesPerSide) {
        corner1 = new BlockPos.MutableBlockPos(corner1.getX() - 0.5, corner1.getY() - 0.5, corner1.getZ() - 0.5);
        corner2 = new BlockPos.MutableBlockPos(corner2.getX() + 0.5, corner2.getY() + 0.5, corner2.getZ() + 0.5);

        sparkleSide(corner1, util.grid().at(corner1.getX(), corner2.getY(), corner2.getZ()), scene.effects(), util.grid(), particlesPerSide / 6);
        sparkleSide(corner1, util.grid().at(corner1.getX(), corner1.getY(), corner2.getZ()), scene.effects(), util.grid(), particlesPerSide / 6);
        sparkleSide(corner1, util.grid().at(corner2.getX(), corner2.getY(), corner1.getZ()), scene.effects(), util.grid(), particlesPerSide / 6);

        sparkleSide(util.grid().at(corner1.getX(), corner2.getY(), corner1.getZ()), corner2, scene.effects(), util.grid(), particlesPerSide / 6); // TOP
        sparkleSide(util.grid().at(corner2.getX(), corner1.getY(), corner1.getZ()), corner2, scene.effects(), util.grid(), particlesPerSide / 6); // EAST
        sparkleSide(util.grid().at(corner1.getX(), corner1.getY(), corner2.getZ()), corner2, scene.effects(), util.grid(), particlesPerSide / 6); // SOUTH
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



    private static void sparkleSide(BlockPos side1, BlockPos side2, EffectInstructions effects, PositionUtil posUtil, int particleAmount) {
        for (int i = side1.getX(); i <= side2.getX(); i++) {
            for (int j = side1.getY(); j <= side2.getY(); j++) {
                for (int k = side1.getZ(); k <= side2.getZ(); k++) {

                    effects.createRedstoneParticles(posUtil.at(i, j, k), 0xFF1100, particleAmount);
                }
            }
        }
    }
}
