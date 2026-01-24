package io.github.alyx.mekponder.ponder.generators.scenes;

import io.github.alyx.mekponder.ponder.generators.MekGensPonderScenes;
import io.github.alyx.mekponder.ponder.element.ChemicalPonderRender;
import io.github.alyx.mekponder.ponder.element.FluidPonderRender;
import io.github.alyx.mekponder.util.SceneUtil;
import mekanism.api.chemical.ChemicalStack;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.registries.MekanismChemicals;
import mekanism.common.registries.MekanismItems;
import mekanism.generators.common.block.attribute.AttributeStateFissionPortMode;
import mekanism.generators.common.registries.GeneratorsBlocks;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComparatorBlock;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.fluids.FluidStack;

public class FissionReactorScenes {


    public static void creatingFissionReactor(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title(MekGensPonderScenes.CREATING_FISSION_REACTOR.getPath(), "Creating a Fission Reactor");
        scene.showBasePlate();

        scene.idle(10);
        scene.world().showSection(util.select().fromTo(1, 1, 1, 5, 1, 5), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(1, 2, 5, 5, 4, 5), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(5, 4, 4, 5, 2, 1), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(4, 2, 1, 2, 4, 1), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(1, 2, 1, 1, 4, 4), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(1, 5, 1, 5, 5, 5), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(80)
                .text("The Fission Reactor is a multiblock capable of processing Fissile Fuel into Nuclear Waste.");

        scene.idle(100);

        scene.overlay().showText(100)
                .pointAt(util.vector().of(1.5, 3.5, 3.5))
                .colored(PonderPalette.BLUE)
                .text("It's a cuboid structure and can range from 3x4x3 up to 18x18x18,\nand uses Fission Reactor Casings for its frame.");

        scene.idle(90);
        AABB reactorBounds = new AABB(1, 1, 1, 6, 6, 6);
        Object reactorOutline = new Object();

        scene.overlay().chaseBoundingBoxOutline(PonderPalette.BLUE, reactorOutline,
                reactorBounds, 15);
        scene.idle(15);

        for (int i = 0; i < 3; i++) {
            int expand = i + 1;
            scene.overlay().chaseBoundingBoxOutline(PonderPalette.BLUE, reactorOutline,
                    reactorBounds.expandTowards(expand, expand, expand), 12);

            scene.idle(12);
        }

        scene.idle(20);
        scene.addKeyframe();
        scene.idle(20);

        Selection innerSections = util.select().fromTo(2, 2, 1, 4, 4, 1)
                .add(util.select().fromTo(1, 2, 2, 1, 4, 4))
                .add(util.select().fromTo(2, 5, 2, 4, 5, 4));

        scene.overlay().showOutlineWithText(innerSections, 120)
                .colored(PonderPalette.BLUE)
                .text("The inner sections of the frame can be replaced with Reactor Glass, Fission Reactor Ports or Fission Reactor Logic Adapters.");

        scene.idle(140);

        scene.world().replaceBlocks(innerSections, GeneratorsBlocks.REACTOR_GLASS.defaultState(), true);
        scene.idle(10);
        scene.world().replaceBlocks(util.select().fromTo(4, 2, 1, 3, 2, 1), GeneratorsBlocks.FISSION_REACTOR_PORT.defaultState(), true);
        scene.idle(5);
        scene.world().replaceBlocks(util.select().fromTo(1, 2, 3, 1, 2, 4), GeneratorsBlocks.FISSION_REACTOR_PORT.defaultState(), true);
        scene.idle(10);
        scene.world().replaceBlocks(util.select().position(2, 2, 1), GeneratorsBlocks.FISSION_REACTOR_LOGIC_ADAPTER.defaultState(), true);
        scene.world().replaceBlocks(util.select().position(1, 2, 2), GeneratorsBlocks.FISSION_REACTOR_LOGIC_ADAPTER.defaultState(), true);

        scene.idle(50);

        Selection reactorSlice = util.select().fromTo(1, 2, 1, 4, 5, 1)
                .add(util.select().fromTo(1, 2, 2, 1, 5, 4))
                .add(util.select().fromTo(2, 5, 2, 4, 5, 4));
        Selection innerReactor = util.select().fromTo(2, 2, 2, 4, 4, 4);

        scene.addKeyframe(); //RRRRR
        scene.world().hideSection(reactorSlice, Direction.UP);
        scene.world().showSection(innerReactor, Direction.DOWN);


        scene.idle(20);

        scene.rotateCameraY(-30);
        scene.idle(20);

        scene.overlay().showText(180)
                .text("Inside the Reactor, Fission Control Rods need to be added, which are built with one or more Fission Fuel Assemblies and a single Control Rod Assembly on top of them.");

        scene.idle(160);

        scene.world().setBlocks(util.select().fromTo(4, 2, 2, 4, 3, 2), GeneratorsBlocks.FISSION_FUEL_ASSEMBLY.defaultState(), true);
        scene.idle(5);
        scene.world().setBlock(util.grid().at(4, 4, 2), GeneratorsBlocks.CONTROL_ROD_ASSEMBLY.defaultState(), true);
        scene.idle(15);

        scene.world().setBlocks(util.select().fromTo(4, 2, 4, 4, 3, 4), GeneratorsBlocks.FISSION_FUEL_ASSEMBLY.defaultState(), true);
        scene.idle(5);
        scene.world().setBlock(util.grid().at(4, 4, 4), GeneratorsBlocks.CONTROL_ROD_ASSEMBLY.defaultState(), true);
        scene.idle(15);

        scene.idle(25);

        scene.world().setBlocks(util.select().fromTo(4, 2, 3, 4, 3, 3), GeneratorsBlocks.FISSION_FUEL_ASSEMBLY.defaultState(), true);
        scene.idle(5);
        scene.world().setBlock(util.grid().at(4, 4, 3), GeneratorsBlocks.CONTROL_ROD_ASSEMBLY.defaultState(), true);
        scene.idle(15);

        scene.overlay().showOutlineWithText(util.select().fromTo(4, 2, 3, 4, 4, 3), 100)
                .colored(PonderPalette.RED)
                .text("The cooling of the Reactor is penalized if Control Rods touch eachother.");

        scene.idle(120);

        scene.world().hideSection(util.select().fromTo(4, 2, 3, 4, 4, 3), Direction.UP);
        scene.idle(40);
        scene.world().replaceBlocks(util.select().fromTo(4, 2, 3, 4, 4, 3), Blocks.AIR.defaultBlockState(), false);

        scene.idle(20);

        scene.world().showSection(reactorSlice, Direction.DOWN);

        scene.idle(20);

        scene.overlay().showText(120)
                .text("Once fully constructed, it will emit Redstone Particles to indicate its completion.");

        scene.idle(100);

        SceneUtil.multiBlockFormParticles(scene, util.grid().at(1, 1, 1), util.grid().at(5, 5, 5), 6);

        scene.idle(20);
    }

    public static void configuringFissionReactor(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title(MekGensPonderScenes.CONFIGURING_FISSION_REACTOR.getPath(), "Configuring a Fission Reactor");
        scene.showBasePlate();

        Selection reactorPorts = util.select().fromTo(4, 2, 1, 3, 2, 1).add(util.select().fromTo(1, 2, 3, 1, 2, 4));
        Selection reactor = util.select().fromTo(1, 1, 1, 5, 5, 5);
        Selection logicPorts = util.select().position(2, 2, 1).add(util.select().position(1, 2, 2));



        scene.idle(10);
        scene.world().showSection(reactor, Direction.DOWN);
        scene.idle(25);



        scene.overlay().showOutlineWithText(reactorPorts, 80)
                .colored(PonderPalette.BLUE)
                .text("Fission Reactor Ports are used to interact with the Fission Reactor.");

        scene.idle(100);

        scene.overlay().showText(80)
                .text("Fission Reactor Ports have 3 different modes they can switch between.");

        scene.idle(100);

        scene.overlay().showText(100)
                .text("To switch between modes, you can use a Configurator on the port by shift-right-clicking the port.");
        scene.idle(80);

        scene.overlay().showControls(util.vector().blockSurface(util.grid().at(4, 2, 1), Direction.EAST), Pointing.RIGHT, 60)
                .rightClick()
                .whileSneaking()
                .withItem(MekanismItems.CONFIGURATOR.getItemStack());
        scene.idle(40);

        SceneUtil.loopBlockProperty(scene, util.grid().at(4, 2, 1), AttributeStateFissionPortMode.modeProperty, 3, 12);

        scene.idle(10);

        // colored based on port color, ponder why dont you give me my own colors :(
        scene.overlay().showOutlineWithText(util.select().position(4, 2, 1), 100)
                .colored(PonderPalette.GREEN)
                .text("Input Only:\n\nThe port will exclusively accept Fluids and Chemicals.");

        scene.idle(120);
        scene.world().modifyBlock(util.grid().at(3, 2, 1), state -> state.setValue(AttributeStateFissionPortMode.modeProperty, AttributeStateFissionPortMode.FissionPortMode.OUTPUT_WASTE), false);
        scene.overlay().showOutlineWithText(util.select().position(3, 2, 1), 100)
                .colored(PonderPalette.OUTPUT)
                .text("Output Waste:\n\nThe port will exclusively output Nuclear Waste produced by the Reactor.");

        scene.idle(120);
        scene.rotateCameraY(-15);
        scene.idle(20);

        scene.world().modifyBlock(util.grid().at(1, 2, 3), state -> state.setValue(AttributeStateFissionPortMode.modeProperty, AttributeStateFissionPortMode.FissionPortMode.OUTPUT_COOLANT), false);
        scene.overlay().showOutlineWithText(util.select().position(1, 2, 3), 100)
                .colored(PonderPalette.MEDIUM)
                .text("Output Coolant:\n\nThe port will exclusively output Heated Coolant produced by the Reactor.");

        scene.idle(150);

        scene.rotateCameraY(5);
        scene.idle(30);
        scene.addKeyframe();
        scene.idle(20);

        scene.overlay().showOutlineWithText(logicPorts, 200)
                .text("The Fission Reactor Logic Adapter can be used to control the reactor with a Redstone Signal,\nor emit a Redstone Signal based on the Reactor State.\n\nThis can help to create fail-safe mechanisms for the reactor.");

        scene.idle(220);

        scene.world().showSection(util.select().fromTo(2, 1, 0, 2, 2, 0), Direction.DOWN);
        scene.world().showSection(util.select().position(0, 2, 2), Direction.EAST);
        scene.idle(20);


        scene.world().modifyBlock(util.grid().at(2, 2, 0), blockState -> blockState.setValue(ComparatorBlock.POWERED, true), false);
        scene.world().modifyBlock(util.grid().at(0, 2, 2), blockState -> blockState.setValue(LeverBlock.POWERED, true), false);
        scene.idle(10);
        scene.overlay().showOutlineWithText(util.select().position(0, 2, 2), 100)
                .colored(PonderPalette.BLUE)
                .text("Logic Adapter is set to Activation.\n\nThe reactor is now running.");

        scene.idle(120);
        scene.overlay().showOutlineWithText(util.select().position(2, 2, 0), 120)
                .colored(PonderPalette.RED)
                .text("Logic Adapter is set to Insufficient Fuel.\n\nA Redstone signal is being outputted.");

        scene.idle(140);

        scene.world().hideSection(util.select().fromTo(2, 1, 0, 2, 2, 0), Direction.UP);
        scene.world().hideSection(util.select().position(0, 2, 2), Direction.WEST);

        scene.idle(20);
        scene.addKeyframe();
        scene.idle(20);

        scene.overlay().showOutlineWithText(reactor, 120)
                .colored(PonderPalette.BLUE)
                .text("The Fission Reactor has an UI that can be accessed by clicking anywhere on its completed structure.");

        scene.idle(100);

        scene.overlay().showControls(util.vector().blockSurface(util.grid().at(1, 3, 1), Direction.NORTH), Pointing.RIGHT, 40)
                .rightClick();
        scene.idle(60);

        scene.overlay().showText(180)
                .colored(PonderPalette.OUTPUT)
                .text("Within the main tab, you can see:\n- its Status\n- its current configured Burn Rate\n- the Heating Rate\n- the current Temperature\n- and the Damage percentage it has sustained.");

        scene.idle(200);

        scene.overlay().showText(80)
                .text("In addition to that, it has a buttons to activate and deactivate the reactor.");

        scene.idle(100);

        scene.overlay().showText(160)
                .colored(PonderPalette.OUTPUT)
                .text("In the Fission Reactor Statistics tab, you can see:\n- Heat Statistic\n- Fuel Statistics\n- as well as being able to set the Current Burn Rate.");

        scene.idle(180);
    }

    public static void coolingFissionReactor(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title(MekGensPonderScenes.COOLING_FISSION_REACTOR.getPath(), "Cooling a Fission Reactor");
        scene.showBasePlate();


        Selection reactor = util.select().fromTo(1, 1, 1, 5, 5, 5);


        scene.idle(10);
        scene.world().showSection(reactor, Direction.DOWN);

        scene.idle(25);

        scene.overlay().showText(80)
                .text("The Fission Reactor can be cooled in two ways.");

        scene.idle(100);

        scene.overlay().showText(300)
                .colored(PonderPalette.BLUE)
                .text("1. Water cooling\n\nWater cooling the reactor produces steam. The reactor uses 20,000mB/t of Water per mB of Burn Rate.\n\nSteam can be used in a Turbine to gain energy, and can also be used to recycle the steam back into Water using Saturating Condensers.");


        scene.addKeyframe();

        scene.idle(250);

        scene.world().showSection(util.select().position(4, 6, 2), Direction.DOWN);
        scene.idle(10);
        scene.world().showSection(util.select().position(2, 6, 4), Direction.DOWN);

        scene.overlay().showControls(util.vector().centerOf(4, 6, 2), Pointing.RIGHT, 80)
                .showing(new FluidPonderRender(new FluidStack(Fluids.WATER, 1000)));

        scene.idle(5);
        scene.overlay().showControls(util.vector().centerOf(2, 6, 4), Pointing.LEFT, 80)
                .showing(new ChemicalPonderRender(new ChemicalStack(MekanismChemicals.STEAM, 1000)));

        scene.idle(100);

        scene.world().hideSection(util.select().position(2, 6, 4), Direction.UP);
        scene.idle(5);
        scene.world().hideSection(util.select().position(4, 6, 2), Direction.UP);

        scene.idle(25);

        scene.addKeyframe();

        scene.world().setBlock(util.grid().at(4, 6, 2), MekanismBlocks.ULTIMATE_CHEMICAL_TANK.defaultState(), false);

        scene.idle(20);

        scene.overlay().showText(300)
                .colored(PonderPalette.OUTPUT)
                .text("2. Sodium cooling\n\nSodium cooling the reactor produces Superheated Sodium.\nSuperheated Sodium can be used create Steam in a Thermoelectric Boiler, as well returning the heated Sodium to a cooled state, where it can be used as a coolant again.");

        scene.idle(325);
        scene.overlay().showText(240)
                .colored(PonderPalette.OUTPUT)
                .text("This method uses 200.000mB/t of Sodium per mB of Burn Rate, however provides double the cooling capacity that Water provides\n\n This allows the reactor able to handle double the Burn Rate it could with Water.");

        scene.idle(230);

        scene.world().showSection(util.select().position(4, 6, 2), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().position(2, 6, 4), Direction.DOWN);

        scene.overlay().showControls(util.vector().centerOf(4, 6, 2), Pointing.RIGHT, 40)
                .showing(new ChemicalPonderRender(new ChemicalStack(MekanismChemicals.SODIUM, 1000)));

        scene.idle(5);
        scene.overlay().showControls(util.vector().centerOf(2, 6, 4), Pointing.LEFT, 40)
                .showing(new ChemicalPonderRender(new ChemicalStack(MekanismChemicals.SUPERHEATED_SODIUM, 1000)));

        scene.idle(60);
    }

    public static void runningFissionReactor(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title(MekGensPonderScenes.RUNNING_FISSION_REACTOR.getPath(), "Running a Fission Reactor");
        scene.showBasePlate();


        Selection reactor = util.select().fromTo(1, 1, 1, 5, 5, 5);


        scene.idle(10);
        scene.world().showSection(reactor, Direction.DOWN);

        scene.idle(30);

        scene.overlay().showText(160)
                .colored(PonderPalette.BLUE)
                .text("By providing Fission Fuel, the reactor can be activated, and will produce Nuclear Waste every tick correlating to the Burn Rate set for the Reactor.");

        scene.idle(140);

        scene.world().showSection(util.select().position(4, 6, 2), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().position(2, 6, 4), Direction.DOWN);

        scene.idle(20);

        scene.overlay().showControls(util.vector().centerOf(4, 6, 2), Pointing.RIGHT, 40)
                .showing(new ChemicalPonderRender(new ChemicalStack(MekanismChemicals.FISSILE_FUEL, 1000)));

        scene.idle(5);
        scene.overlay().showControls(util.vector().centerOf(2, 6, 4), Pointing.LEFT, 40)
                .showing(new ChemicalPonderRender(new ChemicalStack(MekanismChemicals.NUCLEAR_WASTE, 1000)));

        scene.idle(60);

        scene.addKeyframe();
        scene.idle(20);

        scene.overlay().showText(200)
                .pointAt(util.vector().of(2.5, 6, 4.5))
                .colored(PonderPalette.OUTPUT)
                .text("Nuclear Waste is radioactive, meaning that it cannot be stored in normal Chemical Tanks.\nRadioactive Waste Barrels can be used, which will dissapate the waste stored.");

        scene.idle(220);
        scene.addKeyframe();
        scene.idle(20);


        scene.overlay().showText(180)
                .colored(PonderPalette.BLUE)
                .text("While running, the reactor produces heat and can consume Coolant to cool itself down, producing Steam or Superheated Sodium in the process.");

        scene.idle(200);

        scene.overlay().showText(140)
                .colored(PonderPalette.OUTPUT)
                .text("If the temperature reaches levels beyond 1200K the reactor will increase its damage percentage.");

        scene.idle(160);

        scene.overlay().showText(140)
                .colored(PonderPalette.RED)
                .text("Once it's beyond 100%, each tick has a chance that the reactor will explode, while it is above 100%.");

        scene.idle(160);

    }
}
