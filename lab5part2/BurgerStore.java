package lab5part2;

public class BurgerStore extends Store{
	public Item factoryMethodConstruct() {
		return new Burger();
	}
}
