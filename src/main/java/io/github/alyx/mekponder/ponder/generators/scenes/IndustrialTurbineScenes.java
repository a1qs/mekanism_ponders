package io.github.alyx.mekponder.ponder.generators.scenes;

import io.github.alyx.mekponder.ponder.element.ChemicalPonderRender;
import io.github.alyx.mekponder.ponder.generators.MekGensPonderScenes;
import io.github.alyx.mekponder.util.SceneUtil;
import mekanism.api.chemical.ChemicalStack;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.registries.MekanismChemicals;
import mekanism.generators.common.registries.GeneratorsBlocks;
import mekanism.generators.common.registries.GeneratorsItems;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;

public class IndustrialTurbineScenes {

    // TODO: Turbine blade shenanigans
    public static void creatingTurbine(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title(MekGensPonderScenes.CREATING_TURBINE.getPath(), "Creating an Industrial Turbine");
        scene.showBasePlate();
        scene.scaleSceneView(0.8F);

        Selection innerFrame = util.select().fromTo(2, 2, 1, 4, 5, 1)
                        .add(util.select().fromTo(1, 2, 2, 1, 5, 4))
                        .add(util.select().fromTo(5, 2, 2, 5, 5, 4))
                        .add(util.select().fromTo(2, 2, 5, 4, 5, 5));

        Selection turbineSlice = util.select().fromTo(1, 2, 1, 4, 8, 1)
                .add(util.select().fromTo(1, 2, 2, 1, 8, 4))
                .add(util.select().fromTo(2, 8, 2, 4, 8, 4));


        scene.idle(10);
        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(120)
                .text("The Industrial Turbine is a Multiblock, capable of generating large amounts of energy using Steam.");
        scene.idle(140);

        scene.world().showSection(util.select().fromTo(1, 2, 5, 5, 8, 5), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(5, 2, 1, 5, 8, 4), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(4, 2, 1, 1, 8, 1), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(1, 2, 2, 1, 8, 4), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(4, 8, 4, 2, 8, 2), Direction.DOWN);
        scene.idle(5);

        scene.overlay().showText(120)
                .text("Its structure is made out of Turbine Casings and can range from sizes 5x5x5 up to 17x18x17 with an odd diameter.");


        scene.idle(100);

        AABB tankBounds = new AABB(1, 1, 1, 6, 9 ,6);
        Object tankOutline = new Object();

        scene.overlay().chaseBoundingBoxOutline(PonderPalette.BLUE, tankOutline,
                tankBounds, 15);
        scene.idle(15);

        for (int i = 0; i < 3; i++) {
            int expand = (i + 1) * 2;
            scene.overlay().chaseBoundingBoxOutline(PonderPalette.BLUE, tankOutline,
                    tankBounds.expandTowards(expand, expand, expand), 12);

            scene.idle(12);
        }
        scene.idle(20);
        scene.addKeyframe();
        scene.idle(30);

        scene.overlay().showOutlineWithText(innerFrame, 120)
                .text("Inner sections of the structure can be replaced with Structural Glass or Turbine Valves.");

        scene.idle(110);
        scene.world().replaceBlocks(innerFrame, MekanismBlocks.STRUCTURAL_GLASS.defaultState(), true);
        scene.idle(20);
        scene.world().replaceBlocks(util.select().position(3, 2, 1), GeneratorsBlocks.TURBINE_VALVE.defaultState(), true);

        scene.idle(40);

        scene.world().hideSection(turbineSlice, Direction.UP);
        scene.idle(40);

        scene.overlay().showText(160)
                .text("The Turbine requires Turbine Rotors in the center column of the Structure, with a Rotational Complex on top of it.");

        scene.idle(140);

        scene.world().showSection(util.select().fromTo(3, 2, 3, 3, 5, 3), Direction.DOWN);

        scene.idle(20);

        scene.world().showSection(util.select().position(3, 6, 3), Direction.DOWN);

        scene.idle(40);

        scene.overlay().showText(200)
                .text("Turbine Blades are needed on the Turbine Rotors, which are applied by right-clicking, but cannot exceed the the interior width of the structure.");

        scene.idle(180);

        scene.overlay().showControls(util.vector().blockSurface(util.grid().at(3, 3, 3), Direction.UP), Pointing.LEFT, 60)
                .rightClick()
                .withItem(GeneratorsItems.TURBINE_BLADE.getItemStack());

        scene.idle(80);

        scene.overlay().showText(140)
                .text("The inner layer of the Rotational Complex must be filled with Pressure Dispersers.");

        scene.idle(120);

        scene.world().showSection(util.select().fromTo(2, 6, 2, 4, 6, 4).substract(util.select().position(3, 6, 3)), Direction.DOWN);

        scene.idle(60);

        scene.overlay().showText(220)
                .text("Electromagnetic Coils need to be placed on top of the Rotational complex and must connect to eachother.\n\nEach coil allows for 4 Turbine Blades to be added to the Turbine.");

        scene.idle(200);
        scene.world().showSection(util.select().fromTo(4, 7, 3, 3, 7, 3), Direction.DOWN);
        scene.idle(40);

        scene.overlay().showText(140)
                .text("Optionally, Saturating Condensers can be added to recycle the processed Steam back into water.");
        scene.idle(120);

        scene.world().showSection(util.select().fromTo(2, 7, 2, 4, 7, 4).substract(util.select().fromTo(4, 7, 3, 3, 7, 3)), Direction.DOWN);
        scene.idle(60);
        scene.world().showSection(turbineSlice, Direction.DOWN);

        scene.idle(40);
        scene.addKeyframe();
        scene.idle(40);

        Selection topInnerLayers = util.select().fromTo(4, 6, 1, 2, 7, 1).add(util.select().fromTo(1, 6, 2, 1, 7, 4));

        scene.overlay().showOutlineWithText(topInnerLayers.add(util.select().fromTo(2, 8, 2, 4, 8, 4)), 160)
                .text("The inner structure starting from the Rotational Complex layer can be replaced with Turbine Vents, allowing for higher Flow Rate.");

        scene.idle(140);

        scene.world().setBlocks(topInnerLayers, GeneratorsBlocks.TURBINE_VENT.defaultState(), true);
        scene.idle(20);
        scene.world().setBlocks(util.select().fromTo(2, 8, 2, 4, 8, 4), GeneratorsBlocks.TURBINE_VENT.defaultState(), true);
        scene.idle(60);

        scene.overlay().showText(120)
                .text("Once properly built, it will emit Redstone Particles to indicate its completion.");

        scene.idle(100);

        SceneUtil.multiBlockFormParticles(scene, util.grid().at(1, 1, 1), util.grid().at(5, 8, 5),  6);
        scene.idle(60);
    }

