package io.github.alyx.mekponder.ponder.scenes;


import mekanism.common.registries.MekanismBlocks;
import mekanism.generators.common.registries.GeneratorsBlocks;
import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.minecraft.core.Direction;

/**
 *  Can only load things from MekGens if the mod is loaded, so we have this class to only load if the mod is installed, adding extra bits and bobs for
 *  certain scenes
 */
public class MiscGeneratorScenes {

    public static void solarPanelsThermalEvaporationPlant(SceneBuilder scene, SceneBuildingUtil util) {
        Selection solarPanels = util.select().position(1, 3, 1)
                .add(util.select().position(4, 3, 1))
                .add(util.select().position(1, 3, 4))
                .add(util.select().position(4, 3, 4));

        scene.world().hideSection(solarPanels, Direction.UP);
        scene.idle(15);

        scene.world().replaceBlocks(solarPanels, GeneratorsBlocks.ADVANCED_SOLAR_GENERATOR.defaultState(), false);

        scene.idle(5);
        scene.world().showSection(solarPanels, Direction.DOWN);

        scene.idle(5);
        scene.overlay().showOutlineWithText(solarPanels, 120)
                .colored(PonderPalette.BLUE)
                .text("Optionally, Advanced Solar Generators can be used to increase the heat when they are able to generate energy.");

        scene.idle(125);
        scene.world().hideSection(solarPanels, Direction.UP);
        scene.idle(15);
        scene.world().replaceBlocks(solarPanels, MekanismBlocks.THERMAL_EVAPORATION_BLOCK.defaultState(), false);
        scene.idle(5);
        scene.world().showSection(solarPanels, Direction.DOWN);
        scene.idle(30);
    }
}
