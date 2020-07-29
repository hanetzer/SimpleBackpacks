package org.sweetiebelle.simplebackpacks.client.screen;

import org.sweetiebelle.simplebackpacks.common.BackpackType;
import org.sweetiebelle.simplebackpacks.common.container.BackpackContainer;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public class BackpacksScreen extends ContainerScreen<BackpackContainer> {

    private BackpackType backpackType;
    private int textureXSize;
    private int textureYSize;

    public BackpacksScreen(BackpackContainer container, PlayerInventory playerInventory, ITextComponent title) {
        super(container, playerInventory, title);

        this.backpackType = container.getChestType();
        this.xSize = backpackType.xSize;
        this.ySize = backpackType.ySize;
        this.textureXSize = backpackType.textureXSize;
        this.textureYSize = backpackType.textureYSize;

        this.passEvents = false;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.font.drawString(this.title.getFormattedText(), 8.0F, 6.0F, 4210752);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.minecraft.getTextureManager().bindTexture(this.backpackType.guiTexture);

        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;

        blit(x, y, 0, 0, this.xSize, this.ySize, this.textureXSize, this.textureYSize);
    }

}
