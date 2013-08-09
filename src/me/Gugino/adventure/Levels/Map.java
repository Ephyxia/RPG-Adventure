package me.Gugino.adventure.Levels;

import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.Graphics;

public class Map {
	private ArrayList<Layer> layers;
	private ArrayList<MapObject> objects; ////
	private ArrayList<SpriteSheet> spriteSheets;

	public Map(String filePath) {

		layers = new ArrayList<Layer>();
		spriteSheets = new ArrayList<SpriteSheet>();

		long startTime = System.currentTimeMillis();

		String[] rawFile = FileHandler.getRawFile(filePath);

		boolean layerFound = false;
		boolean inLayer = false;
		boolean tileSetsFound = false;
		boolean inTilesets = false;
		boolean done = false;
		String[] imgPath = null;
		String[] pd = new String[10];
		String[] id = new String[10];
		String[] tileIds = null;

		try {
		while (!done) {
			for (int i = 0; i < rawFile.length; i++) {
				if (rawFile[i].trim().startsWith("\"layers\""))
					layerFound = true;
				if (rawFile[i].trim().startsWith("\"tilesets\""))
					tileSetsFound = true;

				if (layerFound) { // found layer tag
					if (rawFile[i].trim().startsWith("{")) { // found opening brace for a layer
						inLayer = true;
					}

					if (inLayer) { // in layer braces
						if (rawFile[i].trim().startsWith("\"data\"")) {
							tileIds = rawFile[i].split("\\[")[1].split("\\]")[0].split(",");
						} else if (rawFile[i].trim().startsWith("\"width\"")) {
							pd[0] = rawFile[i].split(":")[1].split(",")[0];
						} else if (rawFile[i].trim().startsWith("\"height\"")) {
							pd[1] = rawFile[i].split(":")[1].split(",")[0];
						} else if (rawFile[i].trim().startsWith("\"name\"")) {
							pd[2] = rawFile[i].split(":")[1].split(",")[0].split("\"")[1];
						}

						if (rawFile[i].trim().startsWith("}")) {
							inLayer = false;

							System.out.println("\nLayer added!");
							System.out.println("Width: " + pd[0]);
							System.out.println("Height: " + pd[1]);
							System.out.println("Name: " + pd[2]);
							System.out.println("Tiles: " + tileIds.length);
							layers.add(new Layer(pd[2], Integer.parseInt(pd[0]), Integer.parseInt(pd[1]), tileIds));

							if (rawFile[i].trim().startsWith("}]")) {
								layerFound = false;
							}
						}
					} // End inLayer
				} // End layerFound

				if (tileSetsFound) {
					if (rawFile[i].trim().startsWith("{")) { // found opening brace for a layer
						inTilesets = true;
					}

					if (inTilesets) {
						if (rawFile[i].trim().startsWith("\"firstgid\"")) {
							id[0] = rawFile[i].split(":")[1].split(",")[0];
						} else if (rawFile[i].trim().startsWith("\"image\"")) {
							id[1] = rawFile[i].split(":")[1].split(",")[0];
						}

						if (rawFile[i].startsWith("        }")) {
							inTilesets = false;
							spriteSheets.add(new SpriteSheet(id[1].split("\"")[1].replace("\\/", "/").replace("..", "res"), 64, 64, Integer.parseInt(id[0])));
							System.out.println("Spritesheet " + id[1] + " added.");
						}

						if (rawFile[i].trim().startsWith("}]")) {
							tileSetsFound = false;
						}
					}
				}

				if (rawFile[i].startsWith("}")) {
					done = true;
				}
			}
		}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		long finishTime = System.currentTimeMillis();
		System.out.println("\n load time = " + (finishTime - startTime) + "ms.");
	}

	public void renderAll(Graphics g) {
		for (Layer l : layers) {
			l.RenderAll(g);
		}
	}

	public void renderPortion(int sx, int sy, int width, int height) {
		for (Layer l : layers) {
			l.renderPortion(sx, sy, width, height, spriteSheets);
		}
	}

	public void renderPortion(int sx, int sy, int width, int height, float xOff, float yOff) {
		for (Layer l : layers) {
			l.renderPortionWithOffset(sx, sy, width, height, xOff, yOff, spriteSheets);
		}
	}

	public void renderLayerFull(Graphics g, int index) {
		layers.get(index).RenderAll(g);
	}

	public int getWidth() {
		return layers.get(0).getWidth();
	}
}
