package BitManipulation;

public class PairwiseSwapDemo {
	public static void main(String[] args) {
		int n = 0xAA;
		System.out.println(Integer.toBinaryString(n));
		int r = pairwiseSwap(n);

		System.out.println(r);
	}

	// logical right shift not arithmetic right shift.
	private static int pairwiseSwap(int n) {
		return (((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1));
	}

}
