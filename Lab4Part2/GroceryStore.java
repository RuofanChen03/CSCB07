package Lab4Part2;

import java.util.HashSet;

public class GroceryStore {
	
	HashSet<GroceryItem> items;
	DeliveryService ds;
	
	public GroceryStore() {
		items = new HashSet<GroceryItem>();
	}
	
	public void setDeliveryService(DeliveryService ds) {
		this.ds = ds;
	}
	
	public void addItem(GroceryItem item) {
		items.add(item);
	}
	
	public void removeItem(GroceryItem item) {
		items.remove(item);
	}
	
	public boolean itemExists(GroceryItem item) {
		return items.contains(item);
	}
	
	String determineBoxSize(GroceryItem item) {
		return ds.determineBoxSize(item);
	}
	
	void deliver(GroceryItem item, Customer customer) {
		if(itemExists(item)){
			ds.deliver(item, customer);
			removeItem(item);
		}
	}

}
