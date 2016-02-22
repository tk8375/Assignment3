package Assignment3; 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
 
public class ShoppingCartDriver
{
  public static void main(String[] args)   { // TODO Auto-generated method stub
	  //Open file; file name specified in args (command line) 
		if (args.length != 1) 
		{
			System.err.println ("Error: Incorrect number of command line arguments");
			System.exit(-1);
		}
		processLinesInFile (args[0]);
		
	}
		/******************************************************************************
		* Method Name: processLinesInFile                                             *
		* Purpose: Opens the file specified in String filename, reads each line in it *
		*          Invokes processCart () on each line in the file                    *
		* Returns: None                                                               *
		******************************************************************************/
		public static void processLinesInFile (String filename){ 

			ShoppingCartDriver translator = new ShoppingCartDriver(); 
			try 
			{
				FileReader freader = new FileReader(filename);
				BufferedReader reader = new BufferedReader(freader);
				
				for (String s = reader.readLine(); s != null; s = reader.readLine()) 
				{
					String pigLatin = translator.processCart(s);
					System.out.println(pigLatin);
				}
			} 
			catch (FileNotFoundException e) 
			{
				System.err.println ("Error: File not found. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			} catch (IOException e) 
			{
				System.err.println ("Error: IO exception. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			}
		}
		/******************************************************************************
		* Method Name: processCart                                                    *
		* Purpose: Uses String inputString to determine operation and continue 	  *
		* the process accordingly						                              *
		* Returns: None					                                              *
		******************************************************************************/
		public String processCart(String inputString){
			//Parse input, take appropriate actions.
			String original = new String(inputString);
			String words[] = original.split(" ", 2);	//separates first word from rest of the string
			String operation = words[0];
			if (operation.equals("insert")||operation.equals("Insert")){/*insert stuff*/}
			if (operation.equals("search")||operation.equals("Search")){/*search stuff*/}
			if (operation.equals("delete")||operation.equals("Delete")){/*delete stuff*/}
			if (operation.equals("update")||operation.equals("Update")){/*update stuff*/}
			if (operation.equals("print")||operation.equals("Print")){/*print stuff*/}
			else {return "Invalid Operation";}
			//Stub for arraylist.
			ArrayList<Item> shoppingCart = new ArrayList<Item>(); 
			// General code example for how to iterate an array list. 
			//You will have to modify this heavily, to suit your needs.
			Iterator<Item> i = shoppingCart.iterator(); 
			while (i.hasNext()) {
				Item temp = i.next(); temp.calculatePrice(); temp.printItemAttributes(); 
				//This (above) works because of polymorphism: a determination is made at runtime,
				//based on the inherited class type, as to which method is to be invoked. Eg: If it is an instance
				// of Grocery, it will invoke the calculatePrice () method defined in Grocery.
	  }
			return ("bleh");
	}
}