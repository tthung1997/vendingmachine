import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Simulates a real life vending machine with stock read from a file.
 * (Jeremy Suing).
 * 
 * CSCE 155A Spring 2016
 * Assignment 6
 * @author TRIEU HUNG TRAN
 * @date April 23, 2016
 */
public class VendingMachine {
	
	//Data members
	private Item[] stock;  //Array of Item objects in machine
	
	/*********************************************************************
	 * This is the constructor of the VendingMachine class that take a
	 * file name for the items to be loaded into the vending machine.
	 *
	 * It creates objects of the Item class from the information in the 
	 * file to populate into the stock of the vending machine.  It does
	 * this by looping the file to determine the number of items and then
	 * reading the items and populating the array of stock. 
	 * 
	 * @author Jeremy Suing
	 * @param filename Name of the file containing the items to stock into
	 * this instance of the vending machine. 
	 * @throws FileNotFoundException If issues reading the file.
	 *********************************************************************/
	public VendingMachine(String filename) throws FileNotFoundException {
		//Open the file to read with the scanner
		File file = new File(filename);
		Scanner scan = new Scanner(file);

		//Determine the total number of items listed in the file
		int totalItem = 0;
		while (scan.hasNextLine()){
			scan.nextLine();
			totalItem++;
		} //End while another item in file
		//Create the array of stock with the appropriate number of items
		stock = new Item[totalItem];
		scan.close();

		//Open the file again with a new scanner to read the items
		scan = new Scanner(file);
		int itemQuantity = -1;
		double itemPrice = -1;
		String itemDesc = "";
		int count = 0;
		String line = "";

		//Read through the items in the file to get their information
		//Create the item objects and put them into the array of stock
		while(scan.hasNextLine()){
			line = scan.nextLine();
			String[] tokens = line.split(",");
			try {
				itemDesc = tokens[0];
				itemPrice = Double.parseDouble(tokens[1]);
				itemQuantity = Integer.parseInt(tokens[2]);

				stock[count] = new Item(itemDesc, itemPrice, itemQuantity);
				count++;
			} catch (NumberFormatException nfe) {
				System.out.println("Bad item in file " + filename + 
						" on row " + (count+1) + ".");
			}
		} //End while another item in file
		scan.close();
	}//End VendingMachine Constructor
	
	/**
	 * This method searches for a specific item in stock with its id in the 
	 * vending machine.
	 * @param id item's id in the vending machine
	 * @return -1 if cannot find, otherwise, the index of that item
	 */
	public int searchID(String id) {
		for(int index = 0; index < Math.min(stock.length, 36); index++) 
			if (getInfo(index).substring(0, 2).equals(id))
				return index;
		return -1;
	}
	
	/**
	 * This method searches for a specific item in stock with its description.
	 * @param item description of item
	 * @return -1 if cannot find, otherwise, the index of that item
	 */
	public int searchItem(String item) {
		for(int index = 0; index <  Math.min(stock.length, 36); index++) 
			if (stock[index].getDesc().equalsIgnoreCase(item))
				return index;
		return -1;
	}
	
	/**
	 * This method returns the information of a specific item.
	 * @param index index of item in stock
	 * @return a string includes the whole information of that item
	 */
	public String getInfo(int index) {
		DecimalFormat df = new DecimalFormat("0.00");
		return ("" + (char)((int)('A') + index / 6) + 
				((index + 1) % 6 == 0 ? 6 : (index + 1) % 6) + 
				": " + stock[index].getDesc() + 
				" - $" + df.format(stock[index].getPrice()) + 
				" (" + stock[index].getQuantity() + ")");
	}
	
	/**
	 * @return Item array stock
	 */
	public Item[] getStock() {
		return stock;
	}
	
}//End VendingMachine class definition

