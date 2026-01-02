package io.github.alyx.mekponder.datagen;

import io.github.alyx.mekponder.MekanismPonders;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = MekanismPonders.MODID, value = Dist.CLIENT)
public class MekPonderDataGenerator {

    @SubscribeEvent
    public static void runDatagen(GatherDataEvent e) {
        e.addProvider(new MekPonderLanguageProvider(e.getGenerator().getPackOutput()));
    }
}
