import java.util.Arrays;

public class Task4 {
	static int kthMin(int k, int[] array) {
        Arrays.sort(array);
        return array[k];
    }
}
