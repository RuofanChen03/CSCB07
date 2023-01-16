package Lab4Part2;

public class GroceryStoreDS extends DeliveryService{

	@Override
	public String determineBoxSize(Deliverable item) {
		double length = item.getLength();
		double width = item.getWidth();
		double height = item.getHeight();
		double max = length;
		if(max < width)
			max = width;
		if(max < height)
			max = height;
		if(max < 10)
			return "small";
		else if(max < 20)
			return "medium";
		else if(max < 30)
			return "large";
		else
			return "x-large";
	}

	@Override
	public void deliver(Deliverable item, Customer customer) {
		System.out.println("Delivering " + item);
		System.out.println("Delivery service: Groceries Express");
		System.out.println("Box size: " + determineBoxSize(item));
		System.out.println("Address: " + customer.getPostalCode());
	}

}
