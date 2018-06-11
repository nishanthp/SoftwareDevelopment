package accpetedSubmissions;

public class ValidParanthesisString {
	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public boolean checkValidString(String s) {
		int leastOpenBrackets = 0;
		int mostOpenBrackets = 0;
		for (Character eachBracket : s.toCharArray()) {
			leastOpenBrackets += eachBracket == '(' ? 1 : -1;
			mostOpenBrackets += eachBracket == ')' ? -1 : 1;
			if (mostOpenBrackets < 0)
				return false;
			leastOpenBrackets = Math.max(0, leastOpenBrackets);
		}

		return leastOpenBrackets == 0;
	}

}
