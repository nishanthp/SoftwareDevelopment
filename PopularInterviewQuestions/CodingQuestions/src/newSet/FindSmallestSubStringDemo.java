package newSet;

public class FindSmallestSubStringDemo {
	public static void main(String[] args) {
		char[] arr = { 'x', 'y', 'y' };
		String str = "xyyzyzyx";
		String subString = smallestSubString(arr, str);
		System.out.println(subString);

	}

	private static String smallestSubString(char[] arr, String str) {
		int left = 0;
		int size = arr.length - 1;
		int right = left + size;
		while (right < str.length()) {
			String currString = str.substring(left, right + 1);
			if (isSubString(arr, currString)) {
				if (currString.length() > arr.length) {
					left++;
					continue;
				}
				return currString;

			} else {
				right++;

			}
		}
		return null;
	}

	public static boolean isSubString(char[] arr, String str) {
		for (Character c : arr) {
			if (str.indexOf(c) >= 0) {
				continue;
			} else
				return false;
		}
		return true;
	}
}
