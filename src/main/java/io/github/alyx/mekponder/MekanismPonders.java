package io.github.alyx.mekponder;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;


// TODO: Figure out Energy Cube and transmitter logic
@Mod(MekanismPonders.MODID)
public class MekanismPonders {
    public static final String MODID = "mekanism_ponders";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static boolean isMekGensLoaded = false;
    public static boolean isMekEvolvedLoaded = false;
    public static boolean isMekExtrasLoaded = false;

    public MekanismPonders(IEventBus modEventBus, ModContainer modContainer) {
        // We only want to load certain ponders if the mod for the feature is actually loaded
        isMekGensLoaded = ModList.get().isLoaded("mekanismgenerators");
        isMekEvolvedLoaded = ModList.get().isLoaded("evolvedmekanism");
        isMekExtrasLoaded = ModList.get().isLoaded("mekanism_extras");
    }

    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(MODID, name);
    }
}
