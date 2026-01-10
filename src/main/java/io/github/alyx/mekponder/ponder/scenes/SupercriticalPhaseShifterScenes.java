package io.github.alyx.mekponder.ponder.scenes;

import io.github.alyx.mekponder.mixin.AccessorAttributeStateActive;
import io.github.alyx.mekponder.ponder.MekPonderScenes;
import io.github.alyx.mekponder.ponder.element.ChemicalPonderRender;
import io.github.alyx.mekponder.util.SceneUtil;
import mekanism.api.MekanismAPITags;
import mekanism.api.chemical.ChemicalStack;
import mekanism.client.render.MekanismRenderer;
import mekanism.common.block.attribute.Attributes;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.registries.MekanismChemicals;
import mekanism.common.registries.MekanismItems;
import net.createmod.catnip.gui.element.ScreenElement;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;

public class SupercriticalPhaseShifterScenes {


    // RenderSPS
    public static void creatingSPS(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title(MekPonderScenes.CREATING_SPS.getPath(), "Creating a Supercritical Phase Shifter");
        scene.showBasePlate();
        scene.scaleSceneView(0.8F);


        Selection bottomLayer = util.select().fromTo(5, 1 ,1, 3, 1, 7)
                .add(util.select().fromTo(7, 1, 5, 1, 1, 3))
                .add(util.select().position(6, 1, 2))
                .add(util.select().position(6, 1, 6))
                .add(util.select().position(2, 1, 6))
                .add(util.select().position(2, 1, 2));

        Selection ports = util.select().position(4, 4, 1)
                .add(util.select().position(5, 2, 1))
                .add(util.select().position(3, 2, 1))
                .add(util.select().position(1, 4, 4));

        Selection glass = util.select().fromTo(5, 6, 1, 3, 2, 1).add(util.select().fromTo(6, 5, 1, 2, 3, 1));

        scene.world().replaceBlocks(ports, MekanismBlocks.STRUCTURAL_GLASS.defaultState(), false); // place back later



        scene.idle(5);
        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(15);

        scene.overlay().showText(140)
                .text("The Supercritical Phase Shifter is a multiblock capable of converting Polonium into Antimatter by using large amounts of energy.");

        scene.idle(160);



        scene.overlay().showOutlineWithText(bottomLayer, 120)
                .colored(PonderPalette.BLUE)
                .text("Each side of the SPS is built in the same spherical way, with a fixed size of 7x7x7.");

        scene.idle(130);

        scene.world().showSection(util.select().fromTo(1, 2, 7, 7, 7,7), Direction.DOWN); //SOUTH
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(7, 2, 6, 7, 7, 1), Direction.DOWN); //EAST
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(6, 2, 1, 1, 7, 1), Direction.DOWN); //NORTH
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(1, 2, 2, 1, 7, 6), Direction.DOWN); //WEST

        scene.idle(20);

        scene.overlay().showText(120)
                .colored(PonderPalette.BLUE)
                .text("Inner sections of the SPS can be replaced with Structural Glass, Reactor Glass, or SPS Ports.");

        scene.idle(100);
        scene.overlay().showOutline(PonderPalette.BLUE, new Object(), glass, 60);
        scene.idle(65);

        scene.world().setBlocks(ports, MekanismBlocks.SPS_PORT.defaultState(), true);

        scene.idle(30);

        scene.overlay().showText(100)
                .colored(PonderPalette.BLUE)
                .text("Once completed, the Multiblock will emit Redstone Particles to indicate its completion.");

        scene.idle(80);

        scene.world().showSection(util.select().fromTo(6, 7, 2, 2, 7, 6), Direction.DOWN);
        scene.idle(20);
        SceneUtil.multiBlockFormParticles(scene, util.grid().at(1, 1, 1), util.grid().at(7, 7, 7), 6);
        scene.idle(40);

        scene.addKeyframe();

        scene.idle(30);
        scene.rotateCameraY(-80);
        scene.idle(35);

        scene.world().hideSection(util.select().fromTo(1, 2, 2, 1, 7, 6), Direction.UP); // WEST;
        scene.world().hideSection(util.select().fromTo(6, 7, 2, 2, 7, 6), Direction.UP); // TOP

        scene.idle(30);
        scene.overlay().showText(200)
                .colored(PonderPalette.BLUE)
                .text("To process Polonium, the SPS requires a Port placed in the center of one side, and on the inside of the reactor to have a Supercharged Coil placed on the Port.");

        scene.idle(190);

        scene.world().showSection(util.select().position(4, 4, 2), Direction.DOWN);

        scene.idle(40);

        scene.overlay().showText(180)
                .text("Each Port can accept up to 400MFE/t, which can produce 1mb of Antimatter per tick,\nwith the SPS being capped at producing 2mB of Antimatter per tick.");

        scene.idle(200);

        scene.overlay().showText(160)
                .colored(PonderPalette.RED)
                .text("The SPS will still use all the energy provided to it even if it doesnt have the required polonium to process antimatter at the highest speed.");

        scene.idle(180);
        scene.rotateCameraY(80);

        scene.idle(40);
        scene.world().showSection(util.select().fromTo(1, 2, 2, 1, 7, 6).add(util.select().position(2, 4, 4)), Direction.DOWN); //WEST
        scene.world().showSection(util.select().fromTo(6, 7, 2, 2, 7, 6), Direction.DOWN); // TOP

        scene.idle(35);

        scene.addKeyframe();

        scene.idle(20);

        scene.overlay().showOutlineWithText(ports, 100)
                .colored(PonderPalette.BLUE)
                .text("SPS Ports can be used to insert Energy and Polonium into the SPS.");

        scene.idle(80);

        scene.world().showSection(util.select().fromTo(0, 1, 0, 8, 7, 0).add(util.select().position(0, 4, 4)).substract(util.select().position(3, 2, 0)),
                Direction.DOWN
        );

        scene.idle(40);

        scene.overlay().showControls(util.vector().centerOf(util.grid().at(5, 2, 0)), Pointing.RIGHT, 40)
                .showing(new ChemicalPonderRender(MekanismChemicals.POLONIUM.getStack(1000)));

        scene.idle(60);

        scene.overlay().showText(100)
                .colored(PonderPalette.OUTPUT)
                .text("To extract Antimatter, the SPS Port mode needs to be switched to Output.");

        scene.idle(80);

        scene.overlay().showControls(util.vector().blockSurface(util.grid().at(3, 2, 1), Direction.WEST), Pointing.LEFT, 60)
                .rightClick()
                .whileSneaking()
                .withItem(MekanismItems.CONFIGURATOR.getItemStack());

        scene.idle(10);

        SceneUtil.loopBlockProperty(scene, util.grid().at(3, 2, 1), ((AccessorAttributeStateActive) Attributes.ACTIVE).mekanism_ponder$getActiveProperty(), 3, 12);

        scene.idle(20);

        scene.world().showSection(util.select().position(3, 2, 0), Direction.DOWN);

        scene.idle(40);

        scene.overlay().showOutlineWithText(util.select().fromTo(1, 1, 1, 7, 7, 7), 200)
                .colored(PonderPalette.BLUE)
                .text("By right clicking anywhere on the SPS, you can open the UI for it and see: \n- the Status of the SPS\n- the Energy Input,\n- the Process Rate,\n- the Progress,\n- as well as its 2 internal tanks for Polonium and Antimatter.");

        scene.idle(180);

        scene.overlay().showControls(util.vector().centerOf(1, 4, 1), Pointing.RIGHT, 40)
                .rightClick();

        scene.idle(60);
    }




    /*
     *
     *
     *
     * By right clicking anywhere on the SPS, you can open the UI for it and see the Status of the SPS, the Energy Input, the Process Rate, the Progress, as well as its 2 internal tanks for
     * Polonium and Antimatter
     */
}
