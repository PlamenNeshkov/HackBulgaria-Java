
public class Task9 {
	static long getLargestPalindrome(long n) {
        while (!Task19.isPalindrome(String.valueOf(--n)));
        return n;
    }
}
