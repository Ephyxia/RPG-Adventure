package me.Gugino.adventure.State;

import me.Gugino.adventure.Entities.EntityPlayer;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class GamePlayState extends GameState  {

	private int mx;
	private int my;
	
	public static EntityPlayer player;

	public GamePlayState() {
		super(StateManager.GAMEPLAY_STATE);
	}

	@Override
	public void Init() {
		player = new EntityPlayer(480, 480);
	}

	@Override
	public void Update(int delta, Input input) {
		mx = input.getMouseX();
		my = input.getMouseY();
		
		player.update(delta, input);
	}

	@Override
	public void Render(Graphics g) {
		player.render(g);
	}
}
