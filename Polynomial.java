public class Polynomial{
	double[] coeffArr;
	
	public Polynomial(){
		coeffArr = new double[1];
		coeffArr[0] = 0;
	}
	
	public Polynomial(double[] inputArr){
		// Creating a deep copy; not a shallow copy
		int inputLength = inputArr.length;
		coeffArr = new double[inputLength];
		for (int i = 0; i < inputLength; i++){
			coeffArr[i] = inputArr[i];
		}
	}
	
	public Polynomial add(Polynomial input){
		int sumLength = Math.max(input.coeffArr.length, coeffArr.length);
		double[] sumCoeff = new double[sumLength];
		if (sumLength == input.coeffArr.length){
			for (int i = 0; i < sumLength; i++){
				sumCoeff[i] = input.coeffArr[i];
			}
			for (int i = 0; i < coeffArr.length; i++){
				sumCoeff[i] += coeffArr[i];
			}
		}
		else{
			for (int i = 0; i < sumLength; i++){
				sumCoeff[i] = coeffArr[i];
			}
			for (int i = 0; i < coeffArr.length; i++){
				sumCoeff[i] += input.coeffArr[i];
			}
		}
		Polynomial sum = new Polynomial(sumCoeff);
		return sum;
	}
	
	public double evaluate(double input){
		double value = 0;
		for (int i = 0; i < coeffArr.length; i++){
			value += coeffArr[i]*Math.pow(input, i);
		}
		return value;
	}
	
	public boolean hasRoot(double input){
		return (evaluate(input) == 0);
	}	
}