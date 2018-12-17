package com.accpeted.submissions;

import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {

	}

	public boolean isValid(String s) {
		Stack<Character> openBrackets = new Stack<Character>();
		for (Character eachBracket : s.toCharArray()) {
			if (eachBracket == '(' || eachBracket == '{' || eachBracket == '[')
				openBrackets.push(eachBracket);
			else if ((eachBracket == ')' || eachBracket == '}' || eachBracket == ']') && !openBrackets.isEmpty()) {
				Character cuurentOpenBracket = openBrackets.pop();
				if (cuurentOpenBracket == '(' && eachBracket != ')' || cuurentOpenBracket == '{' && eachBracket != '}'
						|| cuurentOpenBracket == '[' && eachBracket != ']') {
					return false;
				}
			} else
				return false;
		}

		if (!openBrackets.isEmpty()) {
			return false;
		}

		return true;
	}

}
