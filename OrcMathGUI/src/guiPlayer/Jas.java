package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Jas extends AnimatedComponent {

	public Jas() {
		super(40, 40, 200, 150);
		addSequence("resources/dog.png", 100, 0, 66, 89, 54, 6);
		Thread animation = new Thread(this);
		animation.start();
		update();
	}

	public void update(Graphics2D g) {
//		g.setColor(Color.GRAY);
//		g.fillRect(0, 0, getWidth(), getHeight());
		super.update(g);
	}

}
