import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task33 {
	static char getLetter(int number, int timesPressed) {
		String letters = new String();
		switch (number) {
			case 2:
				letters = "abc";
				break;
			case 3:
				letters = "def";
				break;
			case 4:
				letters = "ghi";
				break;
			case 5:
				letters = "jkl";
				break;
			case 6:
				letters = "mno";
				break;
			case 7:
				letters = "pqrs";
				break;
			case 8:
				letters = "tuv";
				break;
			case 9:
				letters = "wxyz";
				break;
		}
		
		timesPressed = (timesPressed - 1) % (letters.length());
		
		return letters.charAt(timesPressed);
	}
	
	static String numbersToMessage(int[] numbers) {
		boolean toCapitalize = false;
		int currNum;
		int currCount = 0;
		char currLetter;
		StringBuilder msg = new StringBuilder();
		
		for (int i = 0; i < numbers.length; i++) {
			currNum = numbers[i];
			switch (currNum) {
				case 0:
					msg.append(" ");
					break;
				case 1:
					toCapitalize = true;
					break;
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
					currCount = 0;
					while (numbers[i] == currNum) {
						currCount++;
						i++;
						if (i == numbers.length) {
							break;
						}
					}
					i--;
					
					currLetter = getLetter(currNum, currCount);
					if (toCapitalize) {
						currLetter = Character.toUpperCase(currLetter);
						toCapitalize = false;
					}
					msg.append(currLetter);
					break;
				default:
			}
		}
		return msg.toString();
	}
	
	static int[] messageToNumbers(String msg) {
		char[] chars = msg.toCharArray();
		List<Integer> numbers = new ArrayList<>();
		
		Map<Integer, String> keypad = new HashMap<>();
		
		for (int i = 0; i < chars.length; i++) {
			
		}
		// TODO Implement this function
		return new int[];
	}
}
