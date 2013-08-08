package me.Gugino.adventure.Levels;

import org.newdawn.slick.Image;

public class SpriteSheet {

	private Image[][] subImages;

	public SpriteSheet(Image img, int tileWidth, int tileHeight) {

		int imgWidth = img.getWidth();
		int imgHeight = img.getHeight();

		int numTilesX = (int) Math.floor(imgWidth / tileWidth);
		int numTilesY = (int) Math.floor(imgHeight / tileHeight);
		
		subImages = new Image[numTilesY][numTilesX];

		for (int i = 0; i < numTilesY; i++) {
			for (int j = 0; j < numTilesX; j++) {
				subImages[i][j] = img.getSubImage(j * tileWidth, i * tileHeight, tileWidth, tileHeight);
			}
		}
	}
	public Image[][] getSubImages() {return subImages;}
}
