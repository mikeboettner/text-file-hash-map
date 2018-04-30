import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {
	
	public static void main(String args[]) throws FileNotFoundException
	{
		File myFile = new File("C:\\Users\\Mike\\Desktop\\my_text_file.txt");
		Scanner fileScanner = new Scanner(myFile);
		
		HashMap<String, Integer> myHashMap  = new HashMap<String, Integer>();
		
		int highCount = 0;
		String highWord = "";
		
		while(fileScanner.hasNext())
		{
			String tempString = fileScanner.next().toLowerCase().replaceAll("\\W", "");
			//System.out.println(tempString);
			if(!myHashMap.containsKey(tempString))
			{
				myHashMap.put(tempString, 1);
			}
			else
			{
				int tempCount = myHashMap.get(tempString) + 1;
				myHashMap.put(tempString, tempCount);
				
				if(tempCount > highCount)
				{
					highCount = tempCount;
					highWord = tempString;
				}					
			}			
		}
		
		System.out.println("The most frequently occuring word is: " + highWord + " (" + highCount + ")");
	}
}
