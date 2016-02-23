package Assignment3; 

public class Grocery extends Item { 
	//variables, constructor here
	public boolean perishable;
	
	public Grocery (String itemName, String type, double itemPrice, double pounds, int numPurchased, boolean fresh){
		super(itemName, type, itemPrice, pounds, numPurchased); 
		perishable = fresh;
		//override calculatePrice() if necessary; Implement print methods as necessary
		// Only re-implement stuff you cannot get from the superclass (Item)
	}
}