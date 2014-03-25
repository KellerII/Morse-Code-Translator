/*
Programming Assignment:  Morse Code
Name:  James Keller
Class Info:  1213 - 001 / Lab 6 
Date:  3/28/2012
Purpose:  The following Morse Code program tranlates the user's input (either a sentence or phrase) into a series dots and dashes
provided by the "Morse.txt" file.  The data file is read and stored in array for easy accesibility and then compared to the user's
input and translated using the Translate class.  Output is then provided to the user outlining their original input and its Morse 
Code equivalent. 
*/

//Import statements for the needed classes
import java.util.Scanner;
import javax.swing.JOptionPane; 
import java.io.*;


public class Morse 
{
	//Main method with throws IOException needed for the JOptionPane class
	public static void main(String[] args) throws IOException
	{	
		//Declaration of string and character arrays 
		char[] usersInputArray = new char[36]; 
		String[] morseCodeArray = new String[36];
		//String initialization
		String usersInput = "";
		
		//Opening the "Morse.txt" file with the File and Scanner classes
		File openFile = new File("Morse.txt"); 
		//Declares a new Scanner class object
  		Scanner inFile = new Scanner(openFile); 
		
		//For loop that reads the data in from the 36 lines in the "Morse.txt" file and creates 2 parallel arrays
		//These arrays will be used for the Morse Code translation.  The usersInputArray stores the first character for
		//comparison to the users input and the second array will be used to hold the Morse Code.
		for (int index=0; index < 36; index++) 
    	{
  			String line = inFile.next();  
	   	usersInputArray[index] = line.charAt(0);  
  			morseCodeArray [index] = inFile.next();  
    	} 
		
		//File closure
  		inFile.close(); 
		
		//A do-while loop that is used in conjuction with the sentinel value(0) to indicate a loop break if prompted by
		//the user.
		do
		{
		//JOptionPane class used to collect the users input.
		usersInput = JOptionPane.showInputDialog("Enter your phrase or sentence for translation to Morse Code."
		+ "\n(Entering a 0 will cause the program to end.)");
  		//The users input is changed to upper case for the morse code comparison		
		String usersInputCased= usersInput.toUpperCase(); 
		//If statement used to detect the sentinel value(0) as input
		if (!usersInput.equals("0"))
		{	
			//Translate object creation and the users input is passed to the constructor
  			Translate inputDialog = new Translate(usersInputCased);  
			
			//Passing of the array data to the mutators
  			inputDialog.setUsersInputArray(usersInputArray); 
  			inputDialog.setMorseCodeArray(morseCodeArray); 
			
			//Declaration of a variable for the data from the translationMethod call
  			String input2Morse = inputDialog.translationMethod(); 
			
			//JOptionPane class used to display the users original input and the Morse Code translation of that
			//input
  			JOptionPane.showMessageDialog(null, "Input:\n" + usersInput + "\n" + "\nMorse Code Translation:" 
	 		+ "\n" + input2Morse);
		}
		
		} while (!usersInput.equals("0"));
 	}
} 








