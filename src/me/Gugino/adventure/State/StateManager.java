package me.Gugino.adventure.State;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class StateManager {
	public static final int MAIN_MENU_STATE = 0;
	public static final int GAMEPLAY_STATE = 1;

	public static int currentState;

	public static ArrayList<GameState> states;

	public static void Init() {
		currentState = 1;

		states = new ArrayList<GameState>();

		states.add(new MainMenuState());
		states.add(new GamePlayState());
	}

	public static void UpdateCurrentState(int delta, Input input) {
		states.get(currentState).Update(delta, input);
	}

	public static void RenderCurrentState(Graphics g) {
		states.get(currentState).Render(g);
	}

	public static void enterState(int i) {
		if (!(currentState == i))
			states.get(currentState).Exit();
		currentState = i;
		states.get(currentState).Init();
	}
}
