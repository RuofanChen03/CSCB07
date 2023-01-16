package lab5part2;

import java.util.Scanner;

public class Pizza extends Item{
	String size;
	
	// Added for precaution purposes
	public Pizza() {
		type = null;
		size = null;
	}
	
	@Override
	public void customize() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the pizza type: ");
		type = scan.next();
		System.out.println("Enter the pizza size (small/medium/large): ");
		size = scan.next();
		scan.close();
	}
	
	@Override
	public void prepare() {
		System.out.println("Preparing " + size + " " + type + " pizza");
	}
	
	@Override
	public void box() {
		System.out.println("Boxing " + size + " " + type + " pizza");
	}
}
