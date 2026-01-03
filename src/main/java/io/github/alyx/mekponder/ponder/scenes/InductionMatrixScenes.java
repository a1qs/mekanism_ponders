package io.github.alyx.mekponder.ponder.scenes;

import io.github.alyx.mekponder.mixin.AccessorAttributeStateActive;
import io.github.alyx.mekponder.ponder.MekPonderScenes;
import io.github.alyx.mekponder.util.SceneUtil;
import mekanism.common.block.attribute.Attributes;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.registries.MekanismItems;
import mekanism.generators.common.registries.GeneratorsBlocks;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.phys.AABB;

public class InductionMatrixScenes {

    /*
     *
     *
     */


    public static void creatingInductionMatrix(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title(MekPonderScenes.CREATING_INDUCTION_MATRIX.getPath(), "Creating an Induction Matrix");
        scene.showBasePlate();
        scene.scaleSceneView(0.9F);
        scene.idle(10);
        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(20);


        scene.overlay().showText(130)
                .colored(PonderPalette.BLUE)
                .text("The Induction Matrix is a Multiblock, capable of storing large amounts of energy.");

        scene.idle(150);

        scene.overlay().showText(90)
                .pointAt(util.vector().blockSurface(util.grid().at(3, 1, 3), Direction.UP))
                .text("Building an Induction Matrix requires Induction Casings.");

        scene.idle(80);

        scene.world().showSection(util.select().fromTo(1, 2, 5, 5, 4, 5), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(5, 2, 1, 5, 4, 4), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(4, 2, 1, 1, 4, 1), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(1, 2, 2, 1, 4, 4), Direction.DOWN);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(5, 5, 1, 1, 5, 5), Direction.DOWN);

        scene.idle(15);
        scene.overlay().showText(80)
                .pointAt(util.vector().of(2, 5, 1))
                .text("It's a cuboid structure and its size can range from 3x3x3, to 18x18x18");

        scene.idle(70);
        AABB tankBounds = new AABB(1, 1, 1, 6, 6 ,6);
        Object tankOutline = new Object();

        scene.overlay().chaseBoundingBoxOutline(PonderPalette.BLUE, tankOutline,
                tankBounds, 15);
        scene.idle(15);

        for (int i = 0; i < 3; i++) {
            int expand = i + 1;
            scene.overlay().chaseBoundingBoxOutline(PonderPalette.BLUE, tankOutline,
                    tankBounds.expandTowards(expand, expand, expand), 12);

            scene.idle(12);
        }

        scene.idle(50);
        scene.addKeyframe();
        scene.idle(10);

        scene.overlay().showText(130)
                .colored(PonderPalette.BLUE)
                .text("Inner sections can be replaced by either §6Structural Glass§r, §6Reactor Glass§r, or §6Induction Ports§r.");

        Selection inner = util.select().fromTo(2, 2, 1, 4, 4, 1)
                        .add(util.select().fromTo(2, 5, 2, 4, 5, 4))
                        .add(util.select().fromTo(1, 2, 2, 1, 4, 4));

        scene.overlay().showOutline(PonderPalette.BLUE, new Object(), inner, 130);
        scene.idle(140);

        scene.world().replaceBlocks(util.select().fromTo(2, 2, 1, 4, 4, 1).add(util.select().fromTo(1, 2, 2, 1, 4, 4)), MekanismBlocks.STRUCTURAL_GLASS.defaultState(), true);
        scene.idle(10);
        scene.world().replaceBlocks(util.select().fromTo(2, 5, 2, 4, 5, 4), GeneratorsBlocks.REACTOR_GLASS.defaultState(), true);
        scene.idle(10);
        scene.world().setBlock(util.grid().at(2, 2, 1), MekanismBlocks.INDUCTION_PORT.defaultState(), true);
        scene.world().setBlock(util.grid().at(4, 2, 1), MekanismBlocks.INDUCTION_PORT.defaultState(), true);

        scene.idle(35);

        scene.overlay().showText(100)
                .text("Once constructed, the structure will emit Redstone particles to indicate its completion.");

        scene.idle(80);
        SceneUtil.multiBlockFormParticles(scene, util, util.grid().at(1, 1, 1), util.grid().at(5, 5, 5), 6);

        scene.idle(40);

        scene.addKeyframe();

