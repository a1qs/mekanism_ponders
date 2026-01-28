package io.github.alyx.mekponder.ponder;


import io.github.alyx.mekponder.MekanismPonders;
import io.github.alyx.mekponder.ponder.generators.MekGensPonderScenes;
import io.github.alyx.mekponder.ponder.scenes.*;
import mekanism.common.registries.MekanismBlocks;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class MekPonderScenes {

    public static final ResourceLocation CREATING_DYNAMIC_TANK = MekanismPonders.id("creating_dynamic_tank");
    public static final ResourceLocation CREATING_INDUCTION_MATRIX = MekanismPonders.id("creating_induction_matrix");
    public static final ResourceLocation CREATING_THERMAL_EVAPORATION_PLANT = MekanismPonders.id("creating_thermal_evaporation_plant");
    public static final ResourceLocation CREATING_SPS = MekanismPonders.id("creating_sps");
    public static final ResourceLocation CREATING_THERMOELECTIC_BOILER = MekanismPonders.id("creating_thermoelectric_boiler");

    public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<Item> HELPER = helper.withKeyFunction(BuiltInRegistries.ITEM::getKey);

        HELPER.forComponents(
                MekanismBlocks.DYNAMIC_TANK.asItem(),
                MekanismBlocks.DYNAMIC_VALVE.asItem()
        ).addStoryBoard(CREATING_DYNAMIC_TANK, DynamicTankScenes::creatingDynamicTank);

        HELPER.forComponents(
                MekanismBlocks.INDUCTION_CASING.asItem(),
                MekanismBlocks.INDUCTION_PORT.asItem(),
                MekanismBlocks.BASIC_INDUCTION_CELL.asItem(),
                MekanismBlocks.ADVANCED_INDUCTION_CELL.asItem(),
                MekanismBlocks.ELITE_INDUCTION_CELL.asItem(),
                MekanismBlocks.ULTIMATE_INDUCTION_CELL.asItem(),
                MekanismBlocks.BASIC_INDUCTION_PROVIDER.asItem(),
                MekanismBlocks.ADVANCED_INDUCTION_PROVIDER.asItem(),
                MekanismBlocks.ELITE_INDUCTION_PROVIDER.asItem(),
                MekanismBlocks.ULTIMATE_INDUCTION_PROVIDER.asItem()
        ).addStoryBoard(CREATING_INDUCTION_MATRIX, InductionMatrixScenes::creatingInductionMatrix);

        HELPER.forComponents(
                MekanismBlocks.THERMAL_EVAPORATION_BLOCK.asItem(),
                MekanismBlocks.THERMAL_EVAPORATION_VALVE.asItem(),
                MekanismBlocks.THERMAL_EVAPORATION_CONTROLLER.asItem()
        ).addStoryBoard(CREATING_THERMAL_EVAPORATION_PLANT, ThermalEvaporationPlantScenes::creatingThermalEvaporationPlant);

        HELPER.forComponents(
                MekanismBlocks.SPS_CASING.asItem(),
                MekanismBlocks.SPS_PORT.asItem(),
                MekanismBlocks.SUPERCHARGED_COIL.asItem()
        ).addStoryBoard(CREATING_SPS, SupercriticalPhaseShifterScenes::creatingSPS);

        HELPER.forComponents(
                MekanismBlocks.BOILER_CASING.asItem(),
                MekanismBlocks.BOILER_VALVE.asItem(),
                MekanismBlocks.SUPERHEATING_ELEMENT.asItem()
        ).addStoryBoard(CREATING_THERMOELECTIC_BOILER, ThermoelectricBoilerScenes::creatingBoiler);


        if (MekanismPonders.isMekGensLoaded) {
            MekGensPonderScenes.registerGeneratorScenes(helper);
        }
    }
}
