package io.github.alyx.mekponder.datagen;

import io.github.alyx.mekponder.MekanismPonders;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class MekPonderLanguageProvider extends LanguageProvider {
    public MekPonderLanguageProvider(PackOutput output) {
        super(output, MekanismPonders.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
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
