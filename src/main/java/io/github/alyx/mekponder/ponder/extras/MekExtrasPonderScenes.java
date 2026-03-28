package io.github.alyx.mekponder.ponder.extras;


import io.github.alyx.mekponder.MekanismPonders;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class MekExtrasPonderScenes {
    public static final ResourceLocation CONSTRUCTING_NAQUADAH_REACTOR = MekanismPonders.id("constructing_naquadah_reactor");


    // Only loaded if Mekanism: Generators is loaded
    public static void registerGeneratorScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<Item> HELPER = helper.withKeyFunction(ForgeRegistries.ITEMS::getKey);





//        HELPER.forComponents(
//
//                )
//                .addStoryBoard(, );


    }
}
