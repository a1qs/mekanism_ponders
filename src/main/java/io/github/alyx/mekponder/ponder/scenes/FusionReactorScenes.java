package io.github.alyx.mekponder.ponder.scenes;


import io.github.alyx.mekponder.mixin.AccessorAttributeStateActive;
import io.github.alyx.mekponder.ponder.MekPonderScenes;
import io.github.alyx.mekponder.util.SceneUtil;
import mekanism.common.block.attribute.AttributeStateActive;
import mekanism.common.block.attribute.Attributes;
import mekanism.common.particle.LaserParticleData;
import mekanism.common.registries.MekanismItems;
import mekanism.common.util.ChemicalUtil;
import mekanism.generators.common.registries.GeneratorsBlocks;
import mekanism.generators.common.registries.GeneratorsChemicals;
import mekanism.generators.common.registries.GeneratorsFluids;
import mekanism.generators.common.registries.GeneratorsItems;
import mekanism.generators.common.tile.fusion.TileEntityFusionReactorController;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.ParticleEmitter;
import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FusionReactorScenes {
    public static void constructingReactor(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title(MekPonderScenes.CONSTRUCTING_FUSION_REACTOR.getPath(), "Constructing a Fusion Reactor");
        scene.showBasePlate();
        scene.idle(10);
        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(20);


        Selection basePlate = util.select().fromTo(2, 1, 2, 4, 1, 4)
                .add(util.select().position(3, 1, 1))
                .add(util.select().position(1, 1, 3))
                .add(util.select().position(5, 1, 3))
                .add(util.select().position(3, 1, 5));


        scene.overlay().showOutlineWithText(basePlate, 60)
                .colored(PonderPalette.BLUE)
                .text("This is the basis of a Fusion Reactor.\nIt's made out of Fusion Reactor Frames.");

        scene.idle(80);

        scene.world().showSection(util.select().fromTo(5, 6, 5, 0, 2, 5), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(5, 6, 5, 5, 2, 0), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(4, 6, 1, 1, 2, 1), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(1, 6, 4, 1, 2, 2), Direction.DOWN);
        scene.idle(5);

        scene.overlay().showText(60)
                .colored(PonderPalette.WHITE)
                .text("Each reactor side is built the same way.");

        scene.idle(80);

        scene.addKeyframe();

        scene.overlay().showText(120)
                .independent(0)
                .colored(PonderPalette.WHITE)
                .text("Inner sections can be replaced with other blocks, such as:\n\n- Fusion Reactor Ports\n- Fusion Logic Ports\n- Reactor Glass\n- Laser Focus Matrix");


        // Replacing with Ports 1
        scene.idle(5);
        scene.world().destroyBlock(util.grid().at(2, 3, 1));
        scene.world().destroyBlock(util.grid().at(3, 2, 1));
        scene.world().destroyBlock(util.grid().at(3, 3, 1));
        scene.world().destroyBlock(util.grid().at(3, 4, 1));
        scene.world().destroyBlock(util.grid().at(4, 3, 1));

        scene.idle(10);

        scene.world().setBlock(util.grid().at(2, 3, 1), GeneratorsBlocks.FUSION_REACTOR_PORT.defaultState(), true);
        scene.world().setBlock(util.grid().at(4, 3, 1), GeneratorsBlocks.FUSION_REACTOR_PORT.defaultState(), true);
        scene.idle(5);
        scene.world().setBlock(util.grid().at(3, 2, 1), GeneratorsBlocks.REACTOR_GLASS.defaultState(), true);
        scene.world().setBlock(util.grid().at(3, 3, 1), GeneratorsBlocks.REACTOR_GLASS.defaultState(), true);
        scene.world().setBlock(util.grid().at(3, 4, 1), GeneratorsBlocks.REACTOR_GLASS.defaultState(), true);

        // Replacing with Ports 2
        scene.idle(20);
        scene.world().destroyBlock(util.grid().at(1, 3, 2));
        scene.world().destroyBlock(util.grid().at(1, 2, 3));
        scene.world().destroyBlock(util.grid().at(1, 3, 3));
        scene.world().destroyBlock(util.grid().at(1, 4, 3));
        scene.world().destroyBlock(util.grid().at(1, 3, 4));

        scene.idle(5);

        scene.world().setBlock(util.grid().at(1, 3, 2), GeneratorsBlocks.FUSION_REACTOR_PORT.defaultState(), true);
        scene.world().setBlock(util.grid().at(1, 3, 4), GeneratorsBlocks.FUSION_REACTOR_LOGIC_ADAPTER.defaultState(), true);
        scene.idle(5);
        scene.world().setBlock(util.grid().at(1, 2, 3), GeneratorsBlocks.REACTOR_GLASS.defaultState(), true);
        scene.world().setBlock(util.grid().at(1, 3, 3), GeneratorsBlocks.LASER_FOCUS_MATRIX.defaultState(), true);
        scene.world().setBlock(util.grid().at(1, 4, 3), GeneratorsBlocks.REACTOR_GLASS.defaultState(), true);



        // Placing Controller
        BlockState reactorBlockState = GeneratorsBlocks.FUSION_REACTOR_CONTROLLER.defaultState();
        reactorBlockState = ((AttributeStateActive) Attributes.ACTIVE).setActive(reactorBlockState, true); // why

        scene.idle(100);

        scene.addKeyframe();
        scene.rotateCameraY(-35);
        scene.idle(10);
        scene.world().showSection(util.select().fromTo(2, 5, 2, 4, 5, 4), Direction.DOWN);
        scene.idle(20);

        scene.world().setBlock(util.grid().at(3, 5, 3), reactorBlockState, true);

        scene.idle(10);






        scene.overlay().showOutlineWithText(util.select().position(util.grid().at(3, 5, 3)), 120)
                .text("Each Fusion Reactor requires a Fusion Reactor Controller in the center of the top side to form a complete Multiblock.");
        scene.idle(130);

        scene.overlay().showText(100)
                .text("Once properly assembled, it will emit Redstone particles to indicate its completion.");
        scene.idle(40);

        SceneUtil.multiBlockFormParticles(scene, util, util.grid().at(1, 1, 1), util.grid().at(5, 5, 5), 10);

        scene.idle(50);
    }

    public static void configuringReactor(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title(MekPonderScenes.CONFIGURING_FUSION_REACTOR.getPath(), "Configuring a Fusion Reactor");

        // Intro
        scene.showBasePlate();
        scene.idle(10);


        scene.world().showSection(util.select().fromTo(1, 1, 1, 5, 5, 5), Direction.DOWN);
        scene.idle(10);
        scene.rotateCameraY(-35F);
        scene.idle(30);

        // Configuring Ports
        scene.overlay().showOutlineWithText(util.select().position(util.grid().at(1, 3, 2)), 140)
                .text("The eject mode of a Fusion Reactor Port can be configured by using a Configurator.\n\nThis can toggle the port to either §4Output§r or §aInput§r mode.");

        scene.idle(160);

        scene.overlay().showText(100)
                .independent()
                .text("While in §aInput§r mode, the Reactor can accept §lChemicals§r, §lFluids§r and §lHeat§r.");
        scene.idle(120);

        scene.overlay().showText(100)
                .independent()
                .text("While in §4Output§r mode, the Reactor can output §lChemicals§r, §lHeat§r and §lEnergy§r.");

        scene.idle(120);
        scene.overlay().showControls(util.vector().blockSurface(util.grid().at(1, 3, 2), Direction.WEST), Pointing.LEFT, 60)
                .rightClick()
                .whileSneaking()
                .withItem(MekanismItems.CONFIGURATOR.getItemStack());
        scene.idle(40);

        SceneUtil.loopBlockProperty(scene, util.grid().at(1, 3, 2), ((AccessorAttributeStateActive) Attributes.ACTIVE).mekanism_ponder$getActiveProperty(), 3, 12);

        scene.idle(30);

        // Logic Adapters
        scene.addKeyframe();
        scene.rotateCameraY(-10F);
        scene.idle(20);

        scene.overlay().showOutlineWithText(util.select().position(util.grid().at(1, 3, 4)), 100)
                .text("The Fusion Reactor Logic Port is able to emit redstone based on the state of the Reactor.");

        scene.idle(120);

        scene.overlay().showText(80)
                .text("By right clicking, the user can configure when it outputs a Redstone Signal.");

        scene.idle(70);

        scene.overlay().showControls(util.vector().blockSurface(util.grid().at(1, 3, 4), Direction.WEST), Pointing.LEFT, 40)
                        .rightClick();

        scene.idle(70);

        scene.world().showSection(util.select().fromTo(0, 2, 4, 0, 3, 4), Direction.DOWN);

        scene.idle(20);
        scene.world().toggleRedstonePower(util.select().position(0, 3, 4));
        scene.effects().createRedstoneParticles(util.grid().at(0, 3, 4), 0xFF0000, 2);
        scene.idle(40);
        scene.world().hideSection(util.select().fromTo(0, 2, 4, 0, 3, 4), Direction.DOWN);

        scene.idle(15);

        // Fusion Reactor Controller
        scene.addKeyframe();
        scene.rotateCameraY(25F);
        scene.idle(15);

        scene.overlay().showOutlineWithText(util.select().position(3, 5, 3), 130)
                .text("By right clicking the Fusion Reactor Controller, the user can configure the Fuel Injection Rate of the Reactor");
        scene.idle(135);

        scene.overlay().showControls(util.vector().blockSurface(util.grid().at(3, 5, 3), Direction.UP), Pointing.RIGHT, 40)
                .rightClick();

        scene.idle(55);

        scene.overlay().showText(90)
                .independent(40)
                .text("In addition to that, it shows various statistics, and has a slot for a §lHohlraum§r");

        scene.idle(100);
    }

    public static void startingReactor(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title(MekPonderScenes.STARTING_FUSION_REACTOR.getPath(), "Starting a Fusion Reactor");
        //scene.debug().debugSchematic();

        scene.showBasePlate();
        scene.idle(10);
        scene.rotateCameraY(-35F);



        scene.world().showSection(util.select().fromTo(3, 1, 1, 7, 5, 5), Direction.DOWN);
        scene.idle(10);

        scene.overlay().showText(100)
                .text("To start a Reactor, the Fusion Reactor Controller must contain a §lHohlraum§r filled with §5D-T Fuel§r.");

        scene.idle(90);
        scene.overlay().showControls(util.vector().blockSurface(util.grid().at(5, 5, 3), Direction.UP), Pointing.UP, 40)
                .withItem(ChemicalUtil.getFilledVariant(GeneratorsItems.HOHLRAUM, GeneratorsChemicals.FUSION_FUEL));
        scene.idle(50);

        scene.overlay().showText(130)
                .text("The Reactor will start once it reaches its Ignition Temperature.\n\nThis temperature can be achieved by using a §lLaser Focus Matrix§r.");

        scene.idle(140);
        scene.addKeyframe();
        Selection lasers = util.select().fromTo(1, 1, 1, 1, 5, 5).add(util.select().position(0, 3, 4));

        scene.world().showSection(lasers, Direction.DOWN);
        scene.idle(15);

        scene.overlay().showOutlineWithText(util.select().position(util.grid().at(1, 3, 3)), 130)
                .text("A Laser amplifier can accumulate energy, and release it all at once, resulting in rapid heat increase.");

        scene.idle(150);

        scene.overlay().showText(140)
                .colored(PonderPalette.BLUE)
                .text("A successful activation with a Laser amplifier requires at least §c400MFE§r to reach the required Ignition Temperature.");


        scene.idle(160);
        scene.overlay().showText(150)
                .text("By toggling the Redstone Detection to \"NORMAL\", the Laser Amplifier will only shoot its accumulated energy once it receives a Redstone Signal.");

        scene.idle(165);
        scene.overlay().showText(60)
                .text("Redstone Detection: NORMAL")
                .pointAt(util.vector().centerOf(1, 3, 3));

        scene.idle(80);


        // Slighty inaccurate rendering, however it is clearer, which is why im keeping it this way.
        scene.world().modifyBlock(util.grid().at(0, 3, 4), blockState -> blockState.setValue(LeverBlock.POWERED, true), false);
        ParticleEmitter emitter = scene.effects().simpleParticleEmitter(new LaserParticleData(Direction.EAST, 1, 0.6F), util.vector().of(0, 0, 0));
        scene.effects().emitParticles(util.vector().centerOf(2, 3, 3), emitter, 1, 10);
        scene.idle(3);
        scene.world().modifyBlockEntityNBT(util.select().position(5, 5, 3), TileEntityFusionReactorController.class, nbt -> nbt.putByte("redstone", (byte) 15)); // dear god why

        scene.idle(40);
        scene.world().hideSection(lasers, Direction.UP);
        scene.idle(20);

        scene.overlay().showText(60)
                .text("The Reactor is now running.")
                .pointAt(util.vector().centerOf(5, 2, 4));

        scene.idle(70);
    }

    public static void fuelingReactor(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title(MekPonderScenes.FUELING_FUSION_REACTOR.getPath(), "Fueling a Fusion Reactor");

        // Intro
        scene.showBasePlate();
        scene.idle(10);



        scene.world().showSection(util.select().fromTo(1, 1, 1, 5, 5, 5), Direction.DOWN);
        scene.idle(10);

        scene.overlay().showText(60)
                .text("A Fusion reactor can be fueled in two ways.");
        scene.idle(70);

        // 1. Seperate
        scene.addKeyframe();
        scene.world().showSection(util.select().position(2, 3, 0).add(util.select().position(4, 3, 0)), Direction.DOWN);
        scene.overlay().showText(150)
                .text("1.\nBy using §cDeuterium§r and §aTritium§r, the Reactor can reach a maximum Injection rate of §698§rmB/t in total.\nRequiring §649§rmb/t of both chemicals.");

        scene.idle(90);

        scene.overlay().showControls(util.vector().centerOf(4, 3, 0), Pointing.UP, 60)
                        .withItem(GeneratorsFluids.DEUTERIUM.getBucket().getDefaultInstance());

        scene.overlay().showControls(util.vector().centerOf(2, 3, 0), Pointing.UP, 60)
                .withItem(GeneratorsFluids.TRITIUM.getBucket().getDefaultInstance());

        scene.idle(75);
        scene.world().hideSection(util.select().position(2, 3, 0).add(util.select().position(4, 3, 0)), Direction.UP);

        // 2. D-T Fuel
        scene.idle(20);
        scene.addKeyframe();
        scene.overlay().showText(200)
                .text("2.\nBy mixing §cDeuterium§r and §aTritium§r together, §5D-T Fuel§r is created.\n\nWith §5D-T Fuel§r, the Reactor can reach a maximum Injection rate of §61000§rmB/t in total.\nRequiring §6500§rmb/t of both chemicals seperately.");

        scene.idle(210);
        scene.world().replaceBlocks(util.select().position(4, 3, 1).add(util.select().position(2, 3, 1)), GeneratorsBlocks.REACTOR_GLASS.defaultState(), true);
        scene.idle(5);
        scene.world().setBlock(util.grid().at(3, 3 ,1), GeneratorsBlocks.FUSION_REACTOR_PORT.defaultState(), true);
        scene.idle(5);
        scene.world().showSection(util.select().position(3, 3, 0), Direction.UP);

        scene.idle(50);
        scene.overlay().showControls(util.vector().centerOf(3, 3, 0), Pointing.UP, 60)
                .withItem(GeneratorsFluids.FUSION_FUEL.getBucket().getDefaultInstance());

        scene.idle(60);

        scene.overlay().showText(150)
                .text("However, when using §5D-T Fuel§r, the Reactor ignores the configured Injection Rate, and instead attempts to use §61000§rmb/t at all times.");
        scene.idle(160);

    }
}
