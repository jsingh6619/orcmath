package simonGame;

import guiTeacher.GUIApplication;

public class SimonGameJas extends GUIApplication {

	public SimonGameJas(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		SimonScreenJas play = new SimonScreenJas(getWidth(), getHeight());
		setScreen(play);
	}

	public static void main(String[] args) {
		SimonGameJas g = new SimonGameJas(800, 500);
		Thread t = new Thread(g);
		t.start();
	}

}
