package io.github.alyx.mekponder.ponder.element;

import mekanism.api.chemical.ChemicalStack;
import mekanism.client.gui.GuiUtils;
import mekanism.client.render.MekanismRenderer;
import net.createmod.catnip.gui.element.ScreenElement;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class ChemicalPonderRender implements ScreenElement {
    private final ChemicalStack stack;
    private final TextureAtlasSprite sprite;

    public ChemicalPonderRender(ChemicalStack stack) {
        this.stack = stack;
        this.sprite = MekanismRenderer.getChemicalTexture(stack.getChemical());
    }

    @Override
    public void render(GuiGraphics graphics, int x, int y) {
        MekanismRenderer.color(graphics, stack);
        GuiUtils.drawTiledSprite(graphics, x, y, 16, 16, 16, sprite, 16, 16, 0, GuiUtils.TilingDirection.DOWN_LEFT);
        MekanismRenderer.resetColor(graphics);
    }
}
