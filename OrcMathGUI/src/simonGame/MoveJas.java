package simonGame;

public class MoveJas implements MoveInterfaceJas {

	private ButtonInterfaceJas btn;
	
	public MoveJas(ButtonInterfaceJas button) {
		btn = button;
	}

	public ButtonInterfaceJas getButton() {
		return btn;
	}

}
