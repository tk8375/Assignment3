package Assignment3;
public class Electronics extends Item {
	
// Variables, constructors etc. here.
	protected boolean fragile;
	protected String destination;
		
	public Electronics (String type, String itemName, double itemPrice,  int numPurchased, double pounds, boolean delicate, String state){
		super(type, itemName, itemPrice, numPurchased, pounds); 
		fragile = delicate;
		destination = state;
		//override calculatePrice() if necessary; Implement print methods as necessary
		// Only re-implement stuff you cannot get from the superclass (Item)
	}
//Implement calculate price/print methods as necessary
}