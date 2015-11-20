import java.util.Arrays;

public class Task5 {
	static int getAverage(int[] array) {
        int sum = Arrays.stream(array).sum();
        return sum / array.length;
    }
}
