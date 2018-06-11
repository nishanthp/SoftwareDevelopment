package AccpetedSubmissions;

public class EditDistance {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int minDistance(String word1, String word2) {
		int[][] minDistances = new int[word1.length() + 1][word2.length() + 1];
		// fill up initial values.
		for (int i = 0; i <= word1.length(); i++) {
			minDistances[i][0] = i;
		}

		for (int i = 0; i <= word2.length(); i++) {
			minDistances[0][i] = i;
		}

		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
					minDistances[i][j] = 1 + Math.min(minDistances[i - 1][j - 1],
							Math.min(minDistances[i - 1][j], minDistances[i][j - 1]));
				} else {
					minDistances[i][j] = minDistances[i - 1][j - 1];
				}

			}
		}
		return minDistances[word1.length()][word2.length()];
	}
}
