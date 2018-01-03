package simonGame;

import java.awt.*;
import java.util.*;

import guiTeacher.components.*;
import guiTeacher.interfaces.*;
import guiTeacher.userInterfaces.*;

public class SimonScreenJas extends ClickableScreen implements Runnable {

	private TextLabel label;
	private ButtonInterfaceJas[] buttonFace;
	private ProgressInterfaceJas progressFace;
	private ArrayList<MoveInterfaceJas> moveFace;
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreenJas(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	public void run() {

	}

	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceJas b: buttonFace){ 
		    viewObjects.add(b); 
		}
		progressFace = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		moveFace = new ArrayList<MoveInterfaceJas>();
		//add 2 moves to start
		lastSelectedButton = -1;
		moveFace.add(randomMove());
		moveFace.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progressFace);
		viewObjects.add(label);
	}

	/*
	 * not sure about the Color[] Part 2.2
	 */
	private void addButtons() {
		int numberOfButtons = 5;
		buttonFace = new ButtonInterfaceJas[numberOfButtons];
		Color[] colours = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.GRAY};
		for(int i = 0; i < numberOfButtons; i++) {
			ButtonInterfaceJas b = getAButton();
			buttonFace[i] = b;
			b.setColor(colours[i]);
			b.setX();
			b.setY();
		}
	}
	
	/**
	Placeholder until partner finishes implementation of ButtonInterface
	*/
	private ButtonInterfaceJas getAButton() {
		return null;
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceJas getProgress() {
		return null;
	}

	private MoveInterfaceJas randomMove() {
		int bIndex = (int)(Math.random() * buttonFace.length);
		while(bIndex == lastSelectedButton){
			bIndex = (int)(Math.random() * buttonFace.length);
		}
		return getMove(bIndex);
	}
	
	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	private MoveInterfaceJas getMove(int bIndex) {
		return null;
	}
}
