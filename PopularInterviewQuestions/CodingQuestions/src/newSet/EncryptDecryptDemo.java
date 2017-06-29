package newSet;

public class EncryptDecryptDemo {
	public static void main(String[] args) {
		String input = "dnotq";
		System.out.println(decryptWord(input));
	}

	private static String decryptWord(String input) {
		int[] array = new int[input.length()];
		int i = 0;
		int subtractFactor = 1;
		StringBuffer s = new StringBuffer();
		for (char c : input.toCharArray()) {
			array[i] = (int) c;
			int temp = array[i] - subtractFactor;

			while (temp < 'a') {
				temp += 26;
			}
			subtractFactor = array[i];
			s.append((char) temp);
			i++;
		}

		return s.toString();

	}
}
