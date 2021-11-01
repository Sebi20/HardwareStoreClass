package homework4;

public class Item{
	private String name;
	private int price;
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}// End of the constructor
	
	public String getName() {
		return this.name;
	}// End of the getName method
	
	public int getPrice() {
		return this.price;
	}// End of the getPrice method
	
	public String toString() {
		return this.name + ": $" + this.price;
	}// End of the toString method
	
}// End of the Item class