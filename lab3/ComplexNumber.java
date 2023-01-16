package lab3;

public class ComplexNumber extends SpecialNumber implements Comparable<ComplexNumber>{

	double real;
	double imaginary;
	
	public ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	@Override
	public SpecialNumber add(SpecialNumber input) throws Lab3Exception {
		if (input instanceof ComplexNumber) {
			double newReal = this.real + ((ComplexNumber)input).real;
			double newImag = this.imaginary + ((ComplexNumber)input).imaginary;
			return (SpecialNumber) (new ComplexNumber(newReal, newImag));
		}
		else {
			throw new Lab3Exception("Cannot add an incompatible type");
		}
	}

	@Override
	public SpecialNumber divideByInt(int input) throws Lab3Exception {
		if (input != 0) {
			double newReal = this.real/(double)input;
			double newImag = this.imaginary/(double)input;
			return (SpecialNumber) (new ComplexNumber(newReal, newImag));
		}
		else {
			throw new Lab3Exception("Cannot divide by zero");
		}
	}
	
	@Override
	public int compareTo(ComplexNumber o) {
		double d1 = Math.pow(this.real, 2) + Math.pow(this.imaginary, 2);
		double d2 = Math.pow(o.real, 2) + Math.pow(o.imaginary, 2);
		if(d1 > d2) {
			return 1;
		}
		else if(d1 < d2) {
			return -1;
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object a) {
		if (this == a) 
			return true;
		if (a == null) 
			return false;
		if (getClass() != a.getClass()) 
			return false;
		ComplexNumber cnA = (ComplexNumber) a;
		return ((cnA.real == this.real) && (cnA.imaginary == this.imaginary));
	}
	
	@Override
	public int hashCode() {
		return (int) (real*Math.pow(10, 5) + imaginary);
	}
}
