package me.Gugino.adventure.State;

import me.Gugino.adventure.Entities.EntityPlayer;
import me.Gugino.adventure.Levels.Map;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class GamePlayState extends GameState {

	private int mx;
	private int my;
	
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
		player = new EntityPlayer(5, 5);

		map = new Map("res/maps/test.json");
	}

	@Override
	public void Update(int delta, Input input) {
		mx = input.getMouseX();
		my = input.getMouseY();

		if(input.isKeyPressed(Input.KEY_NUMPAD0)) {
			renderGround = ! renderGround;
		}
		if(input.isKeyPressed(Input.KEY_NUMPAD1)) {
			renderObjects = ! renderObjects;
		}
		if(input.isKeyPressed(Input.KEY_NUMPAD2)) {
			StateManager.enterState(StateManager.GAMEPLAY_STATE);
		}
		
		player.update(delta, input);
	}

	@Override
	public void Render(Graphics g) {
		//		map.Render(g);
//		if (renderGround)
//			map.renderLayerFull(g, 0);
//		if (renderObjects)
//			map.renderLayerFull(g, 1);
//		
		map.renderPortion(0, 0, 21, 14);
		
		player.render(g);
	}
}
