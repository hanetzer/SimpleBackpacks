package org.sweetiebelle.ironbackpacks.common;

import java.util.Locale;

import javax.annotation.Nullable;

import org.sweetiebelle.ironbackpacks.IronBackpacks;
import org.sweetiebelle.ironbackpacks.common.item.BackpackItems;
import org.sweetiebelle.ironbackpacks.common.item.ItemBackpack;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;

public enum BackpackType implements IStringSerializable {

    LEATHER("leather_backpack", 18, 9, 175, 149, new ResourceLocation(IronBackpacks.MODID, "textures/gui/leather_container.png"), 256, 256),
    IRON("iron_backpack", 36, 9, 175, 185, new ResourceLocation(IronBackpacks.MODID, "textures/gui/iron_container.png"), 256, 256),
    GOLD("gold_backpack", 54, 9, 175, 221, new ResourceLocation(IronBackpacks.MODID, "textures/gui/gold_container.png"), 256, 256),
    DIAMOND("diamond_backpack", 77, 11, 219, 239, new ResourceLocation(IronBackpacks.MODID, "textures/gui/diamond_container.png"), 256, 256);

    public String name;
    public int size;
    public int rowLength;
    public int xSize;
    public int ySize;
    public ResourceLocation guiTexture;
    public int textureXSize;
    public int textureYSize;

    BackpackType(int size, int rowLength, int xSize, int ySize, ResourceLocation guiTexture, int textureXSize, int textureYSize) {
        this(null, size, rowLength, xSize, ySize, guiTexture, textureXSize, textureYSize);
    }

    BackpackType(@Nullable String name, int size, int rowLength, int xSize, int ySize, ResourceLocation guiTexture, int textureXSize, int textureYSize) {
        this.name = name == null ? name() : name;
        this.size = size;
        this.rowLength = rowLength;
        this.xSize = xSize;
        this.ySize = ySize;
        this.guiTexture = guiTexture;
        this.textureXSize = textureXSize;
        this.textureYSize = textureYSize;
    }

    public String getId() {
        return name().toLowerCase(Locale.ROOT);
    }

    public String getEnglishName() {
        return name;
    }

    @Override
    public String getName() {
        return getEnglishName();
    }

    public int getRowCount() {
        return size / rowLength;
    }
    
    @Nullable
    public static ItemBackpack get(BackpackType type) {
        switch (type) {
            case LEATHER:
                return BackpackItems.LEATHER_BACKPACK.get();
            case IRON:
                return BackpackItems.IRON_BACKPACK.get();
            case GOLD:
                return BackpackItems.GOLD_BACKPACK.get();
            case DIAMOND:
                return BackpackItems.DIAMOND_BACKPACK.get();
            default:
                return null;
        }
    }
}
