package newSet;

public class DeletionDistanceDemo {
	public static void main(String[] args) {
		String s1 = "some";
		String s2 = "thing";
		int result = deletionDistance(s1, s2, s1.length(), s2.length());
		System.out.println(result);
	}

	private static int deletionDistance(String s1, String s2, int i, int j) {
		if (i == 0 && j != 0) {
			return j;
		}
		if (i != 0 && j == 0) {
			return i;
		}
		if (i == 0 && j == 0) {
			return 0;
		}

		if (s1.charAt(i-1) == s2.charAt(j-1)) {
			return deletionDistance(s1, s2, i - 1, j - 1);
		} else {
			return 1 + Math.min(deletionDistance(s1, s2, i - 1, j), deletionDistance(s1, s2, i, j - 1));
		}
	}
}
