package guiPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
		String country = "";
		System.out.println("What year was it adopted?");
		int year = "";
//		addNewItem(country, year)
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
	
	public void saveCatalog() {
		try{    
			FileWriter fw=new FileWriter("data.csv");
			for(Flags f: list) {
				fw.write(f + "\n");
			}
			fw.close();    
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}
	
	public List<String> testFileLoading() {
		Scanner in = new Scanner(System.in);
		String fileName = "";
		List<String> content = new ArrayList<String>();
		boolean opened = false;
		while(!opened){
			try {
				System.out.println("Open what?");
				fileName = in.nextLine();
				FileReader fileReader = new FileReader(new File(fileName));
				String line = "";
				//a BufferedReader enables us to read teh file one line at a time
				BufferedReader br = new BufferedReader(fileReader);
				while ((line = br.readLine()) != null) {
					content.add(line);
					/*
					 	useful later:
					 	split only a comma that has an even number of quotes ahead of it
					 	String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
					 */
				}
				br.close();
				opened = true;
			}catch (IOException e) {
				System.out.println("The file name you specified does not exist.");
			}
		}
		//close the Scanner
		in.close();
		return content;
}
