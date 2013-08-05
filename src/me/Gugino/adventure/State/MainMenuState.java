package me.Gugino.adventure.State;

import java.util.logging.FileHandler;

import me.Gugino.adventure.Utils.FontHandler;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class MainMenuState extends GameState {

	private int menuPos = 0;

	private String[] menuItems;

	public float oggLength = 0;

	public MainMenuState() {
		super(StateManager.MAIN_MENU_STATE);
		menuItems = new String[] { "Play Game", "Highscores", "Options", "Quit" };
	}

	@Override
	public void Init() {
		
	}

	@Override
	public void Update(int delta, Input input) {

	}

	@Override
	public void Render(Graphics g) {
		g.setFont(FontHandler.s32);
		
		for (int i = 0; i < menuItems.length; i++) {
			g.setColor(Color.white);
			g.drawString(menuItems[i], 300, 200 + (64 * i));
		}
	}

	@Override
	public void Exit() {
		
	}
}
