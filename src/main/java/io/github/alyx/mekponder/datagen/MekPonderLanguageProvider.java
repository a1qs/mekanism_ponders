package io.github.alyx.mekponder.datagen;

import io.github.alyx.mekponder.MekanismPonders;

import io.github.alyx.mekponder.ponder.MekPonderScenes;
import io.github.alyx.mekponder.ponder.PonderGeneratorScenes;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class MekPonderLanguageProvider extends LanguageProvider {
    public MekPonderLanguageProvider(PackOutput output) {
        super(output, MekanismPonders.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addPonderTranslation(
                PonderGeneratorScenes.CONSTRUCTING_FUSION_REACTOR,
                "Constructing a Fusion Reactor",

                "This is the basis of a Fusion Reactor.\nIt's made out of Fusion Reactor Frames.",
                "Each reactor side is built the same way.",
                "Inner sections can be replaced with other blocks, such as:\n\n- Fusion Reactor Ports\n- Fusion Logic Ports\n- Reactor Glass\n- Laser Focus Matrix",
                "Each Fusion Reactor requires a Fusion Reactor Controller in the center of the top side to form a complete Multiblock",
                "Once properly assembled, it will emit Redstone particles to indicate its completion."
        );

        addPonderTranslation(
                PonderGeneratorScenes.CONFIGURING_FUSION_REACTOR,
                "Configuring a Fusion Reactor",

                "The eject mode of a Fusion Reactor Port can be configured by using a Configurator.\n\nThis can toggle the port to either §4Output§r or §aInput§r mode.",
                "While in §aInput§r mode, the Reactor can accept §lChemicals§r, §lFluids§r and §lHeat§r.",
                "While in §4Output§r mode, the Reactor can output §lChemicals§r, §lHeat§r and §lEnergy§r.",
                "The Fusion Reactor Logic Port is able to emit redstone based on the state of the Reactor.",
                "By right clicking, you can configure when it outputs a Redstone Signal.",
                "By right clicking the Fusion Reactor Controller, you can configure the Fuel Injection Rate of the Reactor",
                "In addition to that, it shows various statistics, and has a slot for a §lHohlraum§r"
        );

        addPonderTranslation(
                PonderGeneratorScenes.STARTING_FUSION_REACTOR,
                "Starting a Fusion Reactor",

                "To start a Reactor, the Fusion Reactor Controller must contain a §lHohlraum§r filled with §5D-T Fuel§r.",
                "The Reactor will start once it reaches its Ignition Temperature.\n\nThis temperature can be achieved by using a §lLaser Focus Matrix§r.",
                "A Laser amplifier can accumulate energy, and release it all at once, resulting in rapid heat increase.",
                "A successful activation with a Laser amplifier requires at least §c400MFE§r to reach the required Ignition Temperature.",
                "By toggling the Redstone Detection to \"NORMAL\", the Laser Amplifier will only shoot its accumulated energy once it receives a Redstone Signal.",
                "Redstone Detection: NORMAL",
                "The Reactor is now running."
        );

        addPonderTranslation(
                PonderGeneratorScenes.FUELING_FUSION_REACTOR,
                "Fueling a Fusion Reactor",

                "A Fusion reactor can be fueled in two ways.",
                "1.\nBy using §cDeuterium§r and §aTritium§r, the Reactor can reach a maximum Injection rate of §698§rmB/t in total.\nRequiring §649§rmb/t of both chemicals.",
                "2.\nBy mixing §cDeuterium§r and §aTritium§r together, §5D-T Fuel§r is created.\n\nWith §5D-T Fuel§r, the Reactor can reach a maximum Injection rate of §61000§rmB/t in total.\nRequiring §6500§rmb/t of both chemicals seperately.",
                "However, when using §5D-T Fuel§r, the Reactor ignores the configured Injection Rate, and instead attempts to use §61000§rmb/t at all times."
        );

        addPonderTranslation(
                MekPonderScenes.CREATING_DYNAMIC_TANK,
                "Creating a Dynamic Tank Multiblock",

                "The Dynamic Tank is a Multiblock, capable of storing a large amount of either Fluids, or Chemicals.",
                "Building a Dynamic Tank Multiblock requires Dynamic Tank blocks.",
                "It is a cuboid structure and hollow on the inside.",
                "Inner sections can be replaced by either Structural Glass, Reactor Glass, or Dynamic Valves.",
                "Once properly built, it will emit Redstone Particles to indicate its completion.",
                "A Dynamic Tank Multiblock can range from sizes of 3x3x3, up to 18x18x18.",
                "The larger the structure is, the more capacity it has.\n Capacities differ from Fluids and Chemicals, with Chemicals having larger capacities than fluids.",
                "To insert/extract Fluids or Chemicals, a Dynamic Valve can be used.",
                "Simply connect a transmitter of your choosing to the valve.",
                "To extract Fluids or Chemicals, the given transmitter must be set to pull from the valve."
        );
    }

    private void addPonderTranslation(ResourceLocation ponder, String header, String... text) {
        addPonderHeader(ponder, header);
        addPonderTranslationText(ponder, text);
    }


    private void addPonderTranslationText(ResourceLocation ponder, String... text) {
        for (int i = 0; i < text.length; i++) {
            add(ponder.getNamespace() + ".ponder." + ponder.getPath() + ".text_" + (i + 1), text[i]);
        }
    }

    private void addPonderHeader(ResourceLocation ponder, String header) {
        add(ponder.getNamespace() + ".ponder." + ponder.getPath() + ".header", header);
    }
}
