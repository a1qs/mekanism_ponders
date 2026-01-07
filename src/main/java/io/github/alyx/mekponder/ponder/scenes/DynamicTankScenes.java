package io.github.alyx.mekponder.ponder.scenes;

import io.github.alyx.mekponder.ponder.MekPonderScenes;
import io.github.alyx.mekponder.util.SceneUtil;
import mekanism.common.registries.MekanismBlocks;
import mekanism.generators.common.registries.GeneratorsBlocks;
import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;

public class DynamicTankScenes {


    public static void creatingDynamicTank(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title(MekPonderScenes.CREATING_DYNAMIC_TANK.getPath(), "Creating a Dynamic Tank Multiblock");
        scene.showBasePlate();
        scene.idle(10);
        scene.world().showSection(util.select().layersFrom(1), Direction.DOWN);
        scene.idle(20);


        scene.overlay().showText(130)
                .colored(PonderPalette.BLUE)
                .text("The Dynamic Tank is a Multiblock, capable of storing a large amount of either Fluids, or Chemicals.");

        scene.idle(150);

        scene.overlay().showText(90)
                .pointAt(util.vector().blockSurface(util.grid().at(1, 4, 4), Direction.UP))
                .text("Building a Dynamic Tank Multiblock requires Dynamic Tank blocks.");

        scene.idle(115);

        scene.overlay().showOutlineWithText(util.select().fromTo(1, 1, 1, 4, 4, 4), 80)
                .colored(PonderPalette.BLUE)
                .text("It is a cuboid structure and hollow on the inside.");

        scene.overlay().showOutline(PonderPalette.WHITE, new Object(), util.select().fromTo(2, 2, 2, 3, 3, 3), 80);

        scene.idle(105);

        scene.overlay().showText(130)
                .colored(PonderPalette.BLUE)
                .text("Inner sections can be replaced by either Structural Glass, Reactor Glass, or Dynamic Valves.");

        scene.idle(50);

        scene.world().replaceBlocks(util.select().fromTo(1, 2, 2, 1, 3, 3), GeneratorsBlocks.REACTOR_GLASS.defaultState(), true);
        scene.idle(10);
        scene.world().setBlock(util.grid().at(2, 2, 1), MekanismBlocks.DYNAMIC_VALVE.defaultState(), true);
        scene.world().setBlock(util.grid().at(3, 4, 3), MekanismBlocks.DYNAMIC_VALVE.defaultState(), true);

        scene.idle(90);

        scene.overlay().showText(100)
                        .text("Once properly built, it will emit Redstone Particles to indicate its completion.");

        scene.idle(85);

        SceneUtil.multiBlockFormParticles(scene, util.grid().at(1, 1, 1), util.grid().at(4, 4, 4),  6);

        scene.idle(45);
        scene.addKeyframe();
        scene.idle(5);

        scene.overlay().showText(100)
                .text("A Dynamic Tank Multiblock can range from sizes of 3x3x3, up to 18x18x18.");
        scene.idle(110);


        AABB tankBounds = new AABB(1, 1, 1, 4, 4 ,4);
        Object tankOutline = new Object();

        for (int i = 0; i < 3; i++) {
            int expand = i + 1;
            scene.overlay().chaseBoundingBoxOutline(PonderPalette.WHITE, tankOutline,
                    tankBounds.expandTowards(expand, expand, expand), 15);

            scene.idle(15);
        }

        scene.idle(30);

        scene.overlay().showText(170)
                .text("The larger the structure is, the more capacity it has.\n Capacities differ from Fluids and Chemicals, with Chemicals having larger capacities than fluids.");

        scene.idle(185);
        scene.addKeyframe();

        scene.world().hideSection(util.select().position(2, 2, 0), Direction.UP);
        scene.world().hideSection(util.select().position(3, 5, 3), Direction.UP);


        scene.idle(5);


        scene.overlay().showOutlineWithText(util.select().position(2, 2, 1), 120)
                .text("To insert/extract Fluids or Chemicals, a Dynamic Valve can be used.");

        scene.idle(135);

        scene.world().setBlock(util.grid().at(2, 2, 0), MekanismBlocks.ULTIMATE_MECHANICAL_PIPE.defaultState(), true);
        scene.world().setBlock(util.grid().at(3, 5, 3), MekanismBlocks.ULTIMATE_FLUID_TANK.defaultState(), true);

        scene.overlay().showText(100)
                .text("Simply connect a transmitter of your choosing to the valve.");

        scene.idle(80);


        scene.world().showSection(util.select().position(2, 2, 0), Direction.DOWN);

        scene.idle(5);
        scene.world().showSection(util.select().position(3, 5, 3), Direction.DOWN);


        scene.idle(45);

        scene.overlay().showText(100)
                .pointAt(util.vector().of(2.5, 2.5, 0.5))
                .text("To extract Fluids or Chemicals, the given transmitter must be set to pull from the valve.");

        scene.idle(110);
    }
}

