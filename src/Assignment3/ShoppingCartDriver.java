package Assignment3; 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
 
public class ShoppingCartDriver{
	int index=0;
	int start=0;
  public static void main(String[] args)   { // TODO Auto-generated method stub
	  //Open file; file name specifie00d in args (command line) 
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
					String cart = translator.processCart(s);
					System.out.println(cart);
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
		* Purpose: Uses String inputString to determine operation and continue 	  	  *
		* the process accordingly						                              *
		* Returns: None					                                              *
		******************************************************************************/
		public String processCart(String inputString){
			//Stub for arraylist.
			ArrayList<Item> shoppingCart = new ArrayList<Item>(); 
			// General code example for how to iterate an array list. 
			//You will have to modify this heavily, to suit your needs.
			
			//Parse input, take appropriate actions.
			String original = new String(inputString);
			String operation = nextword(original);
			if (operation.equals("insert")||operation.equals("Insert")){
				System.out.println("Inserting stuff");
				}
			if (operation.equals("search")||operation.equals("Search")){
				System.out.println("Searching stuff");
				}
			if (operation.equals("delete")||operation.equals("Delete")){
				System.out.println("Deleting stuff");
				}
			if (operation.equals("update")||operation.equals("Update")){
				System.out.println("Updating stuff");
				}
			if (operation.equals("print")||operation.equals("Print")){
				System.out.println("Printing stuff");
				printCart(shoppingCart);
				}
			else {return "Invalid Operation";}
			return ("bleh");
		}
		public void printCart(ArrayList<Item> shoppingCart){
			Iterator<Item> i = shoppingCart.iterator(); 
			float total_price = 0;
			while (i.hasNext()) {
				Item temp = i.next(); 
				float cost = temp.calculatePrice(); 
				temp.printItemAttributes(); 
				//This (above) works because of polymorphism: a determination is made at runtime,
				//based on the inherited class type, as to which method is to be invoked. Eg: If it is an instance
				// of Grocery, it will invoke the calculatePrice () method defined in Grocery.
				System.out.println(cost);
				total_price += cost;
				
			}
			System.out.println("Total price of your shopping cart is: " + total_price);
			return;
		}
		public String nextword(String input){								
			char letter = input.charAt(index);
			int doclength = input.length();
			if (doclength==0){return null;}
			while ((Character.isLetter(letter)==true)&& index!=doclength-1){		
				index++;
				letter = input.charAt(index);										//takes the letter at the pointer
				}
				if (index==doclength-1 && Character.isLetter(letter)==true){index++;}	//checks for end of statement
				if (index-start==0){return null;}
				String extracted = input.substring(start,index);
				start = index;
				return extracted;
		}
}