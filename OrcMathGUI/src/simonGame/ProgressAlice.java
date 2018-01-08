package simonGame;

import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressAlice extends Component implements ProgressInterfaceJas {
	
	private boolean gameOver;
	

	public ProgressAlice(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void gameOver() {
		gameOver = false;
	}

	@Override
	public void setRound(int x) {
		
	}

	@Override
	public void setSequenceSize(int x) {

	}

	@Override
	public void update(Graphics2D g) {
		
	}

	@Override
	public int size() {
		return 0;
	}



}
