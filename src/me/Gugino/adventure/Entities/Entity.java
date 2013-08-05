package me.Gugino.adventure.Entities;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Entity {
	
	protected float x;
	protected float y;
	protected int width;
	protected int height;
	
	public Entity(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void Update(Input input, int delta) {
		
	}

	public void Render(Graphics g) {
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
