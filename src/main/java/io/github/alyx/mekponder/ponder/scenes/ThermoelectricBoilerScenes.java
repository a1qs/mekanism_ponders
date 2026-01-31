package io.github.alyx.mekponder.ponder.scenes;

import io.github.alyx.mekponder.ponder.MekPonderScenes;
import io.github.alyx.mekponder.ponder.element.ChemicalPonderRender;
import io.github.alyx.mekponder.util.SceneUtil;
import mekanism.api.chemical.gas.GasStack;
import mekanism.common.block.attribute.AttributeStateBoilerValveMode;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.registries.MekanismGases;
import mekanism.common.registries.MekanismItems;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;

public class ThermoelectricBoilerScenes {



    public static void creatingBoiler(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title(MekPonderScenes.CREATING_THERMOELECTIC_BOILER.getPath(), "Creating a Thermoelectric Boiler");
        scene.showBasePlate();

        int guiScale = Minecraft.getInstance().options.guiScale().get();
        if (guiScale == 3) {
            scene.scaleSceneView(0.5F);
        } else if(guiScale == 4) {
            scene.scaleSceneView(0.4F);
        } else {
            scene.scaleSceneView(0.75F);
        }


        Selection innerSections = util.select().fromTo(2, 2, 1, 6, 8, 1)
                .add(util.select().fromTo(1, 2, 2, 1, 8, 6))
                .add(util.select().fromTo(2, 9, 2, 6, 9, 6))
                .add(util.select().fromTo(2, 2, 7, 6, 8, 7))
                .add(util.select().fromTo(7, 2, 2, 7, 8, 6));

        Selection boilerSlice = util.select().fromTo(1, 2, 1, 6, 9, 6);

        Selection superheatingElements = util.select().fromTo(2, 2, 2, 6, 2, 6).substract(util.select().fromTo(5, 2, 3, 3, 1, 5));
        Selection pressureDispersers = util.select().fromTo(6, 6, 2, 2, 6, 6);

        Selection upperLayer = util.select().fromTo(6, 7, 2, 2, 8, 6);



        scene.idle(10);

        scene.world().showSection(util.select().fromTo(1, 1, 1, 7, 1, 7), Direction.DOWN);

        scene.overlay().showText(100)
                .text("The Thermoelectric Boiler is a multiblock capable of producing large amounts of steam.");

        scene.idle(120);

        scene.overlay().showText(140)
                .text("It can be used to boil water into steam, or cool superheated sodium back down to sodium, using water and producing steam in the process.");

        scene.idle(160);

        scene.overlay().showText(80)
                .text("Its structure is made out of Boiler Casings.");

        scene.idle(80);

        scene.world().showSection(util.select().fromTo(1, 2, 7, 7, 8, 7), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(7, 2, 1, 7, 8, 6), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(6, 2, 1, 1, 8, 1), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(1, 2, 2, 1, 8, 6), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(1, 9, 1, 7, 9, 7), Direction.DOWN);
        scene.idle(30);


        scene.overlay().showText(80)
                .text("Its structure can range from 3x4x3 up to 18x18x18.");

        scene.idle(60);


        AABB tankBounds = new AABB(1, 1, 1, 8, 10 , 8);
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



        scene.overlay().showOutlineWithText(innerSections, 120)
                .colored(PonderPalette.BLUE)
                .text("Inner sections can be replaced with Structural Glass, Reactor Glass, or Boiler Valves");

        scene.idle(100);



        scene.world().replaceBlocks(innerSections, MekanismBlocks.STRUCTURAL_GLASS.getBlock().defaultBlockState(), true);
        scene.idle(20);
        scene.world().replaceBlocks(
                util.select().position(6, 9, 2).add(util.select().position(6, 9, 4)).add(util.select().position(6, 9, 6)),
                MekanismBlocks.BOILER_VALVE.getBlock().defaultBlockState(),
                true
        );

        scene.idle(40);

        scene.addKeyframe();

        scene.idle(20);

        scene.world().hideSection(boilerSlice, Direction.UP);

        scene.idle(20);

        scene.overlay().showText(200)
                .colored(PonderPalette.OUTPUT)
                .text("Each Boiler requires Superheating Elements in its inner bottom layer section. All Superheating elements must be connected to eachother.\n\nEach layer adds to the total Water capacity.");

        scene.idle(180);


        scene.overlay().showOutline(PonderPalette.BLUE, new Object(), superheatingElements, 60);

        scene.idle(20);

        scene.world().setBlocks(superheatingElements, MekanismBlocks.SUPERHEATING_ELEMENT.getBlock().defaultBlockState(), true);
        scene.world().showSection(superheatingElements, Direction.DOWN);

        scene.idle(50);

        scene.overlay().showText(140)
                .colored(PonderPalette.INPUT)
                .text("The layer with the Superheating Elements must be seperated by a layer made out of Pressure Dispersers.");

        scene.idle(120);

        scene.overlay().showOutline(PonderPalette.BLUE, new Object(), pressureDispersers, 60);

        scene.idle(20);
        scene.world().setBlocks(pressureDispersers, MekanismBlocks.PRESSURE_DISPERSER.getBlock().defaultBlockState(), true);
        scene.world().showSection(pressureDispersers, Direction.DOWN);

        scene.idle(50);


        scene.overlay().showOutlineWithText(upperLayer, 140)
                .colored(PonderPalette.BLUE)
                .text("Above the layer of Pressure dispersers, you can leave additional layers to increase the capacity of the Steam layer.");

        scene.idle(160);

        scene.world().showSection(boilerSlice, Direction.DOWN);

        scene.idle(20);



        scene.overlay().showText(120)
                .text("Once constructed, the Multiblock will emit Redstone particles to indicate its completion.");

        scene.idle(100);

        SceneUtil.multiBlockFormParticles(scene, util.grid().at(1, 1, 1), util.grid().at(7, 9, 7),  6);

        scene.idle(40);
        scene.addKeyframe();
        scene.idle(20);

        scene.overlay().showText(160)
                .text("Right clicking the Boiler anywhere opens its UI, allowing you to view its internal tanks and information about its status.");
        scene.idle(140);

        scene.overlay().showControls(util.vector().topOf(4, 2, 1), Pointing.RIGHT, 60)
                .rightClick();
        scene.idle(80);

        scene.overlay().showText(160)
                .colored(PonderPalette.OUTPUT)
                .text("The Boiler statistics screen shows various information about the Thermoelectric Boiler, including its Boil Capacity.");

        scene.idle(200);
        scene.addKeyframe();
        scene.idle(20);

        scene.overlay().showText(160)
                .text("Boiler Valves have 3 different configurations, which can be switched by using a Configurator on the Boiler Valve.");
        scene.idle(140);

        scene.overlay().showControls(util.vector().blockSurface(util.grid().at(6, 9, 4), Direction.WEST), Pointing.LEFT, 60)
                .rightClick()
                .whileSneaking()
                .withItem(new ItemStack(MekanismItems.CONFIGURATOR.asItem(), 1));

        scene.idle(20);

        SceneUtil.loopBlockProperty(scene, util.grid().at(6, 9, 4), AttributeStateBoilerValveMode.modeProperty, 4, 12);
        SceneUtil.loopBlockProperty(scene, util.grid().at(6, 9, 6), AttributeStateBoilerValveMode.modeProperty, 2, 12);

        scene.idle(30);

        scene.overlay().showOutlineWithText(util.select().position(6, 9, 2), 120)
                .colored(PonderPalette.INPUT)
                .text("1. Input Only\n\nThe Valve will only accept fluids, chemicals and heat.");

        scene.idle(100);

        scene.world().showSection(util.select().position(6, 10, 2), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showControls(util.vector().centerOf(6, 10, 2), Pointing.RIGHT, 50)
                .showing(new ChemicalPonderRender(new GasStack(MekanismGases.SUPERHEATED_SODIUM, 1000)));


        scene.idle(90);

        scene.overlay().showOutlineWithText(util.select().position(6, 9, 4), 100)
                .colored(PonderPalette.OUTPUT)
                .text("2. Output Steam\n\nThe Valve will only output Steam.");

        scene.idle(80);

        scene.world().showSection(util.select().position(6, 10, 4), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showControls(util.vector().centerOf(6, 10, 4), Pointing.RIGHT, 50)
                .showing(new ChemicalPonderRender(new GasStack(MekanismGases.STEAM, 1000)));

        scene.idle(90);


        scene.overlay().showOutlineWithText(util.select().position(6, 9, 6), 140)
                .colored(PonderPalette.MEDIUM)
                .text("3. Output Coolant\n\nThe valve will only output Coolant stored in its internal tank.");

        scene.idle(120);
        scene.world().showSection(util.select().position(6, 10, 6), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showControls(util.vector().centerOf(6, 10, 6), Pointing.RIGHT, 50)
                .showing(new ChemicalPonderRender(new GasStack(MekanismGases.SODIUM, 1000)));

        scene.idle(90);
    }
}
