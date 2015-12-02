package calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ShuntingYard {
	private static final int LEFT_ASSOCIATIVE = 0;
	private static final int RIGHT_ASSOCIATIVE = 1;
	
	private static final Map<String, int[]> OPERATORS = new HashMap<String, int[]>() {{
		put("+", new int[] {0, LEFT_ASSOCIATIVE});
		put("-", new int[] {0, LEFT_ASSOCIATIVE});
		put("*", new int[] {1, LEFT_ASSOCIATIVE});
		put("/", new int[] {1, LEFT_ASSOCIATIVE});
		put("^", new int[] {2, RIGHT_ASSOCIATIVE});
	}};
	
	private static boolean isOperator(String token) {
		return OPERATORS.containsKey(token);
	}
	
	private static boolean checkAssoc(String token, int assoc) {
		return OPERATORS.get(token)[1] == assoc;
	}
	
	private static int getPrecedence(String token) {
		return OPERATORS.get(token)[0];
	}
	
	public static String[] infixToRpn(String input) {
		String[] tokens = input.split("");
		
		List<String> output = new ArrayList<>();
		Stack<String> opStack = new Stack<>();
		
		for (String token : tokens) {
			if (isOperator(token)) {		
				while (!opStack.isEmpty() && isOperator(opStack.peek())) {		
					
					if ((checkAssoc(token, LEFT_ASSOCIATIVE) 
					     && (getPrecedence(token) <= getPrecedence(opStack.peek())))  
					 || (checkAssoc(token, RIGHT_ASSOCIATIVE)
						 && (getPrecedence(token) < getPrecedence(opStack.peek())))) {
						
						output.add(opStack.pop());
					
					} else {
						break;
					}
				}
				opStack.push(token);
			} else if (token.equals("(")) {
				opStack.push(token);
			} else if (token.equals(")")) {
				while (!opStack.isEmpty() && !opStack.peek().equals("(")) {
					output.add(opStack.pop());
				}
				opStack.pop();
			} else {
				output.add(token);
			}
		}
		
		while (!opStack.isEmpty()) {
			output.add(opStack.pop());
		}
		
		String[] result = new String[output.size()];
		return output.toArray(result);
	}
	
	public static double evaluateRpn(String[] tokens) {
		Stack<Double> numStack = new Stack<>();
		for (String token : tokens) {
			if (isOperator(token)) {
				double right = numStack.pop();
				double left = numStack.pop();
				
				switch (token) {
				case "+":
					numStack.push(left + right);
					break;
				case "-":
					numStack.push(left - right);
					break;
				case "*":
					numStack.push(left * right);
					break;
				case "/":
					numStack.push(left / right);
					break;
				}
			} else {
				numStack.push(Double.parseDouble(token));
			}
		}
		
		return numStack.pop();
	}
}
