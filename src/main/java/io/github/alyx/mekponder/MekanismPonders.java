package io.github.alyx.mekponder;

import com.mojang.logging.LogUtils;
import io.github.alyx.mekponder.ponder.MekPonderPlugin;
import net.createmod.ponder.foundation.PonderIndex;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;


// TODO: Figure out Energy Cube and transmitter logic
@Mod(MekanismPonders.MODID)
public class MekanismPonders {
    public static final String MODID = "mekanism_ponders";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static boolean isMekGensLoaded = false;
    public static boolean isMekEvolvedLoaded = false;
    public static boolean isMekExtrasLoaded = false;

    public MekanismPonders() {
        // We only want to load certain ponders if the mod for the feature is actually loaded
        isMekGensLoaded = ModList.get().isLoaded("mekanismgenerators");
        isMekEvolvedLoaded = ModList.get().isLoaded("evolvedmekanism");
        isMekExtrasLoaded = ModList.get().isLoaded("mekanism_extras");
    }

    public static ResourceLocation id(String name) {
        return new ResourceLocation(MODID, name);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class Client {
        @SubscribeEvent
        static void onClientSetup(FMLClientSetupEvent event) {
            PonderIndex.addPlugin(new MekPonderPlugin());
        }
    }
}
