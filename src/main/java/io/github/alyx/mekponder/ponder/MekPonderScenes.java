package io.github.alyx.mekponder.ponder;


import io.github.alyx.mekponder.MekanismPonders;
import io.github.alyx.mekponder.ponder.scenes.FusionReactorScenes;
import mekanism.generators.common.registries.GeneratorsBlocks;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class MekPonderScenes {
    public static final ResourceLocation CONSTRUCTING_FUSION_REACTOR = MekanismPonders.id("constructing_fusion_reactor");
    public static final ResourceLocation CONFIGURING_FUSION_REACTOR = MekanismPonders.id("configuring_fusion_reactor");
    public static final ResourceLocation STARTING_FUSION_REACTOR = MekanismPonders.id("starting_fusion_reactor");
    public static final ResourceLocation FUELING_FUSION_REACTOR = MekanismPonders.id("fueling_fusion_reactor");

    public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<Item> HELPER = helper.withKeyFunction(BuiltInRegistries.ITEM::getKey);


        HELPER.forComponents(
                        GeneratorsBlocks.FUSION_REACTOR_CONTROLLER.getBlock().asItem(),
                        GeneratorsBlocks.FUSION_REACTOR_FRAME.getBlock().asItem(),
                        GeneratorsBlocks.FUSION_REACTOR_LOGIC_ADAPTER.getBlock().asItem(),
                        GeneratorsBlocks.FUSION_REACTOR_PORT.getBlock().asItem()
                )
                .addStoryBoard(CONSTRUCTING_FUSION_REACTOR, FusionReactorScenes::constructingReactor)
                .addStoryBoard(CONFIGURING_FUSION_REACTOR, FusionReactorScenes::configuringReactor)
                .addStoryBoard(STARTING_FUSION_REACTOR, FusionReactorScenes::startingReactor)
                .addStoryBoard(FUELING_FUSION_REACTOR, FusionReactorScenes::fuelingReactor);
    }
}
