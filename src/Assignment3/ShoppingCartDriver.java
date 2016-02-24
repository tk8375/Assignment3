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
		* Returns: String to print out				                                  *
		******************************************************************************/
		public String processCart(String inputString){
			if(inputString.length()<=0){return "";}
			index = 0;
			start = 0;
			inputString += " ";
			String original = new String(inputString);
			System.out.println(inputString);
			String operation = nextword(original);
			String message = new String();
			if (operation.equalsIgnoreCase("INSERT")){
				message = InsertItem(original);
				}
			else if (operation.equalsIgnoreCase("SEARCH")){
				message = searchCart(nextword(inputString));
				}
			else if (operation.equalsIgnoreCase("DELETE")){
				message = deleteItem(nextword(inputString));
				}
			else if (operation.equalsIgnoreCase("UPDATE")){
				message = UpdateItem(inputString);
				}
			else if (operation.equalsIgnoreCase("PRINT")){
				printCart();
				}
			else {return "Invalid Operation\n";}
			return message+"\n";
		}
		/******************************************************************************
		* Method Name: insertItem                                                     *
		* Purpose: Inserts specified item into arraylist	  	  					  *
		******************************************************************************/
		
		private String InsertItem(String inputString) {
			String category = nextword(inputString);
			if(category==null){return "Please enter the category of the item";}
			String name = nextword(inputString);
			if(name==null){return "Please enter the name of the item";}
			double price = Conversion.StringToDouble(nextword(inputString),2);
			//if price, quantity, or weight are negative, returns an error message.
			if(price == -1){return "Invalid price";}
			int quantity = Conversion.StringToInt(nextword(inputString));
			if(quantity == -1){return "Invalid quantity, please input only integer numbers not followed by a decimal.";}
			double weight = Conversion.StringToDouble(nextword(inputString), -1);
			if(weight == -1){return "Invalid weight value";}
			String mssg = new String();
			
			//inserting a clothing item
			if (category.equalsIgnoreCase("CLOTHING")||category.equalsIgnoreCase("CLOTHINGS")){
				Clothing newCloth = new Clothing(category,name,price,quantity,weight);
				shoppingCart.add(newCloth);
				
			}
			//inserting a electronics item
			else if (category.equalsIgnoreCase("ELECTRONICS")||category.equalsIgnoreCase("ELECTRONIC")){
				boolean isFragile;
				String fragile = nextword(inputString);
				if(fragile.equalsIgnoreCase("F")){isFragile = true;}
				else if(fragile.equalsIgnoreCase("NF")){isFragile = false;}
				else{return "Please define if the electronic is fragile or not by inputting 'F' or 'NF'";}
				String state = nextword(inputString);
				if(state==null||state.length()>2){return "Please Specify the name of the State using its abbreviation.";}
				if(!Electronics.RealState(state)){return "The input state is not part of the U.S.";}
				Electronics newElectronic = new Electronics(category,name,price,quantity,weight,isFragile,state);
				shoppingCart.add(newElectronic);
				
			}
			//inserting a grocery item
			else if (category.equalsIgnoreCase("GROCERY")||category.equalsIgnoreCase("GROCERIES")){
				boolean isPerishable;
				String perishable = nextword(inputString);
				if(perishable.equalsIgnoreCase("P")){isPerishable = true;}
				else if(perishable.equalsIgnoreCase("NP")){isPerishable = false;}
				else{return "Please define if the grocery item is perishable or not by inputting 'P' or 'NP'";}
				Grocery newGrocery = new Grocery(category,name,price,quantity,weight,isPerishable);
				shoppingCart.add(newGrocery);
				
			}
			//there are no other categories, need to return an error message.
			else{return "Invalid Category";}
			//if insertion went successfully, return a confirmation message.
			mssg = "Inserted " + quantity + " " + name + " for $" + price + " each.";
			return mssg;
		}
		/******************************************************************************
		* Method Name: searchCart                                                     *
		* Purpose: searches for specified item in the array and returns 			  *
		* the amount of exact results and similar results.							  *
		******************************************************************************/
		private String searchCart (String name){
			if(name==null){return "Please input search keyword";}
			int exact_match = 0;
			int contain_match = 0;
			Iterator<Item> i = shoppingCart.iterator();
			while (i.hasNext()) {
				Item temp = i.next();
				if(temp.getName().equals(name)){exact_match +=1;}
				else if(temp.getName().contains(name)||temp.getName().equalsIgnoreCase(name)){contain_match +=1;}
			}
			if(exact_match+contain_match == 0){return "No items found";}
			String mssg = "Found " + exact_match + " exact match(es) and " + contain_match + " item(s) that contains the keyword.";
			return mssg;
		}
		/******************************************************************************
		* Method Name: deleteItem                                                     *
		* Purpose: searches for specified item in the arraylist and removes the entry *
		******************************************************************************/
		private String deleteItem (String name){
			if(name==null){return "Please specify the name of items to be removed.";}
			int exact_match = 0;
			for(int index = 0; index < shoppingCart.size(); index++){
				if(shoppingCart.get(index).getName().equalsIgnoreCase(name)){
					shoppingCart.remove(index);
					index --;
					exact_match ++;
				}
			}
			if(exact_match == 0){return "Item does not exist in the shopping cart";}
			String mssg = "Deleted " + exact_match + " item(s) with name: " + name;
			return mssg;
		}
		
		/******************************************************************************
		* Method Name: updateItem                                                     *
		* Purpose: Searches for specified item in arraylist and 					  *
		* modifies the quantity if found.						  					  *
		******************************************************************************/
		private String UpdateItem (String inputString){
			String name = nextword(inputString);
			if(name==null){return "Specify the name of item to be updated";}
			int quantity = Conversion.StringToInt(nextword(inputString));
			if(quantity == -1){return "Invalid amount to be updated";}
			for(int index = 0; index < shoppingCart.size(); index++){
				if(shoppingCart.get(index).getName().equals(name)){
					shoppingCart.get(index).quantity = quantity;
					return name+" updated; new quantity: " + quantity;
				}
			}
			return "The item " + name+ " does not exist in the shopping cart";
			
		}
		/******************************************************************************
		* Method Name: printCart                                                      *
		* Purpose: sorts the array alphabetically and prints each element  			  *
		* and its attributes: name, category, price, quantity, weight, etc.			  *
		* and prints out the total cost of all items in the cart at the end 		  *		  
		******************************************************************************/
		private void printCart(){
			if(shoppingCart.isEmpty()){return;}
			//must sort the array before printing
			/*write the sort code/method*/
			arrayAlphabeticalSort();
			Iterator<Item> i = shoppingCart.iterator(); 
			float total_price = 0;
			while (i.hasNext()) {
				Item temp = i.next(); 
				float cost = temp.calculatePrice(); 
				float shipping = temp.getShipping_price();
				float total_cost = cost+shipping;
				temp.printItemAttributes(); 
				//This (above) works because of polymorphism: a determination is made at runtime,
				//based on the inherited class type, as to which method is to be invoked. Eg: If it is an instance
				// of Grocery, it will invoke the calculatePrice () method defined in Grocery.
				System.out.println("The cost of this item is: $" + cost +" + $"+shipping+" shipping.");
				System.out.println("Total cost of this item is: $" + total_cost +"\n");
				total_price += total_cost;
				
			}
			System.out.println("Total price of your shopping cart is: $" + total_price);
			return;
		}

		/******************************************************************************
		* Method Name: nextword                                                       *
		* Purpose: itterates through each character in string and separates			  *
		* words by spaces. Returns the next word in the string.						  *
		******************************************************************************/
		public String nextword(String input){								
			char letter = input.charAt(index);
			int doclength = input.length();
			if (doclength==0){return null;}
			while((Character.isSpaceChar(letter)==true)&& index!=doclength-1){
				index++;
				letter = input.charAt(index);
			}
			start = index;
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
		/******************************************************************************
		* Method Name: arrayAlphabeticalSort                                          *
		* Purpose: Goes through each element in the array and compares with 		  *
		* other elements in the array to determine alphabetical order.   			  *
		* entries are reorganized in a new array alphabetically						  *
		******************************************************************************/
		private void arrayAlphabeticalSort() {
			if(shoppingCart.isEmpty()){return;}
			ArrayList<Item> tempList = new ArrayList<Item>();	
			while(!shoppingCart.isEmpty()){
				Item smallest = shoppingCart.get(0);
				Iterator<Item> j = shoppingCart.iterator();
				while(j.hasNext()){
					Item temp = j.next();
					if(smallest.getName().compareTo(temp.getName())>0){
						smallest = temp;
					}
				}
				tempList.add(smallest);
				shoppingCart.remove(smallest);
			}

			shoppingCart = tempList;
		}
}