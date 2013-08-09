package me.Gugino.adventure.Levels;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpriteSheet {

	private Image[][] subImages;

	private int numTilesX;
	private int numTilesY;
	
	private int firstGID;

	public SpriteSheet(String path, int tileWidth, int tileHeight, int gid) {

		this.firstGID = gid;
		
		Image img = null;
		try {
			img = new Image(path);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		int imgWidth = img.getWidth();
		int imgHeight = img.getHeight();

		numTilesX = (int) Math.floor(imgWidth / tileWidth);
		numTilesY = (int) Math.floor(imgHeight / tileHeight);

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
