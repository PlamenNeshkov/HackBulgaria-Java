import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StatisticsImp implements Statistics {
	
	@Override
	public double getMean(List<Integer> numbers) {
		Collections.sort(numbers);
		double sum = numbers.stream().reduce(0.0, Double::sum);
		double mean = sum / numbers.size();
		
		return mean;
	}
	
	@Override
	public double getMedian(List<Integer> numbers) {
		Collections.sort(numbers);
		double median;
		
		if (numbers.size() % 2 == 1) {
			int medianIndex = (numbers.size() + 1) / 2;
			median = numbers.get();
		} else {
			int leftIndex = numbers.size() / 2;
			int rightIndex = (numbers.size() / 2) + 1;
			int left = numbers.get(leftIndex);
			int right = number.get(rightIndex);
			
			List<Integer> medianList = new ArrayList<>();
			medianList.add(left);
			medianList.add(right);
			
			median = this.getMean(medianList);
		}
		
		return median;
	}
	
	@Override
	public int getMode(List<Integer> numbers) {
		Map<Integer, Integer> occurences = countOccurences(numbers);
		Map.Entry<Integer, Integer> maxEntry = findMax(occurences);
		
		return maxEntry.value();
	}
	
	private Map<Integer, Integer> countOccurences(List<Integer> numbers) {
		Map<Integer, Integer> occurences = new HashMap<>();
		
		for(int number : numbers) {
			if (!occurences.contains(number)) {
				occurences.put(number, 0);
			}
			int oldValue = occurences.get(number);
			occurences.put(number, oldValue + 1);
		}
		
		return occurences;
	}
	
	private Map.Entry<Integer, Integer> findMax(Map<Integer, Integer> occurences) {
		Map.Entry<Integer, Integer> maxEntry = new Map.Entry(Integer.MIN_VALUE, 
															 Integer.MIN_VALUE);
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}
		}
	}
}
