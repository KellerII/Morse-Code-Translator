/*
Programming Assignment:  Morse Code
Name:  James Keller
Class Info:  1213 - 001 / Lab 6 
Date:  3/28/2012
Purpose:  Translate Class (see main method for the complete program description) 
*/

class Translate
{	
	//Variable declarations
	private String usersInputClass;
	private String[] morseCodeArrayClass = new String[36];
   private char[] usersInputArrayClass = new char[36];    	
	
	//Constructor that initializes the usersInputClass and accepts a String argument
	public Translate(String str)
   {
  		usersInputClass = str;
   }
	
  	//Mutator for the usersInputArrayClass field
	public void setUsersInputArray(char[] array) 
	{
		usersInputArrayClass = array;
	}
  	
  	//Mutator for the morseCodeArrayClass field
	public void setMorseCodeArray(String[] array) 
   {
		morseCodeArrayClass = array;
  	}
	
	//Translation method that 
	public String translationMethod() 
	{
		//The translation string variable is set to null 
		//Creation of a new StringBuilder object to hold the appending string values of the loops.  Passing the null
		//value of translation to this new object.
		String translation = "";
		StringBuilder translationObject = new StringBuilder(translation);
		
		//For loop that filters through the users input string one character at a time using the .charAt method that
		//returns the character at the specified index
      for (int index=0; index < usersInputClass.length(); index++) 
      {	
			char character = usersInputClass.charAt(index);
			
			//If statement that checks to see if the current character is a space.  If it is a space it
			//is replaced by 2 spaces and then appended to the exiting translationOject string.  This creates a total
			//of 3 spaces between each word that is translated. 	
			if (character == ' ') 
         {
				translationObject = translationObject.append("  ");
			}
		
		//For loop that filters through the users input							
      for (int index2=0; index2 < 36; index2++) 
		{	
			//If statement used to determine which element represented by the index matches the current character in the user's input string.
			//If a match is found it is appended to the existing string and the loop breaks.		
         if (usersInputArrayClass[index2] == character)
         {
				translationObject = translationObject.append(morseCodeArrayClass[index2] + " ");
            break; 
         }
      }
    	}
    	
		//The translated string is returned when the method is called.
		//Additionally a toString method is called to convert the StringBuilder object to a regular string for return.
		String stringTranslationObject = translationObject.toString();
		return stringTranslationObject; 
  }
}
