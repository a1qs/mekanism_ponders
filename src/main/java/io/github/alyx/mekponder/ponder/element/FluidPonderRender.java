package io.github.alyx.mekponder.ponder.element;

import mekanism.client.gui.GuiUtils;
import mekanism.client.render.MekanismRenderer;
import net.createmod.catnip.gui.element.ScreenElement;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fluids.FluidStack;

public class FluidPonderRender implements ScreenElement {
    private final FluidStack stack;
    private final TextureAtlasSprite sprite;

    public FluidPonderRender(FluidStack stack) {
        this.stack = stack;
        this.sprite = MekanismRenderer.getFluidTexture(stack, MekanismRenderer.FluidTextureType.STILL);
    }

    @Override
    public void render(GuiGraphics graphics, int x, int y) {
        MekanismRenderer.color(graphics, stack);
        GuiUtils.drawTiledSprite(graphics, x, y, 16, 16, 16, sprite, 16, 16, 0, GuiUtils.TilingDirection.DOWN_LEFT);
        MekanismRenderer.resetColor(graphics);
    }
}
