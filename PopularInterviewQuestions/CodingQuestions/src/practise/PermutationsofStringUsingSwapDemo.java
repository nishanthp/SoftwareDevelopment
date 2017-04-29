package practise;

public class PermutationsofStringUsingSwapDemo {
	static String input = "abc";

	public static void main(String[] args) {
		PermutationsofStringUsingSwapDemo stringPermutations = new PermutationsofStringUsingSwapDemo();
		stringPermutations.permutations(0, input.length() - 1);

	}

	private void permutations(int l, int r) {
		if (l > r) {
			System.out.println(input);
			return;
		}
		for (int i = l; i <= r; i++) {
			swap(l, i);
			permutations(l + 1, r);
			swap(l, i);
		}
	}

	public void swap(int index1, int index2) {
		char[] temp = input.toCharArray();
		char t = temp[index1];
		temp[index1] = temp[index2];
		temp[index2] = t;
		input = new String(temp);
	}
}
