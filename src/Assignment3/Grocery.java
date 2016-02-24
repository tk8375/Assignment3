package Assignment3; 

public class Grocery extends Item { 
	//variables, constructor here
	private double premium = 20;
	public boolean perishable;
	
	public Grocery (String type, String itemName, double itemPrice,  int numPurchased, double pounds, boolean fresh){
		super(type, itemName, itemPrice, numPurchased, pounds); 
		perishable = fresh;
	}
	
	float calculatePrice() { 
		float final_price =(float) (price * quantity);
		shipping_price = shippingPrice(perishable, premium);
		final_price = (float)Conversion.Rounding(final_price, 2);
		return final_price;
	}
	
	void printItemAttributes () {
		//Print all applicable attributes of this class
		System.out.println("Name: " + name);
		System.out.println("Category: " + category);
		System.out.println("Price per item: $" + price);
		System.out.println("Quantity: " + quantity);
		System.out.println("Weight per item: " + weight + " (" + Conversion.Rounding(weight, 0)+ ")");
		String isPerishable = new String();
		if(perishable){isPerishable = "Yes";}
		else{isPerishable = "No";}
		System.out.println("Perishable: " + isPerishable);
	}
}