package lab3;

import java.util.List;

public abstract class SpecialNumber {
	
	// constructor???
	
	public abstract SpecialNumber add(SpecialNumber input) throws Lab3Exception;
	
	public abstract SpecialNumber divideByInt(int input) throws Lab3Exception;
	
	/**
	 * Computes and returns the average of a list of SpecialNumber elements.
	 * 
	 * @param a the list of SpecialNumber elements used to calculate the average
	 * @return average of list in type SpecialNumber if a is not null or not empty
	 * @throws Lab3Exception if a is null or a is empty
	 */
	public static SpecialNumber computeAverage(List<SpecialNumber> a) throws Lab3Exception {
		if ((a != null) && (!(a.isEmpty()))) {
			SpecialNumber sum = a.get(0);
			int size = a.size();
			for(int i = 1; i < size; i++) {
				sum = sum.add(a.get(i));
			}
			return sum.divideByInt(size);
		}
		else {
			throw new Lab3Exception("List cannot be empty");
		}
	}
}
