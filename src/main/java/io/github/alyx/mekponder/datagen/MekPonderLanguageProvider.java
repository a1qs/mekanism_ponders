package io.github.alyx.mekponder.datagen;

import io.github.alyx.mekponder.MekanismPonders;
import io.github.alyx.mekponder.ponder.MekPonderScenes;
import io.github.alyx.mekponder.ponder.generators.MekGensPonderScenes;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class MekPonderLanguageProvider extends LanguageProvider {
    public MekPonderLanguageProvider(PackOutput output) {
        super(output, MekanismPonders.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {

        // Fission Scenes
        addPonderTranslation(
                MekGensPonderScenes.CREATING_FISSION_REACTOR,
                "Creating a Fission Reactor",

                "The Fission Reactor is a multiblock capable of processing Fissile Fuel into Nuclear Waste.",
                "It's a cuboid structure and can range from 3x4x3 up to 18x18x18,\nand uses Fission Reactor Casings for its frame.",
                "The inner sections of the frame can be replaced with Reactor Glass, Fission Reactor Ports or Fission Reactor Logic Adapters.",
                "Inside the Reactor, Fission Control Rods need to be added, which are built with one or more Fission Fuel Assemblies and a single Control Rod Assembly on top of them.",
                "The cooling of the Reactor is penalized if Control Rods touch eachother.",
                "Once fully constructed, it will emit Redstone Particles to indicate its completion."
        );

        addPonderTranslation(
                MekGensPonderScenes.CONFIGURING_FISSION_REACTOR,
                "Configuring a Fission Reactor",

                "Fission Reactor Ports are used to interact with the Fission Reactor.",
                "Fission Reactor Ports have 3 different modes they can switch between.",
                "To switch between modes, you can use a Configurator on the port by shift-right-clicking the port.",
                "Input Only:\n\nThe port will exclusively accept Fluids and Chemicals.",
                "Output Waste:\n\nThe port will exclusively output Nuclear Waste produced by the Reactor.",
                "Output Coolant:\n\nThe port will exclusively output Heated Coolant produced by the Reactor.",
                "The Fission Reactor Logic Adapter can be used to control the reactor with a Redstone Signal,\nor emit a Redstone Signal based on the Reactor State.\n\nThis can help to create fail-safe mechanisms for the reactor.",
                "Logic Adapter is set to Activation.\n\nThe reactor is now running.",
                "Logic Adapter is set to Insufficient Fuel.\n\nA Redstone signal is being outputted.",
                "The Fission Reactor has an UI that can be accessed by clicking anywhere on its completed structure.",
                "Within the main tab, you can see:\n- its Status\n- its current configured Burn Rate\n- the Heating Rate\n- the current Temperature\n- and the Damage percentage it has sustained.",
                "In addition to that, it has a buttons to activate and deactivate the reactor.",
                "In the Fission Reactor Statistics tab, you can see:\n- Heat Statistic\n- Fuel Statistics\n- as well as being able to set the Current Burn Rate."
        );

        addPonderTranslation(
                MekGensPonderScenes.COOLING_FISSION_REACTOR,
                "Cooling a Fission Reactor",

                "The Fission Reactor can be cooled in two ways.",
                "1. Water cooling\n\nWater cooling the reactor produces steam. The reactor uses 20,000mB/t of Water per mB of Burn Rate.\n\nSteam can be used in a Turbine to gain energy, and can also be used to recycle the steam back into Water using Saturating Condensers.",
                "2. Sodium cooling\n\nSodium cooling the reactor produces Superheated Sodium.\nSuperheated Sodium can be used create Steam in a Thermoelectric Boiler, as well returning the heated Sodium to a cooled state, where it can be used as a coolant again.",
                "This method uses 200.000mB/t of Sodium per mB of Burn Rate, however provides double the cooling capacity that Water provides\n\nThis allows the reactor able to handle double the Burn Rate it could with Water."
        );

        addPonderTranslation(
                MekGensPonderScenes.RUNNING_FISSION_REACTOR,
                "Running a Fission Reactor",

                "By providing Fission Fuel, the reactor can be activated, and will produce Nuclear Waste every tick correlating to the Burn Rate set for the Reactor.",
                "Nuclear Waste is radioactive, meaning that it cannot be stored in normal Chemical Tanks.\nRadioactive Waste Barrels can be used, which will dissapate the waste stored.",
                "While running, the reactor produces heat and can consume Coolant to cool itself down, producing Steam or Superheated Sodium in the process.",
                "If the temperature reaches levels beyond 1200K the reactor will increase its damage percentage.",
                "Once it's beyond 100%%, each tick has a chance that the reactor will explode, while it is above 100%%."
        );

        // Fusion Scenes
        addPonderTranslation(
                MekGensPonderScenes.CONSTRUCTING_FUSION_REACTOR,
                "Constructing a Fusion Reactor",

                "This is the basis of a Fusion Reactor.\nIt's made out of Fusion Reactor Frames.",
                "Each reactor side is built the same way.",
                "Inner sections can be replaced with other blocks, such as:\n\n- Fusion Reactor Ports\n- Fusion Logic Ports\n- Reactor Glass\n- Laser Focus Matrix",
                "Each Fusion Reactor requires a Fusion Reactor Controller in the center of the top side to form a complete Multiblock",
                "Once properly assembled, it will emit Redstone particles to indicate its completion."
        );

        addPonderTranslation(
                MekGensPonderScenes.CONFIGURING_FUSION_REACTOR,
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
                MekGensPonderScenes.STARTING_FUSION_REACTOR,
                "Starting a Fusion Reactor",

                "To start a Reactor, the Fusion Reactor Controller must contain a §lHohlraum§r filled with §5D-T Fuel§r.",
                "The Reactor will start once it reaches its Ignition Temperature.\n\nThis temperature can be achieved by using a §lLaser Focus Matrix§r.",
                "A Laser Focus Matrix can absorb Laser beams and increases the temperature of the Reactor.",
                "A Laser amplifier can accumulate energy, and release it all at once, resulting in rapid heat increase.",
                "A successful activation with a Laser amplifier requires at least §c400MFE§r to reach the required Ignition Temperature.",
                "By toggling the Redstone Detection to \"NORMAL\", the Laser Amplifier will only shoot its accumulated energy once it receives a Redstone Signal.",
                "Redstone Detection: NORMAL",
                "The Reactor is now running."
        );

        addPonderTranslation(
                MekGensPonderScenes.FUELING_FUSION_REACTOR,
                "Fueling a Fusion Reactor",

                "A Fusion reactor can be fueled in two ways.",
                "1.\nBy using §cDeuterium§r and §aTritium§r, the Reactor can reach a maximum Injection rate of §698§rmB/t in total.\nRequiring §649§rmb/t of both chemicals.",
                "2.\nBy mixing §cDeuterium§r and §aTritium§r together, §5D-T Fuel§r is created.\n\nWith §5D-T Fuel§r, the Reactor can reach a maximum Injection rate of §61000§rmB/t in total.\nRequiring §6500§rmb/t of both chemicals seperately.",
                "However, when using §5D-T Fuel§r, the Reactor ignores the configured Injection Rate, and instead attempts to use §61000§rmb/t at all times."
        );


        // Industrial Turbine Scenes
        addPonderTranslation(
                MekGensPonderScenes.CREATING_TURBINE,
                "Creating an Industrial Turbine",

                "The Industrial Turbine is a Multiblock, capable of generating large amounts of energy using Steam.",
                "Its structure is made out of Turbine Casings and can range from sizes 5x5x5 up to 17x18x17 with an odd diameter.",
                "Inner sections of the structure can be replaced with Structural Glass or Turbine Valves.",
                "The Turbine requires Turbine Rotors in the center column of the Structure, with a Rotational Complex on top of it.",
                "Turbine Blades are needed on the Turbine Rotors, which are applied by right-clicking, but cannot exceed the the interior width of the structure.",
                "The inner layer of the Rotational Complex must be filled with Pressure Dispersers.",
                "Electromagnetic Coils need to be placed on top of the Rotational complex and must connect to eachother.\n\nEach coil allows for 4 Turbine Blades to be added to the Turbine.",
                "Optionally, Saturating Condensers can be added to recycle the processed Steam back into water.",
                "The inner structure starting from the Rotational Complex layer can be replaced with Turbine Vents, allowing for higher Flow Rate.",
                "Once properly built, it will emit Redstone Particles to indicate its completion."

        );

        addPonderTranslation(
                MekGensPonderScenes.RUNNING_TURBINE,
                "Running an Industrial Turbine",

                "The Industrial Turbine requires Steam to produce energy.",
                "Steam can be provided through Turbine Valves, while Energy can be extracted from them.",
                "If Saturating Condensers are used, Water can be extracted through the Turbine Vents.",
                "Right clicking the Industrial Turbine opens its UI, displaying a variety of statistics.",
                "The main menu shows:\n- The internal steam tank\n- Energy production\n- The amount of Steam inserted every tick\n- Its total Steam capacity\n- and its maximum steam processing rate.",
                "In addition to that, it has a button allowing you to dump either excess Steam, or all Steam inserted into the Turbine.",
                "While dumping steam, Water will not be recycled.",
                "The Turbine statistics menu shows the maximum energy production, water output and structure statistics.",
                "Furthermore, it shows which parts of the turbine are currently a limiting factor."
        );

        // Dynamic Tank Scenes
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
                "Right clicking anywhere on the Dynamic tank opens its UI, allowing you to see the total stored amount of the Fluid or Chemical and the total Capacity that the Tank can hold.",
                "In addition to that, it allows you to fill containers from the UI, and you can configure whether the Tank should only Fill itself, Empty itself, or both.",
                "To insert/extract Fluids or Chemicals, a Dynamic Valve can be used.",
                "Simply connect a transmitter of your choosing to the valve.",
                "To extract Fluids or Chemicals, the given transmitter must be set to pull from the valve."
        );


        // Induction Matrix Scenes
        addPonderTranslation(
                MekPonderScenes.CREATING_INDUCTION_MATRIX,
                "Creating an Induction Matrix",

                "The Induction Matrix is a Multiblock, capable of storing large amounts of energy.",
                "Building an Induction Matrix requires Induction Casings.",
                "It's a cuboid structure and its size can range from 3x3x3, to 18x18x18",
                "Inner sections can be replaced by either §6Structural Glass§r, §6Reactor Glass§r, or §6Induction Ports§r.",
                "Once constructed, the structure will emit Redstone particles to indicate its completion.",
                "For the Induction Matrix to store power, it requires an Induction Cell of any tier.",
                "Each Induction Cell provides the Induction Matrix with more total Capacity.",
                "To insert and extract any power out of the Induction Matrix, it needs an Induction Provider.",
                "Induction Providers allow you to add transfer Capacity to the Induction Matrix.",
                "The Induction Matrix has a UI, accessible by clicking anywhere on it while it's assembled.",
                "The UI provides information about the §6current amount of power stored§r, the §6total capacity§r, as well as the amount of energy being §6inserted§r and §6outputted§r.",
                "The transfer mode of a Induction Port can be configured using a Configurator.\n\nThis can toggle the port to either §4Output§r or §aInput§r mode.",
                "In §aInput§r mode, it is able to receive power from any source.",
                "In §4Output§r mode, you can extract power from the Induction Matrix."
        );

        // SPS Scenes
        addPonderTranslation(
                MekPonderScenes.CREATING_SPS,
                "Creating a Supercritical Phase Shifter",

                "The Supercritical Phase Shifter is a multiblock capable of converting Polonium into Antimatter by using large amounts of energy.",
                "Each side of the SPS is built in the same spherical way, with a fixed size of 7x7x7.",
                "Inner sections of the SPS can be replaced with Structural Glass, Reactor Glass, or SPS Ports.",
                "Once completed, the Multiblock will emit Redstone Particles to indicate its completion.",
                "To process Polonium, the SPS requires a Port placed in the center of one side, and on the inside of the SPS to have a Supercharged Coil placed on the Port.",
                "Each Port can accept up to 400MFE/t, which can produce 1mb of Antimatter per tick,\nwith the SPS being capped at producing 2mB of Antimatter per tick.",
                "The SPS will still use all the energy provided to it even if it doesnt have the required polonium to process antimatter at the highest speed.",
                "SPS Ports can be used to insert Energy and Polonium into the SPS.",
                "To extract Antimatter, the SPS Port mode needs to be switched to Output.",
                "By right clicking anywhere on the SPS, you can open the UI for it and see: \n- the Status of the SPS\n- the Energy Input,\n- the Process Rate,\n- the Progress,\n- as well as its 2 internal tanks for Polonium and Antimatter."
        );

        // TEP Scenes
        addPonderTranslation(
                MekPonderScenes.CREATING_THERMAL_EVAPORATION_PLANT,
                "Creating a Thermal Evaporation Plant",

                "The Thermal Evaporation Plant is a Multiblock capable of converting §6Water into Brine§r and §6Brine into§r §6Lithium§r.",
                "Its size can range from 4x3x4, up to 4x18x4",
                "Inner sections of the Multiblock can be replaced with §6Thermal§r §6Evaporation Valves§r and §6Structural§r §6Glass§r.",
                "Each Thermal Evaporation Plant requires a Thermal Evaporation Controller placed in its inner section.",
                "Once constructed, the Multiblock will emit Redstone particles to indicate its completion.",
                "The Thermal Evaporation Plant requires §6heat§r to function, with more heat also §6increasing the§r §6processing speed§r.",
                "Heat can be supplied through external means by using Thermal Evaporation Valves.",
                "The §6higher§r the Multiblock, the larger the §6capacity of internal§r §6tanks§r and §6maximum processing§r §6speed§r.\nIn addition to that, the heat required also rises.",
                "To insert fluid, any fluid transmitter can be connected to the Thermal Evaporation Valve.",
                "To extract Fluids, the fluid transmitter must be set to pull from the Thermal Evaporation Valve.",
                "Right Clicking the controller opens an UI providing information about:\n\n- whether the structure is §6formed§r\n- the §6height§r\n- the §6temperature§r\n- and the §6production rate§r in ticks.",
                "In addition to that, it provides slots to insert Fluid Handling items such as buckets or tanks, in order to extract from the internal fluid tanks.",
                "Optionally, Advanced Solar Generators can be used to increase the heat when they are able to generate energy."
        );

        // Boiler Scenes
        addPonderTranslation(
                MekPonderScenes.CREATING_THERMOELECTIC_BOILER,
                "Creating a Thermoelectric Boiler",

                "The Thermoelectric Boiler is a multiblock capable of producing large amounts of steam.",
                "It can be used to boil water into steam, or cool superheated sodium back down to sodium, using water and producing steam in the process.",
                "Its structure is made out of Boiler Casings.",
                "Its structure can range from 3x4x3 up to 18x18x18.",
                "Inner sections can be replaced with Structural Glass, Reactor Glass, or Boiler Valves",
                "Each Boiler requires Superheating Elements in its inner bottom layer section. All Superheating elements must be connected to eachother.\n\nEach layer adds to the total Water capacity.",
                "The layer with the Superheating Elements must be seperated by a layer made out of Pressure Dispersers.",
                "Above the layer of Pressure dispersers, you can leave additional layers to increase the capacity of the Steam layer.",
                "Once constructed, the Multiblock will emit Redstone particles to indicate its completion.",
                "Right clicking the Boiler anywhere opens its UI, allowing you to view its internal tanks and information about its status.",
                "The Boiler statistics screen shows various information about the Thermoelectric Boiler, including its Boil Capacity.",
                "Boiler Valves have 3 different configurations, which can be switched by using a Configurator on the Boiler Valve.",
                "1. Input Only\n\nThe Valve will only accept fluids, chemicals and heat.",
                "2. Output Steam\n\nThe Valve will only output Steam.",
                "3. Output Coolant\n\nThe valve will only output Coolant stored in its internal tank."
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
