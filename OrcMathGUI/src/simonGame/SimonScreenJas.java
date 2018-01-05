package simonGame;

import java.awt.*;
import java.util.*;
import java.util.List;

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
		label.setText("");
	    nextRound();
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		moveFace.add(randomMove());					//not sure Part 3 Line 3
		progressFace.setRound(roundNumber);
		progressFace.setSequenceSize(moveFace.size());
		changeText("Simon's turn");
		label.setText("");
		playSequence();
		changeText("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}
	
	private void playSequence() {
		ButtonInterfaceJas b = getAButton();
		for(MoveInterfaceJas m: moveFace){ 
		    if(b != null) {
		    		b.dim();
		    }
		    b = m.getButton();
		    b.highlight();
		    int sleepTime = (1/roundNumber)/roundNumber;
		    try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    b.dim();
		}

	}

	public void changeText(String str) {
		label.setText(str);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceJas b: buttonFace){ 
		    viewObjects.add(b);
		}
		progressFace = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		moveFace = new ArrayList<MoveInterfaceJas>();
		lastSelectedButton = -1;
		moveFace.add(randomMove());
		moveFace.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progressFace);
		viewObjects.add(label);
	}

	private void addButtons() {
		int numberOfButtons = 5;
		buttonFace = new ButtonInterfaceJas[numberOfButtons];
		Color[] colours = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.GRAY};
		for(int i = 0; i < numberOfButtons; i++) {
			final ButtonInterfaceJas b = getAButton();
			buttonFace[i] = b;
			b.setColor(colours[i]);
			b.setX(5);
			b.setY(5);
			b.setAction(new Action(){
				public void act(){
					if(acceptingInput) {
						Thread blink = new Thread(new Runnable(){
							public void run(){
								b.highlight();
								try {
									Thread.sleep(800);
								} catch(InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
							}
						});
						blink.start();
						if(b == moveFace.get(sequenceIndex).getButton()) {
							sequenceIndex++;
						} else {
							progressFace.gameOver();
						}
						if(sequenceIndex == progressFace.size()){ 
						    Thread nextRound = new Thread(SimonScreenJas.this); 
						    nextRound.start(); 
						}
					}
				}
			});
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
