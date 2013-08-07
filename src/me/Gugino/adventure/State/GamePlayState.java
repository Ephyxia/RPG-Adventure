package me.Gugino.adventure.State;

import me.Gugino.adventure.Entities.EntityPlayer;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class GamePlayState extends GameState  {

	private int mx;
	private int my;
	
	private Image bg;
	
	private TiledMap map;
	
	public static EntityPlayer player;

	public GamePlayState() {
		super(StateManager.GAMEPLAY_STATE);
	}

	@Override
	public void Init() {
		player = new EntityPlayer(5, 5);
		
		try {
			bg = new Image("res/images/strips/testBG.png");
			map = new TiledMap("res/maps/test.tmx");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Update(int delta, Input input) {
		mx = input.getMouseX();
		my = input.getMouseY();
		
		player.update(delta, input);
	}

	@Override
	public void Render(Graphics g) {
//		map.render(0, 0);
//		map.render(0, 0, 0, 0, 22, 14);
		map.render(0, 0, 0, 0, 22, 14, 0, false); // Render ground layer
		map.render(0, 0, 0, 0, 22, 14, 1, false); // Render objects layer
		player.render(g);
	}
}
