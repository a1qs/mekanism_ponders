package io.github.alyx.mekponder;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;


// TODO: Figure out Energy Cube and transmitter logic
// TODO: fix scaling with boiler with gui sizes
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
