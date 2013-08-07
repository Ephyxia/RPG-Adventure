package me.Gugino.adventure.Levels;

import java.util.ArrayList;

public class Layer {

	private Tile[][] tiles;
	
	private String name;
	
	private int width;
	private int height;

	public Layer(String name, int width, int height, String[] tileIds) {
		tiles = new Tile[height][width];

		for (int i = 0; i <= tiles.length - 1; i++) {
			for (int j = 0; j <= tiles[0].length - 1; j++) {
				int id = Integer.parseInt(tileIds[(i * 64) + j].trim());
				tiles[i][j] = new Tile(id);
			}
		}
	}
}
