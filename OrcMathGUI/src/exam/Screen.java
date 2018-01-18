package exam;

import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class Screen extends FullFunctionScreen {

	public int count;
	
	public Screen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		count = 0;
		TextArea text = new TextArea(450, 100, 200, 100, "");
		viewObjects.add(text);
		
		Button win = new Button(100,100,100,30,"Win",new Action() {
			public void act() {
				if(count == 0) {
					text.setText("You Win.");
					count++;
				}
			}
		});
		viewObjects.add(win);
		
		Button lose = new Button(300,100,100,30,"Lose",new Action() {
			public void act() {
				if(count == 0) {
					text.setText("You lose.");
					count++;
				}
			}
		});
		viewObjects.add(lose);
	}

}
