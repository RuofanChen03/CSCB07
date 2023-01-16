package Lab4Part2;

import java.util.HashSet;

public class Library {
	
	HashSet<Book> books;
	DeliveryService ds;
	
	public Library() {
		books = new HashSet<Book>();
	}
	
	public void setDeliveryService(DeliveryService ds) {
		this.ds = ds;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void removeBook(Book book) {
		books.remove(book);
	}
	
	public boolean bookExists(Book book) {
		return books.contains(book);
	}
	
	String determineBoxSize(Book book) {
		return ds.determineBoxSize(book);
	}
	
	void deliver(Book book, Customer customer) {
		if(bookExists(book)){
			ds.deliver(book, customer);
			removeBook(book);
		}
	}

}
