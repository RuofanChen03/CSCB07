package lab3;

public class Lab3Exception extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	
	public Lab3Exception(String input) {
		message = input; // Due to immutability of strings in Java
	}
	
	@Override
	public String toString() {
		return "Lab3Exception: " + message;
	}
}
