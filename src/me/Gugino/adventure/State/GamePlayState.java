package me.Gugino.adventure.State;

import me.Gugino.adventure.Entities.EntityPlayer;
import me.Gugino.adventure.Levels.Map;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class GamePlayState extends GameState {

	private int mx;
	private int my;

	private int mapTileXStart = 0;
	private int mapTileYStart = 0;

	private boolean renderGround = true;
	private boolean renderObjects = true;

	//	private TiledMap map;
	private Map map;

	public static EntityPlayer player;

	public GamePlayState() {
		super(StateManager.GAMEPLAY_STATE);
	}

	@Override
	public void Init() {
		player = new EntityPlayer(175, 47);

		map = new Map("res/maps/test2.json");
	}

	@Override
	public void Update(int delta, Input input) {
		mx = input.getMouseX();
		my = input.getMouseY();

		if (input.isKeyPressed(Input.KEY_NUMPAD0)) {
			renderGround = !renderGround;
		}
		if (input.isKeyPressed(Input.KEY_NUMPAD1)) {
			renderObjects = !renderObjects;
		}
		if (input.isKeyPressed(Input.KEY_NUMPAD2)) {
			map = new Map("res/maps/test2.json");
		}

		player.update(delta, input);

		updateTileRenderStart();
	}

	private void updateTileRenderStart() {
		mapTileXStart = (int) Math.floor(Camera.xOff / 64);
		mapTileYStart = (int) Math.floor(Camera.yOff / 64);

		if (mapTileXStart < 0) {
			mapTileXStart = 0;
		}
		if (mapTileXStart >= map.getWidth() - 21) { // 25 less
			mapTileXStart = map.getWidth() - 21;
		}
		
		if (mapTileYStart < 0) {
			mapTileYStart = 0;
		}
		if (mapTileYStart >= map.getWidth() - 13) { // 13 less
			mapTileYStart = map.getWidth() - 13;
		}
	}

	@Override
	public void Render(Graphics g) {
		map.renderPortion(mapTileXStart, mapTileYStart, 21, 13, Camera.xOff, Camera.yOff);

		g.setColor(Color.white);
		
		g.drawString("TileX start " + mapTileXStart, 10, 64);
		g.drawString("TileY start: " + mapTileYStart, 10, 80);
		g.drawString("Camera xOffset: " + Camera.xOff, 10, 96);
		g.drawString("Camera yOffset: " + Camera.yOff, 10, 112);
		g.drawString("Player X: " + player.getX(), 10, 128);
		g.drawString("Player Y: " + player.getY(), 10, 144);

		player.render(g);
	}
}
