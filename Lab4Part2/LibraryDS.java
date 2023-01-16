package Lab4Part2;

public class LibraryDS extends DeliveryService{

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
		if(max < 5)
			return "small";
		else if(max < 15)
			return "medium";
		else
			return "large";
	}
	
	@Override
	public void deliver(Deliverable item, Customer customer) {
		System.out.println("Delivering " + item);
		System.out.println("Delivery service: Books Express");
		System.out.println("Box size: " + determineBoxSize(item));
		System.out.println("Address: " + customer.getPostalCode());
	}
}
