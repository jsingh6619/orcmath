package simonGame;

import guiTeacher.interfaces.Visible;

public interface ProgressInterfaceJas extends Visible {

	void gameOver();
	int size();
	void setRound(int x);
	void setSequenceSize(int x);

}
