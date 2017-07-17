package Arrays;

public class SentenceContainsFourWordsDemo {
	public static void main(String[] args) {
		String input1 = "Hello";
		String input2 = "This is a new sentence";
		System.out.println(wordWithLength4(input2));
	}

	private static int wordWithLength4(String input1) {
		int count = 0;
		String[] words = input1.split(" ");
		for (String eachWord : words) {
			count = eachWord.length() >= 4 ? count + 1 : count;
		}
		return count;
	}
}
