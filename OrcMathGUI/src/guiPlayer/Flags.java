package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Flags extends Component {

	private String country;
	private int year;
	
	public Flags(String country, int year) {
		super(40, 40, 200, 150);
		this.country = country;
		this.year = year;
		update();
	}

	public void update(Graphics2D g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	public String toString() {
		return country + "," + year;
	}
}
