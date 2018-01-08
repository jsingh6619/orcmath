package simonGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonAlice extends Button implements ButtonInterfaceJas {

	public ButtonAlice(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h,"",null);
	}

	@Override
	public void setColor(Color color) {

		this.setBackground(Color.blue);
		
	}

	@Override
	public void highlight() {
		
		this.setBackground(Color.yellow);
		
		
	}

	@Override
	public void dim() {
		this.setBackground(Color.gray);		
	}

	


}
