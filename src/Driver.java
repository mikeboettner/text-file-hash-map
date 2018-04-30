import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {
	
	/*
	 * Main method to read an external text file and determine the most frequently occurring word
	 */
	public static void main(String args[]) throws FileNotFoundException
	{
		//Scanner object to read in external text file
		File myFile = new File("C:\\Users\\Mike\\Desktop\\my_text_file.txt");
		Scanner fileScanner = new Scanner(myFile);
		
		//new HashMap object with key, value pair of <String, Integer>
		HashMap<String, Integer> myHashMap  = new HashMap<String, Integer>();
		
		//variables track the highest frequency count and highest frequency word
		int highCount = 0;
		String highWord = "";
		
		//loop through each word in the text file
		while(fileScanner.hasNext())
		{
			//store the current word (lowercase and remove punctuation (only allow word characters))
			String tempString = fileScanner.next().toLowerCase().replaceAll("\\W", "");
			
			//if the current word is not in the hashmap, add it with a frequency of 1
			if(!myHashMap.containsKey(tempString))
			{
				myHashMap.put(tempString, 1);
			}
			//otherwise the word is already in the hashmap. Increment its count by 1
			else
			{
				int tempCount = myHashMap.get(tempString) + 1;
				myHashMap.put(tempString, tempCount);
				
				//replace new high variables if this word's count is greater than the running high
				if(tempCount > highCount)
				{
					highCount = tempCount;
					highWord = tempString;
				}					
			}			
		}
		
		fileScanner.close();
		
		System.out.println("The most frequently occuring word is: " + highWord + " (" + highCount + ")");
	}
}
