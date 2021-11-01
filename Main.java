package homework4;

import java.io.*;
import java.util.*;

public class Main{
	public static void main(String [] args) throws IOException{
		Scanner eventInput = new Scanner(new File("/Users/sebiseb/eclipse-workspace/DataStructures3130/src/homework4/event.txt"));
		Scanner inventoryInput = new Scanner(new File("/Users/sebiseb/eclipse-workspace/DataStructures3130/src/homework4/inventory.txt"));
		
		int itemPrice;// Variable for the price of an item
		String firstName, lastName, itemName;// Variables for the shopper and product names
		
		HardwareStore store = new HardwareStore(6);// Hardware store has 6 cashiers
		ArrayList<Item> inventory = new ArrayList<Item>();// Storing the Store's inventory in this list
		
		while(inventoryInput.hasNextLine()) {
			Item item = new Item(itemName = inventoryInput.next(), itemPrice = inventoryInput.nextInt());
			inventory.add(item);
		}// End of the inventory while loop
		
		while(eventInput.hasNext()) {
			Shopper shopper = new Shopper(firstName = eventInput.next(), lastName = eventInput.next());// Gets the name of the shoppers
			int amount  = eventInput.nextInt();// Gets the amount of unique items that the shopper has
			
			int i = 0;
			while(i < amount) {
				itemName = eventInput.next();// Gets the name of the item
				int numItems = eventInput.nextInt();// Gets the number of each unique item
				
				/*This loop looks for the price of the item, creates an item object and then adds the item to the shopper's shopping cart*/ 
				for(int j = 0; j < inventory.size(); j++) {
					
					if(itemName.equals(inventory.get(j).getName())) {
						Item it = new Item(itemName, inventory.get(j).getPrice());
						shopper.addItemToCart(it, numItems);
					}// End of the if statement
					
				}// End of the for loop
				
				i++;// Increments the i for the loop conditional
			
			}// End of the while loop
			
			store.addShopperToLine(shopper);// After each line has been read in, a shopper is added to the store
			System.out.println(shopper);// Prints out the shopper and their items
			
		}// End of the event while loop
		
		System.out.println("The total revenue collected by the store: $" + store.totalRevenue());
		store.checkoutAllShoppers();
	
	}// End of the main method
	
	
}