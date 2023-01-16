package lab5part1;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Collectors;

public class MergeSortingService implements SortingService{

	@Override
	public List<Double> sort(List<Double> L) {
		int length = L.size();
		if (length > 0) {
			double[] input = new double[length];
			for(int i = 0; i < length; i++) {
				input[i] = L.get(i);		//just casting? .doubleValue()?
			}
			MergeSort.sort(input, 0, length-1);
			List<Double> sorted = DoubleStream.of(input).boxed().collect(Collectors.toList());
			return sorted;
		}
		return L;
	}

}
