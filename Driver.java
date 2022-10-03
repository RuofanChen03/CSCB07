import java.io.File;
import java.io.IOException;

public class Driver {
	 public static void main(String [] args) throws IOException { 
		  Polynomial p = new Polynomial(); 
		  System.out.println(p.evaluate(3)); 
		  
		  double [] c1 = {6,1,5};
		  int[] d1 = {0, 1, 3};
		  Polynomial p1 = new Polynomial(c1, d1);
		  p1.printPolynomial();
		  
		  double [] c2 = {-2,-9};
		  int[] d2 = {1, 4};
		  Polynomial p2 = new Polynomial(c2, d2);
		  p2.printPolynomial();
		  
		  Polynomial s = p1.add(p2);
		  s.printPolynomial();
		  System.out.println("s(0.1) = " + s.evaluate(0.1));
		  
		  if(s.hasRoot(1)) 
			  System.out.println("1 is a root of s"); 
		  else 
			  System.out.println("1 is not a root of s"); 
		  
		  Polynomial s2 = p1.multiply(p2);
		  System.out.println("Product of above polynomials:");
		  s2.printPolynomial();
		  
		  File a = new File("a.txt");
		  Polynomial s3 = new Polynomial(a);
		  System.out.println("Polynomial from file:");
		  s3.printPolynomial();
		  
		  s2.saveToFile("b.txt");
		  System.out.println("Check if product saved in b.txt!");
	 }
}

