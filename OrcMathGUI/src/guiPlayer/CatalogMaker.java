package guiPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogMaker {

	private ArrayList<Flags> list;
	
	public CatalogMaker() {
		list = new ArrayList<Flags>();
		list.add(new Flags("USA", 1960));
		list.add(new Flags("Canada", 1965));
		list.add(new Flags("Mexico", 1968));
	}

	public static void main(String[] args) {
		CatalogMaker x = new CatalogMaker();
		Scanner in = new Scanner(System.in);
		System.out.println(x.getCSVContent());
		getUserInput();
	}

	public static void getUserInput() {
		System.out.println("What country do you want to add?");
		String country = ;
		System.out.println("What year was it adopted?");
		int year = ;
		addNewItem(country, year)
	}

	public String getCSVContent() {
		String data = "Country,Year Adopted\n";
		for(Flags f: list) {
			data += f + "\n";
		}
		return data;
	}
	
	public void addNewItem(String country, int year) {
		list.add(new Flags(country, year));
		System.out.println("Item added successfully!");
	}
}
