package io.github.alyx.mekponder.ponder;

import io.github.alyx.mekponder.MekanismPonders;
import io.github.alyx.mekponder.ponder.scenes.FissionReactorScenes;
import io.github.alyx.mekponder.ponder.scenes.FusionReactorScenes;
import mekanism.generators.common.registries.GeneratorsBlocks;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;




public class MekGensPonderScenes {
    public static final ResourceLocation CONSTRUCTING_FUSION_REACTOR = MekanismPonders.id("constructing_fusion_reactor");
    public static final ResourceLocation CONFIGURING_FUSION_REACTOR = MekanismPonders.id("configuring_fusion_reactor");
    public static final ResourceLocation STARTING_FUSION_REACTOR = MekanismPonders.id("starting_fusion_reactor");
    public static final ResourceLocation FUELING_FUSION_REACTOR = MekanismPonders.id("fueling_fusion_reactor");

    public static final ResourceLocation CREATING_FISSION_REACTOR = MekanismPonders.id("creating_fission_reactor");
    public static final ResourceLocation CONFIGURING_FISSION_REACTOR = MekanismPonders.id("configuring_fission_reactor");
    public static final ResourceLocation COOLING_FISSION_REACTOR = MekanismPonders.id("cooling_fission_reactor");

    // Only loaded if Mekanism: Generators is loaded
    public static void registerGeneratorScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<Item> HELPER = helper.withKeyFunction(BuiltInRegistries.ITEM::getKey);

        HELPER.forComponents(
                        GeneratorsBlocks.FUSION_REACTOR_CONTROLLER.asItem(),
                        GeneratorsBlocks.FUSION_REACTOR_FRAME.asItem(),
                        GeneratorsBlocks.FUSION_REACTOR_LOGIC_ADAPTER.asItem(),
                        GeneratorsBlocks.FUSION_REACTOR_PORT.asItem()
                )
                .addStoryBoard(CONSTRUCTING_FUSION_REACTOR, FusionReactorScenes::constructingReactor)
                .addStoryBoard(CONFIGURING_FUSION_REACTOR, FusionReactorScenes::configuringReactor)
                .addStoryBoard(STARTING_FUSION_REACTOR, FusionReactorScenes::startingReactor)
                .addStoryBoard(FUELING_FUSION_REACTOR, FusionReactorScenes::fuelingReactor);



        HELPER.forComponents(
                        GeneratorsBlocks.FISSION_REACTOR_CASING.asItem(),
                        GeneratorsBlocks.FISSION_REACTOR_PORT.asItem(),
                        GeneratorsBlocks.FISSION_REACTOR_LOGIC_ADAPTER.asItem(),
                        GeneratorsBlocks.FISSION_FUEL_ASSEMBLY.asItem(),
                        GeneratorsBlocks.CONTROL_ROD_ASSEMBLY.asItem()
                )
                .addStoryBoard(CREATING_FISSION_REACTOR, FissionReactorScenes::creatingFissionReactor)
                .addStoryBoard(CONFIGURING_FISSION_REACTOR, FissionReactorScenes::configuringFissionReactor)
                .addStoryBoard(COOLING_FISSION_REACTOR, FissionReactorScenes::coolingFissionReactor);

    }
}
