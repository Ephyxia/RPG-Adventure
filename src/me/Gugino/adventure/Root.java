package me.Gugino.adventure;

import me.Gugino.adventure.State.StateManager;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Root extends BasicGame {

	public static final String title = "RPG Adventure!";
	public static final int width = 1280;
	public static final int height = 768;
	
	public Root() {
		super(title);
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Root());

		app.setDisplayMode(width, height, false);
		app.setAlwaysRender(true);
		app.setUpdateOnlyWhenVisible(false);
//		app.setTargetFrameRate(60);
		app.start();
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		StateManager.Init();

//		StateManager.enterState(StateManager.MAIN_MENU_STATE);
		StateManager.enterState(StateManager.GAMEPLAY_STATE);
		
//		Map.loadMap("res/maps/test.lua");
		
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		Input input = gc.getInput();
		StateManager.UpdateCurrentState(delta, input);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.setBackground(Color.darkGray);
		StateManager.RenderCurrentState(g);

		drawDebug(g);
	}

	private void drawDebug(Graphics g) {
		g.setColor(Color.decode("#0080ff"));
	}
}
