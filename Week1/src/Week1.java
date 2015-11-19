import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week1 {
    public static void main(String[] args) {
    	int[] nums = new int[] {10, 10};
        System.out.println(reverseEveryWord("hello word"));
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
    static long fac(long n) {
    	int fac = 1;
        for (long i = n; i >= 2; i--) {
            fac *= i;
        }
        return fac;
    }
    
    static long doubleFac(int n) {
        return fac(fac((int)n));
    }
    
    // Task 7
    static long kthFac(int k, int n) {
    	if (k < 0 || n < 0) {
    		//TODO throw exception
    	}
    	long result = n;
    	for (int i = 0; i < k; i++) {
    		result = fac(result);
    	}
    	return result;
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
    static long getLargestPalindrome(long n) {
        while (!isPalindrome(String.valueOf(--n)));
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
    static long pow(int a, int b) {
		if (b < 0) {
			//TODO throw exception - exponent < 0 is the same as bth root
		}
		if (b == 0) {
			if (a != 0) {
				return 1;
			} else {
				//TODO throw exception - 0^0 is undefined
			}
		}
		if (b % 2 == 0) {
			return pow(a*a, b/2);
		}
		if (b % 2 == 1) {
			return a * pow(a*a, b/2);
		}
    	return 0;
    }
    
    // Task 12
    static int getOddOccurrence(int[] array) {
    	Map<Integer, Integer> occurences = new HashMap<>();
    	for (int num : array) {
    		if (!occurences.containsKey(num)) {
    			occurences.put(num, 0);
    		}
    		occurences.put(num, occurences.get(num) + 1);
    	}
    	for (Integer num : occurences.keySet()) {
    		if (occurences.get(num) % 2 == 1) {
    			return num;
    		}
    	}
    	return -1;
    }
    
    // Task 13
    static long maximalScalarSum(int[] a, int[] b) {
    	Arrays.sort(a);
    	Arrays.sort(b);
    	long sum = 0;
    	for (int i : a) {
    		for (int j : b) {
    			sum += i * j;
    		}
    	}
    	return sum;
    }
    
    // Task 14
    static int maxSpan(int[] numbers) {
    	int[] unique = Arrays.stream(numbers).distinct().toArray();
    	int span = Integer.MIN_VALUE;
    	for (int val : unique) {
    		int i = -1;
    		while (numbers[++i] != val);
    		
    		int j = numbers.length;
    		while (numbers[--j] != val);
    		
    		int currSpan = 1 + (j - i);
    		if (currSpan > span) {
    			span = currSpan;
    		}
    	}
    	return span;
    }
    
    // Task 15
    static boolean canBalance(int[] numbers) {
    	int leftSum = 0;
    	int rightSum = 0;
    	for (int i = 0; i < numbers.length - 1; i++) {
    		leftSum = Arrays.stream(Arrays.copyOfRange(numbers, 0, i)).sum();
    		rightSum = Arrays.stream(Arrays.copyOfRange(numbers, i + 1, numbers.length - 1)).sum();
    		if (leftSum == rightSum) {
    			return true;
    		}
    	}
    	return false;
    }
    
    // Task 16
    static int[][] rescale(int[][] original, int newWidth, int newHeight) {
    	/*int[][] rescaled = new int[newWidth][newHeight];
    	int widthRatio = newWidth / 
    	
    	return rescaled;*/
    	return new int[1][1];
    }
    
    // Task 17
    static String reverseMe(String arg) {
    	return new StringBuffer(arg).reverse().toString();
    }
    
    // Task 18
    static String reverseEveryWord(String arg) {
    	StringBuilder reverse = new StringBuilder();
    	String[] words = arg.split("\\s+");
    	for (String word : words) {
    		reverse.append(new StringBuffer(word).reverse() + " ");
    	}
    	return reverse.toString();
    }
    
    // Task 19
    static boolean isPalindrome(String arg) {
        return arg.equals(new StringBuffer(arg).reverse().toString());
    }
    
    // Task 20
    static boolean isPalindrome(int arg) {
    	int argCopy = arg;
    	int reverse = 0;
    	while (argCopy > 0) {
    		int digit = argCopy % 10;
    		reverse = reverse*10 + digit;
    		argCopy /= 10;
    	}
    	return arg == reverse;
    }
    
    // Task 21
    static String copyEveryChar(String input, int k) {
    	StringBuilder output = new StringBuilder();
    	for (char c : input.toCharArray()) {
    		for (int i = 0; i < k; i++) {
    			output.append(c);
    		}
    	}
    	return output.toString();
    }
    
    // Task 22
    static int getPalindromeLength(String input) {
    	String[] sides = input.split("\\*");
    	char[] left = reverseMe(sides[0]).toCharArray();
    	char[] right = sides[1].toCharArray();
    	int i = -1;
    	while (left[++i] == right[i]);
    	return i;
    }
    
    // Task 23
    static int countOccurrences(String needle, String haystack) {
    	int occurences = 0;
    	while (haystack.contains(needle)) {
    		haystack = haystack.replaceFirst(needle, "");
    		occurences++;
    	}
    	return occurences;
    }
    
    // Task 24
    static String decodeUrl(String input) {
    	input = input.replace("%20", " ")
    	             .replace("%3A", ":")
    	             .replace("%3D", "?")
    	             .replace("%2F", "/");
    	return input;
    }
    
    // Task 25
    static int sumOfNumbers(String input) {
    	int sum = 0;
    	Pattern nums = Pattern.compile("\\d+");
    	Matcher m = nums.matcher(input);
    	while (m.find()) {
    		sum += Integer.parseInt(m.group());
    	}
    	return sum;
    }
    
    // Task 26
    static boolean anagram(String a, String b) {
    	for(char c : a.toCharArray()) {
    		b = b.replaceFirst(c+"", "");
    	}
    	return b.equals("");
    }
}

