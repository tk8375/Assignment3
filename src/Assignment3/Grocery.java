package Assignment3; 

public class Grocery extends Item { 
	//variables, constructor here
	private double premium = 20;
	public boolean perishable;
	
	public Grocery (String type, String itemName, double itemPrice,  int numPurchased, double pounds, boolean fresh){
		super(type, itemName, itemPrice, numPurchased, pounds); 
		perishable = fresh;
		//override calculatePrice() if necessary; Implement print methods as necessary
		// Only re-implement stuff you cannot get from the superclass (Item)
	}
	float calculatePrice() { 
		float final_price =(float) (price * quantity); // Insert price calculation here return final_price;
		shipping_price = shippingPrice(perishable, premium);
		final_price = (float)Conversion.Rounding(final_price, 2);
		return final_price;
	}
	void printItemAttributes () {
		//Print all applicable attributes of this class
		System.out.println("Name: " + name);
		System.out.println("Category: " + category);
		System.out.println("Price per item: " + price);
		System.out.println("Quantity: " + quantity);
		System.out.println("weight per item: " + weight + " (" + Conversion.Rounding(weight, 0)+ ")");
		String isPerishable = new String();
		if(perishable){isPerishable = "YES";}
		else{isPerishable = "NO";}
		System.out.println("Fragile: " + isPerishable);
	}
}