package Assignment3;
public class Electronics extends Item {
	
// Variables, constructors etc. here.
	public boolean fragile;
		
	public Electronics (String itemName, String type, double itemPrice, double pounds, int numPurchased, boolean delicate){
		super(itemName, type, itemPrice, pounds, numPurchased); 
		fragile = delicate;
		//override calculatePrice() if necessary; Implement print methods as necessary
		// Only re-implement stuff you cannot get from the superclass (Item)
	}
//Implement calculate price/print methods as necessary
}