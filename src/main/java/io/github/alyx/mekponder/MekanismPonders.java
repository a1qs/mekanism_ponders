package io.github.alyx.mekponder;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;


// TODO: Helper method for destroying blocks in range
// TODO: Replace "the user" -> "You"
// TODO: Figure out Energy Cube and transmitter logic
// TODO: mention UI in Dynamic tank
@Mod(MekanismPonders.MODID)
public class MekanismPonders {
    public static final String MODID = "mekanism_ponders";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MekanismPonders(IEventBus modEventBus, ModContainer modContainer) {
    }

    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(MODID, name);
    }
}
