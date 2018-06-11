package glassDoor;

public class PerfectSquareDemo {
	public static void main(String[] args) {
		int input = 16;
		System.out.println(perfectSquare(input));
	}

	private static boolean perfectSquare(int input) {
		int low = 1;
		int high = input;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			if (mid * mid == input) {
				return true;
			} else if (mid * mid < input) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}
}
