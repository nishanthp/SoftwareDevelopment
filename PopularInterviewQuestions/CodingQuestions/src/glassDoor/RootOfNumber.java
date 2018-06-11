package glassDoor;

public class RootOfNumber {
	public static void main(String[] args) {
		float x = 9;
		int n = 2;
		System.out.println(findRoot(0, x, x, n));
	}

	// find root of a number using binary search.
	private static float findRoot(float lowerbound, float upperbound, float actualValue, int pow) {
		float left = lowerbound;
		float right = upperbound;
		if (right < left) {
			return 0;
		}
		float mid = (left + right) / 2;
		if (Math.abs(actualValue - Math.pow(mid, pow)) <= 0.001) {
			return Math.round(mid);
		}
		if (Math.pow(mid, pow) > actualValue) {
			// observe the change here.
			return findRoot(lowerbound, mid, actualValue, pow);
		} else {
			// observe the change here.
			return findRoot(mid, upperbound, actualValue, pow);
		}
	}
}
