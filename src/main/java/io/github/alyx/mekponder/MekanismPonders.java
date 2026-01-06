package io.github.alyx.mekponder;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModList;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;


// TODO: Helper method for destroying blocks in range
// TODO: Replace "the user" -> "You"
// TODO: Figure out Energy Cube and transmitter logic
// TODO: mention UI in Dynamic tank
// TODO: Improve multi particles
// TODO: Seperate Stuff from MekGens and only load if mekgens is loaded (e.g reactor glass, heat generator)
@Mod(MekanismPonders.MODID)
public class MekanismPonders {
    public static final String MODID = "mekanism_ponders";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static boolean isMekGensLoaded = false;

    public MekanismPonders(IEventBus modEventBus, ModContainer modContainer) {
        isMekGensLoaded = ModList.get().isLoaded("mekanismgenerators"); // We only want to add Ponders that include MekanismGenerators things if the mod is loaded.
    }

    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(MODID, name);
    }
}
