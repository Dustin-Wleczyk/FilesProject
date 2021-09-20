/**
 * Project will create a file with random numbers in between
 * 1000 and 2000 and will display data about file.
 * 
 * Student Name: Dustin Wleczyk
 * LSU ID: 891888894
 * T.A.: Mikayla Morrow
 * 
 * 
 * @source 11/21/2021
 * @author dustin251
 *
 */

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Random;




public class FilesProject {

	/**
	 * Will verify that string is not empty
	 * Created: 1/21/2021
	 * Author: Dustin251
	 * @return Name of file
	 */
	private static String nameOfFile() {
		String name = "";
		boolean flag = false;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Please input the name of your file: ");
			name = input.nextLine();
			if (name.length() > 0) {
				flag = true;
			} else {
				name = ""; //Reset var value
				System.out.println("Please input the name of your file.");
			}
		} while (!flag);
		
		return name;
	}
	
	/**
	 * Will ensure that input is valid
	 * Created: 1/21/2021
	 * Author: Dustin251
	 * @return File size
	 */
	private static int fileSize() {
		int size = 0;
		boolean flag = false;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Please input the size of your file: ");
			if (input.hasNextInt()) {
				size = input.nextInt();
				if (size > 0) {
					flag = true;
				} else {
					System.out.println("Size of file cannot be 0 or negative.");
					size = 0; //Resets the value
					input.nextLine();
				}
			} else {
				System.out.println("Please input a valid integer");
				input.nextLine();
			}
		} while (!flag);
		
		
		return size;
	}
	
	/**
	 * Populates file with random numbers between 1000 and 2000
	 * Created: 1/21/2021
	 * Author: Dustin251
	 * @param name is the name of file
	 * @param size is size of file
	 */
	
	private static void populateFile(String name, int size) throws FileNotFoundException {
		PrintWriter file = new PrintWriter(name);
		Random rand = new Random();
		int numbers = 0; //Starts at 0 for random numbers to be held
		
		
		for (int i = 0; i < size; i++) {
			numbers = rand.nextInt(1000 + ((2000-1000) + 1));
			file.println(numbers);
		}
		file.close();
		
	}
	
	/**
	 * Returns mean of numbers in file
	 * Created: 1/21/2021
	 * Author: Dustin251
	 * @param name is name of file
	 * @return mean 
	 */
	private static double getMean(String name) throws FileNotFoundException {
		double mean = 0;
		double totalOfNumbersInFile = 0; 
		double counter = 0; //Number of items added
		File readFile = new File(name);
		Scanner file = new Scanner(readFile);
		
		while (file.hasNextInt()) {
			totalOfNumbersInFile = totalOfNumbersInFile + file.nextInt();
			counter++;
		}
		mean = totalOfNumbersInFile/counter;
		file.close();
		return mean;
	}
	
	/**
	 * Returns the maximum number
	 * Created: 1/21/2021
	 * Author: Dustin251
	 * @param name is name of file
	 * @return
	 */
	private static int getMax(String name) throws FileNotFoundException {
		int max = 0;
		File readFile = new File(name);
		int currentNumberToCompare = 0;
		boolean flag = false;
		Scanner file = new Scanner(readFile);
		
		while (!flag) {
			if (file.hasNextInt()) {
				currentNumberToCompare = file.nextInt();
				if (max < currentNumberToCompare) {
					max = currentNumberToCompare;
				}
			} else {
				flag = true;
			}
			
		}
		file.close();
		return max;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String name = nameOfFile();
		int size = fileSize();
		populateFile(name, size);
		double mean = getMean(name);
		int max = getMax(name);
		System.out.printf("File: %s   Mean: %.2f    Max: %d\n", name, mean, max);

	}

}
