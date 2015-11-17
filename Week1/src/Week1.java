import java.util.Arrays;

public class Week1 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(getSmallestMultiple(5));
    }

    // Task 1
    static boolean isOdd(int n) {
        return n % 2 == 1;
    }

    // Task 2
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n <= 3) {
            return true;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i*i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Task 3
    static int min(int[] array) {
        Arrays.sort(array);
        return array[0];
    }

    // Task 4
    static int kthMin(int k, int[] array) {
        Arrays.sort(array);
        return array[k];
    }

    // Task 5
    static int getAverage(int[] array) {
        int sum = Arrays.stream(array).sum();
        return sum / array.length;
    }

    // Task 6
    static long doubleFac(int n) {
        int fac = 1;
        for (int i = n; i >= 2; i++) {
            fac *= i;
        }
        return fac;
    }

    // Task 7
    static long kthFac(int k, int n) {
        return 1L;
    }

    // Task 8
    static long getSmallestMultiple(int upperBound) {
        long multiple = 1;
        boolean divisible = false;
        while (!divisible) {
            divisible = true;
            for (int i = 1; i <= upperBound; i++) {
                if (multiple % i != 0) {
                    divisible = false;
                    multiple++;
                    break;
                }
            }
        }
        return multiple;
    }

    // Task 9
    static boolean isPalindrome(long n) {
        String nString = Long.toString(n);
        return nString.equals(new StringBuffer(nString).reverse().toString());
    }

    static long getLargestPalindrome(long n) {
        while (!isPalindrome(--n)) {
            n--;
        }
        return n;
    }

    // Task 10
    static int[] histogram(short[][] image) {
        int[] result = new int[255];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                result[image[i][j]]++;
            }
        }
        return result;
    }

    // Task 11
 }
