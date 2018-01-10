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
		moveFace.add(randomMove());					
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
		ButtonInterfaceJas b;
		for(int i = 0; i < moveFace.size(); i++){ 
			b = moveFace.get(i).getButton();
		    if(b != null) {
		    		b.dim();
		    }
		    b.highlight();
		    int sleepTime = 1000 - (100*roundNumber);
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
			final ButtonInterfaceJas b = getAButton((90 * i) + 95,75, 50, 50, "", null);
			buttonFace[i] = b;
			b.setColor(colours[i]);
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
						if(sequenceIndex == moveFace.size()){ 
						    Thread nextRound = new Thread(SimonScreenJas.this); 
						    nextRound.start(); 
						}
					}
				}
			});
		}
	}
	

	private ButtonInterfaceJas getAButton(int x, int y, int w, int h, String text, Action action) {
		ButtonJas button = new ButtonJas(x, y, w, h, text, action);
		return button;
	}

	private ProgressInterfaceJas getProgress() {
		return new ProgressJas();
	}

	private MoveInterfaceJas randomMove() {
		int bIndex = (int)(Math.random() * buttonFace.length);
		while(bIndex == lastSelectedButton){
			bIndex = (int)(Math.random() * buttonFace.length);
		}
		return getMove(bIndex);
	}
	
	private MoveInterfaceJas getMove(int bIndex) {
		return new MoveJas(buttonFace[bIndex]);
	}
}
