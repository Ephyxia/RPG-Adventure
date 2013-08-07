package me.Gugino.adventure.Levels;

import java.util.ArrayList;

import org.newdawn.slick.tiled.TileSet;

public class Map {
	private ArrayList<Layer> layers;
	private ArrayList<MapObject> objects;

	public Map(String filePath) {

		layers = new ArrayList<Layer>();

		long startTime = System.currentTimeMillis();

		String[] rawFile = FileHandler.getRawFile(filePath);

		boolean layerFound = false;
		boolean inLayer = false;
		boolean done = false;
		String imgPath = null;
		String[] pd = new String[10];
		String[] tileIds = null;
		//		String[] tileIds = new String[4096];
		ArrayList<String[]> layerPH = new ArrayList<String[]>();

		while (!done) {
			for (int i = 0; i < rawFile.length; i++) {
				if (rawFile[i].trim().startsWith("\"layers\""))
					layerFound = true;

				if (layerFound) {
					if (rawFile[i].trim().startsWith("{")) { // found opening brace for a layer
						inLayer = true;
					}

					if (inLayer) {
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

				if (rawFile[i].trim().startsWith("\"image\"")) {
					imgPath = rawFile[i].split("\"")[3].replace("\\/", "/").replace("..", "res");
				}

				if (rawFile[i].startsWith("}")) {
					done = true;
				}
			}
		}

		for (Layer e : layers) {
			e.setSpriteSheet(imgPath);
			System.out.println("Attached spritesheet " + imgPath + " to layer " + e.getName());
		}
		
		System.out.println(layers.get(0).getName());

		long finishTime = System.currentTimeMillis();
		System.out.println("\n load time = " + (finishTime - startTime) + "ms.");
	}
}
