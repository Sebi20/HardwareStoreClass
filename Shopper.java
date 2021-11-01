package homework4;

public class Shopper  implements Comparable<Shopper>{
	private String firstName;
	private String lastName;
	private ShoppingCart cart;
	
	public Shopper(String firstName, String lastName) {
		this.cart = new ShoppingCart();
		this.firstName = firstName;
		this.lastName = lastName;
		
	}// End of the Shopper constructor
	
	public void addItemToCart(Item item, int numItems) {
		for(int i = 1; i <= numItems; i++) {
			this.cart.addItem(item);
		}// End of the for loop
	}// End of the additemToCart method
	
	public void addItemToCart(Item item) {
		this.cart.addItem(item);
	}// End of the additemToCart method
	
	public int amountOwed() {
		double tax = cart.grandTotal() * 0.08875;
		return (int)Math.ceil(this.cart.grandTotal() + tax);// Adds the tax to the total
	}// End of the amountOwed method
	
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.cart.toString();
				
	}// End of the toString

	@Override
	public int compareTo(Shopper shopper) {
		if(this.amountOwed() > shopper.amountOwed()) {
			return -1;
		}else if(this.amountOwed() < shopper.amountOwed()) {
			return 1;
		}
		
		return 0;
	}// End of the compareTo method
	
	
	
}// End of the Shopper class