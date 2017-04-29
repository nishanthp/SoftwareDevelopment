package practise;

public class RemoveDuplicatesInPlaceDemo {
	static boolean[] seen = new boolean[256];

	public static void main(String[] args) {
		String str = "aabbccd";
		System.out.println(removeDuplicates(str));
	}

	private static String removeDuplicates(String str) {
		StringBuffer b = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!seen[c]) {
				seen[c] = true;
				b.append(c);
			}

		}
		return new String(b);
	}
}
