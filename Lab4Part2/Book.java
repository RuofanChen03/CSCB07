package Lab4Part2;

public class Book extends GeneralBook implements Deliverable{
	double length;
	double width;
	double height;
	
	public Book(String isbn, String title, double length, double width, double height) {
		this.isbn = isbn;
		this.title = title;
		this.length = length;
		this.width = width;
		this.height = height;
	}

	public double getLength() {
		return length;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}
}
