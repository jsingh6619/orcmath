package simonGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonJas extends Button implements ButtonInterfaceJas {

	private Color colour;
	
	public ButtonJas(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h,"",null);
		update();
	}

	public void setColor(Color color) {
		colour = color;
		this.setBackground(colour);
		update();
	}

	public void highlight() {
		this.setBackground(Color.WHITE);
		update();
	}

	public void dim() {
		this.setBackground(colour);
		update();
	}
}
