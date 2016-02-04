
public class Task17 {
	static long fibTail(int n, long a, long b) {
		if (n == 0) {
			return a;
		}
		if (n == 1) {
			return b;
		}
		return fibTail(n - 1, b, a + b);
	}
	
	static long fib(int n) {
		return fibTail(n, 0, 1);
	}
	
	static long fibNumber(int n) {
		long[] fibs = new long[n];
		for (int i = 0; i < n; i++) {
			fibs[i] = fib(i + 1);
		}
		
		StringBuilder result = new StringBuilder();
		for (long f : fibs) {
			result.append(f);
		}
		
		return Long.parseLong(result.toString());
	}
}
