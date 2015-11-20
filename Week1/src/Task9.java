
public class Task9 extends Task19 {
	static long getLargestPalindrome(long n) {
        while (!isPalindrome(String.valueOf(--n)));
        return n;
    }
}
