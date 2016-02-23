package Assignment3; 

public class Grocery extends Item { 
	//variables, constructor here
	public boolean perishable;
	
	public Grocery (String type, String itemName, double itemPrice,  int numPurchased, double pounds, boolean fresh){
		super(type, itemName, itemPrice, numPurchased, pounds); 
		perishable = fresh;
		//override calculatePrice() if necessary; Implement print methods as necessary
		// Only re-implement stuff you cannot get from the superclass (Item)
	}
}