package lab3;

/**
 * Extends from <code>SpecialNumber</code> and represents a rational number
 * with integer numerator and denominator values; contains methods that allow
 * elementary modifications to rational numbers.
 * @author  Ruofan Chen
 * @version 1.0, 10/18/22
 */

public class RationalNumber extends SpecialNumber implements Comparable<RationalNumber>{
	int numerator;
	int denominator;
	
	/**
	 * Constructor of <code>RationalNumber</code> that takes in two integers and initializes
	 * numerator and denominator accordingly if values are acceptable.
	 * @param numerator the numerator to be assigned and recorded
	 * @param denominator the denominator to be assigned and recorded
	 * @throws Lab3Exception if the denominator is 0 (i.e., not valid rational number)
	 */
	public RationalNumber(int numerator, int denominator) throws Lab3Exception {
		if (denominator == 0) {
			throw new Lab3Exception("Denominator cannot be zero");
		}
		this.numerator = numerator;
		this.denominator = denominator;
	}

	private int gcd(int a, int b) {
		int min = Math.abs(Math.min(a, b));
		
		for(int i = min; i > 1; i--) {
			if ((a%i == 0) && (b%i == 0)) {
				return i;
			}
		}
		return 1;
	}
	
	/**
	 * This method overrides superclass <code>SpecialNumber</code>'s abstract add method
	 * and adds two rational numbers together; then it is reduced to lowest terms and returned
	 * while parsed as <code>SpecialNumber</code>.
	 * @param input the entered <code>RationalNumber</code> parsed as type <code>SpecialNumber</code> 
	 * @return the sum of the current <code>RationalNumber</code> with input parsed as type <code>SpecialNumber</code>
	 * @throws Lab3Exception if input is not of type <code>RationalNumber</code>
	 */
	@Override
	public SpecialNumber add(SpecialNumber input) throws Lab3Exception {
		if (input instanceof RationalNumber) {
			int newDenom = ((RationalNumber) input).denominator * this.denominator;
			int newNumer = this.numerator * (((RationalNumber) input).denominator);
			newNumer += ((RationalNumber) input).numerator  * this.denominator;
			int reducingFactor = gcd(newDenom, newNumer);
			newDenom = newDenom/reducingFactor;
			newNumer = newNumer/reducingFactor;
			return (SpecialNumber) (new RationalNumber(newNumer, newDenom));
		}
		else {
			throw new Lab3Exception("Cannot add an incompatible type");
		}
	}

	/**
	 * This method overrides superclass <code>SpecialNumber</code>'s abstract divideByInt method
	 * and divides this current instance of rational number by an integer input while parsed as
	 * <code>SpecialNumber</code>.
	 * @param input the integer used for the division
	 * @return the divident of the current <code>RationalNumber</code> with input parsed as type <code>SpecialNumber</code>
	 * @throws Lab3Exception if input is 0
	 */
	@Override
	public SpecialNumber divideByInt(int input) throws Lab3Exception {
		if (input != 0) {
			int greatestCD = gcd(input, this.numerator);
			int newNumer = this.numerator/greatestCD;
			int newDenom = this.denominator*(input/greatestCD);
			return (SpecialNumber) (new RationalNumber(newNumer, newDenom));
		}
		else {
			throw new Lab3Exception("Cannot divide by zero");
		}
	}
	
	/** 
	* This method overrides the superclass <code>int compareTo(Object obj)</code> and compares two
	* <code>RationalNumber</code> objects.
	* @param a the rational number to be compared with
	* @return -1 if a is less than this <code>RationalNumber</code>, 0 if they are 
	*  equal, and 1 otherwise 
	*/
	@Override
	public int compareTo(RationalNumber a) {
		double difference = ((double)this.numerator/(double)this.denominator)-((double)a.numerator/(double)a.denominator);
		if(difference > 0) {
			return 1;
		}
		else if(difference < 0) {
			return -1;
		}
		return 0;
	}
	
	/** 
	* This method overrides the superclass method <code>boolean equals(Object obj)</code> and checks if
	* the current <code>RationalNumber</code> is equivalent with the input <code>RationalNumber</code>.
	* @param a the object to be checked if equal to current <code>RationalNumber</code>
	* @return true if the double values of the current rational number and a are equivalent, false otherwise
	*/
	@Override
	public boolean equals(Object a) {
		if (this == a) 
			return true;
		if (a == null) 
			return false;
		if (getClass() != a.getClass()) 
			return false;
		RationalNumber rnA = (RationalNumber) a;
		double d1 = (double)numerator/(double)denominator;
		double d2 = (double)rnA.numerator/(double)rnA.denominator;
		return (d1 == d2);
	}
	
	/**
	 * This method overrides the superclass method <code>int hashCode()</code> and generates an unique
	 * integer hash code for the current rational number.
	 * @return integer hash code for this current rational number based on its numerator and denominator values 
	 */
	@Override
	public int hashCode() {
		return (int) (((double)numerator/(double)denominator)*Math.pow(10, 5));
	}
}
