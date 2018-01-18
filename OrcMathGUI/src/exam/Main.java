package exam;

import guiTeacher.GUIApplication;

public class Main extends GUIApplication {

	public static Main main;
	
	public Main(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		setScreen(new Screen(getWidth(), getHeight()));
	}

	public static void main(String[] args) {
		main = new Main(800, 500);
		Thread runner = new Thread(main);
		runner.start();
	}

}
