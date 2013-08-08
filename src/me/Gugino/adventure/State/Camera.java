package me.Gugino.adventure.State;

public class Camera {
	public static float xOff = 0;
	public static float yOff = 0;
	
	public Camera(float xOff, float yOff) {
		Camera.xOff = xOff;
		Camera.yOff = yOff;
	}
	
	public float getXOff(){return xOff;}
	public float getYOff(){return yOff;}
}
