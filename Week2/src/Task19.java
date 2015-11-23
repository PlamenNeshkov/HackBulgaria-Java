
public class Task19 {
	static boolean isIncreasing(int[] sequence) {
		for (int i = 0; i < sequence.length - 1; i++) {
			if (sequence[i] > sequence[i + 1]) {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean isDecreasing(int[] sequence) {
		return !isIncreasing(sequence);
	}
}
