
public class Task7 {
	static long kthFac(int k, int n) {
    	if (k < 0 || n < 0) {
    		//TODO throw exception
    	}
    	long result = n;
    	for (int i = 0; i < k; i++) {
    		result = Task6.fac(result);
    	}
    	return result;
    }
}
