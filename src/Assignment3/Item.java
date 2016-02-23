package Assignment3;

public class Item { 
	//Declare variables for this class. Think about its type: public, protected or private?
	// You will need a constructor (Why?). Create it here.
	protected String category;
    protected String name;
    protected double price;
    protected int quantity;
    protected double weight;

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
	float calculatePrice() { 
		float final_price = 0;
		return final_price;
	}
	void printItemAttributes () {
		//Print all applicable attributes of this class
		System.out.println(name);
		System.out.println(category);
		System.out.println(price);
		System.out.println(quantity);
		System.out.println(weight);
	}
}