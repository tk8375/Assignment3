package Assignment3; 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
 
public class ShoppingCartDriver{
	int index=0;
	int start=0;
	//Stub for arraylist.
	ArrayList<Item> shoppingCart = new ArrayList<Item>();
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
			index = 0;
			start = 0;
			inputString += " ";
			//Parse input, take appropriate actions.
			String original = new String(inputString);
			System.out.println(inputString);
			String operation = nextword(original);
			String message = new String();
			if (operation.equalsIgnoreCase("INSERT")){
				//System.out.println("Inserting stuff");
				message = InsertItem(original);
				}
			else if (operation.equalsIgnoreCase("SEARCH")){
				System.out.println("Searching stuff");
				}
			else if (operation.equalsIgnoreCase("DELETE")){
				System.out.println("Deleting stuff");
				}
			else if (operation.equalsIgnoreCase("UPDATE")){
				System.out.println("Updating stuff");
				}
			else if (operation.equalsIgnoreCase("PRINT")){
				System.out.println("Printing stuff");
				printCart();
				}
			else {return "Invalid Operation\n";}
			return message+"\n";
		}
		//----------------------------------------------------
		//----------------------------------------------------
		
		private String InsertItem(String inputString) {
			String category = nextword(inputString);
			//System.out.println(category);
			String name = nextword(inputString);
			if(name.equals(null)){return "Please enter the name of the item";}
			double price = Conversion.StringToDouble(nextword(inputString),2);
			if(price == -1){return "Invalid price";}
			//System.out.println(price);
			int quantity = Conversion.StringToInt(nextword(inputString));
			if(quantity == -1){return "Invalid quantity";}
			//System.out.println(quantity);
			double weight = Conversion.StringToDouble(nextword(inputString), -1);
			//System.out.println(weight);
			if(weight == -1){return "Invalid weight value";}
			String mssg = new String();
			if (category.equalsIgnoreCase("CLOTHING")||category.equalsIgnoreCase("CLOTHINGS")){
				Clothing newCloth = new Clothing(category,name,price,quantity,weight);
				shoppingCart.add(newCloth);
				mssg = "Inserted " + quantity + " " + name + " for " + price + " each.";
			}
			else if (category.equalsIgnoreCase("ELECTRONICS")||category.equalsIgnoreCase("ELECTRONIC")){
				boolean isFragile;
				if(nextword(inputString).equalsIgnoreCase("F")){isFragile = true;}
				else if(nextword(inputString).equalsIgnoreCase("NF")){isFragile = false;}
				else{return "Please define if the electronic is fragile or not by inputting 'F' or 'NF'";}
				String state = nextword(inputString);
				if(state.equals(null)||state.length()>2){return "Please Specify the name of the State using its abbreviation.";}
				Electronics newElectronic = new Electronics(category,name,price,quantity,weight,isFragile,state);
				shoppingCart.add(newElectronic);
				mssg = "Inserted " + quantity + " " + name + " for " + price + " each.";
			}
			else if (category.equalsIgnoreCase("GROCERY")||category.equalsIgnoreCase("GROCERIES")){
				
			}
			else{mssg = "Invalid Category";}
			return mssg;
		}
		//----------------------------------------------------
		//----------------------------------------------------
		private void printCart(){
			
			//must sort the array before printing
			/*write the sort code/method*/
			Iterator<Item> i = shoppingCart.iterator(); 
			float total_price = 0;
			while (i.hasNext()) {
				Item temp = i.next(); 
				float cost = temp.calculatePrice(); 
				temp.printItemAttributes(); 
				//This (above) works because of polymorphism: a determination is made at runtime,
				//based on the inherited class type, as to which method is to be invoked. Eg: If it is an instance
				// of Grocery, it will invoke the calculatePrice () method defined in Grocery.
				System.out.println("Total cost of this item is: " + cost +"\n");
				total_price += cost;
				
			}
			System.out.println("Total price of your shopping cart is: " + total_price);
			return;
		}
		//----------------------------------------------------
		//--------------------------------------------------------
		public String nextword(String input){								
			char letter = input.charAt(index);
			int doclength = input.length();
			if (doclength==0){return null;}
			while ((!Character.isSpaceChar(letter))&& index!=doclength-1){		
				index++;
				letter = input.charAt(index);										//takes the letter at the pointer
				}
			if (index==doclength-1 && Character.isLetter(letter)==true){index++;}	//checks for end of statement
			if (index-start==0){return null;}
			String extracted = input.substring(start,index);
			while((Character.isSpaceChar(letter)==true)&& index!=doclength-1){
				index++;
				letter = input.charAt(index);
			}
			start = index;
			//System.out.println(extracted);
			return extracted;
		}
}