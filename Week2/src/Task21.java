
public class Task21 {
	static int maxIncreasingConsecutive(int[] items) {
		int maxIncreasing = Integer.MIN_VALUE;
		int currIncreasing = 1;
		
		for (int i = 1; i < items.length; i++) {
			if (items[i] >= items[i - 1]) {
				currIncreasing++;
			} else {
				if (currIncreasing > maxIncreasing) {
					maxIncreasing = currIncreasing;
				}
				currIncreasing = 1;
			}
		}
		
		if (currIncreasing >= maxIncreasing) {
			maxIncreasing = currIncreasing;
		}
		
		return maxIncreasing;
	}
}
