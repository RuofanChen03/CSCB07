import java.io.*;
import java.util.Scanner;

public class Polynomial {
	double[] coeffArr;
	int[] expArr;
	
	public Polynomial(){
		coeffArr = new double[1];
		coeffArr[0] = 0;
		expArr = new int[1];
		expArr[0] = 0;
	}
	
	public Polynomial(double[] inputCoeffs, int[] inputExps){
		// Creating a deep copy; not a shallow copy
		int inputLength = inputCoeffs.length;
		coeffArr = new double[inputLength];
		expArr = new int[inputLength];
		for (int i = 0; i < inputLength; i++){
			coeffArr[i] = inputCoeffs[i];
			expArr[i] = inputExps[i];
		}
	}
	
	public Polynomial(File input) throws FileNotFoundException{
		Scanner sc = new Scanner(input);
		String polynomial = sc.nextLine();
		String[] inputs = polynomial.split("[+\\-]");
		// missing negatives
		
		if (inputs[0].equals("")) {
			coeffArr = new double[inputs.length-1];
			expArr = new int[inputs.length-1];
		}
		else {
			coeffArr = new double[inputs.length];
			expArr = new int[inputs.length];
		}
		int counter = 0;
		for(String a : inputs) {
			if (!a.equals("")) {
				if(a.indexOf("x") > -1) {
					String[] parts = a.split("x");
					coeffArr[counter] = Double.parseDouble(parts[0]);
					expArr[counter] = Integer.parseInt(parts[1]);
				}
				else {
					coeffArr[counter] = Double.parseDouble(a);
					expArr[counter] = 0;
				}
				int x = polynomial.indexOf(a);
				if ((x>0) && (polynomial.charAt(x-1) == '-')) {
					coeffArr[counter] *= -1;
				}
				counter++;
			}
		}
		sc.close();
	}
	
	public Polynomial add(Polynomial input){
		int highestExp = 0;
		for(int i = 0; i < expArr.length; i++){
			if (expArr[i] > highestExp){
				highestExp = expArr[i];
			}
		}
		for(int i = 0; i < input.expArr.length; i++){
			if (input.expArr[i] > highestExp){
				highestExp = input.expArr[i];
			}
		}
		highestExp++;

		double[] sumCoeff1 = new double[highestExp];
		int[] sumExp1 = new int[highestExp];
		
		for(int i = 0; i < expArr.length; i++){
			sumCoeff1[expArr[i]] += coeffArr[i];
		}
		
		for(int i = 0; i < input.expArr.length; i++){
			sumCoeff1[input.expArr[i]] += input.coeffArr[i];
		}
		
		int sumLength = 0;
		for(int i = 0; i < highestExp; i++){
			if (sumCoeff1[i] != 0){
				sumLength++;
			}
		}
		
		double[] sumCoeff2 = new double[sumLength];
		int[] sumExp2 = new int[sumLength];
		int counter = 0;
		for (int i = 0; i < highestExp; i++){
			sumExp1[i] = i;
			if (sumCoeff1[i] != 0){
				sumCoeff2[counter] = sumCoeff1[i];
				sumExp2[counter] = sumExp1[i];
				counter++;
			}
		}
		
		Polynomial sum = new Polynomial(sumCoeff2, sumExp2);
		return sum;
	}
	
	public double evaluate(double input){
		double value = 0;
		for (int i = 0; i < coeffArr.length; i++){
			value += coeffArr[i]*Math.pow(input, expArr[i]);
		}
		return value;
	}
	
	public boolean hasRoot(double input){
		return (evaluate(input) == 0);
	}
	
	public Polynomial multiply(Polynomial input){
		int highestExp = input.expArr[input.expArr.length-1] * expArr[expArr.length-1];
		highestExp++;
		double[] productCoeff1 = new double[highestExp];
		int[] productExp1 = new int[highestExp];
		
		for(int i = 0; i < expArr.length; i++){
			for(int j = 0; j < input.expArr.length; j++){
				productCoeff1[i+j] += coeffArr[i]*input.coeffArr[j];
				productExp1[i+j] = (expArr[i] + input.expArr[j]);
			}
		}
		
		int productLength = 0;
		for(int i = 0; i < highestExp; i++){
			if (productCoeff1[i] != 0){
				productLength++;
			}
		}
		
		double[] productCoeff2 = new double[productLength];
		int[] productExp2 = new int[productLength];
		int counter = 0;
		for (int i = 0; i < highestExp; i++){
			if (productCoeff1[i] != 0){
				productCoeff2[counter] = productCoeff1[i];
				productExp2[counter] = productExp1[i];
				counter++;
			}
		}
		
		Polynomial product = new Polynomial(productCoeff2, productExp2);
		return product;
	}

	public void saveToFile(String fileName) throws IOException {
		FileWriter fw = new FileWriter(fileName);
		String output = "";
		for(int i = 0; i < expArr.length; i++) {
			if(expArr[i] != 0) {
				if (coeffArr[i]>0) {
					output += "+";
				}
				output += coeffArr[i] + "x" + expArr[i];
			}
			else if(expArr[i] == 1) {
				if (coeffArr[i]>0) {
					output += "+";
				}
				output += coeffArr[i] + "x";
			}
			else {
				output += coeffArr[i];
			}
		}
		output += "\n";
		fw.write(output);
		fw.close();
	}
	
	public void printPolynomial() {
		String output = "";
		for(int i = 0; i < expArr.length; i++) {
			if(expArr[i] != 0) {
				if (coeffArr[i]>0) {
					output += "+";
				}
				output += coeffArr[i] + "x" + expArr[i];
			}
			else if(expArr[i] == 1) {
				if (coeffArr[i]>0) {
					output += "+";
				}
				output += coeffArr[i] + "x";
			}
			else {
				output += coeffArr[i];
			}
		}
		System.out.println(output);
	}
}
