package io.github.alyx.mekponder.ponder;


import io.github.alyx.mekponder.MekanismPonders;
import io.github.alyx.mekponder.ponder.scenes.DynamicTankScenes;
import io.github.alyx.mekponder.ponder.scenes.InductionMatrixScenes;
import io.github.alyx.mekponder.ponder.scenes.ThermalEvaporationPlantScenes;
import mekanism.common.registries.MekanismBlocks;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class MekPonderScenes {

    public static final ResourceLocation CREATING_DYNAMIC_TANK = MekanismPonders.id("creating_dynamic_tank");
    public static final ResourceLocation CREATING_INDUCTION_MATRIX = MekanismPonders.id("creating_induction_matrix");
    public static final ResourceLocation CREATING_THERMAL_EVAPORATION_PLANT = MekanismPonders.id("creating_thermal_evaporation_plant");

    public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<Item> HELPER = helper.withKeyFunction(BuiltInRegistries.ITEM::getKey);

        // TODO: add for other related components



        HELPER.forComponents(
                MekanismBlocks.DYNAMIC_TANK.asItem(),
                MekanismBlocks.DYNAMIC_VALVE.asItem()
        ).addStoryBoard(CREATING_DYNAMIC_TANK, DynamicTankScenes::creatingDynamicTank);

        HELPER.forComponents(
                MekanismBlocks.INDUCTION_CASING.asItem(),
                MekanismBlocks.INDUCTION_PORT.asItem(),
                MekanismBlocks.BASIC_INDUCTION_CELL.asItem() // todo? other cells?
        ).addStoryBoard(CREATING_INDUCTION_MATRIX, InductionMatrixScenes::creatingInductionMatrix);

        HELPER.forComponents(
                MekanismBlocks.THERMAL_EVAPORATION_BLOCK.asItem(),
                MekanismBlocks.THERMAL_EVAPORATION_VALVE.asItem(),
                MekanismBlocks.THERMAL_EVAPORATION_CONTROLLER.asItem()
        ).addStoryBoard(CREATING_THERMAL_EVAPORATION_PLANT, ThermalEvaporationPlantScenes::creatingThermalEvaporationPlant);



        if (MekanismPonders.isMekGensLoaded) {
            PonderGeneratorScenes.registerGeneratorScenes(helper);
        }
    }
}
