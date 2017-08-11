package Tree;

public class MovieRatingsDemo {
	public static void main(String[] args) {
		int[] ratings = { -1, -2, -3, -4, -5 };

		System.out.println(findBestRatings(ratings));
	}

	private static int findBestRatings(int[] ratings) {
		int[] sum = new int[ratings.length];
		sum[0] = ratings[0];
		int max = ratings[0];
		int left = 1;
		int right = left + 1;
		int i = 1;
		while (right < ratings.length) {
			if ((ratings[left] + sum[i - 1]) > (ratings[right] + sum[i - 1])) {
				sum[i] = ratings[left] + sum[left - 1];
				left += 1;
				right += 1;
			} else if ((ratings[right] + sum[i - 1]) > (ratings[left] + sum[i - 1])) {
				sum[i] = ratings[right] + sum[i - 1];
				left += 2;
				right += 2;
			}
			max = Math.max(max, sum[i]);
			i++;
		}

		if (left < ratings.length) {
			if (ratings[left] + sum[i - 1] > sum[i - 1]) {
				sum[i] = ratings[left] + sum[i - 1];
				i++;
			}
		}
		return sum[i - 1];
	}
}
