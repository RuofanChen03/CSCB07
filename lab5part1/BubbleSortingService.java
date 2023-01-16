package lab5part1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class BubbleSortingService implements SortingService{

	@Override
	public List<Double> sort(List<Double> L) {
		int length = L.size();
		if (length > 0) {
			double[] input = new double[length];
			for(int i = 0; i < length; i++) {
				input[i] = L.get(i);		//just casting? .doubleValue()?
			}
			BubbleSort.sortArray(input);
			List<Double> sorted = DoubleStream.of(input).boxed().collect(Collectors.toList());
			return sorted;
		}
		return L;
	}

}
