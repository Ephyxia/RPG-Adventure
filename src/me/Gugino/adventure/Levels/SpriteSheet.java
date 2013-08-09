package me.Gugino.adventure.Levels;

import org.newdawn.slick.Image;

public class SpriteSheet {

	private Image[][] subImages;

	private int numTilesX;
	private int numTilesY;

	public SpriteSheet(Image img, int tileWidth, int tileHeight) {

		int imgWidth = img.getWidth();
		int imgHeight = img.getHeight();

		numTilesX = (int) Math.floor(imgWidth / tileWidth);
		numTilesY = (int) Math.floor(imgHeight / tileHeight);

		System.out.println("SpriteSheet X Tiles: " + numTilesX);
		System.out.println("SpriteSheet Y Tiles: " + numTilesY);

		subImages = new Image[numTilesY][numTilesX];

		for (int i = 0; i < numTilesY; i++) {
			for (int j = 0; j < numTilesX; j++) {
				subImages[i][j] = img.getSubImage(j * tileWidth, i * tileHeight, tileWidth, tileHeight);
			}
		}
	}

	public Image[][] getSubImages() {
		return subImages;
	}

	public int getNumTilesX() {
		return numTilesX;
	}

	public int getNumTilesY() {
		return numTilesY;
	}
}
