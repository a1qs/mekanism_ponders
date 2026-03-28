package io.github.alyx.mekponder.ponder.evolved;

import io.github.alyx.mekponder.MekanismPonders;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;


public class MekEvolvedPonderScenes {
    public static final ResourceLocation CREATING_APT = MekanismPonders.id("creating_apt");


    // Only loaded if Mekanism: Generators is loaded
    public static void registerGeneratorScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<Item> HELPER = helper.withKeyFunction(BuiltInRegistries.ITEM::getKey);





//        HELPER.forComponents(
//
//                )
//                .addStoryBoard(, );


    }
}
