package GlassDoor;

import java.util.Stack;

public class ReversePolishNotationDemo {
	public static void main(String[] args) {
		String operators = "+-*/";
		String[] input = { "2", "1", "+", "3", "*" };
		String[] input1 = { "4", "13", "5", "/", "+" };
		Stack<Integer> s = new Stack<>();
		for (String each : input1) {
			int index = operators.indexOf(each);
			if (index == -1) {
				s.push(Integer.parseInt(each));
			} else {
				int n1 = s.pop();
				int n2 = s.pop();

				switch (each) {
				case "+":
					s.push(n1 + n2);
					break;
				case "-":
					s.push(n1 - n2);
					break;
				case "*":
					s.push(n1 * n2);
					break;
				case "/":
					s.push(Math.max(n1, n2) / Math.min(n1, n2));
					break;
				}
			}
		}
		System.out.println(s.pop());
	}
}
