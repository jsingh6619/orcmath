package jasStuff;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPlayer.CustomLabel;
import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button implements CustomLabel {

	private String text;
	private String text2;
	private Color colour;

	public CustomButton(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		// TODO Auto-generated constructor stub
	}

	public void drawButton(Graphics2D g, boolean hover) {
		g.setColor(Color.BLACK);
		g.drawString(text, , );
	}

	public void updateString1(String string) {
		text = string;	
	}

	public void updateString2(String string) {
		text2 = string;
	}

	public void setIconColor(Color color) {
		colour = color;
	}

}