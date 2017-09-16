package Arrays;

public class MajorityElementDemo {
	public static void main(String[] args) {
		int[] input = { 1, 1, 2,3,4 };
		System.out.println(findMajorityElement(input));

	}

	private static int findMajorityElement(int[] input) {
		int count = 0;
		int result = 0;
		for (int eachNumber : input) {
			if (count == 0) {
				result = eachNumber;
				count++;
			} else if (eachNumber == result) {
				count++;
			} else {
				count--;
			}
		}
		return result;
	}
}