        scene.idle(10);
        scene.rotateCameraY(-35F);

        scene.overlay().showText(100)
                        .text("For the Induction Matrix to store power, it requires an Induction Cell of any tier.");

        scene.world().setBlocks(util.select().fromTo(2, 2, 4, 2, 4, 4), MekanismBlocks.BASIC_INDUCTION_CELL.defaultState(), true);
        scene.world().setBlocks(util.select().fromTo(2, 2, 2, 2, 4, 2), MekanismBlocks.BASIC_INDUCTION_PROVIDER.defaultState(), true);

        scene.idle(80);

        scene.world().hideSection(util.select().fromTo(1, 2, 2, 1, 4, 4), Direction.WEST);


        scene.idle(35);

        scene.world().showSection(util.select().fromTo(2, 2, 4, 2, 4, 4), Direction.EAST);

        scene.idle(20);

        scene.overlay().showOutlineWithText(util.select().position(2, 3, 4), 100)
                        .text("Each Induction Cell provides the Induction Matrix with more total Capacity.");

        scene.idle(120);

        scene.rotateCameraY(-35);

        scene.idle(15);

        scene.overlay().showText(100)
                .text("To insert and extract any power out of the Induction Matrix, it needs an Induction Provider.");

        scene.idle(90);

        scene.world().showSection(util.select().fromTo(2, 2, 2, 2, 4, 2), Direction.EAST);

        scene.idle(20);

        scene.overlay().showOutlineWithText(util.select().position(2, 3, 2), 100)
                        .text("Induction Providers allow you to add transfer Capacity to the Induction Matrix.");

        scene.idle(110);

        scene.rotateCameraY(70);

        scene.world().showSection(util.select().fromTo(1, 2, 2, 1, 4, 4), Direction.EAST);

        scene.idle(40);


        scene.addKeyframe();

        scene.idle(10);

        scene.overlay().showOutlineWithText(util.select().cuboid(util.grid().at(1, 1, 1), new Vec3i(4, 4, 4)), 120)
                .colored(PonderPalette.BLUE)
                        .text("The Induction Matrix has a UI, accessible by clicking anywhere on it while it's assembled.");

        scene.idle(100);

        scene.overlay().showControls(util.vector().centerOf(1, 3, 1), Pointing.DOWN, 60)
                .rightClick();

        scene.idle(80);

        scene.overlay().showText(150)
                .colored(PonderPalette.BLUE)
                .text("The UI provides information about the §6current amount of power stored§r, the §6total capacity§r, as well as the amount of energy being §6inserted§r and §6outputtedg§r.");


        scene.idle(175);

        scene.addKeyframe();

        scene.rotateCameraY(20);
        scene.idle(10);


        scene.overlay().showOutlineWithText(util.select().position(2, 2, 1), 120)
                .text("The transfer mode of a Induction Port can be configured using a Configurator.\n\nThis can toggle the port to either §4Output§r or §aInput§r mode.");
        scene.idle(130);

        scene.overlay().showControls(util.vector().blockSurface(util.grid().at(2, 2, 1), Direction.WEST), Pointing.LEFT, 60)
                .rightClick()
                .whileSneaking()
                .withItem(MekanismItems.CONFIGURATOR.getItemStack());

        scene.idle(40);
        SceneUtil.loopBlockProperty(scene, util.grid().at(2, 2, 1), ((AccessorAttributeStateActive) Attributes.ACTIVE).mekanism_ponder$getActiveProperty(), 3, 12);

        scene.idle(30);
        scene.overlay().showOutlineWithText(util.select().position(4, 2, 1), 80)
                .text("In §aInput§r mode, it is able to receive power from any source.");

        scene.idle(70);

        scene.world().showSection(util.select().position(4, 2, 0), Direction.UP);
        scene.idle(20);

        scene.world().cycleBlockProperty(util.grid().at(4, 2, 0), ((AccessorAttributeStateActive) Attributes.ACTIVE).mekanism_ponder$getActiveProperty());

        scene.idle(30);

        scene.overlay().showOutlineWithText(util.select().position(2, 2, 1), 80)
                .text("In §4Output§r mode, you can extract power from the Induction Matrix.");

        scene.idle(70);

        scene.world().showSection(util.select().position(2, 2, 0), Direction.UP);
        scene.idle(40);
    }
}
