package jasStuff;

import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField country;
	private TextField yearAdopt;

	public CatalogScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		country = new TextField(40, 40, 200, 30, "COUNTRY HERE", "Country Name");
		viewObjects.add(country);
		yearAdopt = new TextField(40, 100, 200, 30, "YEAR ADOPTED HERE", "Year Adopted");
		viewObjects.add(yearAdopt);
	}

}
