package Assignment3;
public class Electronics extends Item {
	
// Variables, constructors etc. here.
	private double premium = 20;	//tax/premium is in percents (ex. 10.5% tax -> tax = 10.5)
	protected boolean fragile;
	protected String destination;
		
	public Electronics (String type, String itemName, double itemPrice,  int numPurchased, double pounds, boolean delicate, String state){
		super(type, itemName, itemPrice, numPurchased, pounds); 
		fragile = delicate;
		destination = state;
		state = state.toUpperCase();
		if(	state.equals("TX")||
			state.equals("NM")||
			state.equals("VA")||
			state.equals("AZ")||
			state.equals("AK")){tax = 0;}
		
		//override calculatePrice() if necessary; Implement print methods as necessary
		// Only re-implement stuff you cannot get from the superclass (Item)
	}
	
//Implement calculate price/print methods as necessary
	float calculatePrice() { 
		float final_price =(float) (price * quantity); // Insert price calculation here return final_price;
		float shipping_price = shippingPrice(fragile, premium);
		final_price += shipping_price;
		if(tax != 0){
			final_price = final_price + final_price / (float)tax;
		}
		final_price = (float)Rounding(final_price, 2);
		return final_price;
	}
	void printItemAttributes () {
		//Print all applicable attributes of this class
		System.out.println("Name: " + name);
		System.out.println("Category: " + category);
		System.out.println("Price: " + price);
		System.out.println("Quantity: " + quantity);
		System.out.println("weight: " + weight);
		System.out.println("Destination: " + destination);
		String isFragile = new String();
		if(fragile){isFragile = "yes";}
		else{isFragile = "no";}
		System.out.println("Fragile: " + isFragile);
	}
}