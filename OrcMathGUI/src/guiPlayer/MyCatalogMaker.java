package guiPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyCatalogMaker {

	private ArrayList<Flags> list;
	
	public MyCatalogMaker() {
		list = new ArrayList<Flags>();
		list.add(new Flags("USA", 1960));
		list.add(new Flags("Canada", 1965));
		list.add(new Flags("Mexico", 1968));
	}

	public static void main(String[] args) {
		MyCatalogMaker x = new MyCatalogMaker();
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
	
	private void add() {
		String country = null;
		int year = 0;
		displayMessage("Please enter the country");
		country = getStringInput();
		displayMessage("Please enter the year the flag was adopted");
		year = getIntegerInput();
		addFlag(new Flags(country, year));
	}
	
	private void addFlag(Flags b){
		list.add(b);
	}
	
	public ArrayList<Flags> getCatalog(){
		
	}
	
	private int getIntegerInput() {
		String text = in.nextLine();
		int value = 0;
		boolean valid = false;
		while(!valid){
			try{
				value = Integer.parseInt(text);
				valid = true;
			}catch(NumberFormatException nfe){
				displayMessage("You must enter an integer.");
			}
		}
		return value;
	}

	private static String getStringInput(){
		String text = in.nextLine();
		while(text.isEmpty()){
			displayMessage("You must enter a non-empty String.");
			text = in.nextLine();
		}
		return text;
	}
	
	private static void displayMessage(String message){
		System.out.println(message);
	}
	
	public List<String> testFileLoading() {
		String fileName = "";
		list = new ArrayList<String>();
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
}