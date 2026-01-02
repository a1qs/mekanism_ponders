package io.github.alyx.mekponder;

import io.github.alyx.mekponder.ponder.MekPonderPlugin;
import net.createmod.ponder.foundation.PonderIndex;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = MekanismPonders.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = MekanismPonders.MODID, value = Dist.CLIENT)
public class MekanismPondersClient {
    public MekanismPondersClient(ModContainer container) {
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        PonderIndex.addPlugin(new MekPonderPlugin());
    }
}
