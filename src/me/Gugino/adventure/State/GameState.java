package me.Gugino.adventure.State;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import Interfaces.IRender;
import Interfaces.IUpdate;

public class GameState {

	protected int stateID;
	
	public GameState (int stateID) {
		this.stateID = stateID;
	}
	
	public void Init() {
		
	}
	
	public void Update(int delta, Input input) {
		
	}
	
	public void Render(Graphics g) {
		
	}
	
	public void Exit() {
		
	}
}
