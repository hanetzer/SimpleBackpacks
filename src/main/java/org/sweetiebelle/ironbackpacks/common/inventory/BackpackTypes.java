package org.sweetiebelle.ironbackpacks.common.inventory;

import java.util.Locale;

import javax.annotation.Nullable;

import org.sweetiebelle.ironbackpacks.common.items.ItemBackpack;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;

public enum BackpackTypes implements IStringSerializable {

	LEATHER(18, 9, 0, 0, null, 0, 0), IRON(0, 0, 0, 0, null, 0, 0), GOLD(0, 0, 0, 0, null, 0, 0), DIAMOND(0, 0, 0, 0, null, 0, 0);

	public String name;
	public int size;
	public int rowLength;
	public int xSize;
	public int ySize;
	public ResourceLocation guiTexture;
	public int textureXSize;
	public int textureYSize;

	BackpackTypes(int size, int rowLength, int xSize, int ySize, ResourceLocation guiTexture, int textureXSize,
			int textureYSize) {
		this(null, size, rowLength, xSize, ySize, guiTexture, textureXSize, textureYSize);
	}

	BackpackTypes(@Nullable String name, int size, int rowLength, int xSize, int ySize, ResourceLocation guiTexture,
			int textureXSize, int textureYSize) {
		this.name = name == null ? this.name() : name;
		this.size = size;
		this.rowLength = rowLength;
		this.xSize = xSize;
		this.ySize = ySize;
		this.guiTexture = guiTexture;
		this.textureXSize = textureXSize;
		this.textureYSize = textureYSize;
	}

	public String getId() {
		return this.name().toLowerCase(Locale.ROOT);
	}

	public String getEnglishName() {
		return this.name;
	}

	@Override
	public String getName() {
		return getEnglishName();
	}

	public int getRowCount() {
		return this.size / this.rowLength;
	}

	public static ItemBackpack get(BackpackTypes type) {
		switch (type) {
		case LEATHER:
			return null;
		case IRON:
			return null;
		case GOLD:
			return null;
		case DIAMOND:
			return null;
		default:
			return null;
		}
	}
}
