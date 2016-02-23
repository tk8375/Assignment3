package Assignment3;

public class Item { 
	//Declare variables for this class. Think about its type: public, protected or private?
	// You will need a constructor (Why?). Create it here.
	protected String category;
    protected String name;
    protected double price;
    protected int quantity;
    protected double weight;
    protected double tax = 10;	//tax is in percents (ex. 10.5% tax -> tax = 10.5)
    protected float shipping_price;
    /*******************************************************
    *  Create a new item with the given attributes.		 *
    ******************************************************/
    public Item (String type, String itemName, double itemPrice,  int numPurchased, double pounds)
    {
      name = itemName;
      category = type;
      price = itemPrice;
      quantity = numPurchased;
      weight = pounds;

    }

    public int getQuantity(){
    	return quantity;
    }
    public String getName(){
    	return name;
    }
    public String getType(){
    	return category;
    }
    public float getShipping_price(){
    	return shipping_price;
    }
	float calculatePrice() { 
		float final_price =(float) (price * quantity); // Insert price calculation here return final_price;
		shipping_price = shippingPrice();
		final_price = final_price + final_price / (float)tax;
		final_price = (float)Conversion.Rounding(final_price, 2);
		return final_price;
	}
	protected float shippingPrice(){
		float shippingPrice = (float) ((20*(Conversion.Rounding(weight, 0)))*quantity);
		shippingPrice = (float) Conversion.Rounding(shippingPrice, 2);
		return shippingPrice;
	}
	protected float shippingPrice(boolean premium, double charge){
		float shippingPrice = (float) ((20*Conversion.Rounding(weight, 0))*quantity);
		if(premium){shippingPrice = (float) (shippingPrice + shippingPrice/charge);}
		shippingPrice = (float) Conversion.Rounding(shippingPrice, 2);
		return shippingPrice;
	}
	

	void printItemAttributes () {
		//Print all applicable attributes of this class
		System.out.println("Name: " + name);
		System.out.println("Category: " + category);
		System.out.println("Price: " + price);
		System.out.println("Quantity: " + quantity);
		System.out.println("weight: " + weight+ " (" + Conversion.Rounding(weight, 0)+ ")");
	}

}