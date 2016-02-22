package Assignment3;

public class Item { 
	//Declare variables for this class. Think about its type: public, protected or private?
	// You will need a constructor (Why?). Create it here.
	private String category;
    private String name;
    private double price;
    private int quantity;
    private String details;

    /*******************************************************
    *  Create a new item with the given attributes.		 *
    ******************************************************/
    public Item (String itemName, String type, double itemPrice, int numPurchased, String extra)
    {
      name = itemName;
      category = type;
      price = itemPrice;
      quantity = numPurchased;
      details = type;
    }


	float calculatePrice() { float final_price = 0;
	// Insert price calculation here return final_price;
	return 0;
	}
	void printItemAttributes () {
		//Print all applicable attributes of this class
	}
}