package Assignment3;
public class Electronics extends Item {
	
// Variables, constructors etc. here.
	private double premium = 20;	//tax/premium is in percents (ex. 10.5% tax -> tax = 10.5)
	protected boolean fragile;
	protected String destination;
		
	public Electronics (String type, String itemName, double itemPrice,  int numPurchased, double pounds, boolean delicate, String state){
		super(type, itemName, itemPrice, numPurchased, pounds); 
		fragile = delicate;
		state = state.toUpperCase();
		destination = state;
		if(	state.equals("TX")||
			state.equals("NM")||
			state.equals("VA")||
			state.equals("AZ")||
			state.equals("AK")){tax = 0;}
	}
	//checks to see if item is being sent to a state in the US. 
	public static boolean RealState (String state){
		if( state.equalsIgnoreCase("AL")||
			state.equalsIgnoreCase("AK")||
			state.equalsIgnoreCase("AZ")||
			state.equalsIgnoreCase("AR")||
			state.equalsIgnoreCase("CA")||
			state.equalsIgnoreCase("CO")||
			state.equalsIgnoreCase("CT")||
			state.equalsIgnoreCase("DE")||
			state.equalsIgnoreCase("FL")||
			state.equalsIgnoreCase("GA")||
			state.equalsIgnoreCase("HI")||
			state.equalsIgnoreCase("ID")||
			state.equalsIgnoreCase("IL")||
			state.equalsIgnoreCase("IN")||
			state.equalsIgnoreCase("IA")||
			state.equalsIgnoreCase("KS")||
			state.equalsIgnoreCase("KY")||
			state.equalsIgnoreCase("LA")||
			state.equalsIgnoreCase("ME")||
			state.equalsIgnoreCase("MD")||
			state.equalsIgnoreCase("MA")||
			state.equalsIgnoreCase("MI")||
			state.equalsIgnoreCase("MN")||
			state.equalsIgnoreCase("MS")||
			state.equalsIgnoreCase("MO")||
			state.equalsIgnoreCase("MT")||
			state.equalsIgnoreCase("NE")||
			state.equalsIgnoreCase("NV")||
			state.equalsIgnoreCase("NH")||
			state.equalsIgnoreCase("NJ")||
			state.equalsIgnoreCase("NM")||
			state.equalsIgnoreCase("NY")||
			state.equalsIgnoreCase("NC")||
			state.equalsIgnoreCase("ND")||
			state.equalsIgnoreCase("OH")||
			state.equalsIgnoreCase("OK")||
			state.equalsIgnoreCase("OR")||
			state.equalsIgnoreCase("PA")||
			state.equalsIgnoreCase("SC")||
			state.equalsIgnoreCase("SD")||
			state.equalsIgnoreCase("TN")||
			state.equalsIgnoreCase("TX")||
			state.equalsIgnoreCase("UT")||
			state.equalsIgnoreCase("VT")||
			state.equalsIgnoreCase("VA")||
			state.equalsIgnoreCase("WA")||
			state.equalsIgnoreCase("WV")||
			state.equalsIgnoreCase("WI")||
			state.equalsIgnoreCase("WY")){ return true;}
		return false;
	}
	
//Implement calculate price/print methods as necessary
	float calculatePrice() { 
		float final_price =(float) (price * quantity); // Insert price calculation here return final_price;
		shipping_price = shippingPrice(fragile, premium);
		if(tax != 0){
			final_price = final_price + final_price / (float)tax;
		}
		final_price = (float)Conversion.Rounding(final_price,2);
		return final_price;
	}
	void printItemAttributes () {
		//Print all applicable attributes of this class
		System.out.println("Name: " + name);
		System.out.println("Category: " + category);
		System.out.println("Price: $" + price);
		System.out.println("Quantity: " + quantity);
		System.out.println("Weight: " + weight+ " (" +Conversion.Rounding(weight, 0)+ ")");
		System.out.println("Destination: " + destination);
		String isFragile = new String();
		if(fragile){isFragile = "YES";}
		else{isFragile = "NO";}
		System.out.println("Fragile: " + isFragile);
	}
}