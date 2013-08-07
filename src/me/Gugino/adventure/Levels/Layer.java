package me.Gugino.adventure.Levels;

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
				int id = Integer.parseInt(tileIds[(i * 64) + j].trim());
				tiles[i][j] = new Tile(id);
			}
		}
	}

	public void setSpriteSheet(String path) {
		try {
			Image ph = new Image(path);
			this.spriteSheet = new SpriteSheet(ph, 64, 64);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void RenderAll(Graphics g) {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				int xt;
				int yt;

				xt = tiles[i][j].getTileID() % width;
				yt = (int) Math.floor(tiles[i][j].getTileID() / height);
			}
		}
	}

	public String getName() {return name;}

}
