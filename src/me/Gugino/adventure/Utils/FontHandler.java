package me.Gugino.adventure.Utils;

import java.awt.Font;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;

public class FontHandler {

	public static TrueTypeFont s12 = getFont(12);
	public static TrueTypeFont s18 = getFont(16);
	public static TrueTypeFont s24 = getFont(24);
	public static TrueTypeFont s32 = getFont(32);
	public static TrueTypeFont s48 = getFont(48);

	public static TrueTypeFont getFont(int size) {
		Font font = new Font("Times New Roman", Font.BOLD, size);
		TrueTypeFont ttf = new TrueTypeFont(font, true);
		return ttf;
	}
}
