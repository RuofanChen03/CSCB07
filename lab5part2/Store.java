package lab5part2;

public abstract class Store {
	
	public abstract Item factoryMethodConstruct();
	
	public Item order() {
		Item item = factoryMethodConstruct();
		item.customize();
		item.prepare();
		item.box();
		return item;
	}
}
