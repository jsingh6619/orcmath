package simonGame;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressJas extends Component implements ProgressInterfaceJas {
	
	private boolean gameOver;
	private int roundNumber;
	private int seqNumber;

	public ProgressJas() {
		super(200, 150, 350, 350);
	}

	public void gameOver() {
		gameOver = true;
		update();
	}

	public void setRound(int x) {
		roundNumber = x;
		update();
	}

	public void setSequenceSize(int x) {
		seqNumber = x;
		update();
	}

	public void update(Graphics2D g) {
		clear();
		if(gameOver) {
			g.setColor(Color.RED);
			g.drawString("Round: " + roundNumber, 20, 55);
			g.drawString("Current Sequence Length: " + seqNumber, 20,100);
			g.drawString("You lost", 20, 150);
		}else {
			g.setColor(Color.GRAY);
			g.drawString("Round: " + roundNumber, 20, 55);
			g.drawString("Current Sequence Length: " + seqNumber, 20, 100);
		}

	}
}
