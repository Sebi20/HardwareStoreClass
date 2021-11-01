package homework4;

import java.util.*;

public class ShoppingCart{
	private ArrayList<Item> cart;
	
	public ShoppingCart() {
		cart = new ArrayList<Item>();
	}// End of the constructor
	
	public void addItem(Item item) {
			cart.add(item);
		
	}// End of the additem method
	
	public int grandTotal() {
		int cnt = 0;
		for(int i = 0; i < cart.size(); i++) {
			cnt += this.cart.get(i).getPrice();
		}
		return cnt * 100;
	}// End of the grandTotal method
	
	public int numItems() {
		return this.cart.size();
	}// End of the numItems method
	
	public String toString() {
		return this.cart + "";
	}// End of the toString method
	
}// End of the ShoppingCart class