    public static void runningTurbine(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title(MekGensPonderScenes.RUNNING_TURBINE.getPath(), "Running an Industrial Turbine");
        scene.showBasePlate();
        scene.scaleSceneView(0.8F);

        Selection turbine = util.select().fromTo(1, 1, 1, 5, 8 ,5);


        scene.idle(10);
        scene.world().showSection(turbine, Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(80)
                .colored(PonderPalette.BLUE)
                .text("The Industrial Turbine requires Steam to produce energy.");

        scene.idle(100);


        scene.overlay().showOutlineWithText(util.select().position(3, 2, 1).add(util.select().position(1, 2, 3)), 120)
                .text("Steam can be provided through Turbine Valves, while Energy can be extracted from them.");

        scene.idle(100);

        scene.world().showSection(util.select().position(3, 2, 0), Direction.DOWN);
        scene.idle(10);
        scene.world().showSection(util.select().position(0, 2, 3), Direction.DOWN);
        scene.idle(10);

        scene.overlay().showControls(util.vector().centerOf(3, 2, 0), Pointing.RIGHT, 80)
                .showing(new ChemicalPonderRender(new ChemicalStack(MekanismChemicals.STEAM, 1000)));

        scene.idle(100);

        scene.world().hideSection(util.select().position(3, 2, 0), Direction.UP);
        scene.idle(10);
        scene.world().hideSection(util.select().position(0, 2, 3), Direction.UP);
        scene.idle(30);

        scene.addKeyframe();

        scene.idle(20);

        scene.world().hideSection(util.select().layer(8), Direction.UP);
        scene.idle(20);
        scene.overlay().showOutlineWithText(util.select().fromTo(2, 7, 2, 4, 7, 4).substract(util.select().fromTo(4, 7, 3, 3, 7, 3)), 120)
                .colored(PonderPalette.BLUE)
                .text("If Saturating Condensers are used, Water can be extracted through the Turbine Vents");

        scene.idle(140);
        scene.world().showSection(util.select().layer(8), Direction.DOWN);
        scene.idle(10);

        scene.world().showSection(util.select().position(3, 9, 3), Direction.DOWN);

        scene.idle(60);
        scene.world().hideSection(util.select().position(3, 9, 3), Direction.UP);
        scene.idle(30);
        scene.addKeyframe();
        scene.idle(20);

        scene.overlay().showText(100)
                .colored(PonderPalette.BLUE)
                .text("Right clicking the Industrial Turbine opens its UI, displaying a variety of statistics.");
        scene.idle(80);

        scene.overlay().showControls(util.vector().topOf(5, 3, 1), Pointing.RIGHT, 60)
                .rightClick();

        scene.idle(80);

        scene.overlay().showText(220)
                .text("The main menu shows:\n- The internal steam tank\n- Energy production\n- The amount of Steam inserted every tick\n- Its total Steam capacity\n- and its maximum steam processing rate.");

        scene.idle(240);

        scene.overlay().showText(120)
                .colored(PonderPalette.BLUE)
                .text("In addition to that, it has a button allowing you to dump either excess Steam, or all Steam inserted into the Turbine.");

        scene.idle(140);
        scene.overlay().showText(80)
                .colored(PonderPalette.RED)
                .text("While dumping steam, Water will not be recycled.");

        scene.idle(100);

        scene.addKeyframe();

        scene.idle(30);
        scene.overlay().showText(120)
                .colored(PonderPalette.BLUE)
                .text("The Turbine statistics menu shows the maximum energy production, water output and structure statistics.");

        scene.idle(140);

        scene.overlay().showText(100)
                .text("Furthermore, it shows which parts of the turbine are currently a limiting factor.");

        scene.idle(100);
    }
}
