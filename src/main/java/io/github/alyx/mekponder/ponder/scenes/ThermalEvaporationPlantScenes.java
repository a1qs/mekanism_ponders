package io.github.alyx.mekponder.ponder.scenes;

import io.github.alyx.mekponder.MekanismPonders;
import io.github.alyx.mekponder.mixin.AccessorAttributeStateActive;
import io.github.alyx.mekponder.ponder.MekPonderScenes;
import io.github.alyx.mekponder.util.SceneUtil;
import mekanism.common.block.attribute.Attributes;
import mekanism.common.registries.MekanismBlocks;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;

public class ThermalEvaporationPlantScenes {




    // TODO: mixin into RenderThermalEvaporationPlant to render Water
    public static void creatingThermalEvaporationPlant(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title(MekPonderScenes.CREATING_THERMAL_EVAPORATION_PLANT.getPath(), "Creating a Thermal Evaporation Plant");
        scene.showBasePlate();

        Selection moreTEP = util.select().fromTo(4, 4, 1, 1, 5, 4).substract(util.select().fromTo(3, 4 , 2, 2, 5, 3));



        scene.world().setBlock(util.grid().at(2, 2, 1), MekanismBlocks.THERMAL_EVAPORATION_BLOCK.defaultState(), false);

        scene.idle(10);
        scene.rotateCameraY(-30);
        scene.world().showSection(util.select().fromTo(1, 1, 1, 4, 3, 4), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(100)
                .text("The Thermal Evaporation Plant is a Multiblock capable of converting §6Water into Brine§r and §6Brine into§r §6Lithium§r.");

        scene.idle(120);

        scene.overlay().showText(80)
                .colored(PonderPalette.BLUE)
                .text("Its size can range from 4x3x4, up to 4x18x4");

        scene.idle(20);


        AABB plantBounds = new AABB(1, 1, 1, 5, 4 ,5);
        Object plantOutline = new Object();

        scene.overlay().chaseBoundingBoxOutline(PonderPalette.BLUE, plantOutline,
                plantBounds, 15);
        scene.idle(15);


        for (int i = 0; i < 3; i++) {
            scene.overlay().chaseBoundingBoxOutline(PonderPalette.BLUE, plantOutline,
                    plantBounds.expandTowards(0, (i + 1) * 2, 0), 12);

            scene.idle(12);
        }

        scene.idle(30);

        scene.addKeyframe();
        scene.idle(20);

        scene.overlay().showText(120)
                .text("Inner sections of the Multiblock can be replaced with §6Thermal§r §6Evaporation Valves§r and §6Structural§r §6Glass§r.");

        scene.idle(100);
        scene.world().setBlock(util.grid().at(1, 2, 3), MekanismBlocks.STRUCTURAL_GLASS.defaultState(), true);
        scene.idle(10);
        scene.world().replaceBlocks(util.select().fromTo(3, 2, 1, 2, 2, 1), MekanismBlocks.THERMAL_EVAPORATION_VALVE.defaultState(), true);

        scene.idle(30);
        scene.overlay().showText(120)
                .pointAt(util.vector().of(1.5, 2.5, 2.5))
                .colored(PonderPalette.BLUE)
                .text("Each Thermal Evaporation Plant requires a Thermal Evaporation Controller placed in its inner section.");
        scene.idle(135);

        scene.overlay().showText(100)
                .text("Once constructed, the Multiblock will emit Redstone particles to indicate its completion.");
        scene.idle(90);

        SceneUtil.multiBlockFormParticles(scene, util.grid().at(1, 1, 1), util.grid().at(4, 3, 4), 6);

        scene.idle(60);

        scene.addKeyframe();
        scene.idle(10);

        scene.overlay().showText(130)
                .text("The Thermal Evaporation Plant requires §6heat§r to function, with more heat also §6increasing the§r §6processing speed§r.");

        scene.idle(145);

        scene.world().showSection(util.select().fromTo(4, 2, 0, 3, 2, 0), Direction.DOWN);

        scene.idle(15);

        scene.world().cycleBlockProperty(util.grid().at(3, 2, 0), ((AccessorAttributeStateActive) Attributes.ACTIVE).mekanism_ponder$getActiveProperty());

        scene.overlay().showText(100)
                .pointAt(util.vector().of(3.5, 2.5, 0.5))
                .text("Heat can be supplied through external means by using Thermal Evaporation Valves.");

        scene.idle(115);


        if (MekanismPonders.isMekGensLoaded) {
            MiscGeneratorScenes.solarPanelsThermalEvaporationPlant(scene, util);
        }

        scene.world().setBlocks(moreTEP, MekanismBlocks.THERMAL_EVAPORATION_BLOCK.defaultState(), false);
        scene.overlay().showText(140)
                .text("The §6higher§r the Multiblock, the larger the §6capacity of internal§r §6tanks§r and §6maximum processing§r §6speed§r.\nIn addition to that, the heat required also rises.");


        scene.idle(110);

        scene.world().showSection(moreTEP, Direction.DOWN);

        scene.idle(40);

        scene.world().hideSection(moreTEP, Direction.UP);

        scene.idle(30);
        scene.addKeyframe();
        scene.idle(5);
        scene.rotateCameraY(30);
        scene.idle(10);

        scene.overlay().showOutlineWithText(util.select().position(2, 2, 1), 100)
                .colored(PonderPalette.INPUT)
                .text("To insert fluid, any fluid transmitter can be connected to the Thermal Evaporation Valve.");

        scene.idle(90);

        scene.world().showSection(util.select().fromTo(2, 1, 0, 2, 2, 0), Direction.DOWN);

        scene.idle(40);

        scene.overlay().showText( 100)
                .colored(PonderPalette.OUTPUT)
                .text("To extract Fluids, the fluid transmitter must be set to pull from the Thermal Evaporation Valve.");

        scene.idle(130);
        scene.rotateCameraY(-30);
        scene.idle(10);

        scene.overlay().showText( 180)
                .text("Right Clicking the controller opens an UI providing information about:\n\n- whether the structure is §6formed§r\n- the §6height§r\n- the §6temperature§r\n- and the §6production rate§r in ticks.");


        scene.idle(165);
        scene.overlay().showOutline(PonderPalette.BLUE, new Object(), util.select().position(1, 2, 2), 60);
        scene.overlay().showControls(util.vector().blockSurface(util.grid().at(1, 2, 2), Direction.WEST), Pointing.RIGHT, 60).rightClick();

        scene.idle(75);

        scene.overlay().showText( 160)
                .colored(PonderPalette.BLUE)
                .text("In addition to that, it provides slots to insert Fluid Handling items such as buckets or tanks, in order to extract from the internal fluid tanks.");

        scene.idle(170);
    }
}
