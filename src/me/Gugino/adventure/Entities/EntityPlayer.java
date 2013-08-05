package me.Gugino.adventure.Entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class EntityPlayer extends Entity {

	protected static int width = 48;
	protected static int height = 96;

	protected float speed = 2f;

	protected float dx = 0, dy = 0;
	protected int tx = 0, ty = 0;

	boolean moving = false;

	public EntityPlayer(int x, int y) {
		super(x, y);
	}

	public void update(int delta, Input input) {
		move(delta, input);
	}

	private void move(int delta, Input input) {

		if (!moving) {

			tx = (int) x;
			ty = (int) y;

			if (input.isKeyDown(Input.KEY_W)) {
				dy = -speed;
				ty = (int) (y - 48);
				moving = true;
			} else if (input.isKeyDown(Input.KEY_S)) {
				dy = speed;
				ty = (int) (y + 48);
				moving = true;
			}

			if (input.isKeyDown(Input.KEY_A)) {
				dx = -speed;
				tx = (int) (x - 48);
				moving = true;
			} else if (input.isKeyDown(Input.KEY_D)) {
				dx = speed;
				tx = (int) (x + 48);
				moving = true;
			}
		} else {
			x += dx;
			y += dy;

			if (dy > 0 && y > ty) {
				if(input.isKeyDown(Input.KEY_S)) {
					ty += 48;
				} else {
					y = ty;
					dy = 0;
					moving = false;
				}

			} else if (dy < 0 && y < ty) {
				if(input.isKeyDown(Input.KEY_W)) {
					ty -= 48;
				} else {
					y = ty;
					dy = 0;
					moving = false;
				}
			}
			
			if (dx > 0 && x > tx) {
				if(input.isKeyDown(Input.KEY_D)) {
					tx += 48;
				} else {
					x = tx;
					dx = 0;
					moving = false;
				}
			} else if (dx < 0 && x < tx) {
				if(input.isKeyDown(Input.KEY_A)) {
					tx -= 48;
				} else {
					x = tx;
					dx = 0;
					moving = false;
				}
			}
		}

	}

	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		g.setColor(Color.red);
		g.fillRect(x + 1, y + 1, width - 2, height - 2);
		g.drawString("Moving: " + moving + " tt: " + ty, 10, 32);
	}

}
