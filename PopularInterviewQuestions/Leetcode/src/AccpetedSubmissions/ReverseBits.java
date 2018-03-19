package AccpetedSubmissions;

public class ReverseBits {
	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public int reverseBits(int n) {
		for (int i = 0; i < 16; i++) {
			n = reverse(n, i, 32 - i - 1);
		}
		return n;
	}

	public int reverse(int num, int left, int right) {
		int a = (num >> left) & 1;
		int b = (num >> right) & 1;

		if ((a ^ b) != 0) {
			return num ^= ((1 << right) | (1 << left));
		}

		return num;
	}

}
