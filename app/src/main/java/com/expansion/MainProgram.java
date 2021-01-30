package com.expansion;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;


public class MainProgram {

	
	public static void main(String[] args) {
		
		progStart();
		MenuOptions.menuPrint();
		MenuOptions.mainMenu();

	}

	static void progStart() {
				
			int fileFound = readFile();

			if (fileFound == 1) {

				System.out.println("File not found");
				System.out.println("\nData will be Created, Please Enter Table Dimension");
				int row = getRow();
				int col = getCol();
				createFile(row, col);
			}
			
	}

	static int validator(int valid) {

			if (valid == 1) {
				System.out.println("\nData Files Successfully Loaded\n");
			} else if (valid == 2) {
				System.out.println("Failed");
			}
			return valid;
	}

	public static int getRow() {

			Scanner getInput = new Scanner(System.in);
	  		boolean isNumber;	
	  		int row = 0;	

			do {
		    		System.out.print("Enter Number of Row: ");
			    	if (getInput.hasNextInt()) {
			    		row = getInput.nextInt();
			    		isNumber = true;
			    	} else {
			    		System.out.println("Please Input a valid number!");
			    		isNumber = false;
			    		getInput.next();
			    	}

			    	if ((row > 1000) || (row < 1)) {
				    	System.out.println("Not allowed! Please Select from 1 - 1000 \n");
				    	isNumber = false;
			    	}
	    	} while (!(isNumber));

	    	return row;
	}

	public static int getCol() {

			Scanner getInput = new Scanner(System.in);
	  		boolean isNumber;	
	  		int col = 0;

			do {
			    	System.out.print("Enter Number of Column: ");
			    	if (getInput.hasNextInt()) {
			    		col = getInput.nextInt();
			    		isNumber = true;
			    	} else {
			    		System.out.println("Please Input a valid number!");
			    		isNumber = false;
			    		getInput.next();
			    	}
			    	if ((col > 1000) || (col < 1)) {
				    	System.out.println("Not allowed! Please Select from 1 - 1000 \n");
				    	isNumber = false;
			   		}
		    } while (!(isNumber));

		    return col;
	}

	static int readFile() {

			int fileFound = 0;
			Scanner openFile = null;
			Scanner openData = null;

			try {
				openFile = new Scanner(new File("dimension.txt"));
				openData = new Scanner(new File("data.txt"));
				int dim = 0;

				while (openFile.hasNextLine()) {
						String line = openFile.nextLine();
										
						FileStorage.storeDimension[dim] = line;
						dim = dim + 1;
				}
				
				openFile.close();
				
				validator(1);

				while (openData.hasNextLine()) {
					String key = openData.nextLine();
					String value = openData.nextLine();			
					FileStorage.cellData.put(key, value);
				}
				
				openData.close();

			} catch (FileNotFoundException e) {
				
				fileFound = 1;
				
			}

			return fileFound;
	}

	static boolean createFile(int row, int col) {

			try {
				FileWriter saveFile = new FileWriter(new File("data.txt"));
				FileWriter saveDimension = new FileWriter(new File("dimension.txt"));

				for(int index1 = 1 ; index1 <= (row * 2) ; index1++) {
				  		for(int index2 = 1 ; index2 <= (col) ; index2++) {
							saveFile.write(FileStorage.generateASCII()+"\n");
						}
				}			
				saveDimension.write(row+"\n");
				saveDimension.write(col+"\n");
				saveDimension.close();
				saveFile.close();
				System.out.println("\n");
				System.out.println("You Successfully created a table");
				progStart();

			} catch (IOException e) {
				System.out.println("Unable to open file for writing");
			}

			return true;
	}

}