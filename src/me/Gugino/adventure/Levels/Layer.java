package me.Gugino.adventure.Levels;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Layer {

	private Tile[][] tiles;

	private String name;

	private int width;
	private int height;

	private SpriteSheet spriteSheet;

	public Layer(String name, int width, int height, String[] tileIds) {
		this.width = width;
		this.height = height;
		this.name = name;
		tiles = new Tile[height][width];

		for (int i = 0; i <= tiles.length - 1; i++) {
			for (int j = 0; j <= tiles[0].length - 1; j++) {
				int id = Integer.parseInt(tileIds[(i * height) + j].trim());
				tiles[i][j] = new Tile(id);
			}
		}
	}

	//	public void setSpriteSheet(String path) {
	//		this.spriteSheet = new SpriteSheet(path, 64, 64);
	//	}

	public void RenderAll(Graphics g) {
		for (int i = 0; i < tiles.length; i++) { // cols
			for (int j = 0; j < tiles[0].length; j++) { // rows
				int xt;
				int yt;

				if (tiles[i][j].getTileID() != 0) {
					xt = tiles[i][j].getTileID() % 16 - 1;
					yt = (int) Math.floor(tiles[i][j].getTileID() / 16);

					spriteSheet.getSubImages()[yt][xt].draw(j * 64, i * 64);
				}
			}
		}
	}

	public String getName() {
		return name;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void renderPortion(int sx, int sy, int rWidth, int rHeight, ArrayList<SpriteSheet> sh) {
		renderPortionWithOffset(sx, sy, rWidth, rHeight, 0, 0, sh);
	}

	public void renderPortionWithOffset(int sx, int sy, int rWidth, int rHeight, float xOff, float yOff, ArrayList<SpriteSheet> sh) {
		for (int i = sy; i < rHeight + sy; i++) { // cols
			for (int j = sx; j < rWidth + sx; j++) { // rows
				int xt;
				int yt;

				if (tiles[i][j].getTileID() != 0) {
					if (tiles[i][j].getTileID() < 1025) {
						xt = tiles[i][j].getTileID() % sh.get(0).getNumTilesX() - 1;
						yt = (int) Math.floor(tiles[i][j].getTileID() / sh.get(0).getNumTilesY());

						sh.get(0).getSubImages()[yt][xt].draw((j * 64) - (int) xOff, (i * 64) - (int) yOff);
					} else if(tiles[i][j].getTileID() >= 1025) {
						xt = (tiles[i][j].getTileID() - 1024) % sh.get(1).getNumTilesX() - 1;
						yt = (int) Math.floor((tiles[i][j].getTileID() - 1024) / sh.get(1).getNumTilesY());

						sh.get(1).getSubImages()[yt][xt].draw((j * 64) - (int) xOff, (i * 64) - (int) yOff);
					}
				}
			}
		}
	}
}
