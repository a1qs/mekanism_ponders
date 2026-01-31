package io.github.alyx.mekponder.datagen;

import io.github.alyx.mekponder.MekanismPonders;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = MekanismPonders.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MekPonderDataGenerator {

    @SubscribeEvent
    public static void runDatagen(GatherDataEvent e) {
        e.getGenerator().addProvider(
                e.includeClient(),
                new MekPonderLanguageProvider(e.getGenerator().getPackOutput())
        );
    }
}
