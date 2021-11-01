package homework4;

import java.util.*;


public class HardwareStore{
	private PriorityQueue<Shopper> shopper;
	private ArrayList<Queue<Shopper>> queue;
	
 	
	public HardwareStore(int numRegisters) {
		this.shopper = new PriorityQueue<Shopper>();     
		queue = new ArrayList<Queue<Shopper>>();
		
		for(int i = 0; i < numRegisters; i++) {
			Queue<Shopper> q = new LinkedList<Shopper>();
			queue.add(q);
			
		}// End of the for loop
	}// End of the constructor
	
	public void addShopperToLine(Shopper shopper) {
		this.shopper.add(shopper);
	}// End of addShopperToLine method
	
	public void checkoutAllShoppers() {
		while(!shopper.isEmpty()) {// While there are shoppers left in the store
			for(int i = 0; i < queue.size(); i++) {
				int min = queue.get(0).size();// The queue with the smallest number of people in given to the 1st of the list
				
				for(int j = 0; j < queue.size(); j++) {
				
					if(queue.get(j).size() < min) {
					min = queue.get(j).size();
					}// End of the if statement
				}// End of inner for loop
			
				/*if the size of the min matches the size of the queue then the shopper is added to the list*/ 
				if(queue.get(i).size() == min) {
					queue.get(i).offer(shopper.poll());
				}// End of the if statement
				
				
			}// End of outer for loop
		
		}// End of the while loop
		
		// This pops the queues from the longest to the shortest 
		for(int k = queue.size() - 1; k <= 0; k--) {
			queue.get(k).poll();
		}// End of the for loop
		
	}// End of the checkoutAllShoppers method
	
	public double totalRevenue() {
		double sum = 0;
		while(!shopper.isEmpty()) {
			sum += shopper.poll().amountOwed();
		}
		
		return sum/100;
	}
	
	
	
	
}// End of the HardwareStore class