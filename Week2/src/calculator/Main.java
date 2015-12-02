package calculator;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hello!");
		System.out.println();
		
		final String inPrompt = "Enter expression:> ";
		final String outPrompt = "Output:> ";
		
		System.out.print(inPrompt);
		String input = sc.nextLine();
		
		while (!input.equals("exit")) {
			String[] rpn = ShuntingYard.infixToRpn(input);
			double result = ShuntingYard.evaluateRpn(rpn);
			
			System.out.print(outPrompt);
			System.out.println(result);
			
			System.out.print(inPrompt);
			input = sc.nextLine();
		}
		
		System.out.println();
		System.out.println("Bye!");
	}
}
