package Arrays;

/**
 * 
 * Mojority element: element that occurs more the 1/2 the length of the array.
 */
public class MajorityElementDemo {
	public static void main(String[] args) {
		int[] input = { 1, 1, 1, 3, 4 };
		int candidate = findMajorityElement(input);
		int result = validate(input, candidate) ? candidate : -1;
		System.out.println(result);
	}

	private static boolean validate(int[] input, int candidate) {
		int count = 0;
		for (int element : input) {
			if (element == candidate)
				count++;
		}

		return count > input.length / 2;
	}

	private static int findMajorityElement(int[] input) {
		int count = 0;
		int majorityElement = 0;
		for (int eachNumber : input) {
			if (count == 0) {
				majorityElement = eachNumber;
			} 
			if (eachNumber == majorityElement) {
				count++;
			} else {
				count--;
			}
		}
		return majorityElement;
	}
}
