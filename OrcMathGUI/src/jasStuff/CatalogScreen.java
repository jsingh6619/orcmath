package jasStuff;

import java.util.List;

import guiPlayer.Book;
import guiPlayer.CatalogMaker;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField title;
	private TextField author;
	private TextField pages;
	private Button add;
	private CatalogMaker catalog;
	private TextArea textArea;
	private TextArea error;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		catalog = new CatalogMaker();
		
		title = new TextField(40, 40, 200, 30, "Title HERE", "Title");
		viewObjects.add(title);
		
		author = new TextField(40, 100, 200, 30, "Author HERE", "Author");
		viewObjects.add(author);
		
		pages = new TextField(40, 160, 200, 30, "Pages HERE", "Pages");
		pages.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(pages);
		
		textArea = new TextArea(250, 40, 300, 300, "BOX OF TEXT\n");
		viewObjects.add(textArea);
		
		add = new Button(40, 200, 100, 40, "Add", new Action() {
			
			public void act() {
				addButtonClicked();
			}
		});
		viewObjects.add(add);
		
		error = new TextArea(400, 350, 250, 100, "ERROR! Fields NOT complete!");
	}

	protected void addButtonClicked() {
		if(emptyField()) {
			error.setVisible(true);
		}
		else {
			Book x = new Book(title.getText(), author.getText(), Integer.parseInt(pages.getText()));
			String s = textArea.getText() + x + "\n";
			textArea.setText(s);
			title.setText("");
			author.setText("");
			pages.setText("");
			catalog.addBook(x);
			error.setVisible(false);
		}
	}

	public boolean emptyField() {
		return title.getText().equals("")||author.getText().equals;
	}


