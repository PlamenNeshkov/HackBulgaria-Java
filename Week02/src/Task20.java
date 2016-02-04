
public class Task20 {
	static int maxEqualConsecutive(int[] items) {
		int maxEqual = Integer.MIN_VALUE;
		int currEqual = 1;
		
		for (int i = 1; i < items.length; i++) {
			if (items[i] == items[i - 1]) {
				currEqual++;
			} else {
				if (currEqual > maxEqual) {
					maxEqual = currEqual;
				}
				currEqual = 1;
			}
		}
		
		if (currEqual > maxEqual) {
			maxEqual = currEqual;
		}
		
		return maxEqual;
	}
}
