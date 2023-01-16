package Lab4Part2;

public abstract class DeliveryService {
	public abstract String determineBoxSize(Deliverable item);
	
	public abstract void deliver(Deliverable item, Customer customer);
}
