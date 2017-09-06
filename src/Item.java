
/*************************************************************************
 * Simulates an item from a vending machine with description, price and 
 * quantity.
 * 
 * CSCE 155A Spring 2016
 * Assignment 6 
 * From TRIEU HUNG TRAN, Assignment 4: Vending Machine II
 * @file Item.java
 * @author TRIEU HUNG TRAN
 * @date March 21, 2016
 *************************************************************************/
public class Item {

	//Data members
	private String desc;	//Description of the item
	private double price;	//Price of the item
	private int quantity;	//Quantity of the item
	
	/*********************************************************************
	 * This is the constructor of the Item class that take a description, 
	 * a price and a quantity to initialize an item.
	 * 
	 * @param desc description of the item
	 * @param price price of the item
	 * @param quantity quantity of the item
	 *********************************************************************/
	public Item(String desc, double price, int quantity) {
		this.desc = desc;
		this.price = price;
		this.quantity = quantity;
	}

	/*********************************************************************
	 * This getter returns the item's price.
	 * 
	 * @return the price of the item.
	 *********************************************************************/
	public double getPrice() {
		return price;
	}

	/*********************************************************************
	 * This getter returns the item's description.
	 * 
	 * @return the description of the item.
	 *********************************************************************/
	public String getDesc() {
		return desc;
	}

	/*********************************************************************
	 * This getter returns the item's quantity.
	 * 
	 * @return the quantity of the item.
	 *********************************************************************/
	public int getQuantity() {
		return quantity;
	}
	
	/*********************************************************************
	 * This method prints out the information of this item.
	 *********************************************************************/
	public void printInformation() {
		System.out.printf("%-12s%5.2f%7d\n", desc, price, quantity);
	}

	/*********************************************************************
	 * This setter sets the quantity of the item.
	 * 
	 * @param quantity the quantity to set
	 *********************************************************************/
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

} //End Item class definition.

