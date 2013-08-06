package me.Gugino.adventure.State;

import me.Gugino.adventure.Entities.EntityPlayer;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class GamePlayState extends GameState  {

	private int mx;
	private int my;
	
	private Image bg;
	
	public static EntityPlayer player;

	public GamePlayState() {
		super(StateManager.GAMEPLAY_STATE);
	}

	@Override
	public void Init() {
		player = new EntityPlayer(480, 480);
		
		try {
			bg = new Image("res/images/strips/testBG.png");
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
		bg.draw(0,-24);
		player.render(g);
	}
}
